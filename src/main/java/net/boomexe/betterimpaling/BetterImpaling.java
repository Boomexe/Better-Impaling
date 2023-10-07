package net.boomexe.betterimpaling;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BetterImpaling implements ModInitializer {
	public static final String MODID = "betterimpaling";
	public static final Logger LOGGER = LoggerFactory.getLogger(MODID);

	@Override
	public void onInitialize() {
		LOGGER.info("Better Impaling Mod Initialized");
	}
}
