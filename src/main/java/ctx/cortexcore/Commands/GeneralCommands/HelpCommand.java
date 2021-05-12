package ctx.cortexcore.Commands.GeneralCommands;

import ctx.cortexcore.Commands.CommandMessages.PlayerMessages;
import ctx.cortexcore.PermissionsSystem.RankHandler;
import ctx.cortexcore.Utils.ConsoleMessage;
import ctx.cortexcore.Utils.PluginPrefix;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class HelpCommand implements CommandExecutor {
    RankHandler rankHandler = new RankHandler();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player))
            ConsoleMessage.instanceOfConsole(sender);
        assert sender instanceof Player;
        Player player = (Player) sender;

        if(rankHandler.getPlayerRank(player) >= 6){
            m(player, PluginPrefix.PLUGINPREFIX + "&6List Of Commands:&r\n" +
                    "&6/cc &r: Clears The Chat : &6&lTRAINEE\n" +
                    "&6/fly &r: Toggles Fly : &6&lTRAINEE\n" +
                    "&6/gm &r: Change Gamemode : &6&lMOD\n" +
                    "&4/rank &r: Sets a Players Rank : &4&lADMIN\n");
        }else{
            m(player, PluginPrefix.PLUGINPREFIX + "&cYour Rank Doesn't Come With Any Commands");
        }

        return false;
    }
    public String m(Player player, String msg){
        return PlayerMessages.Message(player, msg);
    }
}
