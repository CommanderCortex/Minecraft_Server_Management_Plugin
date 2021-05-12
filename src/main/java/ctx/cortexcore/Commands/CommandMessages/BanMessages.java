package ctx.cortexcore.Commands.CommandMessages;

import ctx.cortexcore.Utils.PluginPrefix;
import org.bukkit.entity.Player;

public class BanMessages {
    public static String alreadyBanned = PluginPrefix.PLUGINPREFIX + "&cPlayer Already Banned!";
    public static String banUsageMSG = PluginPrefix.PLUGINPREFIX + "/&aUsage: &b/tempban or /ban <player>, <time>, <reason>";

    public static void alreadyBanned(Player player){
        PlayerMessages.Message(player, alreadyBanned);
    }
    public static void banUsage(Player player){
        PlayerMessages.Message(player, banUsageMSG);
    }
}
