package ctx.cortexcore.Commands.CommandMessages;

import ctx.cortexcore.PermissionsSystem.RankHandler;
import ctx.cortexcore.Utils.ColorUtil;
import ctx.cortexcore.Utils.PluginPrefix;
import org.bukkit.entity.Player;

public class UpdatedRankMsg {
    static RankHandler rankHandler=new RankHandler();
    public static void Message(String message, Player player){
        player.sendMessage(ColorUtil.Color(message));
    }
    public static void updatedRank(Player player){
        int rank = rankHandler.getPlayerRank(player);
        String rankPrefix = rankHandler.getRankPrefix(rank);
        Message(PluginPrefix.PLUGINPREFIX + "&bRank Updated to " + rankPrefix, player);
    }
}
