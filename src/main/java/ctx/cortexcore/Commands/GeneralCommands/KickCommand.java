package ctx.cortexcore.Commands.GeneralCommands;

import ctx.cortexcore.Commands.CommandMessages.PlayerMessages;
import ctx.cortexcore.PermissionsSystem.RankHandler;
import ctx.cortexcore.Utils.ConsoleMessage;
import ctx.cortexcore.Utils.PluginPrefix;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class KickCommand implements CommandExecutor {
    RankHandler rankHandler = new RankHandler();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player))
            ConsoleMessage.instanceOfConsole(sender);

        assert sender instanceof Player;
        Player player = (Player) sender;

        Player target = Bukkit.getPlayer(args[0]);

        if(rankHandler.getPlayerRank(player) >= 6){
            if(target != null && target.isOnline()){
                target.kickPlayer(PlayerMessages.Message(target, "Kicked By Console!"));
            }else{
                PlayerMessages.PlayerNotFount(player);
            }
        }else{
            PlayerMessages.NoPermissions(player);
        }

        return false;
    }
}
