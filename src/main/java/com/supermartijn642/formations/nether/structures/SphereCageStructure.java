package com.supermartijn642.formations.nether.structures;

import com.supermartijn642.formations.generators.FormationsLootTableGenerator;
import com.supermartijn642.formations.generators.StructureConfiguration;
import com.supermartijn642.formations.generators.StructureConfigurator;
import com.supermartijn642.formations.generators.TemplatePoolGenerator;
import com.supermartijn642.formations.nether.StructureSets;
import com.supermartijn642.formations.structure.StructurePlacement;
import com.supermartijn642.formations.structure.processors.BiomeReplacementProcessor;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.levelgen.structure.TerrainAdjustment;

/**
 * Created 21/09/2023 by SuperMartijn642
 */
public class SphereCageStructure extends StructureConfigurator {

    public SphereCageStructure(){
        super("sphere_cage");
    }

    @Override
    protected void configureStructure(StructureConfiguration configuration){
        configuration.biomeTags(BiomeTags.IS_NETHER.location())
            .set(StructureSets.COMMON)
            .terrainAdjustment(TerrainAdjustment.BURY)
            .simpleType(properties -> properties.templatePool("sphere_cages").placement(StructurePlacement.UNDERGROUND_BURIED));
    }

    @Override
    protected void createTemplatePools(TemplatePoolGenerator generator){
        generator.pool("sphere_cages")
            .entry("sphere_cage1", entry -> {})
            .entry("sphere_cage2", entry -> entry.processors(new BiomeReplacementProcessor()));
    }

    @Override
    protected void createLootTables(FormationsLootTableGenerator generator){
        generator.lootTable("sphere_cage/wither")
            .chestParameters()
            .pool(pool ->
                pool.uniformRolls(5, 9)
                    .itemEntry(Items.WITHER_SKELETON_SKULL, 1, 2, 1)
                    .itemEntry(Items.WITHER_ROSE, 1, 2, 3)
                    .itemEntry(Items.BLAZE_POWDER, 1, 4, 5)
                    .itemEntry(Items.IRON_INGOT, 1, 4, 5)
                    .itemEntry(Items.COAL, 1, 4, 8)
                    .itemEntry(Items.COAL_BLOCK, 1, 3)
            );
        generator.lootTable("sphere_cage/piglin")
            .chestParameters()
            .pool(pool ->
                pool.uniformRolls(6, 9)
                    .itemEntry(Items.NETHERITE_SCRAP, 1, 2, 1)
                    .itemEntry(Items.BLAZE_POWDER, 1, 4, 3)
                    .itemEntry(Items.GOLD_INGOT, 1, 2, 5)
                    .itemEntry(Items.GOLD_NUGGET, 1, 2, 5)
                    .itemEntry(Items.GOLD_BLOCK, 1, 1)
                    .itemEntry(Items.MAGMA_CREAM, 1, 4, 3)
                    .itemEntry(Items.NETHER_WART, 1, 4, 3)
            );
    }
}
