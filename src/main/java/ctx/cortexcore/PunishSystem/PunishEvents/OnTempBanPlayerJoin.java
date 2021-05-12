package ctx.cortexcore.PunishSystem.PunishEvents;

import ctx.cortexcore.PunishSystem.Utils.BanUtil;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class OnTempBanPlayerJoin implements Listener {
    BanUtil banUtil = new BanUtil();
    @EventHandler
    public void onTempBanJoin(PlayerJoinEvent joinEvent){
        Player player = joinEvent.getPlayer();

        if(banUtil.isBanned(player)){
            if(banUtil.getBanMillis(player) <= System.currentTimeMillis())
                banUtil.unBan(player);
        }else {
            banUtil.sendBanScreen(player);
        }
    }
}
