package skyblock.me.jack.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import skyblock.me.jack.commands.items.item;
import skyblock.me.jack.variables.var;

public class is_items implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(args[0].equalsIgnoreCase("give")){
            if(!sender.hasPermission("skyblock.commnd.is-items--give")){
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


            } else if(args[1].equalsIgnoreCase("big_hoe")){
                if(args.length == 2){
                    if(sender instanceof Player){
                        Player p = (Player) sender;

                        p.getInventory().addItem(item.get_speed_hoe());
                        sender.sendMessage(var.Prefix()+"§a A tárgyat sikeresen megkaptad.");
                    } else {
                        sender.sendMessage(var.Prefix()+" Ez csak a játékban használható.");
                        return true;
                    }


                } else if(args.length == 3){
                    try{
                        Player p = Bukkit.getPlayer(args[2]);
                        p.getInventory().addItem(item.get_speed_hoe());
                        sender.sendMessage(var.Prefix()+"§a A játékos tárgyat sikeresen megkapta.");
                    }catch (NullPointerException e){
                        sender.sendMessage(var.Prefix()+" §cNincs ilyen online játékos.");
                    }
                }

            } else if(args[1].equalsIgnoreCase("carrot_farm")){
            if(args.length == 2){
                if(sender instanceof Player){
                    Player p = (Player) sender;

                    p.getInventory().addItem(item.get_carrot_farm());
                    sender.sendMessage(var.Prefix()+"§a A tárgyat sikeresen megkaptad.");
                } else {
                    sender.sendMessage(var.Prefix()+" Ez csak a játékban használható.");
                    return true;
                }


            } else if(args.length == 3){
                try{
                    Player p = Bukkit.getPlayer(args[2]);
                    p.getInventory().addItem(item.get_carrot_farm());
                    sender.sendMessage(var.Prefix()+"§a A játékos tárgyat sikeresen megkapta.");
                }catch (NullPointerException e){
                    sender.sendMessage(var.Prefix()+" §cNincs ilyen online játékos.");
                }
            }

            } else if(args[1].equalsIgnoreCase("shade_bow")) {
                if (args.length == 2) {
                    if (sender instanceof Player) {
                        Player p = (Player) sender;

                        p.getInventory().addItem(item.get_shade_bow());
                        sender.sendMessage(var.Prefix() + "§a A tárgyat sikeresen megkaptad.");
                    } else {
                        sender.sendMessage(var.Prefix() + " Ez csak a játékban használható.");
                        return true;
                    }


                } else if (args.length == 3) {
                    try {
                        Player p = Bukkit.getPlayer(args[2]);
                        p.getInventory().addItem(item.get_shade_bow());
                        sender.sendMessage(var.Prefix() + "§a A játékos tárgyat sikeresen megkapta.");
                    } catch (NullPointerException e) {
                        sender.sendMessage(var.Prefix() + " §cNincs ilyen online játékos.");
                    }
                }
            }


        } else if(args[0].equalsIgnoreCase("name-item")){
            if(args.length < 1){
                return true;
            }
            String name = "";
            for (String  a : args){
                if(a.equalsIgnoreCase("name-item")){

                } else {
                    name += a+" ";
                }
            }
            Player p  = (Player) sender;
            try{
                ItemStack item = new ItemStack(p.getInventory().getItemInHand().getType());
                ItemMeta meta = item.getItemMeta();
                meta.setDisplayName(name.replace('&', '§'));
                p.getInventory().getItemInHand().setItemMeta(meta);

            } catch (NullPointerException e){
                sender.sendMessage(var.Prefix()+" §cNincs semmi a kezedben!");
                return true;
            }


        }
        return false;
    }
}
