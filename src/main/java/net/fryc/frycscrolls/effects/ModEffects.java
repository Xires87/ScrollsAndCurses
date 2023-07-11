package net.fryc.frycscrolls.effects;

import net.fryc.frycscrolls.FrycScrolls;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;


public class ModEffects {

    public static StatusEffect CHAOTIC_TELEPORTATION;

    static StatusEffect chaotic_teleportation = new ChaoticTeleportationEffect(StatusEffectCategory.NEUTRAL, 13458603);

    public static StatusEffect registerStatusEffect(String name, StatusEffect effect) {
        return Registry.register(Registries.STATUS_EFFECT, new Identifier(FrycScrolls.MOD_ID, name), effect);
    }

    public static void registerEffects() {
        if(CHAOTIC_TELEPORTATION == null){
            CHAOTIC_TELEPORTATION = registerStatusEffect("chaotic_teleportation", chaotic_teleportation);
        }
    }
}
