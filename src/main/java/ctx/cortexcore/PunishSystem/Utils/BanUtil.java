package ctx.cortexcore.PunishSystem.Utils;

import ctx.cortexcore.Global.Strings.PathStrings;

import ctx.cortexcore.Utils.ColorUtil;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class BanUtil {

    private static YamlConfiguration BanYmlFile;
    private Plugin plugin;
    private File _BanFile;

    public void setupBanFile(Plugin plugin){
        this.plugin = plugin;
        String BanFile = PathStrings.BANDIR;
        File _BanFile = new File(BanFile + "BanList.yml");
        if(!_BanFile.exists()){ try { _BanFile.createNewFile(); } catch (IOException e) { e.printStackTrace(); } }
        BanYmlFile = YamlConfiguration.loadConfiguration(_BanFile);
    }
    public void ban(Player player, String Reason, long seconds){
        if(isBanned(player))
            return;

        long time = 0;
        long current = System.currentTimeMillis();
        long millis = seconds*1000;
        time = current + millis;

        if(seconds == -1)
            time = -1;

        BanYmlFile.set("Bans." + player + ".time", time);
        BanYmlFile.set("Bans." + player + ".reason", Reason);
    }
    public void unBan(Player player){
        BanYmlFile.set("Bans." + player + ".time", null);
        BanYmlFile.set("Bans." + player + ".reason", null);
    }
    public void sendBanScreen(Player player){
        player.kickPlayer(ColorUtil.Color("You are Banned!\n\n" +
                "&7Reason: " + getReason(player) +"\n\n"+
                "&7Unban Date: " + getUnbanDate(player)));
    }
    public String getUnbanDate(Player player){
        long time = BanYmlFile.getLong("Bans." + player + ".time");
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        dateFormat.setTimeZone(TimeZone.getTimeZone("New Zealand"));
        Date date = new Date(time);
        return dateFormat.format(date);
    }
    public String getReason(Player player){
        return BanYmlFile.getString("Bans."+player+".reason");
    }
    public boolean isBanned(Player player){
        return BanYmlFile.get("Bans." + player + ".reason") != null;
    }
    public long getBanMillis(Player player){
        return BanYmlFile.getLong("Bans." + player + ".time");
    }
    public void saveFile(){
        try {
            BanYmlFile.save(_BanFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
