package com.supermartijn642.formations.nether.structures;

import com.supermartijn642.formations.generators.FormationsLootTableGenerator;
import com.supermartijn642.formations.generators.StructureConfiguration;
import com.supermartijn642.formations.generators.StructureConfigurator;
import com.supermartijn642.formations.generators.TemplatePoolGenerator;
import com.supermartijn642.formations.nether.StructureSets;
import com.supermartijn642.formations.structure.StructurePlacement;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.levelgen.structure.TerrainAdjustment;

/**
 * Created 21/09/2023 by SuperMartijn642
 */
public class SmallFireArenaStructure extends StructureConfigurator {

    public SmallFireArenaStructure(){
        super("small_fire_arena");
    }

    @Override
    protected void configureStructure(StructureConfiguration configuration){
        //noinspection unchecked
        configuration.biomes(Biomes.NETHER_WASTES, Biomes.SOUL_SAND_VALLEY, Biomes.BASALT_DELTAS)
            .set(StructureSets.COMMON)
            .terrainAdjustment(TerrainAdjustment.BEARD_THIN)
            .simpleType(properties -> properties.templatePool("small_fire_arenas").placement(StructurePlacement.UNDERGROUND_SURFACE));
    }

    @Override
    protected void createTemplatePools(TemplatePoolGenerator generator){
        generator.pool("small_fire_arenas")
            .entry("small_fire_arena", entry -> entry.groundLevel(2));
    }

    @Override
    protected void createLootTables(FormationsLootTableGenerator generator){
        generator.lootTable("small_fire_arena")
            .chestParameters()
            .pool(pool ->
                pool.uniformRolls(5, 6)
                    .itemEntry(Items.BONE, 1, 2, 15)
                    .itemEntry(Items.COAL, 1, 2, 15)
                    .itemEntry(Items.WITHER_ROSE, 2)
                    .itemEntry(Items.WITHER_SKELETON_SKULL, 1)
            )
            .pool(pool ->
                pool.uniformRolls(1, 2)
                    .enchantedItemEntry(Items.IRON_SWORD, 20, 35, false, 2)
                    .enchantedItemEntry(Items.IRON_PICKAXE, 20, 35, false, 2)
                    .enchantedItemEntry(Items.IRON_AXE, 20, 35, false, 2)
                    .enchantedItemEntry(Items.IRON_SHOVEL, 20, 35, false, 2)
                    .enchantedItemEntry(Items.IRON_HELMET, 20, 35, false, 2)
                    .enchantedItemEntry(Items.IRON_CHESTPLATE, 20, 35, false, 2)
                    .enchantedItemEntry(Items.IRON_LEGGINGS, 20, 35, false, 2)
                    .enchantedItemEntry(Items.IRON_BOOTS, 20, 35, false, 2)
                    .enchantedItemEntry(Items.BOOK, 20, 35, false, 4)
                    .itemEntry(Items.TOTEM_OF_UNDYING)
            );
    }
}
