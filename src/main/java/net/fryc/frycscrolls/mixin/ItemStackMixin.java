package net.fryc.frycscrolls.mixin;

import net.fabricmc.fabric.api.item.v1.FabricItemStack;
import net.fryc.frycscrolls.enchantments.ModEnchantments;
import net.minecraft.component.ComponentHolder;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

import java.util.function.Consumer;

@Mixin(ItemStack.class)
abstract class ItemStackMixin implements ComponentHolder, FabricItemStack {

    @ModifyVariable(method = "damage(ILnet/minecraft/server/world/ServerWorld;Lnet/minecraft/server/network/ServerPlayerEntity;Ljava/util/function/Consumer;)V", at = @At("HEAD"), ordinal = 0)
    private int addDamageIfCursed(int amount, int amountv2, ServerWorld world, @Nullable ServerPlayerEntity player, Consumer<Item> breakCallback) {
        return amount + (EnchantmentHelper.getLevel(world.getRegistryManager().get(RegistryKeys.ENCHANTMENT).entryOf(ModEnchantments.RUST_CURSE), ((ItemStack) (Object) this)));
    }
}
