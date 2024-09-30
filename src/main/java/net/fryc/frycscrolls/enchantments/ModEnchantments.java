package net.fryc.frycscrolls.enchantments;

import net.fryc.frycscrolls.FrycScrolls;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.LivingEntity;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class ModEnchantments {

    public static RegistryKey<Enchantment> ABSORPTION = of("absorption");
    public static RegistryKey<Enchantment> AMOK = of("amok");
    public static RegistryKey<Enchantment> ENDER_CURSE = of("ender_curse");
    public static RegistryKey<Enchantment> VULNERABILITY_CURSE = of("vulnerability_curse");
    public static RegistryKey<Enchantment> FLAMES_CURSE = of("flames_curse");
    public static RegistryKey<Enchantment> RUST_CURSE = of("rust_curse");


    private static RegistryKey<Enchantment> of(String id) {
        return RegistryKey.of(RegistryKeys.ENCHANTMENT, Identifier.of(FrycScrolls.MOD_ID, id));
    }

    public static void registerModEnchantments() {
    }

    public static int getAmok(LivingEntity entity){
        return EnchantmentHelper.getEquipmentLevel(entity.getWorld().getRegistryManager().get(RegistryKeys.ENCHANTMENT).entryOf(AMOK), entity);
    }

}
