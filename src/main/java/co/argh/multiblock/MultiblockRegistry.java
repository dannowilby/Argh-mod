package co.argh.multiblock;

import java.util.ArrayList;

import co.argh.Argh;
import co.argh.structure.Structure;
import co.argh.structure.StructureUtils;
import net.minecraft.util.ResourceLocation;

public class MultiblockRegistry {

	public static ArrayList<Structure> structures;
	
	public static void init_structures() {
		
		structures = new ArrayList<Structure>();
		structures.add(StructureUtils.loadStructure(new ResourceLocation(Argh.MODID, "structures/toolpress.json")));
	}
	
}
