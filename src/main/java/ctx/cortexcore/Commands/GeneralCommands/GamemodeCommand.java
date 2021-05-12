package ctx.cortexcore.Commands.GeneralCommands;

import ctx.cortexcore.Commands.CommandMessages.PlayerMessages;
import ctx.cortexcore.PermissionsSystem.RankHandler;
import ctx.cortexcore.Utils.ConsoleMessage;
import ctx.cortexcore.Utils.PluginPrefix;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GamemodeCommand implements CommandExecutor {
    RankHandler rankHandler = new RankHandler();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player))
            ConsoleMessage.instanceOfConsole(sender);

        assert sender instanceof Player;
        Player player = (Player) sender;
        Player target = Bukkit.getPlayer(args[0]);
        String Updated = PluginPrefix.PLUGINPREFIX+"&aYour Gamemode has Been Updated!";

        if(rankHandler.getPlayerRank(player) >= 6){
            if(target != null && target.isOnline()){
                switch (args[1]) {
                    case "c":
                        target.setGameMode(GameMode.CREATIVE);
                        PlayerMessages.Message(player, Updated);
                        break;
                    case "s":
                        target.setGameMode(GameMode.SURVIVAL);
                        PlayerMessages.Message(player, Updated);
                        break;
                    case "a":
                        target.setGameMode(GameMode.ADVENTURE);
                        PlayerMessages.Message(player, Updated);
                        break;
                    case "p":
                        target.setGameMode(GameMode.SPECTATOR);
                        PlayerMessages.Message(player, Updated);
                    default:
                        PlayerMessages.Message(player, PluginPrefix.PLUGINPREFIX + "&cError Gamemode Not Fount! Usage: /gm <c, s, a, p>");
                }
            }else{
                PlayerMessages.PlayerNotFount(player);
            }
        }else{
            PlayerMessages.NoPermissions(player);
        }
        return false;
    }
}
