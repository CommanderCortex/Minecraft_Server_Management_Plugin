package ctx.cortexcore.Commands.GeneralCommands;

import ctx.cortexcore.Commands.CommandMessages.PlayerMessages;
import ctx.cortexcore.PermissionsSystem.RankHandler;
import ctx.cortexcore.Utils.ConsoleMessage;
import ctx.cortexcore.Utils.PluginPrefix;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FlyCommand implements CommandExecutor {
    RankHandler rankHandler =new RankHandler();
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player))
            ConsoleMessage.instanceOfConsole(sender);

        assert sender instanceof Player;
        Player player = (Player) sender;
        String fly = PluginPrefix.PLUGINPREFIX + "&bAllow Flight Toggled";

        if(rankHandler.getPlayerRank(player) >= 6){
            player.setAllowFlight(!player.getAllowFlight());
            PlayerMessages.Message(player, fly);
        }else{
            PlayerMessages.NoPermissions(player);
        }
        return false;
    }
}
