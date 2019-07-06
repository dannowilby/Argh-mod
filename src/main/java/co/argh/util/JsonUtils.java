package co.argh.util;

import java.util.HashMap;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import co.argh.structure.StructureUtils;
import net.minecraft.block.Block;

public class JsonUtils {

	public static String formatJsonString(String s) {
		return s.substring(1, s.length() - 1);
	}

	public static Block[][][] parseJsonStructure(JsonObject o) {
		
		JsonArray x = (JsonArray) o.get("data");
		JsonArray y = (JsonArray) x.get(0);
		JsonArray z = (JsonArray) y.get(0);
		
		Block[][][] output = new Block[x.size()][y.size()][z.size()];
		
		HashMap<String, Block> key = StructureUtils.getKey(o);
		
		for(int ix = 0; ix < x.size(); ix++) {
			for(int iy = 0; iy < y.size(); iy++) {
				for(int iz = 0; iz < z.size(); iz++) {
					
					String line = JsonUtils.formatJsonString(
							((JsonArray) ((JsonArray) x.get(ix)).get(iy)).get(iz).toString()
					);
					
					output[ix][iy][iz] = (Block) Utils.getValueFromHashMap(key, line);
				}
			}
		}
		
		return output;
	}
	
}
