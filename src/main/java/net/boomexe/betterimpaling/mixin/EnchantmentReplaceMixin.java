package net.boomexe.betterimpaling.mixin;

import net.minecraft.enchantment.ImpalingEnchantment;
import net.minecraft.entity.EntityGroup;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ImpalingEnchantment.class)
public class EnchantmentReplaceMixin {
    @Inject(method = "getAttackDamage", at = @At("RETURN"), cancellable = true)
    private void modifyAttackDamage(int level, EntityGroup group, CallbackInfoReturnable<Float> info) {
        info.setReturnValue(0f);
    }
}