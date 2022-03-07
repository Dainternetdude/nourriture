package net.dain.nourriture.item;

import net.dain.nourriture.Nourriture;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModItems {

	public static final Item BURGER = registerItem("burger",
			new Item(new FabricItemSettings().group(ModItemGroup.NOURRITURE).food(ModFoodComponents.BURGER)));


	private static Item registerItem(String name, Item item) {
		return Registry.register(Registry.ITEM, new Identifier(Nourriture.MOD_ID, name), item);
	}

	public static void registerModItems() {
		Nourriture.LOGGER.info("registering mod items for " + Nourriture.MOD_ID);
	}
}
