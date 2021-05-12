package ctx.cortexcore.PunishSystem.Utils;

import ctx.cortexcore.Global.Strings.PathStrings;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class MuteUtil {
    private static YamlConfiguration MuteYmlFile;
    private Plugin plugin;
    private File _MuteFile;

    public void setMuteYmlFile(Plugin plugin){
        this.plugin = plugin;
        String MuteFile= PathStrings.MUTEDIR;
        File _MuteFile = new File(MuteFile + "MuteList.yml");
        if(!_MuteFile.exists()) { try { _MuteFile.createNewFile(); } catch (IOException e) { e.printStackTrace(); } }
        MuteYmlFile = YamlConfiguration.loadConfiguration(_MuteFile);
    }
    public void mute(Player player, String Reason, long seconds){
        if(isMuted(player))
            return;

        long time = 0;
        long current = System.currentTimeMillis();
        long millis = seconds*1000;
        time = current + millis;

        if(seconds == -1)
            time = -1;

        MuteYmlFile.set("Mutes."+player+".time", null);
        MuteYmlFile.set("Mutes."+player+".reason", null);
    }
    public String getMuteReason(Player player){
        return MuteYmlFile.getString("Mutes."+player+".reason");
    }
    public String getUnMuteDate(Player player){
        long time = MuteYmlFile.getLong("Mutes."+player+".time");
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        dateFormat.setTimeZone(TimeZone.getTimeZone("New Zealand"));
        Date date = new Date(time);
        return dateFormat.format(date);
    }
    public boolean isMuted(Player player){
        return  MuteYmlFile.get("Mutes." + player + ".reason") != null;
    }
    public long getMuteMillis(Player player){
        return MuteYmlFile.getLong("Mutes."+player+".time");
    }
    public void saveFile(){
        try {
            MuteYmlFile.save(_MuteFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void unMute(Player player){
        MuteYmlFile.set("Bans." + player + ".time", null);
        MuteYmlFile.set("Bans." + player + ".reason", null);
    }
}
