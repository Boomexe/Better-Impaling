package net.boomexe.betterimpaling.mixin;

import net.boomexe.betterimpaling.BetterImpaling;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Enchantments.class)
public abstract class EnchantmentReplaceMixin {
    @Inject(method = "register", at = @At("HEAD"), cancellable = true)
    private static void replaceImpalingEnchantment(String name, Enchantment enchantment, CallbackInfoReturnable<Enchantment> cir) {
        if (name.equals("impaling")) {
            cir.setReturnValue(Registry.register(Registries.ENCHANTMENT, "impaling", BetterImpaling.BETTER_IMPALING));
        }
    }
}