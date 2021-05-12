package ctx.cortexcore.Global.Files;

import ctx.cortexcore.Global.Strings.PathStrings;
import org.bukkit.Bukkit;

import java.io.File;

public class MainDIRSetup {
    public static void MAINDIRSETUP(){
        File _MAINDIR = new File(PathStrings.MAINDIR);
        if(!_MAINDIR.exists())
            _MAINDIR.mkdir();
    }
    public static void PLAYERSIRSETUP(){
        File _PLAYERDIR = new File(PathStrings.PLAYERDIR);
        if(!_PLAYERDIR.exists())
            _PLAYERDIR.mkdir();
    }
    public static void SETUP(boolean Setup){
        if(Setup){
            MAINDIRSETUP();
            PLAYERSIRSETUP();
        }else
        Bukkit.broadcastMessage("DIR Setup Disabled, Skipping Setup of DIRS.");
    }
}
