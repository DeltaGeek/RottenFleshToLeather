package com.deltageek.rottenflesh.item;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;

public class UncuredFlesh extends RottenFleshItem {
    public UncuredFlesh(){
        CreativeTabs tab = Items.leather.getCreativeTab();
        setCreativeTab(tab);
        setUnlocalizedName("uncuredFlesh");
    }
}
