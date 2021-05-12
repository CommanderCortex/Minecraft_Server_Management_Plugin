package ctx.cortexcore.Utils;

import org.bukkit.command.CommandSender;

public class ConsoleMessage {
    //Tells the Console that the working command is for players only.
    public static void instanceOfConsole(CommandSender sender){
        sender.sendMessage(PluginPrefix.PLUGINPREFIX + "Error, This is a Player only Command!");
    }
}
