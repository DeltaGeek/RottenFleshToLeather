package deltageek.rottenflesh;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class UncuredFlesh extends Item {

    public UncuredFlesh(int id) {
        super(id);
        setUnlocalizedName("uncuredFlesh");
        setTextureName("rottenfleshtoleather:uncuredFlesh");
        setCreativeTab(CreativeTabs.tabMaterials);
    }
}
