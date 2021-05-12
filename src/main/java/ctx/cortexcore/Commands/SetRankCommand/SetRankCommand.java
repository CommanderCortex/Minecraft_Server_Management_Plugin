package ctx.cortexcore.Commands.SetRankCommand;

import ctx.cortexcore.Commands.CommandMessages.PlayerMessages;
import ctx.cortexcore.PermissionsSystem.RankHandler;
import ctx.cortexcore.Utils.ConsoleMessage;
import ctx.cortexcore.Utils.PluginPrefix;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class SetRankCommand implements CommandExecutor {
    RankHandler rankHandler = new RankHandler();
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player))
            ConsoleMessage.instanceOfConsole(sender);

        assert sender instanceof Player;
        Player player = (Player) sender;
        Player target = Bukkit.getPlayer(args[0]);

        if(rankHandler.getPlayerRank(player) >= 9){
            if(target != null && target.isOnline()){

                switch (args[1]){
                    case "DEVELOPER":
                        rankHandler.setPlayerRank(target, rankHandler.DEVELOPER);
                        break;
                    case "ADMINISTRATOR":
                        rankHandler.setPlayerRank(target, rankHandler.ADMINISTRATOR);
                        break;
                    case "SNR_MODERATOR":
                        rankHandler.setPlayerRank(target, rankHandler.SNR_MODERATOR);
                        break;
                    case "MODERATOR":
                        rankHandler.setPlayerRank(target, rankHandler.MODERATOR);
                        break;
                    case "TRAINEE":
                        rankHandler.setPlayerRank(target, rankHandler.TRAINEE);
                        break;
                    case "DEFAULT":
                        rankHandler.setPlayerRank(target, rankHandler.DEFAULT);
                    default:
                        PlayerMessages.Message(player, PluginPrefix.PLUGINPREFIX + "&cError, &eRank Not Found Usage: /rank <player> <RANK> : for list of ranks use /ranks");
                }
                rankHandler.setTabPrefix();
            }else{
                PlayerMessages.PlayerNotFount(player);
            }
        }else{
            PlayerMessages.NoPermissions(player);
        }
        return false;
    }
}
