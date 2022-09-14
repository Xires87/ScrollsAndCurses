package net.fryc.endercurse;

import net.fabricmc.api.ModInitializer;
import net.fryc.endercurse.effects.ModEffects;
import net.fryc.endercurse.enchantments.ModEnchantments;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EnderCurse implements ModInitializer {

	public static final String MOD_ID = "endercurse";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModEnchantments.registerModEnchantments();
		ModEffects.registerEffects();
	}
}
