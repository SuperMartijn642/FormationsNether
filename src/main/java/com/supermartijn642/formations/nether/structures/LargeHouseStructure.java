package com.supermartijn642.formations.nether.structures;

import com.supermartijn642.formations.generators.FormationsLootTableGenerator;
import com.supermartijn642.formations.generators.StructureConfiguration;
import com.supermartijn642.formations.generators.StructureConfigurator;
import com.supermartijn642.formations.generators.TemplatePoolGenerator;
import com.supermartijn642.formations.nether.StructureSets;
import com.supermartijn642.formations.structure.StructurePlacement;
import com.supermartijn642.formations.structure.processors.*;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.levelgen.structure.TerrainAdjustment;

/**
 * Created 21/09/2023 by SuperMartijn642
 */
public class LargeHouseStructure extends StructureConfigurator {

    public LargeHouseStructure(){
        super("large_house");
    }

    @Override
    protected void configureStructure(StructureConfiguration configuration){
        //noinspection unchecked
        configuration.biomes(Biomes.CRIMSON_FOREST, Biomes.WARPED_FOREST)
            .set(StructureSets.COMMON)
            .terrainAdjustment(TerrainAdjustment.BEARD_THIN)
            .simpleType(properties -> properties.templatePool("large_houses").placement(StructurePlacement.UNDERGROUND_SURFACE));
    }

    @Override
    protected void createTemplatePools(TemplatePoolGenerator generator){
        generator.pool("large_houses")
            .entry("large_house", entry -> entry.groundLevel(1).processors(new BiomeReplacementProcessor(), new PlantGrowthProcessor(0, 1), new BrewingStandProcessor(0.5f, 5), new ChiseledBookshelfProcessor(0.15f), new RespawnAnchorProcessor()));
    }

    @Override
    protected void createLootTables(FormationsLootTableGenerator generator){
        generator.lootTable("large_house/chest")
            .chestParameters()
            .pool(pool ->
                pool.uniformRolls(5, 7)
                    .itemEntry(Items.GHAST_TEAR)
                    .itemEntry(Items.WITHER_ROSE)
                    .itemEntry(Items.WARPED_FUNGUS)
                    .itemEntry(Items.CRIMSON_FUNGUS)
                    .itemEntry(Items.MAGMA_CREAM)
                    .enchantedItemEntry(Items.GOLDEN_SWORD, 25, 35, 1)
                    .itemEntry(Items.NETHER_WART, 1, 2, 1)
                    .itemEntry(Items.BLAZE_POWDER, 1, 2, 1)
                    .itemEntry(Items.GOLDEN_APPLE)
                    .itemEntry(Items.SADDLE)
                    .itemEntry(Items.WARPED_FUNGUS_ON_A_STICK)
            );
        generator.lootTable("large_house/barrel")
            .chestParameters()
            .pool(pool ->
                pool.uniformRolls(1, 5)
                    .itemEntry(Items.NETHERITE_SCRAP, 1, 2, 2)
                    .itemEntry(Items.GOLD_INGOT, 1, 2, 5)
                    .itemEntry(Items.GOLD_NUGGET, 1, 2, 5)
                    .itemEntry(Items.IRON_INGOT, 1, 2, 5)
                    .itemEntry(Items.IRON_NUGGET, 1, 2, 5)
            );
    }
}
