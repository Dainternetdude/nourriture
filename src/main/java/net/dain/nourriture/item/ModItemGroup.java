package net.dain.nourriture.item;

import net.dain.nourriture.Nourriture;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class ModItemGroup {

	public static final ItemGroup NOURRITURE = FabricItemGroupBuilder.build(new Identifier(Nourriture.MOD_ID, "nourriture"),
			() -> new ItemStack(ModItems.BURGER)); //defines picture
}
