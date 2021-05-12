package ctx.cortexcore.Commands.GeneralCommands;

import ctx.cortexcore.Commands.CommandMessages.PlayerMessages;
import ctx.cortexcore.PermissionsSystem.RankHandler;
import ctx.cortexcore.Utils.PluginPrefix;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ClearChatCommand  implements CommandExecutor {
    RankHandler rankHandler = new RankHandler();

    public void clearChat(){
        for(int i = 0; i<256; i++)
            Bukkit.broadcastMessage("");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player))
            clearChat();
            sender.sendMessage("Chat Cleared!");

        assert sender instanceof Player;
        Player player = (Player) sender;

        if(rankHandler.getPlayerRank(player) >= 6){
            clearChat();
            PlayerMessages.Message(player, PluginPrefix.PLUGINPREFIX + "&bChat Cleared!");
        }else {
            PlayerMessages.NoPermissions(player);
        }
        return false;
    }
}
