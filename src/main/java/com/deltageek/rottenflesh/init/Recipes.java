package com.deltageek.rottenflesh.init;

import com.deltageek.rottenflesh.config.RottenFleshConfig;
import com.deltageek.rottenflesh.util.LogHelper;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;

import java.util.ArrayList;

public class Recipes {
    public static void removeRecipes(){
        switch(RottenFleshConfig.DIFFICULTY_MODE){
            case 0:
                FurnaceRecipes.smelting().getSmeltingList().remove(Items.rotten_flesh);
                break;
            case 1:
            case 2:
                removeRecipe(new ItemStack(ModItems.uncuredFlesh));
                FurnaceRecipes.smelting().getSmeltingList().remove(ModItems.uncuredFlesh);
                break;
        }
    }

    public static void init(){

        switch(RottenFleshConfig.DIFFICULTY_MODE){
            case 0:
                GameRegistry.addSmelting(Items.rotten_flesh, new ItemStack(Items.leather), 0.1F);
                LogHelper.info("Easy mode recipes loaded");
                break;
            case 1:
                GameRegistry.addRecipe(new ShapedOreRecipe(
                        ModItems.uncuredFlesh,
                        "FF",
                        "FF",
                        'F',
                        Items.rotten_flesh));

                GameRegistry.addSmelting(ModItems.uncuredFlesh, new ItemStack(Items.leather), 0.1F);
                LogHelper.info("Normal mode recipes loaded");
                break;
            case 2:
                ItemStack bonemeal = new ItemStack(Items.dye, 1, 15);

                GameRegistry.addRecipe(new ShapelessOreRecipe(
                        ModItems.uncuredFlesh,
                        Items.rotten_flesh,
                        Items.sugar,
                        bonemeal));

                GameRegistry.addSmelting(ModItems.uncuredFlesh, new ItemStack(Items.leather), 0.1F);
                LogHelper.info("Hard mode recipes loaded");
                break;
        }
    }

    private static void removeRecipe(ItemStack resultItem)
    {
        ItemStack recipeResult;
        ArrayList recipes = (ArrayList) CraftingManager.getInstance().getRecipeList();
        for (int scan = 0; scan < recipes.size(); scan++)
        {
            IRecipe recipe = (IRecipe) recipes.get(scan);
            recipeResult = recipe.getRecipeOutput();

            if (ItemStack.areItemStacksEqual(resultItem, recipeResult))
            {
                recipes.remove(scan);
            }
        }
    }
}
