package co.argh.util;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;

public interface IProxy {

	void preinit(FMLPreInitializationEvent event);
	
	void init(FMLInitializationEvent event);
	
	void postinit(FMLPostInitializationEvent event);
	
	Side getSide();
}
