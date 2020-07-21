package io.github._727021.moretools.armor;

import io.github._727021.moretools.MoreTools;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class Armor {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MoreTools.MODID);

    public static void init() {
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

    // #region Copper Armor
    public static final RegistryObject<ArmorItem> COPPER_HELMET = ITEMS.register("copper_helmet",
            () -> new HelmetBase(ModArmorMaterial.COPPER));
    public static final RegistryObject<ArmorItem> COPPER_CHESTPLATE = ITEMS.register("copper_chestplate",
            () -> new ChestplateBase(ModArmorMaterial.COPPER));
    public static final RegistryObject<ArmorItem> COPPER_LEGGINGS = ITEMS.register("copper_leggings",
            () -> new LeggingsBase(ModArmorMaterial.COPPER));
    public static final RegistryObject<ArmorItem> COPPER_BOOTS = ITEMS.register("copper_boots",
            () -> new BootsBase(ModArmorMaterial.COPPER));
    // #endregion

    // #region ArmorItem Bases
    private static class HelmetBase extends ArmorItem {
        public HelmetBase(IArmorMaterial material) {
            super(material, EquipmentSlotType.HEAD, new Item.Properties().group(MoreTools.TAB));
        }
    }

    private static class ChestplateBase extends ArmorItem {
        public ChestplateBase(IArmorMaterial material) {
            super(material, EquipmentSlotType.CHEST, new Item.Properties().group(MoreTools.TAB));
        }
    }

    private static class LeggingsBase extends ArmorItem {
        public LeggingsBase(IArmorMaterial material) {
            super(material, EquipmentSlotType.LEGS, new Item.Properties().group(MoreTools.TAB));
        }
    }

    private static class BootsBase extends ArmorItem {
        public BootsBase(IArmorMaterial material) {
            super(material, EquipmentSlotType.FEET, new Item.Properties().group(MoreTools.TAB));
        }
    }
    // #endregion
}