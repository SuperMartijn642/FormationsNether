package com.supermartijn642.formations.nether.structures;

import com.supermartijn642.formations.generators.FormationsLootTableGenerator;
import com.supermartijn642.formations.generators.StructureConfiguration;
import com.supermartijn642.formations.generators.StructureConfigurator;
import com.supermartijn642.formations.generators.TemplatePoolGenerator;
import com.supermartijn642.formations.nether.StructureSets;
import com.supermartijn642.formations.structure.StructurePlacement;
import com.supermartijn642.formations.structure.processors.BiomeReplacementProcessor;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.levelgen.structure.TerrainAdjustment;

/**
 * Created 21/09/2023 by SuperMartijn642
 */
public class LargeTreeStructure extends StructureConfigurator {

    public LargeTreeStructure(){
        super("large_tree");
    }

    @Override
    protected void configureStructure(StructureConfiguration configuration){
        //noinspection unchecked
        configuration.biomes(Biomes.CRIMSON_FOREST, Biomes.WARPED_FOREST)
            .set(StructureSets.COMMON)
            .terrainAdjustment(TerrainAdjustment.BEARD_THIN)
            .simpleType(properties -> properties.templatePool("large_trees").placement(StructurePlacement.UNDERGROUND_SURFACE));
    }

    @Override
    protected void createTemplatePools(TemplatePoolGenerator generator){
        generator.pool("large_trees")
            .entry("large_tree", entry -> entry.groundLevel(1).processors(new BiomeReplacementProcessor()));
    }

    @Override
    protected void createLootTables(FormationsLootTableGenerator generator){
        generator.lootTable("large_tree")
            .chestParameters()
            .pool(pool ->
                pool.uniformRolls(3, 4)
                    .itemEntry(Items.GOLD_INGOT)
                    .itemEntry(Items.GOLD_NUGGET, 1, 4, 1)
                    .itemEntry(Items.WARPED_FUNGUS, 1, 2, 2)
                    .itemEntry(Items.CRIMSON_FUNGUS, 1, 2, 2)
                    .itemEntry(Items.GLOWSTONE_DUST, 1, 4, 1)
                    .itemEntry(Items.GLOW_BERRIES, 1, 4, 1)
            );
    }
}
