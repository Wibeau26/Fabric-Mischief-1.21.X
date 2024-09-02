package net.wibeau.mischief;

import net.fabricmc.api.ModInitializer;

import net.wibeau.mischief.block.ModBlocks;
import net.wibeau.mischief.item.ModItemGroups;
import net.wibeau.mischief.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Mischief implements ModInitializer {
	public static final String MOD_ID = "mischief";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItemGroups.registerItemGroups();

		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
	}
}