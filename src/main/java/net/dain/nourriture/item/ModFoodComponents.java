package net.dain.nourriture.item;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;

public class ModFoodComponents {

	public static final FoodComponent BURGER = new FoodComponent.Builder().hunger(8).saturationModifier(1.0f)
			.alwaysEdible().statusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 5 * 20), 1).build();
}
