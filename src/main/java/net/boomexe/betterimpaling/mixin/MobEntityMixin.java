package com.boyonk.betterimpaling.mixin;

import com.boyonk.betterimpaling.BetterImpaling;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.Mixin;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.Entity;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.mob.MobEntity;

@Mixin(MobEntity.class)
public class MobEntityMixin {
    @Redirect(method = "tryAttack(Lnet/minecraft/entity/Entity;)Z", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/mob/MobEntity;getAttributeValue(Lnet/minecraft/entity/attribute/EntityAttribute;)D", ordinal = 0))
    public double tryAttack(MobEntity mob, EntityAttribute attribute, Entity target) {
        float f = (float)mob.getAttributeValue(EntityAttributes.GENERIC_ATTACK_DAMAGE);
        if (target.isTouchingWaterOrRain()) {
            f += EnchantmentHelper.getLevel(BetterImpaling.BETTER_IMPALING, mob.getMainHandStack()) * 2.5f;
        }
        return f;
    }
}
