package io.github._727021.moretools.armor;

import io.github._727021.moretools.MoreTools;
import io.github._727021.moretools.items.Items;

import java.util.function.Supplier;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public enum ModArmorMaterial implements IArmorMaterial {
    COPPER(MoreTools.MODID + ":copper", 18, new int[] { 2, 5, 6, 2 }, 9, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 0.0f,
            () -> Ingredient.fromItems(Items.COPPER.get()));

    // Vanilla materials for reference
    //
    // LEATHER("leather", 5, new int[]{1, 2, 3, 1}, 15,
    // SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0F, 0.0F, () -> {
    // return Ingredient.fromItems(Items.LEATHER);
    // }),
    // CHAIN("chainmail", 15, new int[]{1, 4, 5, 2}, 12,
    // SoundEvents.ITEM_ARMOR_EQUIP_CHAIN, 0.0F, 0.0F, () -> {
    // return Ingredient.fromItems(Items.IRON_INGOT);
    // }),
    // IRON("iron", 15, new int[]{2, 5, 6, 2}, 9, SoundEvents.ITEM_ARMOR_EQUIP_IRON,
    // 0.0F, 0.0F, () -> {
    // return Ingredient.fromItems(Items.IRON_INGOT);
    // }),
    // GOLD("gold", 7, new int[]{1, 3, 5, 2}, 25, SoundEvents.ITEM_ARMOR_EQUIP_GOLD,
    // 0.0F, 0.0F, () -> {
    // return Ingredient.fromItems(Items.GOLD_INGOT);
    // }),
    // DIAMOND("diamond", 33, new int[]{3, 6, 8, 3}, 10,
    // SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 2.0F, 0.0F, () -> {
    // return Ingredient.fromItems(Items.DIAMOND);
    // }),
    // TURTLE("turtle", 25, new int[]{2, 5, 6, 2}, 9,
    // SoundEvents.ITEM_ARMOR_EQUIP_TURTLE, 0.0F, 0.0F, () -> {
    // return Ingredient.fromItems(Items.SCUTE);
    // }),
    // NETHERITE("netherite", 37, new int[]{3, 6, 8, 3}, 15,
    // SoundEvents.field_232681_Q_, 3.0F, 0.1F, () -> {
    // return Ingredient.fromItems(Items.field_234759_km_);
    // });

    private static final int[] MAX_DAMAGE = new int[] { 11, 16, 15, 13 };
    private final String name;
    private final int maxDamageFactor;
    private final int[] damageReductionAmount;
    private final int enchantability;
    private final SoundEvent soundEvent;
    private final float toughness;
    private final Supplier<Ingredient> repairMaterial;

    @Override
    public int getDurability(EquipmentSlotType slotIn) {
        return MAX_DAMAGE[slotIn.getIndex()] * this.maxDamageFactor;
    }

    @Override
    public int getDamageReductionAmount(EquipmentSlotType slotIn) {
        return this.damageReductionAmount[slotIn.getIndex()];
    }

    @Override
    public int getEnchantability() {
        return this.enchantability;
    }

    @Override
    public SoundEvent getSoundEvent() {
        return this.soundEvent;
    }

    @Override
    public Ingredient getRepairMaterial() {
        return this.repairMaterial.get();
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public float getToughness() {
        return this.toughness;
    }

    @Override
    public float func_230304_f_() {
        return 0;
    }

    private ModArmorMaterial(String name, int maxDamageFactor, int[] damageReductionAmount, int enchantability,
            SoundEvent soundEvent, float toughness, Supplier<Ingredient> repairMaterial) {
        this.name = name;
        this.maxDamageFactor = maxDamageFactor;
        this.damageReductionAmount = damageReductionAmount;
        this.enchantability = enchantability;
        this.soundEvent = soundEvent;
        this.toughness = toughness;
        this.repairMaterial = repairMaterial;
    }

}