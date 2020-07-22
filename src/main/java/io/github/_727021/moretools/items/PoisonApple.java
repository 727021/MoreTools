package io.github._727021.moretools.items;

import io.github._727021.moretools.MoreTools;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;

public class PoisonApple extends Item {
    public PoisonApple() {
        super(new Item.Properties().group(MoreTools.TAB).food(new Food.Builder().hunger(4).saturation(1.2f)
                .effect(() -> new EffectInstance(Effects.NAUSEA, 20 * 20, 0), 1)
                .effect(() -> new EffectInstance(Effects.POISON, 15 * 20, 1), 0.5f)
                .effect(() -> new EffectInstance(Effects.HUNGER, 15 * 20, 0), 0.3f)
                .effect(() -> new EffectInstance(Effects.REGENERATION, 15 * 20, 2), 0.1f).setAlwaysEdible().build()));
    }
}