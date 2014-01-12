package deltageek.rottenflesh;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;

import java.util.logging.Logger;

/**
 * Created with IntelliJ IDEA.
 * User: David
 * Date: 1/12/14
 * Time: 2:44 AM
 * To change this template use File | Settings | File Templates.
 */
public class RottenFleshContent {
    public UncuredFlesh uncuredFlesh;

    public RottenFleshContent(){
        if(RottenFleshConfig.difficultyMode > 0){
            uncuredFlesh = new UncuredFlesh(RottenFleshConfig.uncuredFlesh);
        }
    }

    public void initRecipes() {
        Logger logger = RottenFleshToLeather.logger;

        switch(RottenFleshConfig.difficultyMode){
            case 1:
                GameRegistry.addRecipe(
                        new ItemStack(uncuredFlesh),
                        new Object[]{
                                "LL",
                                "LL",
                                'L', Item.rottenFlesh
                        });
                break;
            case 2:
                GameRegistry.addShapelessRecipe(
                        new ItemStack(uncuredFlesh),
                        new Object[]{
                                new ItemStack(Item.sugar),
                                new ItemStack(Item.rottenFlesh),
                                new ItemStack(Item.dyePowder, 1, 15)
                        });
                break;
        }
        logger.info("[RottenFlesh] Item recipes loaded");

        switch(RottenFleshConfig.difficultyMode){
            case 0:
                FurnaceRecipes.smelting().addSmelting(Item.rottenFlesh.itemID, new ItemStack(Item.leather), 0.1F);
                break;
            case 1:
            case 2:
                FurnaceRecipes.smelting().addSmelting(uncuredFlesh.itemID, new ItemStack(Item.leather), 0.1F);
                break;
        }
        logger.info("[RottenFlesh] Furnace recipes loaded");
    }

}
