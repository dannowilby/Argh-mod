package co.argh.multiblock;

import co.argh.structure.Structure;
import net.minecraft.tileentity.TileEntity;

public class TileEntityMultiblock extends TileEntity {

	private boolean isMaster;
	private Structure structure;
	
	public TileEntityMultiblock(boolean master, Structure s) {
		super();
		
		this.isMaster = master;
		this.structure = s;
	}
	
	public boolean isStructure() {
		if(this.structure.isMultiblock(world, pos)) {
			return true;
		}
		
		return false;
	}
	
	public boolean isMaster() {
		return this.isMaster;
	}
	
	public Structure getStructure() {
		return this.structure;
	}
	
}
