package net.fryc.frycscrolls.effects;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.effect.StatusEffectInstance;

public class AbsorptionCooldownEffect extends StatusEffect {
    protected AbsorptionCooldownEffect(StatusEffectCategory category, int color) {
        super(category, color);
    }

    public void onApplied(LivingEntity entity, int amplifier) {
        StatusEffectInstance instance = entity.getActiveStatusEffects().get(ModEffects.ABSORPTION_COOLDOWN);
        if(instance.shouldShowIcon()){
            StatusEffectInstance newInstance = new StatusEffectInstance(instance.getEffectType(), instance.getDuration(), instance.getAmplifier(), false, false, false);
            entity.removeStatusEffect(ModEffects.ABSORPTION_COOLDOWN);
            entity.addStatusEffect(newInstance);
        }
    }
}
