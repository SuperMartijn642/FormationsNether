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
public class QuartzSpikesStructure extends StructureConfigurator {

    public QuartzSpikesStructure(){
        super("quartz_spikes");
    }

    @Override
    protected void configureStructure(StructureConfiguration configuration){
        //noinspection unchecked
        configuration.biomes(Biomes.NETHER_WASTES, Biomes.SOUL_SAND_VALLEY)
            .set(StructureSets.COMMON)
            .terrainAdjustment(TerrainAdjustment.BEARD_THIN)
            .simpleType(properties -> properties.templatePool("quartz_spikes").placement(StructurePlacement.UNDERGROUND_SURFACE));
    }

    @Override
    protected void createTemplatePools(TemplatePoolGenerator generator){
        generator.pool("quartz_spikes")
            .entry("quartz_spikes1", entry -> entry.groundLevel(1).processors(new BiomeReplacementProcessor()))
            .commonEntries(entry -> entry.groundLevel(3).processors(new BiomeReplacementProcessor()), "quartz_spikes2", "quartz_spikes3");
    }
}
