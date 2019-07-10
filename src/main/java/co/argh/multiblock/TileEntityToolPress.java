package co.argh.multiblock;

import net.minecraft.util.ITickable;

public class TileEntityToolPress extends TileEntityMultiblock implements ITickable {

	public TileEntityToolPress() {
		super(true, MultiblockRegistry.toolpress);
	}

	@Override
	public void update() {
		if(world.getWorldTime() % 20 == 0 && !world.isRemote)
			System.out.println(this.isStructure());
	}

}
