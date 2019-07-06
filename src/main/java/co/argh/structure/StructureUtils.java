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
