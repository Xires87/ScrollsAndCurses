package net.fryc.frycscrolls.enchantments;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;

public class AbsorptionEnchantment extends Enchantment {
    public AbsorptionEnchantment(Rarity weight, EquipmentSlot... slotTypes) {
        super(weight, EnchantmentTarget.ARMOR_CHEST, slotTypes);
    }

    public void onUserDamaged(LivingEntity user, Entity attacker, int level) {
        if(!user.hasStatusEffect(StatusEffects.ABSORPTION)) user.addStatusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 1200, 0));
    }

    public int getMinPower(int level) {
        return 25;
    }

    public int getMaxPower(int level) {
        return 75;
    }
    public int getMaxLevel() {
        return 1;
    }

    @Override
    public boolean isTreasure() {
        return true;
    }

    @Override
    public boolean isAvailableForEnchantedBookOffer() {
        return false;
    }
}
