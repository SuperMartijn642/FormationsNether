package com.supermartijn642.formations.nether.structures;

import com.supermartijn642.formations.generators.StructureConfiguration;
import com.supermartijn642.formations.generators.StructureConfigurator;
import com.supermartijn642.formations.generators.TemplatePoolGenerator;
import com.supermartijn642.formations.nether.StructureSets;
import com.supermartijn642.formations.structure.StructurePlacement;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.levelgen.structure.TerrainAdjustment;

/**
 * Created 21/09/2023 by SuperMartijn642
 */
public class FlamingPillarStructure extends StructureConfigurator {

    public FlamingPillarStructure(){
        super("flaming_pillar");
    }

    @Override
    protected void configureStructure(StructureConfiguration configuration){
        //noinspection unchecked
        configuration.biomes(Biomes.NETHER_WASTES)
            .set(StructureSets.COMMON)
            .terrainAdjustment(TerrainAdjustment.NONE)
            .simpleType(properties -> properties.templatePool("flaming_pillars").placement(StructurePlacement.UNDERGROUND_ON_LAVA));
    }

    @Override
    protected void createTemplatePools(TemplatePoolGenerator generator){
        generator.pool("flaming_pillars")
            .entry("flaming_pillar", entry -> entry.groundLevel(15));
    }
}
