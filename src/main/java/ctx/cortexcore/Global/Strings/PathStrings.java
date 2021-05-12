package ctx.cortexcore.Global.Strings;

import org.bukkit.entity.Player;

public class PathStrings {
    public static final String MAINDIR = "plugins/cortex/"; //Define our Main Working DIR
    public static final String PLAYERDIR = MAINDIR + "players/"; //Define Our Main Player DIR
    public static String getPlayerFile(Player player){
        return PLAYERDIR + player.getUniqueId() + ".yml";
    } //Returns the players UUID and stores it as a .yml file.
}
