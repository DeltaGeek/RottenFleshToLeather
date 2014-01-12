package deltageek.rottenflesh;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;

import java.util.logging.Logger;

@Mod(modid="RottenFleshToLeather", name="Rotten Flesh to Leather", version="0.0.0")
@NetworkMod(clientSideRequired=true)
public class RottenFleshToLeather {

    // Shared mod logger
    public static final Logger logger = Logger.getLogger("RottenFleshToLeather");

    // The instance of your mod that Forge uses.
    @Mod.Instance(value = "RottenFleshToLeather")
    public static RottenFleshToLeather instance;

    private RottenFleshConfig config;
    private RottenFleshContent content;

    @Mod.EventHandler // used in 1.6.2
    public void preInit(FMLPreInitializationEvent event) {
        config = new RottenFleshConfig(event.getSuggestedConfigurationFile());
        config.init();
    }

    @Mod.EventHandler // used in 1.6.2
    public void load(FMLInitializationEvent event) {
        content = new RottenFleshContent();
    }

    @Mod.EventHandler // used in 1.6.2
    public void postInit(FMLPostInitializationEvent event) {
        content.initRecipes();
    }
}
