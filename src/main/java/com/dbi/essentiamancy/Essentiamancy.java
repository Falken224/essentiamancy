package com.dbi.essentiamancy;

import com.dbi.essentiamancy.items.EssentiaWand;
import com.dbi.essentiamancy.proxy.Proxy;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(modid = Essentiamancy.MODID, version = Essentiamancy.VERSION)
public class Essentiamancy {
    public static final String MODID = "essentiamancy";
    public static final String VERSION = "0.1alpha";

    public static final Item ESSENTIA_WAND=new EssentiaWand();

    @SidedProxy(clientSide = "com.dbi.essentiamancy.proxy.ClientProxy", serverSide = "com.dbi.essentiamancy.proxy.proxy.ServerProxy")
    public static Proxy proxy;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        proxy.preInit();
        registerBlocks();
        registerRecipes();
    }

    private void registerBlocks() {
        GameRegistry.register(ESSENTIA_WAND);
    }

    private void registerRecipes()
    {
        GameRegistry.addRecipe(new ItemStack(ESSENTIA_WAND),"  B"," A ","A  ",'A', Items.STICK,'B',Blocks.GLASS);
    }
}
