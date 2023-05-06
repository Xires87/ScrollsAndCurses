package net.fryc.frycscrolls.enchantments;

import net.fryc.frycscrolls.FrycScrolls;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModEnchantments {
    private static final EquipmentSlot[] ALL_ARMOR = new EquipmentSlot[]{EquipmentSlot.HEAD, EquipmentSlot.CHEST, EquipmentSlot.LEGS, EquipmentSlot.FEET};

    public static Enchantment ABSORPTION = register("absorption_enchantment",
            new AbsorptionEnchantment(Enchantment.Rarity.VERY_RARE, EquipmentSlot.CHEST));

    public static Enchantment AMOK = register("amok_enchantment",
            new AmokEnchantment(Enchantment.Rarity.VERY_RARE, EquipmentSlot.MAINHAND));

    public static Enchantment ENDER_CURSE = register("ender_curse_enchantment",
            new EnderCurseEnchantment(Enchantment.Rarity.VERY_RARE, ALL_ARMOR));

    public static Enchantment VULNERABILITY_CURSE = register("vulnerability_curse_enchantment",
            new VulnerabilityCurseEnchantment(Enchantment.Rarity.VERY_RARE, ALL_ARMOR));

    public static Enchantment FLAMES_CURSE = register("flames_curse_enchantment",
            new FlamesCurseEnchantment(Enchantment.Rarity.VERY_RARE, EquipmentSlot.MAINHAND));

    public static Enchantment RUST_CURSE = register("rust_curse_enchantment",
            new RustCurseEnchantment(Enchantment.Rarity.VERY_RARE, EquipmentSlot.values()));


    private static Enchantment register(String name, Enchantment enchantment) {
        return Registry.register(Registry.ENCHANTMENT, new Identifier(FrycScrolls.MOD_ID, name), enchantment);
    }

    public static void registerModEnchantments() {
    }

    public static int getAmok(LivingEntity entity) {
        return EnchantmentHelper.getEquipmentLevel(ModEnchantments.AMOK, entity);
    }

}
