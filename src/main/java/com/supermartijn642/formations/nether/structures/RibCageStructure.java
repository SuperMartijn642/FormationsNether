package com.supermartijn642.formations.nether.structures;

import com.supermartijn642.formations.generators.FormationsLootTableGenerator;
import com.supermartijn642.formations.generators.StructureConfiguration;
import com.supermartijn642.formations.generators.StructureConfigurator;
import com.supermartijn642.formations.generators.TemplatePoolGenerator;
import com.supermartijn642.formations.nether.StructureSets;
import com.supermartijn642.formations.structure.StructurePlacement;
import com.supermartijn642.formations.structure.processors.BiomeReplacementProcessor;
import com.supermartijn642.formations.structure.processors.BrewingStandProcessor;
import com.supermartijn642.formations.structure.processors.PlantGrowthProcessor;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.levelgen.structure.TerrainAdjustment;

/**
 * Created 21/09/2023 by SuperMartijn642
 */
public class RibCageStructure extends StructureConfigurator {

    public RibCageStructure(){
        super("rib_cage");
    }

    @Override
    protected void configureStructure(StructureConfiguration configuration){
        //noinspection unchecked
        configuration.biomes(Biomes.NETHER_WASTES, Biomes.SOUL_SAND_VALLEY, Biomes.CRIMSON_FOREST, Biomes.WARPED_FOREST)
            .set(StructureSets.COMMON)
            .terrainAdjustment(TerrainAdjustment.BEARD_THIN)
            .simpleType(properties -> properties.templatePool("rib_cages").placement(StructurePlacement.UNDERGROUND_SURFACE));
    }

    @Override
    protected void createTemplatePools(TemplatePoolGenerator generator){
        generator.pool("rib_cages")
            .commonEntries(entry -> entry.groundLevel(3).processors(new BiomeReplacementProcessor(), new PlantGrowthProcessor(0, 1), new BrewingStandProcessor(0.3f, 6)), "rib_cage1", "rib_cage2");
    }

    @Override
    protected void createLootTables(FormationsLootTableGenerator generator){
        generator.lootTable("rib_cage")
            .chestParameters()
            .pool(pool ->
                pool.uniformRolls(4, 6)
                    .itemEntry(Items.MUSHROOM_STEW, 3)
                    .itemEntry(Items.BONE, 2, 4, 3)
                    .itemEntry(Items.BLAZE_POWDER, 2, 4, 3)
                    .itemEntry(Items.GLASS, 2, 4, 3)
                    .itemEntry(Items.MAGMA_CREAM, 2, 4, 3)
                    .itemEntry(Items.ENDER_PEARL, 1, 4, 2)
                    .itemEntry(Items.NETHERRACK, 1, 2, 3)
            );
    }
}
