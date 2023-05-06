package net.fryc.frycscrolls.loot;

import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
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
            = new Identifier("minecraft", "chests/ancient_city");

    private static final Identifier VILLAGE_TEMPLE_CHEST
            = new Identifier("minecraft", "chests/village/village_temple");

    private static final Identifier ABANDONED_MINESHAFT_CHEST
            = new Identifier("minecraft", "chests/abandoned_mineshaft");

    private static final Identifier BASTION_BRIDGE_CHEST
            = new Identifier("minecraft", "chests/bastion_bridge");

    private static final Identifier BASTION_OTHER_CHEST
            = new Identifier("minecraft", "chests/bastion_other");

    private static final Identifier BASTION_HOGLIN_STABLE_CHEST
            = new Identifier("minecraft", "chests/bastion_hoglin_stable");

    private static final Identifier BASTION_TREASURE_CHEST
            = new Identifier("minecraft", "chests/bastion_treasure");

    private static final Identifier BURIED_TREASURE_CHEST
            = new Identifier("minecraft", "chests/buried_treasure");

    private static final Identifier DESERT_PYRAMID_CHEST
            = new Identifier("minecraft", "chests/desert_pyramid");

    private static final Identifier END_CITY_TREASURE_CHEST
            = new Identifier("minecraft", "chests/end_city_treasure");

    private static final Identifier JUNGLE_TEMPLE_CHEST
            = new Identifier("minecraft", "chests/jungle_temple");

    private static final Identifier NETHER_BRIDGE_CHEST
            = new Identifier("minecraft", "chests/nether_bridge");

    private static final Identifier PILLAGER_OUTPOST_CHEST
            = new Identifier("minecraft", "chests/pillager_outpost");

    private static final Identifier STRONGHOLD_LIBRARY_CHEST
            = new Identifier("minecraft", "chests/stronghold_library");

    private static final Identifier SIMPLE_DUNGEON_CHEST
            = new Identifier("minecraft", "chests/simple_dungeon");

    private static final Identifier UNDERWATER_RUIN_SMALL_CHEST
            = new Identifier("minecraft", "chests/underwater_ruin_small");

    private static final Identifier UNDERWATER_RUIN_BIG_CHEST
            = new Identifier("minecraft", "chests/underwater_ruin_big");

    private static final Identifier WOODLAND_MANSION_CHEST
            = new Identifier("minecraft", "chests/woodland_mansion");

    public static void modifyLootTables(){
        //woodland mansion
        LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
            if(WOODLAND_MANSION_CHEST.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(UniformLootNumberProvider.create(1,2))
                        .conditionally(RandomChanceLootCondition.builder(0.13f))
                        .with(ItemEntry.builder(ModItems.CURSED_SCROLL))
                        .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(1.0f)).build());
                tableBuilder.pool(poolBuilder.build());
            }
        });

        LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
            if(WOODLAND_MANSION_CHEST.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(UniformLootNumberProvider.create(1,2))
                        .conditionally(RandomChanceLootCondition.builder(0.004f))
                        .with(ItemEntry.builder(ModItems.POWERFUL_MAGIC_SCROLL))
                        .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(1.0f)).build());
                tableBuilder.pool(poolBuilder.build());
            }
        });

        //underwater ruins
        LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
            if(UNDERWATER_RUIN_BIG_CHEST.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.21f))
                        .with(ItemEntry.builder(ModItems.TORN_MAGIC_SCROLL))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 2.0f)).build());
                tableBuilder.pool(poolBuilder.build());
            }
        });

        LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
            if(UNDERWATER_RUIN_SMALL_CHEST.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.18f))
                        .with(ItemEntry.builder(ModItems.TORN_MAGIC_SCROLL))
                        .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(1.0f)).build());
                tableBuilder.pool(poolBuilder.build());
            }
        });

        //dungeon (with spawner)
        LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
            if(SIMPLE_DUNGEON_CHEST.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(UniformLootNumberProvider.create(1, 3))
                        .conditionally(RandomChanceLootCondition.builder(0.21f))
                        .with(ItemEntry.builder(ModItems.MAGIC_SCROLL))
                        .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(1.0f)).build());
                tableBuilder.pool(poolBuilder.build());
            }
        });

        LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
            if(SIMPLE_DUNGEON_CHEST.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.0413f))
                        .with(ItemEntry.builder(ModItems.CURSED_SCROLL))
                        .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(1.0f)).build());
                tableBuilder.pool(poolBuilder.build());
            }
        });

        //stronghold
        LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
            if(STRONGHOLD_LIBRARY_CHEST.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(UniformLootNumberProvider.create(1, 2))
                        .conditionally(RandomChanceLootCondition.builder(0.413f))
                        .with(ItemEntry.builder(ModItems.CURSED_SCROLL))
                        .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(1.0f)).build());
                tableBuilder.pool(poolBuilder.build());
            }
        });

        LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
            if(STRONGHOLD_LIBRARY_CHEST.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(UniformLootNumberProvider.create(1, 2))
                        .conditionally(RandomChanceLootCondition.builder(0.26f))
                        .with(ItemEntry.builder(ModItems.POWERFUL_MAGIC_SCROLL))
                        .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(1.0f)).build());
                tableBuilder.pool(poolBuilder.build());
            }
        });

        //pillager outpost
        LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
            if(PILLAGER_OUTPOST_CHEST.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(UniformLootNumberProvider.create(1,2))
                        .conditionally(RandomChanceLootCondition.builder(0.164f))
                        .with(ItemEntry.builder(ModItems.MAGIC_SCROLL))
                        .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(1.0f)).build());
                tableBuilder.pool(poolBuilder.build());
            }
        });

        //nether bridge
        LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
            if(NETHER_BRIDGE_CHEST.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(UniformLootNumberProvider.create(1, 2))
                        .conditionally(RandomChanceLootCondition.builder(0.22f))
                        .with(ItemEntry.builder(ModItems.MAGIC_SCROLL))
                        .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(1.0f)).build());
                tableBuilder.pool(poolBuilder.build());
            }
        });

        //jungle temple
        LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
            if(JUNGLE_TEMPLE_CHEST.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(UniformLootNumberProvider.create(1, 2))
                        .conditionally(RandomChanceLootCondition.builder(0.0513f))
                        .with(ItemEntry.builder(ModItems.CURSED_SCROLL))
                        .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(1.0f)).build());
                tableBuilder.pool(poolBuilder.build());
            }
        });

        //end city
        LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
            if(END_CITY_TREASURE_CHEST.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(UniformLootNumberProvider.create(1,2))
                        .conditionally(RandomChanceLootCondition.builder(0.12f))
                        .with(ItemEntry.builder(ModItems.POWERFUL_MAGIC_SCROLL))
                        .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(1.0f)).build());
                tableBuilder.pool(poolBuilder.build());
            }
        });

        //desert pyramid
        LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
            if(DESERT_PYRAMID_CHEST.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.013f))
                        .with(ItemEntry.builder(ModItems.CURSED_SCROLL))
                        .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(1.0f)).build());
                tableBuilder.pool(poolBuilder.build());
            }
        });

        LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
            if(DESERT_PYRAMID_CHEST.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(UniformLootNumberProvider.create(1,2))
                        .conditionally(RandomChanceLootCondition.builder(0.22f))
                        .with(ItemEntry.builder(ModItems.TORN_MAGIC_SCROLL))
                        .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(1.0f)).build());
                tableBuilder.pool(poolBuilder.build());
            }
        });

        //buried treasure
        LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
            if(BURIED_TREASURE_CHEST.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(UniformLootNumberProvider.create(1, 2))
                        .conditionally(RandomChanceLootCondition.builder(0.05f))
                        .with(ItemEntry.builder(ModItems.MAGIC_SCROLL))
                        .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(1.0f)).build());
                tableBuilder.pool(poolBuilder.build());
            }
        });

        //bastion
        LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
            if(BASTION_TREASURE_CHEST.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(UniformLootNumberProvider.create(1, 2))
                        .conditionally(RandomChanceLootCondition.builder(0.16f))
                        .with(ItemEntry.builder(ModItems.POWERFUL_MAGIC_SCROLL))
                        .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(1.0f)).build());
                tableBuilder.pool(poolBuilder.build());
            }
        });

        LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
            if(BASTION_HOGLIN_STABLE_CHEST.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(UniformLootNumberProvider.create(1, 2))
                        .conditionally(RandomChanceLootCondition.builder(0.19f))
                        .with(ItemEntry.builder(ModItems.CURSED_SCROLL))
                        .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(1.0f)).build());
                tableBuilder.pool(poolBuilder.build());
            }
        });

        LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
            if(BASTION_HOGLIN_STABLE_CHEST.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(UniformLootNumberProvider.create(1, 2))
                        .conditionally(RandomChanceLootCondition.builder(0.1f))
                        .with(ItemEntry.builder(ModItems.POWERFUL_MAGIC_SCROLL))
                        .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(1.0f)).build());
                tableBuilder.pool(poolBuilder.build());
            }
        });

        LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
            if(BASTION_OTHER_CHEST.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(UniformLootNumberProvider.create(1, 2))
                        .conditionally(RandomChanceLootCondition.builder(0.076f))
                        .with(ItemEntry.builder(ModItems.POWERFUL_MAGIC_SCROLL))
                        .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(1.0f)).build());
                tableBuilder.pool(poolBuilder.build());
            }
        });

        LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
            if(BASTION_BRIDGE_CHEST.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(UniformLootNumberProvider.create(1, 2))
                        .conditionally(RandomChanceLootCondition.builder(0.076f))
                        .with(ItemEntry.builder(ModItems.CURSED_SCROLL))
                        .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(1.0f)).build());
                tableBuilder.pool(poolBuilder.build());
            }
        });

        //mineshaft
        LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
            if(ABANDONED_MINESHAFT_CHEST.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(UniformLootNumberProvider.create(1,3))
                        .conditionally(RandomChanceLootCondition.builder(0.12f))
                        .with(ItemEntry.builder(ModItems.MAGIC_SCROLL))
                        .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(1.0f)).build());
                tableBuilder.pool(poolBuilder.build());
            }
        });

        //village
        LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
            if(VILLAGE_TEMPLE_CHEST.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(UniformLootNumberProvider.create(1, 2))
                        .conditionally(RandomChanceLootCondition.builder(0.21f))
                        .with(ItemEntry.builder(ModItems.TORN_MAGIC_SCROLL))
                        .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(1.0f)).build());
                tableBuilder.pool(poolBuilder.build());
            }
        });


        //ancient city
        LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
            if(ANCIENT_CITY_CHEST.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(UniformLootNumberProvider.create(1,2))
                        .conditionally(RandomChanceLootCondition.builder(0.12f))
                        .with(ItemEntry.builder(ModItems.CURSED_SCROLL))
                        .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(1.0f)).build());
                tableBuilder.pool(poolBuilder.build());
            }
        });

        LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
            if(ANCIENT_CITY_CHEST.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(UniformLootNumberProvider.create(1,2))
                        .conditionally(RandomChanceLootCondition.builder(0.08f))
                        .with(ItemEntry.builder(ModItems.POWERFUL_MAGIC_SCROLL))
                        .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(1.0f)).build());
                tableBuilder.pool(poolBuilder.build());
            }
        });

    }
}
