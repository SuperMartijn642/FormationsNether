package com.supermartijn642.formations.nether;

import com.supermartijn642.formations.generators.StructureResourceGenerators;
import com.supermartijn642.formations.nether.structures.*;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;

/**
 * Created 7/7/2020 by SuperMartijn642
 */
public class FormationsNether implements ModInitializer {

    public static final String MODID = "formationsnether";

    @Override
    public void onInitialize(){
        if(FabricLoader.getInstance().isModLoaded("supermartijn642corelib") && FabricLoader.getInstance().isDevelopmentEnvironment())
            registerGenerators();
    }

    private static void registerGenerators(){
        StructureResourceGenerators generators = new StructureResourceGenerators(MODID);

        generators.addStructure(new BasaltHutStructure());
        generators.addStructure(new BlackstoneCastleStructure());
        generators.addStructure(new BlackstoneRemnantStructure());
        generators.addStructure(new CampsiteStructure());
        generators.addStructure(new CheckerboardTempleStructure());
        generators.addStructure(new FlamingPillarStructure());
        generators.addStructure(new LargeHouseStructure());
        generators.addStructure(new LargePedestalStructure());
        generators.addStructure(new LargeTreeStructure());
        generators.addStructure(new NetherWartFieldStructure());
        generators.addStructure(new ObsidianPillarStructure());
        generators.addStructure(new OreShardStructure());
        generators.addStructure(new ParkourChallengeStructure());
        generators.addStructure(new QuartzSpikesStructure());
        generators.addStructure(new RespawnAnchorAltarStructure());
        generators.addStructure(new RibCageStructure());
        generators.addStructure(new SmallFireArenaStructure());
        generators.addStructure(new SmallLavaArenaStructure());
        generators.addStructure(new SmallLavaShrineStructure());
        generators.addStructure(new SmallPedestalStructure());
        generators.addStructure(new SphereCageStructure());

        generators.register();
    }
}
