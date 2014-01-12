package deltageek.rottenflesh;

import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.Property;

import java.io.File;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: David
 * Date: 1/12/14
 * Time: 2:20 AM
 * To change this template use File | Settings | File Templates.
 */
public class RottenFleshConfig extends Configuration {
    public RottenFleshConfig(File configFile){
        super(configFile);
    }

    public void init(){
        load();

        Property difficulty = get(Configuration.CATEGORY_GENERAL, "difficultyMode", 0);
        difficulty.comment =
                "Difficulty Modes:\n"
              + " 0 - Easy   (Just smelt Rotten Flesh)\n"
              + " 1 - Normal (Combine Rotten Flesh, then smelt it)\n"
              + " 2 - Hard   (Purify Rotten Flesh, then smelt it)";
        difficultyMode = difficulty.getInt();

        uncuredFlesh = getItem("uncuredFlesh.id", 12345).getInt();

        save();
    }

    public static int difficultyMode;
    public static int uncuredFlesh;
}
