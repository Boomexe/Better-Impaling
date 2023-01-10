package net.boomexe.betterimpaling.enchantment;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;

public class BetterImpalingEnchantment extends Enchantment {
    public BetterImpalingEnchantment(Rarity weight, EquipmentSlot...slotTypes) {
        super(weight, EnchantmentTarget.TRIDENT, slotTypes);
    }

    @Override
    public void onTargetDamaged(LivingEntity user, Entity target, int level) {
        if (!user.world.isClient()) {
            if (target.isTouchingWaterOrRain()) {
                if (user instanceof PlayerEntity) {
                    PlayerEntity player = (PlayerEntity) user;
                    target.damage(DamageSource.player(player), 9 + (float) level * 2.5 F);
                } else {
                    target.damage(DamageSource.mob(user), 9 + (float) level * 2.5 F);
                }
            }
        }
    }

    public int getMaxLevel() {
        return 5;
    }
}
