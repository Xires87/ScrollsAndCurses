package net.fryc.endercurse.enchantments;

import net.fryc.endercurse.effects.ModEffects;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;

import java.util.Random;

public class EnderCurseEnchantment extends Enchantment {
    protected EnderCurseEnchantment(Rarity weight, EquipmentSlot... slotTypes) {
        super(weight, EnchantmentTarget.WEARABLE, slotTypes);
    }

    Random random = new Random();

    public void onUserDamaged(LivingEntity user, Entity attacker, int level) {
        if(random.nextInt(0,100) >= 93) user.addStatusEffect(new StatusEffectInstance(ModEffects.ENDER_CURSE, 240 + random.nextInt(0 , 240), 0));
    }

    public int getMinPower(int level) {
        return 25;
    }

    public int getMaxPower(int level) {
        return 50;
    }
    @Override
    public int getMaxLevel() {
        return 1;
    }

    @Override
    public boolean isTreasure() {
        return true;
    }

    @Override
    public boolean isCursed() {
        return true;
    }
}
