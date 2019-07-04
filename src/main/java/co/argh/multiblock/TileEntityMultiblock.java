package co.argh.multiblock;

import net.minecraft.tileentity.TileEntity;

public class TileEntityMultiblock extends TileEntity {

	private boolean isMaster;
	private Structure structure;
	
	public TileEntityMultiblock(boolean master, Structure s) {
		super();
		
		this.isMaster = master;
		this.structure = s;
	}
	
	public boolean checkStructure() {
		return false;
	}
	
	public boolean isMaster() {
		return this.isMaster;
	}
	
}
