package net.fryc.endercurse.effects;

import net.fryc.endercurse.EnderCurse;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;

import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;


public class ModEffects {

    //Registering effect
    public static StatusEffect ENDER_CURSE;

    static StatusEffect endercurse = new EnderCurseEffect(StatusEffectCategory.NEUTRAL, 13458603);

    public static StatusEffect registerStatusEffect(String name, StatusEffect effect) {
        return Registry.register(Registry.STATUS_EFFECT, new Identifier(EnderCurse.MOD_ID, name), effect);
    }

    public static void registerEffects() {
        ENDER_CURSE = registerStatusEffect("ender_curse", endercurse);
    }
}
