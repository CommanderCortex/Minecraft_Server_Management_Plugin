package ctx.cortexcore.Global.Players;

import ctx.cortexcore.Global.Strings.PathStrings;
import ctx.cortexcore.PermissionsSystem.Ranks;
import ctx.cortexcore.Utils.ColorUtil;
import ctx.cortexcore.Utils.PluginPrefix;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;

public class PlayerSetup {
    static final Ranks ranks = new Ranks();

    //Player Setup
    public static void setupPlayer(Player player){
        String PlayerFile = PathStrings.getPlayerFile(player);
        File _PLAYERFILE = new File(PlayerFile);
        if(!_PLAYERFILE.exists()) { try { _PLAYERFILE.createNewFile(); } catch (IOException e) { e.printStackTrace(); } }
        YamlConfiguration playerConfiguration = YamlConfiguration.loadConfiguration(_PLAYERFILE);
        playerConfiguration.addDefault("Player", player.getName());
        playerConfiguration.addDefault("DisplayName", player.getDisplayName());
        playerConfiguration.addDefault("Rank", ranks.DEFAULT);
        playerConfiguration.options().copyDefaults(true);
        try { playerConfiguration.save(_PLAYERFILE); } catch (IOException e) { e.printStackTrace(); }
        player.sendMessage(ColorUtil.Color(PluginPrefix.PLUGINPREFIX + "&aYour Player Data Has Been Updated!"));
    }
}
