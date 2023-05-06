package net.fryc.frycscrolls.enchantments;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;

import java.util.Random;

public class FlamesCurseEnchantment extends Enchantment {
    protected FlamesCurseEnchantment(Rarity weight, EquipmentSlot... slotTypes) {
        super(weight, EnchantmentTarget.WEAPON , slotTypes);
    }

    Random random = new Random();

    public void onTargetDamaged(LivingEntity user, Entity target, int level) {
        if(!user.getWorld().isClient()){
            if(target.isOnFire() || target.isInLava()){
                user.setOnFireFor(3);
            }
            else if(random.nextInt(0, 100) > 83 && !target.isFireImmune()) target.setOnFireFor(4);
        }
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
