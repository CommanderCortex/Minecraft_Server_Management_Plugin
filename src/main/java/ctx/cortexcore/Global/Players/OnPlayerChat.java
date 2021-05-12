package ctx.cortexcore.Global.Players;

import ctx.cortexcore.PermissionsSystem.RankHandler;
import ctx.cortexcore.PunishSystem.Utils.MuteUtil;
import ctx.cortexcore.Utils.ColorUtil;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class OnPlayerChat implements Listener {
    RankHandler rankHandler = new RankHandler();
    MuteUtil muteUtil = new MuteUtil();
    @EventHandler
    public void onPlayerChatEvent(AsyncPlayerChatEvent playerChatEvent){
        playerChatEvent.setCancelled(true);
        Player player = playerChatEvent.getPlayer();
        String playerMSG = playerChatEvent.getMessage();
        String DisplayName = player.getDisplayName();
        String prefix = rankHandler.getRankPrefix(rankHandler.getPlayerRank(player));
        if(muteUtil.isMuted(player)){
            return;
        }else{
            Bukkit.broadcastMessage(ColorUtil.Color(prefix + DisplayName + " &a>> &r" + playerMSG));
        }
    }
}
