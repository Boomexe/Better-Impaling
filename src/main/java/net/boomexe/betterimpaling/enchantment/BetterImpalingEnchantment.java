package com.boyonk.betterimpaling.enchantment;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;

public class BetterImpalingEnchantment extends Enchantment {
    public BetterImpalingEnchantment(Rarity weight, EquipmentSlot... slotTypes) {
        super(weight, EnchantmentTarget.TRIDENT, slotTypes);
    }

    public float getAttackDamage(int level, Entity group) {
        return 0.0f;
    }
}
