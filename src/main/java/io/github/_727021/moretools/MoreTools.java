package io.github._727021.moretools;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import io.github._727021.moretools.armor.Armor;
import io.github._727021.moretools.blocks.Blocks;
import io.github._727021.moretools.items.Items;
import io.github._727021.moretools.tools.Tools;

@Mod(MoreTools.MODID)
public class MoreTools {
    private static final Logger LOGGER = LogManager.getLogger();
    public static final String MODID = "moretools";

    public MoreTools() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);

        MinecraftForge.EVENT_BUS.register(this);

        LOGGER.info("Adding MoreTools blocks/items");

        // Init registries
        Blocks.init();
        Items.init();
        Tools.init();
        Armor.init();
    }

    private void setup(final FMLCommonSetupEvent event) {
    }

    private void doClientStuff(final FMLClientSetupEvent event) {
    }

    // Creative Tab
    public static final ItemGroup TAB = new ItemGroup("moretools_tab") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(Tools.COPPER_PICKAXE.get());
        }
    };
}
