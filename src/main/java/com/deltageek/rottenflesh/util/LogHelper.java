package com.deltageek.rottenflesh.util;

import cpw.mods.fml.common.FMLLog;
import org.apache.logging.log4j.Level;

public class LogHelper {
    public static void off(Object object)   { log(Level.OFF,    object); }
    public static void fatal(Object object) { log(Level.FATAL,  object); }
    public static void error(Object object) { log(Level.ERROR,  object); }
    public static void warn(Object object)  { log(Level.WARN,   object); }
    public static void info(Object object)  { log(Level.INFO,   object); }
    public static void debug(Object object) { log(Level.DEBUG,  object); }
    public static void trace(Object object) { log(Level.TRACE,  object); }

    private static void log(Level level, Object object){
        FMLLog.log(Reference.MOD_ID, level, object.toString());
    }
}
