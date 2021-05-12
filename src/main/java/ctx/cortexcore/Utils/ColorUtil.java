package ctx.cortexcore.Utils;

import org.bukkit.ChatColor;

public class ColorUtil {
    //Allows us to use & for color codes when sending messages to a player.
    public static String Color(String string){
        return ChatColor.translateAlternateColorCodes('&', string);
    }
}
