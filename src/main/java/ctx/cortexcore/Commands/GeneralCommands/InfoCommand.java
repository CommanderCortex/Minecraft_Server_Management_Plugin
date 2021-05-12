package ctx.cortexcore.Commands.GeneralCommands;

import ctx.cortexcore.Utils.ColorUtil;
import ctx.cortexcore.Utils.PluginPrefix;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.chat.hover.content.Text;
import org.bukkit.Color;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class InfoCommand implements CommandExecutor{
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player)sender;
        sender.sendMessage(ColorUtil.Color(PluginPrefix.PLUGINPREFIX+"&9Developed By CommanderCortex.\n"));
        TextComponent message = new TextComponent("Check Out My Github Here!");
        message.setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, "https://www.github.com/CommanderCortex"));
        message.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new Text("Click for my Github Link!")));
        player.spigot().sendMessage(message);
        //player.performCommand("tellraw @p {\"text\":\"Click here for my Github\",\"color\":\"white\",\"underlined\":\"false\",\"clickEvent\":{\"action\":\"open_url\",\"value\":\"https://www.github.com/CommanderCortex\"}}]");

        return false;
    }
}
