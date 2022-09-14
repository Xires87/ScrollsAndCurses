package net.fryc.endercurse.effects;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;

import java.util.Random;

public class EnderCurseEffect extends StatusEffect {
    public EnderCurseEffect(StatusEffectCategory statusEffectCategory, int color) {
        super(statusEffectCategory, color);
    }

    Random random = new Random();

    @Override
    public void applyUpdateEffect(LivingEntity pLivingEntity, int pAmplifier) {
        if (!pLivingEntity.world.isClient()) {
            double x = pLivingEntity.getX(), y= pLivingEntity.getY(), z=pLivingEntity.getZ();
            pLivingEntity.teleport(x,y,z,true);
            x+= random.nextInt(-10, 10);
            z+= random.nextInt(-10, 10);
            pLivingEntity.world.playSound(null, pLivingEntity.getX(), pLivingEntity.getY(), pLivingEntity.getZ(), SoundEvents.ENTITY_ENDERMAN_TELEPORT, SoundCategory.PLAYERS, 1.0F, 1.0F);
            pLivingEntity.teleport(x,y,z);
            while(pLivingEntity.isInsideWall()) pLivingEntity.teleport(pLivingEntity.getX(),pLivingEntity.getY() + 3,pLivingEntity.getZ());
        }

        super.applyUpdateEffect(pLivingEntity, pAmplifier);
    }

    @Override
    public boolean canApplyUpdateEffect(int pDuration, int pAmplifier) {
        int i;
        i = 120 >> pAmplifier;
        if (i > 0) {
            return pDuration % i == 0;
        } else {
            return true;
        }
    }
}
