package net.boomexe.betterimpaling.enchantment;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EntityGroup;
import net.minecraft.entity.EquipmentSlot;

public class BetterImpalingEnchantment extends Enchantment {
    public BetterImpalingEnchantment(Rarity weight, EquipmentSlot... slotTypes) {
        super(weight, EnchantmentTarget.TRIDENT, slotTypes);
    }

    @Override
    public float getAttackDamage(int level, EntityGroup group) {
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
