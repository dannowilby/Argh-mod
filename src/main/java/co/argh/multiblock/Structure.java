package co.argh.multiblock;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;

public class Structure {
	
	private Block[][][] data;
	
	private String name;
	
	public Structure(String name) {
		this(name, 0, 0, 0);
	}
	
	public Structure(String name, int sizeX, int sizeY, int sizeZ) {
		this.name = name;
		data = new Block[sizeX][sizeY][sizeZ];
	}
	
	public String getName() {
		return this.name;
	}
	
	public Block[][][] getData() {
		return this.data;
	}
	
	public void setBlock(Block b, int x, int y, int z) {
		this.data[x][y][z] = b;
	}
	
	public Block getBlock(int x, int y, int z) {
		return data[x][y][z];
	}
	
	public void addLayer(EnumFacing.Axis e) {
		
		if(e == EnumFacing.Axis.X)
			data = new Block[data.length + 1][data[0].length][data[0][0].length];
		if(e == EnumFacing.Axis.Y)
			data = new Block[data.length][data[0].length + 1][data[0][0].length];
		if(e == EnumFacing.Axis.Z)
			data = new Block[data.length][data[0].length][data[0][0].length + 1];
	}
	
	
	private String readFile(String path) {
		
		String output = "";
		
		try {
			
			File f = new File(path);
			BufferedReader br = new BufferedReader(new FileReader(f));
		
			String line;
			while((line = br.readLine()) != null)
				output.concat(line);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return output;
	}
	
	public Structure loadStructure(ResourceLocation fileName) {
		
		InputStream is;
		
		try {
			Gson g = new Gson();
			is = Minecraft.getMinecraft().getResourceManager().getResource(fileName).getInputStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(is));
			JsonElement je = g.fromJson(reader, JsonElement.class);
			JsonObject json = je.getAsJsonObject();
			JsonArray ja = (JsonArray) json.get("data");
			System.out.println(ja.get(0));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return this;
	}
	
}
