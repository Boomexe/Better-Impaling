package com.boyonk.betterimpaling.mixin;

import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.Mixin;
import com.boyonk.betterimpaling.BetterImpaling;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;

@Mixin({ PlayerEntity.class })
public class PlayerEntityMixin {
    @Redirect(method = { "attack(Lnet/minecraft/entity/Entity;)V" }, at = @At(value = "INVOKE", target = "Lnet/minecraft/enchantment/EnchantmentHelper;getAttackDamage(Lnet/minecraft/item/ItemStack;Lnet/minecraft/entity/EntityGroup;)F"))
    public float attack(ItemStack stack, EntityGroup group, Entity target) {
        float h;
        if (target instanceof LivingEntity) {
            h = EnchantmentHelper.getAttackDamage(stack, ((LivingEntity) target).getGroup());
        } else {
            h = EnchantmentHelper.getAttackDamage(stack, EntityGroup.DEFAULT);
        }
        if (target.isTouchingWaterOrRain()) {
            h += EnchantmentHelper.getLevel(BetterImpaling.BETTER_IMPALING, stack) * 2.5f;
        }
        return h;
    }
}
