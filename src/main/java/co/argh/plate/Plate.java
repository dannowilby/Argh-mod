package co.argh.plate;

import net.minecraftforge.registries.IForgeRegistryEntry;

public class Plate extends IForgeRegistryEntry.Impl<Plate> {
	
	private String name;
	private PlateType type;
	
	public Plate(String name, PlateType pt) {
		super();
		
		this.setRegistryName(name);
		this.name = name;
		this.type = pt;
	}
	
	public PlateType getPlateType() {
		return this.type;
	}
	
	public String getName() {
		return this.name;
	}
	
}
