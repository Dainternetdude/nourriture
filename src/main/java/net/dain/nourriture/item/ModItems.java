package net.dain.nourriture.item;

import net.dain.nourriture.Nourriture;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModItems {

	public static final Item HAMBURGER = registerItem("hamburger",
			new Item(new FabricItemSettings().group(ModItemGroup.NOURRITURE).food(ModFoodComponents.HAMBURGER)));
	public static final Item CHEESE = registerItem("cheese",
			new Item(new FabricItemSettings().group(ModItemGroup.NOURRITURE)));
	public static final Item BUN = registerItem("bun",
			new Item(new FabricItemSettings().group(ModItemGroup.NOURRITURE)));


	private static Item registerItem(String name, Item item) {
		return Registry.register(Registry.ITEM, new Identifier(Nourriture.MOD_ID, name), item);
	}

	public static void registerModItems() {
		Nourriture.LOGGER.info("registering mod items for " + Nourriture.MOD_ID);
	}
}
