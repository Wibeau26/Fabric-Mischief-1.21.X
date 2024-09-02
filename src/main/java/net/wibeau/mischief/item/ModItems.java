package net.wibeau.mischief.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.util.Identifier;
import net.wibeau.mischief.Mischief;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public class ModItems {
    public static final Item Cotton = registerItem("cotton", new Item(new Item.Settings()));
    public static final Item Compacted_Cotton = registerItem("compacted_cotton", new Item(new Item.Settings()));
    public static final Item Cotton_Shard = registerItem("cotton_shard", new Item(new Item.Settings()));


    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(Mischief.MOD_ID, name), item);
    }

    public static void registerModItems() {
        Mischief.LOGGER.info("Registering Mod Items for " + Mischief.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(Cotton);
            entries.add(Compacted_Cotton);
            entries.add(Cotton_Shard);
        });
    }
}
