package com.supermartijn642.formations.nether.structures;

import com.supermartijn642.formations.generators.StructureConfiguration;
import com.supermartijn642.formations.generators.StructureConfigurator;
import com.supermartijn642.formations.generators.TemplatePoolGenerator;
import com.supermartijn642.formations.nether.StructureSets;
import com.supermartijn642.formations.structure.StructurePlacement;
import com.supermartijn642.formations.structure.processors.BiomeReplacementProcessor;
import com.supermartijn642.formations.structure.processors.RespawnAnchorProcessor;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.levelgen.structure.TerrainAdjustment;

/**
 * Created 21/09/2023 by SuperMartijn642
 */
public class RespawnAnchorAltarStructure extends StructureConfigurator {

    public RespawnAnchorAltarStructure(){
        super("respawn_anchor_altar");
    }

    @Override
    protected void configureStructure(StructureConfiguration configuration){
        configuration.biomeTags(BiomeTags.IS_NETHER.location())
            .set(StructureSets.COMMON)
            .terrainAdjustment(TerrainAdjustment.BEARD_THIN)
            .simpleType(properties -> properties.templatePool("respawn_anchor_altars").placement(StructurePlacement.UNDERGROUND_SURFACE));
    }

    @Override
    protected void createTemplatePools(TemplatePoolGenerator generator){
        generator.pool("respawn_anchor_altars")
            .entry("respawn_anchor_altar", entry -> entry.groundLevel(1).processors(new BiomeReplacementProcessor(), new RespawnAnchorProcessor()));
    }
}
