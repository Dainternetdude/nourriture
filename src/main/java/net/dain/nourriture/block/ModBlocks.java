package net.dain.nourriture.block;

import net.dain.nourriture.Nourriture;
import net.dain.nourriture.item.ModItemGroup;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModBlocks {

	public static final Block CAULDRON_WITH_BUCKET = registerBlock("cauldron_with_bucket",
			new CauldronBlock(AbstractBlock.Settings.of(Material.METAL, MapColor.STONE_GRAY).requiresTool().strength(2.0f).nonOpaque()), ModItemGroup.NOURRITURE);


	private static Block registerBlock(String name, Block block, ItemGroup group) {
		registerBlockItem(name, block, group);
		return Registry.register(Registry.BLOCK, new Identifier(Nourriture.MOD_ID, name), block);
	}

	private static Item registerBlockItem(String name, Block block, ItemGroup group) {
		return Registry.register(Registry.ITEM, new Identifier(Nourriture.MOD_ID, name),
				new BlockItem(block, new FabricItemSettings().group(group)));
	}

	public static void registerModBlocks() {
		Nourriture.LOGGER.info("registering mod blocks for {}", Nourriture.MOD_ID);
	}
}
