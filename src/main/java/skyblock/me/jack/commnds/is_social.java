package skyblock.me.jack.commnds;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.Plugin;
import skyblock.me.jack.variables.var;

import java.util.ArrayList;
import java.util.List;

public class is_social implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(args[0].equalsIgnoreCase("daily_news")){
            if(args[1].equalsIgnoreCase("add-line")){
                 if (args.length > 3){
                     Plugin plugin = skyblock.me.jack.Skyblock.getPlugin(skyblock.me.jack.Skyblock.class);
                     List<String> list = plugin.getConfig().getStringList("daily_news");



                 } else {
                     sender.sendMessage(var.Prefix()+" §eUsage: /is-social daily-news add-line <line>");
                 }
            }
        }
        return false;
    }
}
