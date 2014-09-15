package com.deltageek.rottenflesh.config;

import com.deltageek.rottenflesh.init.Recipes;
import com.deltageek.rottenflesh.util.LogHelper;
import com.deltageek.rottenflesh.util.Reference;
import cpw.mods.fml.client.event.ConfigChangedEvent;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.common.config.ConfigCategory;
import net.minecraftforge.common.config.Configuration;
import org.apache.logging.log4j.Level;

import java.io.File;

public class RottenFleshConfig {
    public static int DIFFICULTY_MODE;

    private static Configuration configuration;

    public static void init(File configFile) {
        FMLLog.log("OmniScaffolds", Level.INFO, "Starting configuration load");

        configuration = null;
        try{
            configuration = new Configuration(configFile);
            load();

            LogHelper.info("Mod configuration successfully loaded");
        }
        catch(Exception e){
            LogHelper.error("Error loading configuration");
        }
    }

    private static void load(){
        DIFFICULTY_MODE = configuration.getInt("difficultyMode", Configuration.CATEGORY_GENERAL, 0, 0, 2, Reference.DIFFICULTY_COMMENT);

        if(configuration.hasChanged())
            configuration.save();
    }

    public static ConfigCategory getConfigCategory(String categoryName){
        return configuration.getCategory(categoryName);
    }

    public static String getConfigPath(){
        return configuration.toString();
    }

    @SubscribeEvent
    public void onConfigurationChanged(ConfigChangedEvent.OnConfigChangedEvent event){
        if(event.modID.equalsIgnoreCase(Reference.MOD_ID)){
            Recipes.removeRecipes();
            load();
            Recipes.init();
        }
    }
}
