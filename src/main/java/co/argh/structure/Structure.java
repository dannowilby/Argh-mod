package co.argh.structure;

import net.minecraft.block.Block;
import net.minecraft.util.EnumFacing;

public class Structure {
	
	private Block[][][] data;
	
	private String name;
	
	public Structure(String name) {
		this(name, 0, 0, 0);
	}
	
	public Structure(String name, int sizeX, int sizeY, int sizeZ) {
		this(name, new Block[sizeX][sizeY][sizeZ]);
	}
	
	public Structure(String name, Block[][][] structure) {
		this.name = name;
		this.data = structure;
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
	
	public void printData() {
		for(int x = 0; x < this.data.length; x++)
			for(int y = 0; y < this.data[0].length; y++)
				for(int z = 0; z < this.data[0][0].length; z++)
					System.out.println(this.data[x][y][z]);
	}
	
	public void printSize() {
		System.out.println("Size of structure (" + this.getName() + ") is " + this.data.length + " x " + this.data[0].length + " x " + this.data[0][0].length);
	}
	
}
