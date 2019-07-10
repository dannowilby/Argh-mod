package co.argh.structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import co.argh.util.JsonUtils;
import co.argh.util.Utils;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.util.ResourceLocation;

public class StructureUtils {
	
	public static Block[][][] rotateData(Block[][][] input) {

		Block[][][] output = new Block[input[0][0].length][input[0].length][input.length];
		
		for(int x = 0; x < input.length; x++) {
			for(int y = 0; y < input[0].length; y++) {
				for(int z = 0; z < input[0][0].length; z++) {
					output[z][y][x] = input[x][y][z]; 
				}
			}
		}
		
		return output;
	}
	
	public static Block[][][] flipData(Block[][][] input) {
		
		Block[][][] output = new Block[input.length][input[0].length][input[0][0].length];
		
		for(int x = 0; x < input.length; x++) {
			for(int y = 0; y < input[0].length; y++) {
				for(int z = 0; z < input[0][0].length; z++) {
					
					output[x][y][z] = input[(input.length - 1) - x][y][z];
				}
			}
		}
		
		return output;
	}

	public static HashMap<String, Block> getKey(JsonObject o) {
		
		HashMap<String, Block> key = new HashMap<String, Block>();
		JsonObject k = (JsonObject) o.get("key");
		
		k.entrySet().forEach((e) -> {
			
			String name = e.getValue().toString();
			name = name.substring(1, name.length() - 1);
			
			ResourceLocation r = new ResourceLocation(name);
			key.put(e.getKey(), Utils.findBlock(r));
		});
		
		return key;
	}
	
	public static Structure loadStructure(ResourceLocation fileName) {
		
		InputStream is;
		Gson g = new Gson();
		JsonElement data = null;
		JsonObject object = null;
		
		try {
			
			is = Minecraft.getMinecraft().getResourceManager().getResource(fileName).getInputStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(is));
			data = g.fromJson(reader, JsonElement.class);
		} catch (IOException e) { e.printStackTrace(); }
		
		object = data.getAsJsonObject();
		
		return new Structure(object.get("id").toString(), JsonUtils.parseJsonStructure(object));
	}
	
}
