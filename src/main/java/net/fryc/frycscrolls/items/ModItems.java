package net.fryc.frycscrolls.items;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fryc.frycscrolls.FrycScrolls;
import net.fryc.frycscrolls.items.custom.ScrollItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

public class ModItems {

    //Item Group
    public static final RegistryKey<ItemGroup> SCROLLS_AND_CURSES = RegistryKey.of(RegistryKeys.ITEM_GROUP, new Identifier(FrycScrolls.MOD_ID, "scrolls_and_curses_item_group"));

    public static final Item TORN_MAGIC_SCROLL = registerItem("torn_magic_scroll" ,
            new ScrollItem(new FabricItemSettings().maxCount(4), 1));

    public static final Item MAGIC_SCROLL = registerItem("magic_scroll" ,
            new ScrollItem(new FabricItemSettings().maxCount(4), 2));

    public static final Item POWERFUL_MAGIC_SCROLL = registerItem("powerful_magic_scroll" ,
            new ScrollItem(new FabricItemSettings().maxCount(4).rarity(Rarity.RARE), 3));

    public static final Item CURSED_SCROLL = registerItem("cursed_scroll" ,
            new ScrollItem(new FabricItemSettings().maxCount(4).rarity(Rarity.UNCOMMON), 3));

    private static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM, new Identifier(FrycScrolls.MOD_ID, name), item);
    }
    public static void registerModItems(){
        //Item Group
        Registry.register(Registries.ITEM_GROUP, SCROLLS_AND_CURSES, FabricItemGroup.builder()
                .icon(() -> new ItemStack(ModItems.POWERFUL_MAGIC_SCROLL))
                .displayName(Text.literal("Scrolls and Curses"))
                .entries((enabledFeatures, entries) -> {
                    entries.add(ModItems.TORN_MAGIC_SCROLL);
                    entries.add(ModItems.MAGIC_SCROLL);
                    entries.add(ModItems.CURSED_SCROLL);
                    entries.add(ModItems.POWERFUL_MAGIC_SCROLL);
                })
                .build());

    }
}
