package co.argh.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class ArghBlock extends Block{

	private String name;
	
	public ArghBlock(String name, Material materialIn) {
		super(materialIn);
		
		this.name = name;
		this.setRegistryName(name);
		this.setCreativeTab(CreativeTabs.MATERIALS);
		this.setUnlocalizedName(name);
	}
	
	public String getName() {
		return this.name;
	}

}
