package com.deltageek.rottenflesh.client.ui;

import com.deltageek.rottenflesh.config.RottenFleshConfig;
import com.deltageek.rottenflesh.util.Reference;
import cpw.mods.fml.client.config.GuiConfig;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.common.config.ConfigElement;
import net.minecraftforge.common.config.Configuration;

public class ConfigUI extends GuiConfig {
    public ConfigUI(GuiScreen parentScreen) {
        super(parentScreen,
              new ConfigElement(RottenFleshConfig.getConfigCategory(Configuration.CATEGORY_GENERAL)).getChildElements(),
                Reference.MOD_ID,
                false,
                false,
                GuiConfig.getAbridgedConfigPath(RottenFleshConfig.getConfigPath()));
    }
}
