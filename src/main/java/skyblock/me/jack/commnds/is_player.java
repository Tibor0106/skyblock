package skyblock.me.jack.commnds;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import skyblock.me.jack.variables.var;

import java.util.UUID;

public class is_player implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(args.length == 0){
            sender.sendMessage(""+var.Prefix()+" §eUsage: /is-player help");
            return true;
        }
        if(args[0].equalsIgnoreCase("info")){
            if(args.length != 2){
                sender.sendMessage(""+var.Prefix()+" §eUsage: /is-player info (player)");
                return true;
            }
           OfflinePlayer p =  Bukkit.getOfflinePlayer(args[1]);
           //check player exits
            if(var.getLevel(p) == -1){
                sender.sendMessage(var.Prefix()+" §cNincs ilyen játékos.");
                return true;
            }
           UUID uuid = p.getUniqueId();

           sender.sendMessage("§8[§a§l----------------------§r§8[ §e§lINFO §8]§a§l--------------------§r§8]");
           sender.sendMessage(" §e- §aName: §e"+p.getName());
           if(p.isOnline()){
               sender.sendMessage(" §e- §aIp: §e"+p.getPlayer().getAddress().getAddress());
           }
           sender.sendMessage(" §e- §aUUID: §e"+uuid.toString());
           sender.sendMessage(" §e- §aLevel: §e"+ var.getLevel(p));
           sender.sendMessage(" §e- §aXp: §e"+ var.get_xp(p));
           sender.sendMessage(" §e- §aMost xp: §e"+ var.getmost_xp(p));
           sender.sendMessage(" §e- §acredit: §e"+ var.getCredit(p));


        } else if(args[0].equalsIgnoreCase("level-set")) {
            if(args.length != 3){
                sender.sendMessage(""+var.Prefix()+" §eUsage: /is-player level-set <player> (amount)");
                return true;
            }
            OfflinePlayer p = Bukkit.getOfflinePlayer(args[1]);
            //check player exits
            if (var.getLevel(p) == -1) {
                sender.sendMessage(var.Prefix() + " §cNincs ilyen játékos.");
                return true;
            }
            int a = Integer.parseInt(args[2]);
            var.setLevel(p, a);
            if (var.getLevel(p) == a){
                sender.sendMessage(var.Prefix()+" §e"+p.getName()+" új szintje "+var.getLevel(p));
            }
        } else if(args[0].equalsIgnoreCase("level-give")) {
            if(args.length != 3){
                sender.sendMessage(""+var.Prefix()+" §eUsage: /is-player level-give <player> (amount)");
                return true;
            }
            OfflinePlayer p = Bukkit.getOfflinePlayer(args[1]);
            if (var.getLevel(p) == -1) {
                sender.sendMessage(var.Prefix() + " §cNincs ilyen játékos.");
                return true;
            }
            int a = Integer.parseInt(args[2]);
            var.setLevel(p, var.getLevel(p)+a);
            sender.sendMessage(""+var.Prefix()+" §eSikeresen hozzáadtál "+p.getName()+" szintjéhez "+a+" szintet.");
        } else if(args[0].equalsIgnoreCase("credit-give")) {
            if(args.length != 3){
                sender.sendMessage(""+var.Prefix()+" §eUsage: /is-player credit-give <player> (amount)");
                return true;
            }
            OfflinePlayer p = Bukkit.getOfflinePlayer(args[1]);
            if (var.getCredit(p) == -1) {
                sender.sendMessage(var.Prefix() + " §cNincs ilyen játékos.");
                return true;
            }
            int a = Integer.parseInt(args[2]);
            var.setCredit(p, var.getCredit(p)+a);
            sender.sendMessage(""+var.Prefix()+" §eSikeresen hozzáadtál "+p.getName()+" egyengéhez "+a+" creditet.");
        } else if(args[0].equalsIgnoreCase("credit-set")) {
            if(args.length != 3){
                sender.sendMessage(""+var.Prefix()+" §eUsage: /is-player credit-set <player> (amount)");
                return true;
            }
            OfflinePlayer p = Bukkit.getOfflinePlayer(args[1]);
            if (var.getCredit(p) == -1) {
                sender.sendMessage(var.Prefix() + " §cNincs ilyen játékos.");
                return true;
            }
            int a = Integer.parseInt(args[2]);
            var.setCredit(p, a);
            sender.sendMessage(""+var.Prefix()+" §eSikeresen beállítottad "+p.getName()+" egyengét "+a+" credit-re/ra.");

        } else {
            sender.sendMessage(""+var.Prefix()+" §eUsage: /is-player help");
        }
        return false;
    }
}
