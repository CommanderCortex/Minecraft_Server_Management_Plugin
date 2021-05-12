package ctx.cortexcore;

import ctx.cortexcore.PunishSystem.PunishEvents.OnTempBanPlayerJoin;
import ctx.cortexcore.Commands.GeneralCommands.*;
import ctx.cortexcore.Commands.GeneralCommands.QuickGM.gmc;
import ctx.cortexcore.Commands.SetRankCommand.SetRankCommand;
import ctx.cortexcore.Global.Files.MainDIRSetup;
import ctx.cortexcore.Global.Players.OnPlayerChat;
import ctx.cortexcore.Global.Players.OnPlayerJoin;
import ctx.cortexcore.PunishSystem.Utils.BanUtil;
import ctx.cortexcore.PunishSystem.Utils.MuteUtil;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class CortexCore extends JavaPlugin {
    MuteUtil muteUtil = new MuteUtil();
    BanUtil banUtil = new BanUtil();

    @Override
    public void onEnable() {
        MainDIRSetup.SETUP(true); // Sets up plugin directories if set to true.
        registerCommands();
        registerEvents();
        muteUtil.setMuteYmlFile(this);
        banUtil.setupBanFile(this);

    }

    //Registers Our Plugin Events.
    public void registerEvents(){
        Bukkit.getPluginManager().registerEvents(new OnPlayerJoin(), this);
        Bukkit.getPluginManager().registerEvents(new OnPlayerChat(), this);
        Bukkit.getPluginManager().registerEvents(new OnTempBanPlayerJoin(), this);
    }

    //Registers Our Plugin Commands.
    public void registerCommands(){
        Objects.requireNonNull(Bukkit.getPluginCommand("fly")).setExecutor(new FlyCommand());
        Objects.requireNonNull(Bukkit.getPluginCommand("rank")).setExecutor(new SetRankCommand());
        Objects.requireNonNull(Bukkit.getPluginCommand("gm")).setExecutor(new GamemodeCommand());
        Objects.requireNonNull(Bukkit.getPluginCommand("cc")).setExecutor(new ClearChatCommand());
        Objects.requireNonNull(Bukkit.getPluginCommand("cortexhelp")).setExecutor(new HelpCommand());
        Objects.requireNonNull(Bukkit.getPluginCommand("cortex")).setExecutor(new InfoCommand());
        Objects.requireNonNull(Bukkit.getPluginCommand("kick")).setExecutor(new KickCommand());
        Objects.requireNonNull(Bukkit.getPluginCommand("gmc")).setExecutor(new gmc());
        //Objects.requireNonNull(Bukkit.getPluginCommand("tempmute")).setExecutor();
    }
}
