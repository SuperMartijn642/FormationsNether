package com.supermartijn642.formations.nether.structures;

import com.supermartijn642.formations.generators.StructureConfiguration;
import com.supermartijn642.formations.generators.StructureConfigurator;
import com.supermartijn642.formations.generators.TemplatePoolGenerator;
import com.supermartijn642.formations.nether.StructureSets;
import com.supermartijn642.formations.structure.StructurePlacement;
import com.supermartijn642.formations.structure.processors.BiomeReplacementProcessor;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.levelgen.structure.TerrainAdjustment;

/**
 * Created 21/09/2023 by SuperMartijn642
 */
public class SmallPedestalStructure extends StructureConfigurator {

    public SmallPedestalStructure(){
        super("small_pedestal");
    }

    @Override
    protected void configureStructure(StructureConfiguration configuration){
        //noinspection unchecked
        configuration.biomes(Biomes.CRIMSON_FOREST, Biomes.WARPED_FOREST)
            .set(StructureSets.COMMON)
            .terrainAdjustment(TerrainAdjustment.BEARD_THIN)
            .simpleType(properties -> properties.templatePool("small_pedestals").placement(StructurePlacement.UNDERGROUND_SURFACE));
    }

    @Override
    protected void createTemplatePools(TemplatePoolGenerator generator){
        generator.pool("small_pedestals")
            .commonEntries(entry -> entry.groundLevel(1).processors(new BiomeReplacementProcessor()), "small_pedestal1", "small_pedestal2");
    }
}
