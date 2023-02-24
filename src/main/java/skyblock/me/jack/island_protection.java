package skyblock.me.jack;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.util.Vector;
import skyblock.me.jack.Skyblock;
import skyblock.me.jack.variables.var;

import java.util.ArrayList;

public class island_protection implements Listener {


    private Location bottomLocation;
    private Location topLocation;
    @EventHandler
    public void onBlockPlace(BlockPlaceEvent event) {
        Player p = event.getPlayer();
        if(p.hasPermission("skyblock.island.admin")){
            return;
        }
        bottomLocation = getUserIslandsLowerPoint(p);
        topLocation = getUserIslandsUpperPoint(p);
        Player player = event.getPlayer();
        Block placedBlock = event.getBlock();
        Location placedBlockLocation = placedBlock.getLocation();
        if (!isInsideProtectedArea(placedBlockLocation)) {
            event.setCancelled(true);
            player.sendMessage(var.Prefix()+" §cEzt itt nem teheted meg!");
        }
    }
    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        Player p = event.getPlayer();
        if(p.hasPermission("skyblock.islands.admin")){
            return;
        }
        bottomLocation = getUserIslandsLowerPoint(p);
        topLocation = getUserIslandsUpperPoint(p);
        Player player = event.getPlayer();
        Block brokenBlock = event.getBlock();
        Location brokenBlockLocation = brokenBlock.getLocation();

        if (!isInsideProtectedArea(brokenBlockLocation)) {
            event.setCancelled(true);
            player.sendMessage(var.Prefix()+" §cEzt itt nem teheted meg!");
        }
    }

    private boolean isInsideProtectedArea(Location location) {

        if (bottomLocation == null || topLocation == null) {
            return false;
        }
        if (location.getWorld() != bottomLocation.getWorld()) {
            return false;
        }
        if (location.getBlockY() < bottomLocation.getBlockY() || location.getBlockY() > topLocation.getBlockY()) {
            return false;
        }
        if (location.getX() < Math.min(bottomLocation.getX(), topLocation.getX()) || location.getX() > Math.max(bottomLocation.getX(), topLocation.getX())) {
            return false;
        }
        if (location.getZ() < Math.min(bottomLocation.getZ(), topLocation.getZ()) || location.getZ() > Math.max(bottomLocation.getZ(), topLocation.getZ())) {
            return false;
        }
        return true;
    }

    private static Location getUserIslandsUpperPoint(Player p) {
        double x2 = Skyblock.Islands.getDouble("Islands." + p.getName() + ".pos1.X");
        double y2 = Skyblock.Islands.getDouble("Islands." + p.getName() + ".pos1.Y");
        double z2 = Skyblock.Islands.getDouble("Islands." + p.getName() + ".pos1.Z");


        return new Location(Bukkit.getWorld("islands"), x2, y2, z2);


    }
    private static Location getUserIslandsLowerPoint(Player p) {
        double x1 = Skyblock.Islands.getDouble("Islands." + p.getName() + ".pos2.X");
        double y1 = Skyblock.Islands.getDouble("Islands." + p.getName() + ".pos2.Y");
        double z1 = Skyblock.Islands.getDouble("Islands." + p.getName() + ".pos2.Z");


        return new Location(Bukkit.getWorld("islands"), x1, y1, z1);


    }
}



