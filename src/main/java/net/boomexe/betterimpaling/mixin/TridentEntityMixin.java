package net.boomexe.betterimpaling.mixin;

import net.boomexe.betterimpaling.BetterImpaling;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.Mixin;
import net.minecraft.entity.LivingEntity; //1309
import net.minecraft.enchantment.EnchantmentHelper; //1890
import net.minecraft.util.hit.EntityHitResult; //3966
import net.minecraft.entity.EntityGroup; //1310
import net.minecraft.item.ItemStack; //1799
import net.minecraft.entity.projectile.TridentEntity; //1685

@Mixin(TridentEntity.class)
public class TridentEntityMixin
{
    @Redirect(method = { "onEntityHit(Lnet/minecraft/util/hit/EntityHitResult;)V" }, at = @At(value = "INVOKE", target = "Lnet/minecraft/enchantment/EnchantmentHelper;getAttackDamage(Lnet/minecraft/item/ItemStack;Lnet/minecraft/entity/EntityGroup;)F"))
    public float onEntityHit(ItemStack stack, final EntityGroup group, final EntityHitResult entityHitResult) {
        float f = EnchantmentHelper.getAttackDamage(stack, group);

        if (entityHitResult.getEntity() instanceof LivingEntity && entityHitResult.getEntity().isTouchingWaterOrRain()) {
            f = EnchantmentHelper.getLevel(BetterImpaling.BETTER_IMPALING, stack) * 2.5f;
        }

        return f;
    }
}

