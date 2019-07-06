package co.argh.util;

import java.util.HashMap;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.registries.IForgeRegistry;

public class Utils {

	public static Object getValueFromHashMap(HashMap<? extends Object, ?> map, Object key) {
		
		for(Object k : map.keySet())
			if(k.equals(key))
				return map.get(k);
		
		return null;
	}
	
	public static Block findBlock(ResourceLocation r) {
		
		IForgeRegistry<Block> blocks = GameRegistry.findRegistry(Block.class);
		
		if(blocks.containsKey(r))
			return blocks.getValue(r);
		return Blocks.AIR;
	}
	
}
