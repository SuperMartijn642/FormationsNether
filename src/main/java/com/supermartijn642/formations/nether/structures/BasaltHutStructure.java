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
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.structure.TerrainAdjustment;

/**
 * Created 21/09/2023 by SuperMartijn642
 */
public class BasaltHutStructure extends StructureConfigurator {

    public BasaltHutStructure(){
        super("basalt_hut");
    }

    @Override
    protected void configureStructure(StructureConfiguration configuration){
        //noinspection unchecked
        configuration.biomes(Biomes.BASALT_DELTAS)
            .set(StructureSets.COMMON)
            .terrainAdjustment(TerrainAdjustment.BEARD_THIN)
            .generationStep(GenerationStep.Decoration.UNDERGROUND_STRUCTURES)
            .simpleType(properties -> properties.templatePool("basalt_huts").placement(StructurePlacement.UNDERGROUND_SURFACE));
    }

    @Override
    protected void createTemplatePools(TemplatePoolGenerator generator){
        generator.pool("basalt_huts")
            .commonEntries(entry -> entry.groundLevel(1).processors(new BiomeReplacementProcessor(), new PlantGrowthProcessor(0, 1), new BrewingStandProcessor(0.3f, 4)), "basalt_hut1", "basalt_hut2");
    }

    @Override
    protected void createLootTables(FormationsLootTableGenerator generator){
        generator.lootTable("basalt_hut")
            .chestParameters()
            .pool(pool ->
                pool.uniformRolls(3, 4)
                    .itemEntry(Items.GHAST_TEAR, 1, 2)
                    .itemEntry(Items.MAGMA_CREAM, 1, 2, 1)
                    .itemEntry(Items.NETHER_WART, 1, 2, 1)
                    .itemEntry(Items.BLAZE_POWDER, 1, 2, 1)
                    .itemEntry(Items.SADDLE)
                    .itemEntry(Items.WARPED_FUNGUS_ON_A_STICK)
                    .itemEntry(Items.MUSHROOM_STEW)
                    .itemEntry(Items.SUSPICIOUS_STEW)
            );
    }
}
