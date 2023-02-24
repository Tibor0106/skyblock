package skyblock.me.jack.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import skyblock.me.jack.variables.var;

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
        } else if(args[0].equalsIgnoreCase("broadcast")){
            if (!sender.hasPermission("skyblock.command.is-social.broadcast")){
                sender.sendMessage(var.Prefix()+" §cNincs jogod ehez.");
                return true;
            }
            if(args.length > 1){
                StringBuilder str = new StringBuilder();
                for (int i = 1; i <  args.length; i++) {
                    str.append(args[i]+ " ");
                }
                String a = str.toString();
                for (Player playres : Bukkit.getOnlinePlayers()){
                    playres.sendMessage(var.Prefix()+" §4§lKÖZVETÍTÉS §r» §c"+a.replace("&","§"));
                }


            } else {
                sender.sendMessage(var.Prefix()+" §eUsagse: /is-social broadcast <text>");
            }

        }
        return false;
    }
}
