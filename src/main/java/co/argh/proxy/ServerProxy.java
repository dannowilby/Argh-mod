package co.argh.proxy;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;

public class ServerProxy implements IProxy{

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
		return Side.SERVER;
	}

}
