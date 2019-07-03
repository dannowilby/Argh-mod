package co.argh;

import co.argh.util.IProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;

public class ClientProxy implements IProxy {

	@Override
	public void preinit(FMLPreInitializationEvent event) {
		
	}

	@Override
	public void init(FMLInitializationEvent event) {
		
	}

	@Override
	public void postinit(FMLPostInitializationEvent event) {
		
	}

	@Override
	public Side getSide() {
		return Side.CLIENT;
	}

}
