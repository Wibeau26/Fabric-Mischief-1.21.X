package net.wibeau.mischief.item.custom;

import net.minecraft.entity.passive.VillagerEntity;
import net.minecraft.item.Item;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.server.network.ServerPlayerEntity;


public class CottonBagItem extends Item {

    public CottonBagItem(Settings settings) {
        super(settings.maxCount(1));
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if (target instanceof VillagerEntity && attacker instanceof ServerPlayerEntity) {
            if (!attacker.getWorld().isClient && target.isAlive()) {
                target.setHealth(0.0f);
                stack.decrementUnlessCreative(1, attacker);
                ServerPlayerEntity player = (ServerPlayerEntity) attacker;
                player.getInventory().insertStack(new ItemStack(Items.VILLAGER_SPAWN_EGG));
            }
        }
        return super.postHit(stack, target, attacker);
    }
}
