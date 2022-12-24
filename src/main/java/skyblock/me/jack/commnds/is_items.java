package skyblock.me.jack.commnds;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import skyblock.me.jack.commnds.items.item;
import skyblock.me.jack.variables.var;

public class is_items implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(args[0].equalsIgnoreCase("give")){
            if(!sender.hasPermission("skyblock.commnd.is-give")){
                sender.sendMessage(var.Prefix()+" §cNincs jogod ehez!");
                return true;
            }
            if(args[1].equalsIgnoreCase("senior_sword")){
                if(args.length == 2){
                    if(sender instanceof Player){
                        Player p = (Player) sender;

                        p.getInventory().addItem(item.getSenior_sword());
                        sender.sendMessage(var.Prefix()+"§a A tárgyat sikeresen megkaptad.");
                    } else {
                        sender.sendMessage(var.Prefix()+" Ez csak a játékban használható.");
                        return true;
                    }


                } else if(args.length == 3){
                    try{
                        Player p = Bukkit.getPlayer(args[2]);
                        p.getInventory().addItem(item.getSenior_sword());
                        sender.sendMessage(var.Prefix()+"§a A játékos tárgyat sikeresen megkapta.");
                    }catch (NullPointerException e){
                        sender.sendMessage(var.Prefix()+" §cNincs ilyen online játékos.");
                    }
                }
                //item-

            } else if(args[1].equalsIgnoreCase("legend_miner")){
                if(args.length == 2){
                    if(sender instanceof Player){
                        Player p = (Player) sender;

                        p.getInventory().addItem(item.getlegend_miner());
                        sender.sendMessage(var.Prefix()+"§a A tárgyat sikeresen megkaptad.");
                    } else {
                        sender.sendMessage(var.Prefix()+" Ez csak a játékban használható.");
                        return true;
                    }


                } else if(args.length == 3){
                    try{
                        Player p = Bukkit.getPlayer(args[2]);
                        p.getInventory().addItem(item.getlegend_miner());
                        sender.sendMessage(var.Prefix()+"§a A játékos tárgyat sikeresen megkapta.");
                    }catch (NullPointerException e){
                        sender.sendMessage(var.Prefix()+" §cNincs ilyen online játékos.");
                    }
                }

            }

        }
        return false;
    }
}
