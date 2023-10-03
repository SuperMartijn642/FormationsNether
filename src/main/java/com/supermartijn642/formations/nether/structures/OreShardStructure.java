package com.supermartijn642.formations.nether.structures;

import com.supermartijn642.formations.generators.StructureConfiguration;
import com.supermartijn642.formations.generators.StructureConfigurator;
import com.supermartijn642.formations.generators.TemplatePoolGenerator;
import com.supermartijn642.formations.nether.StructureSets;
import com.supermartijn642.formations.structure.StructurePlacement;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.structure.TerrainAdjustment;

/**
 * Created 21/09/2023 by SuperMartijn642
 */
public class OreShardStructure extends StructureConfigurator {

    public OreShardStructure(){
        super("ore_shard");
    }

    @Override
    protected void configureStructure(StructureConfiguration configuration){
        configuration.biomeTags(BiomeTags.IS_NETHER.location())
            .set(StructureSets.ORE_SHARDS)
            .generationStep(GenerationStep.Decoration.UNDERGROUND_STRUCTURES)
            .terrainAdjustment(TerrainAdjustment.NONE)
            .simpleType(properties -> properties.templatePool("ore_shards").placement(StructurePlacement.UNDERGROUND_CEILING));
    }

    @Override
    protected void createTemplatePools(TemplatePoolGenerator generator){
        generator.pool("ore_shards")
            .commonEntries(entry -> entry.groundLevel(26), "ore_shard1", "ore_shard2", "ore_shard3", "ore_shard4");
    }
}
