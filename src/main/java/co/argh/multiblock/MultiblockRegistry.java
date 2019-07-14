package co.argh.multiblock;

import java.util.ArrayList;

import co.argh.Argh;
import co.argh.structure.Structure;
import co.argh.structure.StructureUtils;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class MultiblockRegistry {

	public static ArrayList<Structure> structures;

	public static Structure toolpress;
	
	public static void init_structures() {
		
		structures = new ArrayList<Structure>();
		
		toolpress = StructureUtils.loadStructure(new ResourceLocation(Argh.MODID, "structures/toolpress.json"));
		
		structures.add(toolpress);
		
		for(Structure s : structures)
			s.printSize();
	}
	
	public static void init_tile_entities() {
		GameRegistry.registerTileEntity(TileEntityToolPress.class, new ResourceLocation(Argh.MODID, "toolpress"));
	}
	
}
