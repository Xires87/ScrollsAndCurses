package net.fryc.frycscrolls.effects;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;

import java.util.Random;

public class ChaoticTeleportationEffect extends StatusEffect {
    public ChaoticTeleportationEffect(StatusEffectCategory statusEffectCategory, int color) {
        super(statusEffectCategory, color);
    }

    Random random = new Random();


    @Override
    public void applyUpdateEffect(LivingEntity pLivingEntity, int pAmplifier) {
        if (!pLivingEntity.getWorld().isClient()) {
            double x = pLivingEntity.getX(), y= pLivingEntity.getY(), z=pLivingEntity.getZ();


            pLivingEntity.teleport(x,y,z,true);

            x+= random.nextInt(-10, 10);
            y+= random.nextInt(2);
            z+= random.nextInt(-10, 10);
            BlockPos.Mutable mutable = new BlockPos.Mutable(x, y, z);

            pLivingEntity.getWorld().playSound(null, pLivingEntity.getX(), pLivingEntity.getY(), pLivingEntity.getZ(), SoundEvents.ENTITY_ENDERMAN_TELEPORT, SoundCategory.PLAYERS, 1.0F, 1.0F);


            while(mutable.getY() > pLivingEntity.getWorld().getBottomY() && !pLivingEntity.getWorld().getBlockState(mutable).getMaterial().blocksMovement()) {
                mutable.move(Direction.DOWN);
            }

            do{
                mutable.move(Direction.UP);
            }while(!pLivingEntity.getWorld().getBlockState(mutable).isAir() && !pLivingEntity.getWorld().getBlockState(mutable).getMaterial().isLiquid());


            pLivingEntity.teleport(mutable.getX(), mutable.getY(), mutable.getZ());
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
