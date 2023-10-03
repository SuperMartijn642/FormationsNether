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
public class CheckerboardTempleStructure extends StructureConfigurator {

    public CheckerboardTempleStructure(){
        super("checkerboard_temple");
    }

    @Override
    protected void configureStructure(StructureConfiguration configuration){
        //noinspection unchecked
        configuration.biomes(Biomes.NETHER_WASTES, Biomes.SOUL_SAND_VALLEY, Biomes.BASALT_DELTAS)
            .set(StructureSets.RARE)
            .terrainAdjustment(TerrainAdjustment.BEARD_THIN)
            .simpleType(properties -> properties.templatePool("checkerboard_temples").placement(StructurePlacement.UNDERGROUND_SURFACE));
    }

    @Override
    protected void createTemplatePools(TemplatePoolGenerator generator){
        generator.pool("checkerboard_temples")
            .entry("checkerboard_temple", entry -> entry.groundLevel(1).processors(new BiomeReplacementProcessor()));
    }
}
