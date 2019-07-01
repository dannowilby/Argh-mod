package co.argh.item;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ArghItem extends Item {

	private String name;
	
	public ArghItem(String name) {
		super();
		
		this.name = name;
		this.setRegistryName(name);
		this.setCreativeTab(CreativeTabs.MATERIALS);
		this.setUnlocalizedName(name);
	}
	
	public String getName() {
		return this.name;
	}
	
}
