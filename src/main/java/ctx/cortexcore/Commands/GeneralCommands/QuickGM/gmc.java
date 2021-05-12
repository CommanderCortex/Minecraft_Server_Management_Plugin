package ctx.cortexcore.Commands.GeneralCommands.QuickGM;

import ctx.cortexcore.Commands.CommandMessages.PlayerMessages;
import ctx.cortexcore.PermissionsSystem.RankHandler;
import ctx.cortexcore.Utils.ConsoleMessage;
import ctx.cortexcore.Utils.PluginPrefix;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class gmc implements CommandExecutor {

    RankHandler rankHandler = new RankHandler();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player))
            ConsoleMessage.instanceOfConsole(sender);

        assert sender instanceof Player;
        Player player = (Player) sender;

        if(rankHandler.getPlayerRank(player) >=9) {
            player.setGameMode(GameMode.CREATIVE);
            PlayerMessages.Message(player, PluginPrefix.PLUGINPREFIX+"&bGamemode Updated!");
        }else
            PlayerMessages.NoPermissions(player);

        return false;
    }
}
