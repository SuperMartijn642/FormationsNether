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
public class BlackstoneCastleStructure extends StructureConfigurator {

    public BlackstoneCastleStructure(){
        super("blackstone_castle");
    }

    @Override
    protected void configureStructure(StructureConfiguration configuration){
        configuration.biomeTags(BiomeTags.IS_NETHER.location())
            .set(StructureSets.RARE)
            .terrainAdjustment(TerrainAdjustment.BEARD_THIN)
            .simpleType(properties -> properties.templatePool("blackstone_castles").placement(StructurePlacement.UNDERGROUND_SURFACE));
    }

    @Override
    protected void createTemplatePools(TemplatePoolGenerator generator){
        generator.pool("blackstone_castles")
            .commonEntries(entry -> entry.groundLevel(1).processors(new BiomeReplacementProcessor()), "blackstone_castle1", "blackstone_castle2");
    }

    @Override
    protected void createLootTables(FormationsLootTableGenerator generator){
        generator.lootTable("blackstone_castle")
            .chestParameters()
            .pool(pool ->
                pool.uniformRolls(4, 5)
                    .itemEntry(Items.GHAST_TEAR, 1, 3, 15)
                    .itemEntry(Items.WITHER_ROSE, 1, 2, 5)
                    .itemEntry(Items.WARPED_FUNGUS, 2, 5, 10)
                    .itemEntry(Items.CRIMSON_FUNGUS, 2, 5, 10)
                    .itemEntry(Items.MAGMA_CREAM, 2, 5, 15)
                    .itemEntry(Items.NETHER_WART, 2, 4, 20)
                    .itemEntry(Items.BLAZE_POWDER, 1, 7, 10)
                    .itemEntry(Items.BLAZE_ROD, 1, 7, 10)
                    .itemEntry(Items.QUARTZ, 1, 7, 10)
                    .itemEntry(Items.QUARTZ_BLOCK, 1, 7, 10)
                    .itemEntry(Items.GOLDEN_APPLE, 5)
                    .itemEntry(Items.ENCHANTED_GOLDEN_APPLE)
                    .itemEntry(Items.SADDLE)
                    .itemEntry(Items.WARPED_FUNGUS_ON_A_STICK)
                    .itemEntry(Items.BLACKSTONE, 1, 4, 10)
                    .itemEntry(Items.NETHERITE_INGOT, 1, 2, 3)
                    .itemEntry(Items.ANCIENT_DEBRIS, 1, 3, 5)
                    .itemEntry(Items.NETHERITE_SCRAP, 1, 6, 5)
                    .enchantedItemEntry(Items.GOLDEN_SWORD, 20, 35, 2)
                    .enchantedItemEntry(Items.GOLDEN_PICKAXE, 20, 35, 2)
                    .enchantedItemEntry(Items.GOLDEN_AXE, 20, 35, 2)
                    .enchantedItemEntry(Items.GOLDEN_SHOVEL, 20, 35, 2)
                    .enchantedItemEntry(Items.GOLDEN_HELMET, 20, 35, 2)
                    .enchantedItemEntry(Items.GOLDEN_CHESTPLATE, 20, 35, 2)
                    .enchantedItemEntry(Items.GOLDEN_LEGGINGS, 20, 35, 2)
                    .enchantedItemEntry(Items.GOLDEN_BOOTS, 20, 35, 2)
                    .enchantedItemEntry(Items.IRON_SWORD, 20, 35, 2)
                    .enchantedItemEntry(Items.IRON_PICKAXE, 20, 35, 2)
                    .enchantedItemEntry(Items.IRON_AXE, 20, 35, 2)
                    .enchantedItemEntry(Items.IRON_SHOVEL, 20, 35, 2)
                    .enchantedItemEntry(Items.IRON_HELMET, 20, 35, 2)
                    .enchantedItemEntry(Items.IRON_CHESTPLATE, 20, 35, 2)
                    .enchantedItemEntry(Items.IRON_LEGGINGS, 20, 35, 2)
                    .enchantedItemEntry(Items.IRON_BOOTS, 20, 35, 2)
                    .enchantedItemEntry(Items.BOW, 20, 35, 2)
                    .enchantedItemEntry(Items.BOOK, 20, 40, 5)
            );
    }
}
