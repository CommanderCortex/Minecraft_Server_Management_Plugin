package ctx.cortexcore.Commands.CommandMessages;

import ctx.cortexcore.Utils.ColorUtil;
import ctx.cortexcore.Utils.PluginPrefix;
import org.bukkit.entity.Player;

public class PlayerMessages {
    public static String Message(Player player, String Message){
        player.sendMessage(ColorUtil.Color(Message));
        return Message;
    }
    public static void NoPermissions(Player player){
        Message(player, PluginPrefix.PLUGINPREFIX + "&4Error, Insufficient Permissions!");
    }
    public static void PlayerNotFount(Player player){
        Message(player, PluginPrefix.PLUGINPREFIX + "&4Error, Player Not Found!");
    }
}
