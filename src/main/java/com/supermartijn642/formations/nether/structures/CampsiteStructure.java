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
public class CampsiteStructure extends StructureConfigurator {

    public CampsiteStructure(){
        super("campsite");
    }

    @Override
    protected void configureStructure(StructureConfiguration configuration){
        //noinspection unchecked
        configuration.biomes(Biomes.CRIMSON_FOREST, Biomes.WARPED_FOREST)
            .set(StructureSets.COMMON)
            .terrainAdjustment(TerrainAdjustment.BEARD_THIN)
            .simpleType(properties -> properties.templatePool("campsites").placement(StructurePlacement.UNDERGROUND_SURFACE));
    }

    @Override
    protected void createTemplatePools(TemplatePoolGenerator generator){
        generator.pool("campsites")
            .commonEntries(entry -> entry.groundLevel(1).processors(new BiomeReplacementProcessor()), "campsite1", "campsite2");
    }

    @Override
    protected void createLootTables(FormationsLootTableGenerator generator){
        generator.lootTable("campsite")
            .chestParameters()
            .pool(pool ->
                pool.uniformRolls(2,4)
                    .itemEntry(Items.GHAST_TEAR, 1, 2, 2)
                    .itemEntry(Items.WARPED_FUNGUS, 1, 2, 3)
                    .itemEntry(Items.CRIMSON_FUNGUS, 1, 2, 3)
                    .itemEntry(Items.NETHER_WART, 1, 3, 5)
                    .itemEntry(Items.BLAZE_POWDER, 1, 3, 3)
                    .itemEntry(Items.GOLDEN_APPLE)
                    .itemEntry(Items.SADDLE)
                    .itemEntry(Items.WARPED_FUNGUS_ON_A_STICK, 2)
            );
    }
}
