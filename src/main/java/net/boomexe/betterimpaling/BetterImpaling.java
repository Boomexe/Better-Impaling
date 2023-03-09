package com.boyonk.betterimpaling;

import com.boyonk.betterimpaling.enchantment.BetterImpalingEnchantment;
import net.fabricmc.api.ModInitializer;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.EquipmentSlot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BetterImpaling implements ModInitializer {
	public static final String MODID = "betterimpaling";
	public static final Logger LOGGER = LoggerFactory.getLogger(MODID);
	public static Enchantment BETTER_IMPALING = new BetterImpalingEnchantment(Enchantment.Rarity.RARE, EquipmentSlot.MAINHAND);;

	@Override
	public void onInitialize() {
		LOGGER.info("Better Impaling Mod Initialized");
	}
}
