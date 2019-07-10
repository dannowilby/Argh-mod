package co.argh.structure;

import co.argh.block.ArghStructureBlock;
import co.argh.multiblock.TileEntityMultiblock;
import net.minecraft.block.Block;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

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
	
	public BlockPos getMasterBlock(Block[][][] input, World world, BlockPos pos) {
		
		for(int x = 0; x < this.data.length; x++) {
			for(int y = 0; y < this.data[0].length; y++) {
				for(int z = 0; z < this.data[0][0].length; z++) {
					
					Block b = this.data[x][y][z];
					System.out.println(b);
					if(b instanceof ArghStructureBlock)
						if(((ArghStructureBlock) b).isMaster())
							return new BlockPos(x, y, z);
				}
			}
		}
		
		return null;
	}
	
	public boolean isMultiblock(Block[][][] input, World world, BlockPos pos) {
		
		BlockPos np;
		BlockPos offset = getMasterBlock(input, world, pos);
		
		if(offset == null) return false;
		System.out.println(offset);
		np = (new BlockPos(pos)).add(-offset.getX(), -offset.getY(), -offset.getZ());
		
		for(int x = 0; x < input.length; x++) {
			for(int y = 0; y < input[0].length; y++) {
				for(int z = 0; z < input[0][0].length; z++)
					if(!world.getBlockState(np.add(x, y, z)).getBlock().equals(input[x][y][z]))
						return false;
			}
		}
		
		return true;
	}
	
	public boolean isMultiblock(World world, BlockPos pos) {
		
		Block[][][] temp1 = this.data.clone();
		Block[][][] temp2 = this.data.clone();
	
		if(isMultiblock(temp1, world, pos))
			return true;
		
		temp1 = StructureUtils.rotateData(temp1);
		
		if(isMultiblock(temp1, world, pos))
			return true;
		
		temp2 = StructureUtils.flipData(temp2);
		if(isMultiblock(temp2, world, pos))
			return true;
		
		//temp = StructureUtils.rotateData(temp);
		//if(isMultiblock(temp, world, pos))
			//return true;
		
		/*
		temp = this.data;
		if(isMultiblock(temp, world, pos))
			return true;
		temp = StructureUtils.rotateData(temp);
		if(isMultiblock(temp, world, pos))
			return true;
		*/
		
		return false;
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
					System.out.println(x + " " + y + " " + z + " " + this.data[x][y][z] + " for " + this.getName());
	}
	
	public void printSize() {
		System.out.println("Size of structure (" + this.getName() + ") is " + this.data.length + " x " + this.data[0].length + " x " + this.data[0][0].length);
	}
	
}
