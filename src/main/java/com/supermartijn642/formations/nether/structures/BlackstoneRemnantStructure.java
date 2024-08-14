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
public class BlackstoneRemnantStructure extends StructureConfigurator {

    public BlackstoneRemnantStructure(){
        super("blackstone_remnant");
    }

    @Override
    protected void configureStructure(StructureConfiguration configuration){
        configuration.biomeTags(BiomeTags.IS_NETHER.location())
            .set(StructureSets.COMMON)
            .terrainAdjustment(TerrainAdjustment.BEARD_THIN)
            .simpleType(properties -> properties.templatePool("blackstone_remnants").placement(StructurePlacement.UNDERGROUND_SURFACE));
    }

    @Override
    protected void createTemplatePools(TemplatePoolGenerator generator){
        generator.pool("blackstone_remnants")
            .commonEntries(entry -> entry.groundLevel(1).processors(new BiomeReplacementProcessor()), "blackstone_remnant1", "blackstone_remnant2");
    }

    @Override
    protected void createLootTables(FormationsLootTableGenerator generator){
        generator.lootTable("blackstone_remnant")
            .chestParameters()
            .pool(pool ->
                pool.uniformRolls(2, 4)
                    .itemEntry(Items.BLACKSTONE, 1, 2, 3)
                    .itemEntry(Items.GOLD_INGOT, 1, 3, 1)
                    .itemEntry(Items.GOLD_NUGGET, 1, 1)
            )
            .pool(pool ->
                pool.uniformRolls(0, 1)
                    .enchantedItemEntry(Items.BOW, 10, 20, 1)
            );
    }
}
