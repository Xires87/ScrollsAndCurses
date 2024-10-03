package net.fryc.frycscrolls.loot;


import net.fabricmc.fabric.api.loot.v3.LootTableEvents;
import net.fryc.frycscrolls.items.ModItems;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.util.Identifier;

public class ModLootTables {

    private static final Identifier ANCIENT_CITY_CHEST
            = Identifier.ofVanilla("chests/ancient_city");

    private static final Identifier VILLAGE_TEMPLE_CHEST
            = Identifier.ofVanilla("chests/village/village_temple");

    private static final Identifier ABANDONED_MINESHAFT_CHEST
            = Identifier.ofVanilla("chests/abandoned_mineshaft");

    private static final Identifier BASTION_BRIDGE_CHEST
            = Identifier.ofVanilla("chests/bastion_bridge");

    private static final Identifier BASTION_OTHER_CHEST
            = Identifier.ofVanilla("chests/bastion_other");

    private static final Identifier BASTION_HOGLIN_STABLE_CHEST
            = Identifier.ofVanilla("chests/bastion_hoglin_stable");

    private static final Identifier BASTION_TREASURE_CHEST
            = Identifier.ofVanilla("chests/bastion_treasure");

    private static final Identifier BURIED_TREASURE_CHEST
            = Identifier.ofVanilla("chests/buried_treasure");

    private static final Identifier DESERT_PYRAMID_CHEST
            = Identifier.ofVanilla("chests/desert_pyramid");

    private static final Identifier END_CITY_TREASURE_CHEST
            = Identifier.ofVanilla("chests/end_city_treasure");

    private static final Identifier JUNGLE_TEMPLE_CHEST
            = Identifier.ofVanilla("chests/jungle_temple");

    private static final Identifier NETHER_BRIDGE_CHEST
            = Identifier.ofVanilla("chests/nether_bridge");

    private static final Identifier PILLAGER_OUTPOST_CHEST
            = Identifier.ofVanilla("chests/pillager_outpost");

    private static final Identifier STRONGHOLD_LIBRARY_CHEST
            = Identifier.ofVanilla("chests/stronghold_library");

    private static final Identifier SIMPLE_DUNGEON_CHEST
            = Identifier.ofVanilla("chests/simple_dungeon");

    private static final Identifier UNDERWATER_RUIN_SMALL_CHEST
            = Identifier.ofVanilla("chests/underwater_ruin_small");

    private static final Identifier UNDERWATER_RUIN_BIG_CHEST
            = Identifier.ofVanilla("chests/underwater_ruin_big");

    private static final Identifier WOODLAND_MANSION_CHEST
            = Identifier.ofVanilla("chests/woodland_mansion");

    public static void modifyLootTables(){
        //woodland mansion
        LootTableEvents.MODIFY.register((key, tableBuilder, source, registries) -> {
            if(WOODLAND_MANSION_CHEST.equals(key.getValue())) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(UniformLootNumberProvider.create(1,2))
                        .conditionally(RandomChanceLootCondition.builder(0.13f))
                        .with(ItemEntry.builder(ModItems.CURSED_SCROLL))
                        .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(1.0f)));
                tableBuilder.pool(poolBuilder).build();
            }
        });

        LootTableEvents.MODIFY.register((key, tableBuilder, source, registries) -> {
            if(WOODLAND_MANSION_CHEST.equals(key.getValue())) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(UniformLootNumberProvider.create(1,2))
                        .conditionally(RandomChanceLootCondition.builder(0.004f))
                        .with(ItemEntry.builder(ModItems.POWERFUL_MAGIC_SCROLL))
                        .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(1.0f)));
                tableBuilder.pool(poolBuilder).build();
            }
        });

        //underwater ruins
        LootTableEvents.MODIFY.register((key, tableBuilder, source, registries) -> {
            if(UNDERWATER_RUIN_BIG_CHEST.equals(key.getValue())) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.21f))
                        .with(ItemEntry.builder(ModItems.TORN_MAGIC_SCROLL))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 2.0f)));
                tableBuilder.pool(poolBuilder).build();
            }
        });

        LootTableEvents.MODIFY.register((key, tableBuilder, source, registries) -> {
            if(UNDERWATER_RUIN_SMALL_CHEST.equals(key.getValue())) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.18f))
                        .with(ItemEntry.builder(ModItems.TORN_MAGIC_SCROLL))
                        .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(1.0f)));
                tableBuilder.pool(poolBuilder).build();
            }
        });

        //dungeon (with spawner)
        LootTableEvents.MODIFY.register((key, tableBuilder, source, registries) -> {
            if(SIMPLE_DUNGEON_CHEST.equals(key.getValue())) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(UniformLootNumberProvider.create(1, 3))
                        .conditionally(RandomChanceLootCondition.builder(0.21f))
                        .with(ItemEntry.builder(ModItems.MAGIC_SCROLL))
                        .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(1.0f)));
                tableBuilder.pool(poolBuilder).build();
            }
        });

        LootTableEvents.MODIFY.register((key, tableBuilder, source, registries) -> {
            if(SIMPLE_DUNGEON_CHEST.equals(key.getValue())) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.0413f))
                        .with(ItemEntry.builder(ModItems.CURSED_SCROLL))
                        .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(1.0f)));
                tableBuilder.pool(poolBuilder).build();
            }
        });

        //stronghold
        LootTableEvents.MODIFY.register((key, tableBuilder, source, registries) -> {
            if(STRONGHOLD_LIBRARY_CHEST.equals(key.getValue())) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(UniformLootNumberProvider.create(1, 2))
                        .conditionally(RandomChanceLootCondition.builder(0.413f))
                        .with(ItemEntry.builder(ModItems.CURSED_SCROLL))
                        .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(1.0f)));
                tableBuilder.pool(poolBuilder).build();
            }
        });

        LootTableEvents.MODIFY.register((key, tableBuilder, source, registries) -> {
            if(STRONGHOLD_LIBRARY_CHEST.equals(key.getValue())) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(UniformLootNumberProvider.create(1, 2))
                        .conditionally(RandomChanceLootCondition.builder(0.26f))
                        .with(ItemEntry.builder(ModItems.POWERFUL_MAGIC_SCROLL))
                        .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(1.0f)));
                tableBuilder.pool(poolBuilder).build();
            }
        });

        //pillager outpost
        LootTableEvents.MODIFY.register((key, tableBuilder, source, registries) -> {
            if(PILLAGER_OUTPOST_CHEST.equals(key.getValue())) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(UniformLootNumberProvider.create(1,2))
                        .conditionally(RandomChanceLootCondition.builder(0.164f))
                        .with(ItemEntry.builder(ModItems.MAGIC_SCROLL))
                        .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(1.0f)));
                tableBuilder.pool(poolBuilder).build();
            }
        });

        //nether bridge
        LootTableEvents.MODIFY.register((key, tableBuilder, source, registries) -> {
            if(NETHER_BRIDGE_CHEST.equals(key.getValue())) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(UniformLootNumberProvider.create(1, 2))
                        .conditionally(RandomChanceLootCondition.builder(0.22f))
                        .with(ItemEntry.builder(ModItems.MAGIC_SCROLL))
                        .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(1.0f)));
                tableBuilder.pool(poolBuilder).build();
            }
        });

        //jungle temple
        LootTableEvents.MODIFY.register((key, tableBuilder, source, registries) -> {
            if(JUNGLE_TEMPLE_CHEST.equals(key.getValue())) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(UniformLootNumberProvider.create(1, 2))
                        .conditionally(RandomChanceLootCondition.builder(0.0513f))
                        .with(ItemEntry.builder(ModItems.CURSED_SCROLL))
                        .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(1.0f)));
                tableBuilder.pool(poolBuilder).build();
            }
        });

        //end city
        LootTableEvents.MODIFY.register((key, tableBuilder, source, registries) -> {
            if(END_CITY_TREASURE_CHEST.equals(key.getValue())) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(UniformLootNumberProvider.create(1,2))
                        .conditionally(RandomChanceLootCondition.builder(0.12f))
                        .with(ItemEntry.builder(ModItems.POWERFUL_MAGIC_SCROLL))
                        .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(1.0f)));
                tableBuilder.pool(poolBuilder).build();
            }
        });

        //desert pyramid
        LootTableEvents.MODIFY.register((key, tableBuilder, source, registries) -> {
            if(DESERT_PYRAMID_CHEST.equals(key.getValue())) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.013f))
                        .with(ItemEntry.builder(ModItems.CURSED_SCROLL))
                        .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(1.0f)));
                tableBuilder.pool(poolBuilder).build();
            }
        });

        LootTableEvents.MODIFY.register((key, tableBuilder, source, registries) -> {
            if(DESERT_PYRAMID_CHEST.equals(key.getValue())) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(UniformLootNumberProvider.create(1,2))
                        .conditionally(RandomChanceLootCondition.builder(0.22f))
                        .with(ItemEntry.builder(ModItems.TORN_MAGIC_SCROLL))
                        .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(1.0f)));
                tableBuilder.pool(poolBuilder).build();
            }
        });

        //buried treasure
        LootTableEvents.MODIFY.register((key, tableBuilder, source, registries) -> {
            if(BURIED_TREASURE_CHEST.equals(key.getValue())) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(UniformLootNumberProvider.create(1, 2))
                        .conditionally(RandomChanceLootCondition.builder(0.05f))
                        .with(ItemEntry.builder(ModItems.MAGIC_SCROLL))
                        .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(1.0f)));
                tableBuilder.pool(poolBuilder).build();
            }
        });

        //bastion
        LootTableEvents.MODIFY.register((key, tableBuilder, source, registries) -> {
            if(BASTION_TREASURE_CHEST.equals(key.getValue())) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(UniformLootNumberProvider.create(1, 2))
                        .conditionally(RandomChanceLootCondition.builder(0.16f))
                        .with(ItemEntry.builder(ModItems.POWERFUL_MAGIC_SCROLL))
                        .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(1.0f)));
                tableBuilder.pool(poolBuilder).build();
            }
        });

        LootTableEvents.MODIFY.register((key, tableBuilder, source, registries) -> {
            if(BASTION_HOGLIN_STABLE_CHEST.equals(key.getValue())) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(UniformLootNumberProvider.create(1, 2))
                        .conditionally(RandomChanceLootCondition.builder(0.19f))
                        .with(ItemEntry.builder(ModItems.CURSED_SCROLL))
                        .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(1.0f)));
                tableBuilder.pool(poolBuilder).build();
            }
        });

        LootTableEvents.MODIFY.register((key, tableBuilder, source, registries) -> {
            if(BASTION_HOGLIN_STABLE_CHEST.equals(key.getValue())) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(UniformLootNumberProvider.create(1, 2))
                        .conditionally(RandomChanceLootCondition.builder(0.1f))
                        .with(ItemEntry.builder(ModItems.POWERFUL_MAGIC_SCROLL))
                        .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(1.0f)));
                tableBuilder.pool(poolBuilder).build();
            }
        });

        LootTableEvents.MODIFY.register((key, tableBuilder, source, registries) -> {
            if(BASTION_OTHER_CHEST.equals(key.getValue())) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(UniformLootNumberProvider.create(1, 2))
                        .conditionally(RandomChanceLootCondition.builder(0.076f))
                        .with(ItemEntry.builder(ModItems.POWERFUL_MAGIC_SCROLL))
                        .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(1.0f)));
                tableBuilder.pool(poolBuilder).build();
            }
        });

        LootTableEvents.MODIFY.register((key, tableBuilder, source, registries) -> {
            if(BASTION_BRIDGE_CHEST.equals(key.getValue())) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(UniformLootNumberProvider.create(1, 2))
                        .conditionally(RandomChanceLootCondition.builder(0.076f))
                        .with(ItemEntry.builder(ModItems.CURSED_SCROLL))
                        .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(1.0f)));
                tableBuilder.pool(poolBuilder).build();
            }
        });

        //mineshaft
        LootTableEvents.MODIFY.register((key, tableBuilder, source, registries) -> {
            if(ABANDONED_MINESHAFT_CHEST.equals(key.getValue())) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(UniformLootNumberProvider.create(1,2))
                        .conditionally(RandomChanceLootCondition.builder(0.12f))
                        .with(ItemEntry.builder(ModItems.MAGIC_SCROLL))
                        .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(1.0f)));
                tableBuilder.pool(poolBuilder).build();
            }
        });

        //village
        LootTableEvents.MODIFY.register((key, tableBuilder, source, registries) -> {
            if(VILLAGE_TEMPLE_CHEST.equals(key.getValue())) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(UniformLootNumberProvider.create(1, 2))
                        .conditionally(RandomChanceLootCondition.builder(0.21f))
                        .with(ItemEntry.builder(ModItems.TORN_MAGIC_SCROLL))
                        .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(1.0f)));
                tableBuilder.pool(poolBuilder).build();
            }
        });


        //ancient city
        LootTableEvents.MODIFY.register((key, tableBuilder, source, registries) -> {
            if(ANCIENT_CITY_CHEST.equals(key.getValue())) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(UniformLootNumberProvider.create(1,2))
                        .conditionally(RandomChanceLootCondition.builder(0.12f))
                        .with(ItemEntry.builder(ModItems.CURSED_SCROLL))
                        .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(1.0f)));
                tableBuilder.pool(poolBuilder).build();
            }
        });

        LootTableEvents.MODIFY.register((key, tableBuilder, source, registries) -> {
            if(ANCIENT_CITY_CHEST.equals(key.getValue())) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(UniformLootNumberProvider.create(1,2))
                        .conditionally(RandomChanceLootCondition.builder(0.08f))
                        .with(ItemEntry.builder(ModItems.POWERFUL_MAGIC_SCROLL))
                        .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(1.0f)));
                tableBuilder.pool(poolBuilder).build();
            }
        });



    }
}
