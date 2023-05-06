package net.fryc.frycscrolls.mixin;

import net.fryc.frycscrolls.enchantments.ModEnchantments;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(ItemStack.class)
abstract class ItemStackMixin {

    @ModifyVariable(method = "damage(ILnet/minecraft/util/math/random/Random;Lnet/minecraft/server/network/ServerPlayerEntity;)Z", at = @At("HEAD"), ordinal = 0)
    private int addDamageIfCursed(int amount) {
        return amount + (EnchantmentHelper.getLevel(ModEnchantments.RUST_CURSE, ((ItemStack) (Object) this)));
    }
}
