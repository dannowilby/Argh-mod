package co.argh.item;

import java.util.ArrayList;

import co.argh.Argh;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber
public class ItemRegistry {

	public static ArrayList<ArghItem> items;
	
	public static void init_items() {
		
		items = new ArrayList<ArghItem>();
		
		items.add(new ArghItem("test_item"));
	}
	
	@SubscribeEvent
	public void register_items(RegistryEvent.Register<Item> register) {
		
		for(ArghItem i : items)
			register.getRegistry().register(i);	
	}
	
}
