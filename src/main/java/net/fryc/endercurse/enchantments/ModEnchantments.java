package net.fryc.endercurse.enchantments;

import net.fryc.endercurse.EnderCurse;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModEnchantments {
    private static final EquipmentSlot[] ALL_ARMOR = new EquipmentSlot[]{EquipmentSlot.HEAD, EquipmentSlot.CHEST, EquipmentSlot.LEGS, EquipmentSlot.FEET};

    public static Enchantment ABSORPTION = register("absorption_enchantment",
            new AbsorptionEnchantment(Enchantment.Rarity.VERY_RARE, EquipmentSlot.CHEST));

    public static Enchantment ENDER_CURSE = register("ender_curse_enchantment",
            new EnderCurseEnchantment(Enchantment.Rarity.VERY_RARE, ALL_ARMOR));


    private static Enchantment register(String name, Enchantment enchantment) {
        return Registry.register(Registry.ENCHANTMENT, new Identifier(EnderCurse.MOD_ID, name), enchantment);
    }

    public static void registerModEnchantments() {
        System.out.println("Registering Enchantments for " + EnderCurse.MOD_ID);
    }
}
