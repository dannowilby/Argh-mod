package co.argh.block;

import java.util.ArrayList;

import co.argh.multiblock.TileEntityToolPress;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber
public class BlockRegistry {

	public static ArrayList<ArghBlock> blocks;
	
	public static void init_blocks() {
		
		blocks = new ArrayList<ArghBlock>();
		
		blocks.add(new ArghStructureBlock("toolpress", Material.IRON, true, TileEntityToolPress.class));
	}
	
	@SubscribeEvent
	public void register_blocks(RegistryEvent.Register<Block> event) {
		
		for(ArghBlock b : blocks)
			event.getRegistry().register(b);
	}
	
	@SubscribeEvent
	public void register_item_blocks(RegistryEvent.Register<Item> event) {
		
		for(ArghBlock b : blocks)
			event.getRegistry().register((new ItemBlock(b)).setRegistryName(b.getName()));
	}
	
}
