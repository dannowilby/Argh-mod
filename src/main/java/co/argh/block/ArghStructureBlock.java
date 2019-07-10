package co.argh.block;

import co.argh.multiblock.TileEntityMultiblock;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class ArghStructureBlock extends ArghBlock {

	private Class<? extends TileEntityMultiblock> tileEntity;
	private boolean isMaster;
	
	public ArghStructureBlock(String name, Material materialIn, boolean isMaster, Class<? extends TileEntityMultiblock> tileEntity) {
		super(name, materialIn);
		
		this.tileEntity = tileEntity;
		this.isMaster = isMaster;
	}
	
	public boolean isMaster() {
		return this.isMaster;
	}
	
	@Override
	public boolean hasTileEntity(IBlockState state) {
		return true;
	}

	@Override
	public TileEntity createTileEntity(World world, IBlockState state) {
		
		try {
			return this.tileEntity.newInstance();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
