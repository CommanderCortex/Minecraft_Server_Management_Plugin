package ctx.cortexcore.Global.Players;

import ctx.cortexcore.PermissionsSystem.RankHandler;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class OnPlayerJoin implements Listener {
    RankHandler rankHandler = new RankHandler();
    //Sets up our Player file when a player joins the server.
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent playerJoinEvent) {
        Player player = playerJoinEvent.getPlayer();
        PlayerSetup.setupPlayer(player);
        rankHandler.setTabPrefix();
    }
}
