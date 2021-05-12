package ctx.cortexcore.PermissionsSystem;

import ctx.cortexcore.Global.Strings.PathStrings;
import ctx.cortexcore.Utils.ColorUtil;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

import java.io.File;
import java.io.IOException;

public class RankHandler extends Ranks{

    //Get the players rank from the players UUID.yml
    public int getPlayerRank(Player player){
        String playerFile = PathStrings.getPlayerFile(player);
        File playerRank = new File(playerFile);
        YamlConfiguration playerYamlConfig = YamlConfiguration.loadConfiguration(playerRank);
        return playerYamlConfig.getInt("Rank");
    }
    //Set the players rank in the players UUID.yml
    public void setPlayerRank(Player player, int rank){
        String playerFile = PathStrings.getPlayerFile(player);
        File playerRank = new File(playerFile);
        YamlConfiguration playerYamlConfig = YamlConfiguration.loadConfiguration(playerRank);
        playerYamlConfig.set("Rank", rank);
        try { playerYamlConfig.save(playerRank); } catch (IOException e) { e.printStackTrace(); }
    }
    //Gets the rank then returns a string in the form of a prefix.
    public String getRankPrefix(int rank){
        if(rank == DEVELOPER)
            return Color("&4&lDEV &r");
        if(rank == ADMINISTRATOR)
            return Color("&4&lADMIN &r");
        if(rank == SNR_MODERATOR)
            return Color("&6&lSNR_MOD &r");
        if(rank == MODERATOR)
            return Color("&6&lMOD &r");
        if(rank == TRAINEE)
            return Color("&6&lTRAINEE &r");
        return "";
    }
    //Sets rank prefix in tab
    public void setTabPrefix(){
        for(Player player : Bukkit.getOnlinePlayers()){
            Scoreboard scoreboard = Bukkit.getScoreboardManager().getNewScoreboard();
            for (Player player1 : Bukkit.getOnlinePlayers()){
                String prefix = getRankPrefix(getPlayerRank(player));
                Team team = scoreboard.registerNewTeam(player1.getDisplayName());
                team.setPrefix(prefix);
                team.addEntry(player1.getDisplayName());
            }
            player.setScoreboard(scoreboard);
        }
    }

    //Implementing Color Util to make getting Color(<string>) easy
    String Color(String prefix) {
        return ColorUtil.Color(prefix);
    }
}
