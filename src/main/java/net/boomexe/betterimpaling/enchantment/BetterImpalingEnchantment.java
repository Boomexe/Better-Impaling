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

    public int getMinPower(int level) {
        return 1 + (level - 1) * 8;
    }

    public int getMaxPower(int level) {
        return this.getMinPower(level) + 20;
    }

    public int getMaxLevel() {
        return 5;
    }
}
