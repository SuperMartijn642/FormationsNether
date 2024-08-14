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
public class ParkourChallengeStructure extends StructureConfigurator {

    public ParkourChallengeStructure(){
        super("parkour_challenge");
    }

    @Override
    protected void configureStructure(StructureConfiguration configuration){
        //noinspection unchecked
        configuration.biomes(Biomes.NETHER_WASTES)
            .set(StructureSets.COMMON)
            .terrainAdjustment(TerrainAdjustment.BEARD_THIN)
            .simpleType(properties -> properties.templatePool("parkour_challenges").placement(StructurePlacement.UNDERGROUND_SURFACE));
    }

    @Override
    protected void createTemplatePools(TemplatePoolGenerator generator){
        generator.pool("parkour_challenges")
            .entry("parkour_challenge1", entry -> entry.groundLevel(1).processors(new BiomeReplacementProcessor()));
    }

    @Override
    protected void createLootTables(FormationsLootTableGenerator generator){
        generator.lootTable("parkour_challenge")
            .pool(pool ->
                pool.uniformRolls(3, 4)
                    .itemEntry(Items.GOLDEN_CARROT, 2, 5, 5)
                    .itemEntry(Items.BLAZE_POWDER, 2, 5, 2)
                    .itemEntry(Items.MAGMA_CREAM, 2, 3, 2)
                    .itemEntry(Items.BONE, 2, 5, 2)
                    .itemEntry(Items.ENDER_PEARL, 2, 3, 1)
            )
            .pool(pool ->
                pool.constantRolls(1)
                    .enchantedItemEntry(Items.GOLDEN_SWORD, 20, 35, 2)
                    .enchantedItemEntry(Items.GOLDEN_PICKAXE, 20, 35, 2)
                    .enchantedItemEntry(Items.GOLDEN_AXE, 20, 35, 2)
                    .enchantedItemEntry(Items.GOLDEN_SHOVEL, 20, 35, 2)
                    .enchantedItemEntry(Items.GOLDEN_HELMET, 20, 35, 2)
                    .enchantedItemEntry(Items.GOLDEN_CHESTPLATE, 20, 35, 2)
                    .enchantedItemEntry(Items.GOLDEN_LEGGINGS, 20, 35, 2)
                    .enchantedItemEntry(Items.GOLDEN_BOOTS, 20, 35, 2)
                    .enchantedItemEntry(Items.IRON_SWORD, 20, 35, 1)
                    .enchantedItemEntry(Items.IRON_PICKAXE, 20, 35, 1)
                    .enchantedItemEntry(Items.IRON_AXE, 20, 35, 1)
                    .enchantedItemEntry(Items.IRON_SHOVEL, 20, 35, 1)
                    .enchantedItemEntry(Items.IRON_HELMET, 20, 35, 1)
                    .enchantedItemEntry(Items.IRON_CHESTPLATE, 20, 35, 1)
                    .enchantedItemEntry(Items.IRON_LEGGINGS, 20, 35, 1)
                    .enchantedItemEntry(Items.IRON_BOOTS, 20, 35, 1)
                    .enchantedItemEntry(Items.BOW, 20, 35, 1)
            );
    }
}
