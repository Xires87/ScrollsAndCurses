package net.fryc.frycscrolls.items.custom;

import com.google.common.collect.Lists;
import net.fryc.frycscrolls.items.ModItems;
import net.minecraft.component.type.ItemEnchantmentsComponent;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.EnchantmentLevelEntry;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.registry.entry.RegistryEntryList;
import net.minecraft.registry.tag.EnchantmentTags;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;


public class ScrollItem extends Item {

    private static final Random random = Random.create();
    private final int tier;

    public ScrollItem(Settings settings, int tier) {
        super(settings);
        this.tier = tier;
    }


    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if (user.getMainHandStack().getItem() instanceof ScrollItem) {
            ItemStack itemStack = user.getStackInHand(hand);
            if (hasOnlyOneItemInOffStack(user)) {
                ItemStack offStack = user.getOffHandStack();
                //cursed scroll
                if(this.getDefaultStack().isOf(ModItems.CURSED_SCROLL)){
                    if(!offStack.isEnchantable() && !offStack.hasEnchantments()) return TypedActionResult.pass(itemStack);
                    ItemEnchantmentsComponent enchantments = offStack.getEnchantments();
                    ArrayList<RegistryEntry<Enchantment>> existingTreasures = new ArrayList<>();
                    int multiplier = 0;
                    for (RegistryEntry<Enchantment> currentEnchantment : enchantments.getEnchantments()) {
                        if(currentEnchantment.isIn(EnchantmentTags.TREASURE)){
                            existingTreasures.add(currentEnchantment);
                            multiplier += 2;
                        }
                        else {
                            multiplier += enchantments.getLevel(currentEnchantment);
                        }
                    }

                    boolean notCursed = random.nextInt(100) >= 4 + multiplier * 6;
                    RegistryEntry<Enchantment> enchantment = getRandomTreasureEnchantment(offStack, world, existingTreasures, notCursed);
                    if(existingTreasures.contains(enchantment)){
                        return TypedActionResult.fail(itemStack);
                    }
                    if(!user.getWorld().isClient()){
                        offStack.addEnchantment(enchantment, enchantment.value().getMaxLevel());
                    }
                }
                //magic scroll
                else if(offStack.isEnchantable()){
                    int level = (random.nextInt(this.tier*6)+1) + ((this.tier-1)*8);
                    Optional<RegistryEntryList.Named<Enchantment>> optional = world.getRegistryManager().get(RegistryKeys.ENCHANTMENT).getEntryList(EnchantmentTags.ON_RANDOM_LOOT);
                    if(optional.isPresent()){
                        if(!user.getWorld().isClient()){
                            EnchantmentHelper.enchant(random, offStack, level, optional.get().stream());
                        }
                    }
                    else {
                        return TypedActionResult.fail(itemStack);
                    }
                }
                else{
                    return TypedActionResult.pass(itemStack);
                }

                if(!user.isCreative()) itemStack.setCount(itemStack.getCount() - 1);
                user.getWorld().playSound(user, user.getBlockPos(), SoundEvents.BLOCK_ENCHANTMENT_TABLE_USE, SoundCategory.PLAYERS, 0.7f, 1.0f);
                user.setCurrentHand(hand);
                return TypedActionResult.consume(itemStack);
            } else {
                return TypedActionResult.pass(itemStack);
            }
        } else {
            return TypedActionResult.pass(user.getStackInHand(hand));
        }
    }

    public boolean hasGlint(ItemStack stack) {
        return this.tier == 3 || super.hasGlint(stack);
    }

    public static boolean hasOnlyOneItemInOffStack(PlayerEntity user){
        return user.getOffHandStack().getCount() == 1;
    }

    private static RegistryEntry<Enchantment> getRandomTreasureEnchantment(ItemStack stack, World world, ArrayList<RegistryEntry<Enchantment>> existingTreasures, boolean cursed){
        return getRandomTreasureEnchantment(stack, world, existingTreasures, cursed, true);
    }

    //returns random treasure enchantment available for given item (gives Curse Of Vanishing if item has all available treasure enchantments)
    private static RegistryEntry<Enchantment> getRandomTreasureEnchantment(ItemStack stack, World world, ArrayList<RegistryEntry<Enchantment>> existingTreasures, boolean cursed, boolean repeatIfNeeded){
        Optional<RegistryEntryList.Named<Enchantment>> optional = world.getRegistryManager().get(RegistryKeys.ENCHANTMENT).getEntryList(EnchantmentTags.TREASURE);
        if(optional.isEmpty()){
            return getDefaultEnchantment(world);
        }
        else {
            List<EnchantmentLevelEntry> list = getPossibleTreasureEntries(35, stack, optional.get().stream());
            int size = list.size();
            if(size <= existingTreasures.size()) return getDefaultEnchantment(world);
            RegistryEntry<Enchantment> enchantment;
            int randomNumber;

            do{
                do{
                    randomNumber = random.nextInt(size);
                    enchantment = list.get(randomNumber).enchantment;
                    list.remove(randomNumber);
                    size--;
                    if(size < 1){
                        if(!existingTreasures.contains(enchantment) && ((enchantment.isIn(EnchantmentTags.CURSE) && cursed) || (!enchantment.isIn(EnchantmentTags.CURSE) && !cursed))){
                            return enchantment;
                        }
                        else if(repeatIfNeeded){
                            return getRandomTreasureEnchantment(stack, world, existingTreasures, !cursed, false);
                        }
                        else {
                            return getDefaultEnchantment(world);
                        }
                    }
                }while(existingTreasures.contains(enchantment));
            }while((enchantment.isIn(EnchantmentTags.CURSE) && !cursed) || (!enchantment.isIn(EnchantmentTags.CURSE) && cursed));

            return enchantment;
        }
    }

    private static RegistryEntry<Enchantment> getDefaultEnchantment(World world){
        return world.getRegistryManager().get(RegistryKeys.ENCHANTMENT).entryOf(Enchantments.VANISHING_CURSE);
    }


    public static List<EnchantmentLevelEntry> getPossibleTreasureEntries(int level, ItemStack stack, Stream<RegistryEntry<Enchantment>> possibleEnchantments) {
        List<EnchantmentLevelEntry> list = Lists.newArrayList();
        possibleEnchantments.filter((enchantment) -> {
            return enchantment.isIn(EnchantmentTags.TREASURE) && enchantment.value().isAcceptableItem(stack);
        }).forEach((enchantmentx) -> {
            Enchantment enchantment = (Enchantment)enchantmentx.value();

            for(int j = enchantment.getMaxLevel(); j >= enchantment.getMinLevel(); --j) {
                if (level >= enchantment.getMinPower(j) && level <= enchantment.getMaxPower(j)) {
                    list.add(new EnchantmentLevelEntry(enchantmentx, j));
                    break;
                }
            }

        });
        return list;
    }




}
