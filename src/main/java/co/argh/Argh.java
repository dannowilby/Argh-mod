package co.argh;

import co.argh.block.BlockRegistry;
import co.argh.item.ItemRegistry;
import co.argh.multiblock.MultiblockRegistry;
import co.argh.plate.PlateRegistry;
import co.argh.proxy.IProxy;
import co.argh.structure.Structure;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Argh.MODID, name = Argh.NAME, version = Argh.VERSION)
public class Argh {

	public static final String NAME = "Argh";
	public static final String MODID = "argh";
	public static final String VERSION = "1.0";
	
	@Mod.Instance
	public static Argh instance;
	
	@SidedProxy(serverSide = "co.argh.proxy.ServerProxy", clientSide = "co.argh.proxy.ClientProxy")
	public static IProxy proxy;
	
	@EventHandler
	public void preinit(FMLPreInitializationEvent event) {
		
		PlateRegistry.init_plates();
		MinecraftForge.EVENT_BUS.register(new PlateRegistry());
		
		BlockRegistry.init_blocks();
		MinecraftForge.EVENT_BUS.register(new BlockRegistry());
		
		ItemRegistry.init_items();
		MinecraftForge.EVENT_BUS.register(new ItemRegistry());
		
		proxy.preinit(event);
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event) {
		
		MultiblockRegistry.init_structures();
		
		proxy.init(event);
	}
	
	@EventHandler
	public void postinit(FMLPostInitializationEvent event) {
		
		proxy.postinit(event);
	}
}
