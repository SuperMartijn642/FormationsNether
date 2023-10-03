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
public class SmallLavaShrineStructure extends StructureConfigurator {

    public SmallLavaShrineStructure(){
        super("small_lava_shrine");
    }

    @Override
    protected void configureStructure(StructureConfiguration configuration){
        //noinspection unchecked
        configuration.biomes(Biomes.NETHER_WASTES)
            .set(StructureSets.COMMON)
            .terrainAdjustment(TerrainAdjustment.BEARD_THIN)
            .simpleType(properties -> properties.templatePool("small_lava_shrines").placement(StructurePlacement.UNDERGROUND_SURFACE));
    }

    @Override
    protected void createTemplatePools(TemplatePoolGenerator generator){
        generator.pool("small_lava_shrines")
            .commonEntries(entry -> entry.groundLevel(2).processors(new BiomeReplacementProcessor()), "small_lava_shrine1", "small_lava_shrine2");
    }

    @Override
    protected void createLootTables(FormationsLootTableGenerator generator){
        generator.lootTable("small_lava_shrine")
            .chestParameters()
            .pool(pool ->
                pool.uniformRolls(4, 5)
                    .itemEntry(Items.NETHERITE_SCRAP, 1, 3, 1)
                    .itemEntry(Items.BLAZE_POWDER, 1, 5, 3)
                    .itemEntry(Items.GOLD_INGOT, 1, 3, 3)
                    .itemEntry(Items.MAGMA_BLOCK, 1, 3, 5)
                    .itemEntry(Items.MAGMA_CREAM, 3, 5, 5)
            );
    }
}
