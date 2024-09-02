package net.wibeau.mischief.block;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.wibeau.mischief.Mischief;

public class ModBlocks {
    public static final Block Cotton_Block = registerBlock("cotton_block",
            new Block(AbstractBlock.Settings.create().strength(0.7f).sounds(BlockSoundGroup.WOOL)));

    public static final Block QC_Block = registerBlock("qc_block",
            new Block(AbstractBlock.Settings.create().strength(4f).requiresTool().sounds(BlockSoundGroup.BASALT)));

    public static final Block Enhanced_Cotton_Block = registerBlock("enhanced_cotton_block",
            new Block(AbstractBlock.Settings.create().strength(2f).requiresTool().sounds(BlockSoundGroup.WOOL)));

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(Mischief.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(Mischief.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }

    public static void registerModBlocks() {
        Mischief.LOGGER.info("Registering Mod Blocks for " + Mischief.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {
            entries.add(ModBlocks.Cotton_Block);
            entries.add(ModBlocks.QC_Block);
            entries.add(ModBlocks.Enhanced_Cotton_Block);
        });
    }
}
