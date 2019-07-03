package co.argh.plate;

import java.util.ArrayList;

import co.argh.Argh;
import net.minecraft.init.Blocks;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistryInternal;
import net.minecraftforge.registries.RegistryBuilder;
import net.minecraftforge.registries.RegistryManager;

@EventBusSubscriber
public class PlateRegistry {

	public static ArrayList<Plate> plates;
	
	public static Plate getPlate(String name) {
		
		for(Plate p : plates)
			if(p.getName().equalsIgnoreCase(name))
				return p;
		
		return null;
	}
	
	public static void init_plates() {
		plates = new ArrayList<Plate>();
		
		plates.add(new Plate("test_1", PlateType.NONE));
	}
	
	@SubscribeEvent
	public void register_plates(RegistryEvent.Register<Plate> event) {
		
		for(Plate p : plates)
			event.getRegistry().register(p);
	}
	
	@SubscribeEvent
	public static void create_plate_registry(RegistryEvent.NewRegistry event) {
		
		ResourceLocation rs = new ResourceLocation(Argh.MODID, "plate");
		RegistryBuilder<Plate> builder = new RegistryBuilder<Plate>();
		
		builder.setType(Plate.class);
		builder.setName(rs);
		builder.setDefaultKey(rs);
		
		builder.create();
	}
	
}
