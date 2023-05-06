package net.fryc.frycscrolls;

import net.fabricmc.api.ModInitializer;
import net.fryc.frycscrolls.effects.ModEffects;
import net.fryc.frycscrolls.enchantments.ModEnchantments;
import net.fryc.frycscrolls.items.ModItems;
import net.fryc.frycscrolls.loot.ModLootTables;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FrycScrolls implements ModInitializer {

	public static final String MOD_ID = "frycscrolls";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.registerModItems();
		ModEnchantments.registerModEnchantments();
		ModEffects.registerEffects();
		ModLootTables.modifyLootTables(); // todo tekstury
	}
}
