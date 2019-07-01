package co.argh;

import co.argh.item.ItemRegistry;
import net.minecraft.client.Minecraft;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Argh.MODID)
public class Argh {

	public static final String NAME = "Argh";
	public static final String MODID = "argh";
	public static final String VERSION = "1.0";
	
	@EventHandler
	public void preinit(FMLPreInitializationEvent event) {
		
		ItemRegistry.init_items();
		MinecraftForge.EVENT_BUS.register(new ItemRegistry());
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event) {
		
	}
	
	@EventHandler
	public void postinit(FMLPostInitializationEvent event) {
		
	}
}
