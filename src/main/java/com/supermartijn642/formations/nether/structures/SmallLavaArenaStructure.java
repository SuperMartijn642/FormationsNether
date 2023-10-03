package com.supermartijn642.formations.nether.structures;

import com.supermartijn642.formations.generators.FormationsLootTableGenerator;
import com.supermartijn642.formations.generators.StructureConfiguration;
import com.supermartijn642.formations.generators.StructureConfigurator;
import com.supermartijn642.formations.generators.TemplatePoolGenerator;
import com.supermartijn642.formations.nether.StructureSets;
import com.supermartijn642.formations.structure.StructurePlacement;
import com.supermartijn642.formations.structure.processors.BiomeReplacementProcessor;
import com.supermartijn642.formations.structure.processors.RespawnAnchorProcessor;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.levelgen.structure.TerrainAdjustment;

/**
 * Created 21/09/2023 by SuperMartijn642
 */
public class SmallLavaArenaStructure extends StructureConfigurator {

    public SmallLavaArenaStructure(){
        super("small_lava_arena");
    }

    @Override
    protected void configureStructure(StructureConfiguration configuration){
        configuration.biomeTags(BiomeTags.IS_NETHER.location())
            .set(StructureSets.COMMON)
            .terrainAdjustment(TerrainAdjustment.BEARD_THIN)
            .simpleType(properties -> properties.templatePool("small_lava_arenas").placement(StructurePlacement.UNDERGROUND_SURFACE));
    }

    @Override
    protected void createTemplatePools(TemplatePoolGenerator generator){
        generator.pool("small_lava_arenas")
            .entry("small_lava_arena", entry -> entry.groundLevel(3).processors(new BiomeReplacementProcessor(), new RespawnAnchorProcessor()));
    }

    @Override
    protected void createLootTables(FormationsLootTableGenerator generator){
        generator.lootTable("small_lava_arena")
            .chestParameters()
            .pool(pool ->
                pool.uniformRolls(4, 6)
                    .itemEntry(Items.NETHERITE_SCRAP, 1, 4, 1)
                    .itemEntry(Items.GOLD_INGOT, 1, 4, 1)
                    .itemEntry(Items.GOLD_BLOCK)
                    .itemEntry(Items.ENCHANTED_GOLDEN_APPLE)
                    .itemEntry(Items.GHAST_TEAR, 1, 3)
                    .itemEntry(Items.BLAZE_ROD, 1, 3)
            );
    }
}
