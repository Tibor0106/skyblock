package skyblock.me.jack.commnds;

import com.sk89q.worldedit.IncompleteRegionException;
import com.sk89q.worldedit.WorldEdit;
import com.sk89q.worldedit.bukkit.BukkitAdapter;
import com.sk89q.worldedit.regions.Region;
import com.sk89q.worldguard.WorldGuard;
import com.sk89q.worldguard.domains.DefaultDomain;
import com.sk89q.worldguard.protection.managers.RegionManager;
import com.sk89q.worldguard.protection.regions.ProtectedCuboidRegion;
import com.sk89q.worldguard.protection.regions.ProtectedRegion;
import com.sk89q.worldguard.protection.regions.RegionContainer;
import org.bukkit.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Marker;
import org.bukkit.entity.Player;
import org.bukkit.util.BlockVector;
import skyblock.me.jack.Skyblock;
import skyblock.me.jack.variables.var;
import com.sk89q.worldguard.protection.regions.ProtectedRegion;
import com.sk89q.worldguard.protection.regions.RegionContainer;
import com.sk89q.worldguard.protection.regions.RegionQuery;
import com.sk89q.worldguard.protection.regions.RegionType;



import java.util.Vector;
import java.util.concurrent.TimeUnit;

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

           Skyblock.save();

           Location loc1 = new Location(world, island.getX() , island.getY(),island.getZ());
           for(int i = 0; i < 30; i++){
               loc1.setX(loc1.getX()+1);
               loc1.setZ(loc1.getZ()-1);

            }
            Location loc2 = new Location(world, island.getX() , island.getY(),island.getZ());
            for(int i = 0; i < 30; i++){
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


        } else if(args[0].equalsIgnoreCase("home")){

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

        }  else if(args[0].equalsIgnoreCase("leave")){
            Player p = (Player) sender;
            Skyblock.Islands.set("Islands."+p.getName()+"", null);
            Skyblock.save();
            sender.sendMessage(var.Prefix()+" §cA Szigeted véglegesen tötölve lett!");

        } else {
            sender.sendMessage(var.Prefix()+" §cNincs ilyen parancs!");
        }

        return false;
    }
}
