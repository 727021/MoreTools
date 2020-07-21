package io.github._727021.moretools.blocks;

import io.github._727021.moretools.MoreTools;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class Blocks {
    public static DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MoreTools.MODID);
    public static DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MoreTools.MODID);

    public static void init() {
        BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

    // #region Blocks
    public static final RegistryObject<Block> COPPER_ORE = BLOCKS.register("copper_ore", CopperOre::new);
    public static final RegistryObject<Block> COPPER_BLOCK = BLOCKS.register("copper_block", CopperBlock::new);
    // #endregion

    // #region Block Items
    public static final RegistryObject<Item> COPPER_ORE_ITEM = ITEMS.register("copper_ore",
            () -> new BlockItemBase(COPPER_ORE.get()));
    public static final RegistryObject<Item> COPPER_BLOCK_ITEM = ITEMS.register("copper_block",
            () -> new BlockItemBase(COPPER_BLOCK.get()));
    // #endregion

    // #region BlockItem Base
    private static class BlockItemBase extends BlockItem {
        public BlockItemBase(Block blockIn) {
            super(blockIn, new Item.Properties().group(MoreTools.TAB));
        }
    }
    // #endregion
}