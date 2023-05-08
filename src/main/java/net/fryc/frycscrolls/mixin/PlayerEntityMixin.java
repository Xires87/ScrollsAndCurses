package net.fryc.frycscrolls.mixin;

import net.fryc.frycscrolls.enchantments.ModEnchantments;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(PlayerEntity.class)
abstract class PlayerEntityMixin extends LivingEntity {

    protected PlayerEntityMixin(EntityType<? extends LivingEntity> entityType, World world) {
        super(entityType, world);
    }

    @Inject(method = "onKilledOther(Lnet/minecraft/server/world/ServerWorld;Lnet/minecraft/entity/LivingEntity;)Z", at = @At("HEAD"))
    private void applyAmokEnchantmentEffect(ServerWorld world, LivingEntity other, CallbackInfoReturnable<Boolean> ret) {
        PlayerEntity dys = ((PlayerEntity)(Object)this);
        if(ModEnchantments.getAmok(dys) > 0){
            if(!dys.hasStatusEffect(StatusEffects.STRENGTH)){
                dys.addStatusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 200));
            }
            else {
                int amp = dys.getActiveStatusEffects().get(StatusEffects.STRENGTH).getAmplifier();
                int dur = dys.getActiveStatusEffects().get(StatusEffects.STRENGTH).getDuration();
                dys.addStatusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, dur + 200, amp));
            }

            if(!dys.hasStatusEffect(StatusEffects.SPEED)){
                dys.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, 200));
            }
            else {
                int amp = dys.getActiveStatusEffects().get(StatusEffects.SPEED).getAmplifier();
                int dur = dys.getActiveStatusEffects().get(StatusEffects.SPEED).getDuration();
                dys.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, dur + 200, amp));
            }
        }
    }
}
