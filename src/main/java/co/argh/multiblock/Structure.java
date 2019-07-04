package co.argh.multiblock;

import net.minecraft.block.Block;
import net.minecraft.util.EnumFacing;

public class Structure {
	
	private Block[][][] data;
	
	private String name;
	
	public Structure(String name) {
		this(name, 0, 0, 0);
	}
	
	public Structure(String name, int sizeX, int sizeY, int sizeZ) {
		this.name = name;
		data = new Block[sizeX][sizeY][sizeZ];
	}
	
	public String getName() {
		return this.name;
	}
	
	public Block[][][] getData() {
		return this.data;
	}
	
	public void setBlock(Block b, int x, int y, int z) {
		this.data[x][y][z] = b;
	}
	
	public Block getBlock(int x, int y, int z) {
		return data[x][y][z];
	}
	
	public void addLayer(EnumFacing.Axis e) {
		
		if(e == EnumFacing.Axis.X)
			data = new Block[data.length + 1][data[0].length][data[0][0].length];
		if(e == EnumFacing.Axis.Y)
			data = new Block[data.length][data[0].length + 1][data[0][0].length];
		if(e == EnumFacing.Axis.Z)
			data = new Block[data.length][data[0].length][data[0][0].length + 1];
	}
	
	public Structure loadStructure(String fileName) {
		return this;
	}
	
}
