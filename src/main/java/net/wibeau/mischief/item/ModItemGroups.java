package net.wibeau.mischief.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.wibeau.mischief.Mischief;
import net.wibeau.mischief.block.ModBlocks;

public class ModItemGroups {
    public static final ItemGroup Mischief_Items = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(Mischief.MOD_ID, "mischief_items"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.Cotton))
                    .displayName(Text.translatable("itemgroup.mischief.mischief_items"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.Cotton);
                        entries.add(ModItems.Compacted_Cotton);
                        entries.add(ModBlocks.QC_Block);
                        entries.add(ModBlocks.Cotton_Block);
                        entries.add(ModItems.Cotton_Shard);
                        entries.add(ModBlocks.Enhanced_Cotton_Block);
                        entries.add(ModItems.Unrefined_Cotton_Shard);

                    }).build());



    public static void registerItemGroups() {
        Mischief.LOGGER.info("Registering Item Groups for " + Mischief.MOD_ID);
    }
}
