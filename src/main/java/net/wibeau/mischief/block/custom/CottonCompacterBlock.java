package net.wibeau.mischief.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.util.ItemActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.wibeau.mischief.item.ModItems;

public class CottonCompacterBlock extends Block {
    public CottonCompacterBlock(Settings settings) {
        super(settings);
    }

    @Override
    protected ItemActionResult onUseWithItem(ItemStack stack, BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if(stack.getItem() == ModItems.Unrefined_Cotton_Shard){
            stack.decrementUnlessCreative(1, player);
            world.playSound(player, pos, SoundEvents.BLOCK_AMETHYST_BLOCK_CHIME, SoundCategory.BLOCKS, 2f, 1f);
            player.getInventory().insertStack(new ItemStack(ModItems.Cotton_Shard));
        }
        return super.onUseWithItem(stack, state, world, pos, player, hand, hit);
    }
}
