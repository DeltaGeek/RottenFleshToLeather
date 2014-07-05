package com.deltageek.rottenflesh.init;

import com.deltageek.rottenflesh.item.UncuredFlesh;
import cpw.mods.fml.common.registry.GameRegistry;

public class ModItems {
    public static final UncuredFlesh uncuredFlesh = new UncuredFlesh();

    public static void init(){
        GameRegistry.registerItem(uncuredFlesh, "uncuredFlesh");
    }
}
