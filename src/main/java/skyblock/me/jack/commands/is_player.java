package skyblock.me.jack.commands;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import skyblock.me.jack.Skyblock;
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
            if(!sender.hasPermission("skyblock.command.is-player.info")){
                sender.sendMessage(var.Prefix()+" §cNincs jogod ehez!");
                return true;
            }
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
            if(Skyblock.Islands.contains("Islands."+p.getName()+"")){
                sender.sendMessage(" §e- §aHas island: §eYes");
            } else {
                sender.sendMessage(" §e- §aHas island: §cNo");
            }



        } else if(args[0].equalsIgnoreCase("level-set")) {
            if(!sender.hasPermission("skyblock.command.is-player.level-set")){
                sender.sendMessage(var.Prefix()+" §cNincs jogod ehez!");
                return true;
            }
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
            if(a >= 5001){
                sender.sendMessage(var.Prefix()+" §c§lA maximum szint 5000!");
                return true;
            }
            var.setLevel(p, a);
            if (var.getLevel(p) == a){
                sender.sendMessage(var.Prefix()+" §e"+p.getName()+" új szintje "+var.getLevel(p));
            }
        } else if(args[0].equalsIgnoreCase("level-give")) {
            if(!sender.hasPermission("skyblock.command.is-player.level-give")){
                sender.sendMessage(var.Prefix()+" §cNincs jogod ehez!");
                return true;
            }
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
            if(!sender.hasPermission("skyblock.command.is-player.credit-give")){
                sender.sendMessage(var.Prefix()+" §cNincs jogod ehez!");
                return true;
            }
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
            if(!sender.hasPermission("skyblock.command.is-player.credit-set")){
                sender.sendMessage(var.Prefix()+" §cNincs jogod ehez!");
                return true;
            }
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
        } else if(args[0].equalsIgnoreCase("mute-history")) {
            if(!sender.hasPermission("skyblock.command.is-player.mute-history")){
                sender.sendMessage(var.Prefix()+" §cNincs jogod ehez!");
                return true;
            }
            if(args.length != 2) {
                sender.sendMessage("" + var.Prefix() + " §eUsage: /is-player mute-history (player)");
                return true;
            }
            String player = args[1];
            var.mute_history(player, sender);
        } else {
            sender.sendMessage(""+var.Prefix()+" §eUsage: /is-player help");
        }

        return false;
    }
}
