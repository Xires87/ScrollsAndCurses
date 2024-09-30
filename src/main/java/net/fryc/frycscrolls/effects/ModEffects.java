package net.fryc.frycscrolls.effects;

import net.fryc.frycscrolls.FrycScrolls;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;


public class ModEffects {

    public static RegistryEntry<StatusEffect> CHAOTIC_TELEPORTATION;
    public static RegistryEntry<StatusEffect> ABSORPTION_COOLDOWN;

    private static final StatusEffect chaotic_teleportation = new ChaoticTeleportationEffect(StatusEffectCategory.NEUTRAL, 13458603);
    private static final StatusEffect absorption_cooldown = new AbsorptionCooldownEffect(StatusEffectCategory.HARMFUL, 2445989);


    private static RegistryEntry<StatusEffect> register(String id, StatusEffect statusEffect) {
        return Registry.registerReference(Registries.STATUS_EFFECT, Identifier.of(FrycScrolls.MOD_ID, id), statusEffect);
    }

    public static void registerEffects() {
        if(CHAOTIC_TELEPORTATION == null){
            CHAOTIC_TELEPORTATION = register("chaotic_teleportation", chaotic_teleportation);
            ABSORPTION_COOLDOWN = register("absorption_cooldown", absorption_cooldown);
        }
    }
}
