package com.deltageek.rottenflesh;

import com.deltageek.rottenflesh.config.RottenFleshConfig;
import com.deltageek.rottenflesh.init.ModItems;
import com.deltageek.rottenflesh.init.Recipes;
import com.deltageek.rottenflesh.proxy.IProxy;
import com.deltageek.rottenflesh.util.Reference;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.MOD_VERSION, guiFactory = Reference.UI_FACTORY)
public class RottenFleshToLeather {

    @Mod.Instance(Reference.MOD_ID)
    public static RottenFleshToLeather instance;

    @SidedProxy(clientSide= Reference.CLIENT_PROXY, serverSide = Reference.SERVER_PROXY)
    public static IProxy proxy;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event){
        // network handling

        // load config
        RottenFleshConfig.init(event.getSuggestedConfigurationFile());

        // Register for config events
        FMLCommonHandler.instance().bus().register(new RottenFleshConfig());

        // Register items & blocks
        ModItems.init();
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event){
        // UI

        // Tile Entities

        // Recipes
        Recipes.init();
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event){
        // Respond to other mods
    }
}
