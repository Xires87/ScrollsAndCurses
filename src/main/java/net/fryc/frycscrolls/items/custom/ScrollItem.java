package net.fryc.frycscrolls.items.custom;

import com.google.common.collect.Lists;
import net.fryc.frycscrolls.items.ModItems;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.EnchantmentLevelEntry;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtList;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;


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
                    if(!user.getWorld().isClient()){
                        AtomicInteger multiplier = new AtomicInteger();
                        NbtList list = offStack.getEnchantments();
                        ArrayList<Enchantment> treasureEn = new ArrayList<>();
                        if(!list.isEmpty()){
                            for(int i = 0; i < list.size(); ++i) {
                                NbtCompound nbtCompound = list.getCompound(i);
                                Registry.ENCHANTMENT.getOrEmpty(EnchantmentHelper.getIdFromNbt(nbtCompound)).ifPresent((enchantment) -> {
                                    if(enchantment.isTreasure()){
                                        multiplier.getAndAdd(2);
                                        treasureEn.add(enchantment);
                                    }
                                    multiplier.getAndAdd(EnchantmentHelper.getLevelFromNbt(nbtCompound));
                                });
                            }
                        }

                        boolean notCursed = random.nextInt(100) >= 4 + multiplier.get() * 6;
                        Enchantment enchantment = getRandomTreasureEnchantment(offStack, treasureEn, notCursed);
                        offStack.addEnchantment(enchantment, enchantment.getMaxLevel());
                    }

                }
                //magic scroll
                else if(offStack.isEnchantable()){
                    if(!user.getWorld().isClient()){
                        int level = (random.nextInt(this.tier*6)+1) + ((this.tier-1)*10);
                        EnchantmentHelper.enchant(random, offStack, level, true);
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

    public static boolean hasOnlyOneItemInOffStack(PlayerEntity user){
        return user.getOffHandStack().getCount() == 1;
    }


    //returns random treasure enchantment available for given item (gives Curse Of Vanishing if item has all available treasure enchantments)
    private static Enchantment getRandomTreasureEnchantment(ItemStack stack, ArrayList<Enchantment> existingTreasures, boolean cursed){
        List<EnchantmentLevelEntry> list = getPossibleTreasureEntries(35, stack);
        Enchantment enchantment;
        int i = list.size(), rand;
        if(i <= existingTreasures.size()) return Enchantments.VANISHING_CURSE;
        do{
            do{
                rand = random.nextInt(i);
                enchantment = list.get(rand).enchantment;
                list.remove(rand);
                i--;
                if(i <= 0){
                    if(!existingTreasures.contains(enchantment)) return enchantment;
                    return getRandomTreasureEnchantment(stack, new ArrayList<>(), !cursed);
                }
            }while(existingTreasures.contains(enchantment));
        }while((enchantment.isCursed() && !cursed) || (!enchantment.isCursed() && cursed));

        return enchantment;
    }


    //returns list of treasure enchantments available for given item
    private static List<EnchantmentLevelEntry> getPossibleTreasureEntries(int power, ItemStack stack) {
        List<EnchantmentLevelEntry> list = Lists.newArrayList();
        Item item = stack.getItem();
        boolean bl = stack.isOf(Items.BOOK);
        Iterator var6 = Registry.ENCHANTMENT.iterator();

        while(true) {
            while(true) {
                Enchantment enchantment;
                do {
                    do {
                        do {
                            if (!var6.hasNext()) {
                                return list;
                            }

                            enchantment = (Enchantment)var6.next();
                        } while(!enchantment.isTreasure());
                    } while(!enchantment.isAvailableForRandomSelection());
                } while(!enchantment.type.isAcceptableItem(item) && !bl);

                for(int i = enchantment.getMaxLevel(); i > enchantment.getMinLevel() - 1; --i) {
                    if (power >= enchantment.getMinPower(i) && power <= enchantment.getMaxPower(i)) {
                        list.add(new EnchantmentLevelEntry(enchantment, i));
                        break;
                    }
                }
            }
        }
    }


}
