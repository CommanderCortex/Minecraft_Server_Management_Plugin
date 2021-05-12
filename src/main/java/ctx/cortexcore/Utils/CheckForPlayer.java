package ctx.cortexcore.Utils;

import org.bukkit.entity.Player;

public class CheckForPlayer {
    //Returns A Bool For if a Player is Online
    public static boolean PLAYERTRUE(Player target){
        return target == null || !target.isOnline();
    }
}
