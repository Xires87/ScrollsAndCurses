package net.fryc.frycscrolls.items;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fryc.frycscrolls.FrycScrolls;
import net.fryc.frycscrolls.items.custom.ScrollItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.registry.Registry;

public class ModItems {

    public static final Item TORN_MAGIC_SCROLL = registerItem("torn_magic_scroll" ,
            new ScrollItem(new FabricItemSettings().maxCount(4).group(ItemGroup.MISC), 1));

    public static final Item MAGIC_SCROLL = registerItem("magic_scroll" ,
            new ScrollItem(new FabricItemSettings().maxCount(4).group(ItemGroup.MISC), 2));

    public static final Item POWERFUL_MAGIC_SCROLL = registerItem("powerful_magic_scroll" ,
            new ScrollItem(new FabricItemSettings().maxCount(4).group(ItemGroup.MISC).rarity(Rarity.RARE), 3));

    public static final Item CURSED_SCROLL = registerItem("cursed_scroll" ,
            new ScrollItem(new FabricItemSettings().maxCount(4).group(ItemGroup.MISC).rarity(Rarity.UNCOMMON), 3));

    private static Item registerItem(String name, Item item){
        return Registry.register(Registry.ITEM, new Identifier(FrycScrolls.MOD_ID, name), item);
    }
    public static void registerModItems(){
    }
}
