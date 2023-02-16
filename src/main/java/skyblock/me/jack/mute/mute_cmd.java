package skyblock.me.jack.mute;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import skyblock.me.jack.Database.mysql;
import skyblock.me.jack.variables.var;


public class mute_cmd implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender.hasPermission("skyblock.command.mute")){
            if(args.length !=2){
                sender.sendMessage(var.Prefix()+" §eUsage: /mute <player> <time> §8| §c§otime to seconds!");
                return true;
            }
            int time;
            Player p;
            try {
                time = Integer.parseInt(args[1]);
            }catch (NumberFormatException e){
                sender.sendMessage(var.Prefix()+" §cHelytelen haszálat! Számot adj meg!");
                return true;
            }
            try {
                p = Bukkit.getPlayer(args[0]);
            }catch (NumberFormatException e){
                sender.sendMessage(var.Prefix()+" §cNincs ilyen játékos!");
                return  true;
            }
            mute.getMutecd().put(p.getUniqueId(), time);
            sender.sendMessage(var.Prefix()+" §cJátékos le lett némítva!");
            mysql.mute_log(sender.getName().toString(), p.getName().toString(), time);
            for(Player s : Bukkit.getOnlinePlayers()){
                if (s.hasPermission("skyblock.command.mute")){
                    s.sendMessage(var.Prefix()+" §c§lNémítás: §r§e"+sender.getName()+ "§b némította §f"+p.getName()+"§b játékost §c"+time+" §bmásodpercre.");
                }
            }
            p.sendMessage(var.Prefix()+" §cLe lettél némítva §e"+var.sec_to_time_format(time)+"");
        }
        return false;
    }
}
