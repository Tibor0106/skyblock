package skyblock.me.jack.commands;

import me.jack.Spawn;
import org.bukkit.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import skyblock.me.jack.Skyblock;
import skyblock.me.jack.island_settings.settings_gui;
import skyblock.me.jack.variables.var;


public class island implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(args.length == 0){
            sender.sendMessage(var.Prefix()+" §cUse: §e/is help");
            return true;
        }

        if(args[0].equalsIgnoreCase("create")){
            Player p = (Player) sender;
            if(Skyblock.Islands.contains("Islands."+p.getName()+".spawn.X")){
                sender.sendMessage(var.Prefix()+" §cMár van szigeted! §7(§bHasználd a /is home parancsot§7)");
                return true;

            }
            sender.sendMessage(var.Prefix()+" §bLétrehozás...");
            Location a = p.getLocation();
            World world = Bukkit.getWorld(Skyblock.Islands.get("Island_world").toString());
            double x = Skyblock.Islands.getDouble("next-free-pos.X");
            double y = Skyblock.Islands.getDouble("next-free-pos.Y");
            double z = Skyblock.Islands.getDouble("next-free-pos.Z");
            Location island = new Location(world, x ,y , z);
            Skyblock.Islands.set("Islands."+p.getName()+".spawn.X", island.getX());
            Skyblock.Islands.set("Islands."+p.getName()+".spawn.Y", island.getY());
            Skyblock.Islands.set("Islands."+p.getName()+".spawn.Z", island.getZ());
           if(x <= z){
               Skyblock.Islands.set("next-free-pos.X", island.getZ()+200.0);
           } else {
               Skyblock.Islands.set("next-free-pos.Z", island.getX()+200.0);
           }
           Skyblock.Islands.set("Islands."+p.getName()+".settings.kill_mobs_other_player", true);
           Skyblock.save();

           Location loc1 = new Location(world, island.getX() , island.getY(),island.getZ());
           for(int i = 0; i < 100; i++){
               loc1.setX(loc1.getX()+1);
               loc1.setZ(loc1.getZ()-1);

            }
            Location loc2 = new Location(world, island.getX() , island.getY(),island.getZ());
            for(int i = 0; i < 100; i++){
                loc2.setX(loc2.getX()-1);
                loc2.setZ(loc2.getZ()+1);

            }
            loc1.setY(318);
            loc2.setY(-60);


            loc1.getBlock().setType(Material.GLOWSTONE);
            loc2.getBlock().setType(Material.GLOWSTONE);
            Skyblock.Islands.set("Islands."+p.getName()+".pos1.X", loc1.getX());
            Skyblock.Islands.set("Islands."+p.getName()+".pos1.Y", loc1.getY());
            Skyblock.Islands.set("Islands."+p.getName()+".pos1.Z", loc1.getZ());

            Skyblock.Islands.set("Islands."+p.getName()+".pos2.X", loc2.getX());
            Skyblock.Islands.set("Islands."+p.getName()+".pos2.Y", loc2.getY());
            Skyblock.Islands.set("Islands."+p.getName()+".pos2.Z", loc2.getZ());
            Skyblock.save();
            island.getBlock().setType(Material.BEDROCK);
            p.teleport(island.add(0, 1, 0));
            sender.sendMessage(var.Prefix()+" §aSziget sikeresen létrehozva! §e§oJó játékos kívánunk!");


        } else if(args[0].equalsIgnoreCase("home")|| args[0].equalsIgnoreCase("spawn") || args[0].equalsIgnoreCase("h")){

            Player p = (Player) sender;

            if(!Skyblock.Islands.contains("Islands."+p.getName()+".spawn.X")){
                sender.sendMessage(var.Prefix()+" §cMég nincs szigeted! §7(§bHasználd a /is create parancsot§7)");
                return true;

            }
            sender.sendMessage(var.Prefix()+" §bTeleportálás...");
            double x = Skyblock.Islands.getDouble("Islands."+p.getName()+".spawn.X");
            double y = Skyblock.Islands.getDouble("Islands."+p.getName()+".spawn.Y");
            double z = Skyblock.Islands.getDouble("Islands."+p.getName()+".spawn.Z");
            World world = Bukkit.getWorld(Skyblock.Islands.get("Island_world").toString());
            Location island = new Location(world, x ,y , z);
            p.teleport(island.add(0, 1, 0));
            sender.sendMessage(var.Prefix()+" §aSikeres teleportálás!..");

        }  else if(args[0].equalsIgnoreCase("leave")) {
            Player p = (Player) sender;
            Skyblock.Islands.set("Islands." + p.getName() + "", null);
            Skyblock.save();
            p.teleport(Spawn.getSpawn());


            sender.sendMessage(var.Prefix() + " §cA Szigeted véglegesen tötölve lett!");
        }else if(args[0].equalsIgnoreCase("settings")){
            Player p = (Player) sender;
            settings_gui.OpenIslandSettings(p);



        } else {
            sender.sendMessage(var.Prefix()+" §cNincs ilyen parancs!");
        }

        return false;
    }
}
