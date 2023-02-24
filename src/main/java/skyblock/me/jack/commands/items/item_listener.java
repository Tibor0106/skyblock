package skyblock.me.jack.commands.items;

import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;

import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import skyblock.me.jack.variables.var;

import java.util.ArrayList;
import java.util.List;

public class item_listener implements Listener {
    @EventHandler
    public void onClick(PlayerInteractEvent e) {
        try {

            ArrayList<LivingEntity> k = new ArrayList<LivingEntity>();
            if (e.getAction() == Action.RIGHT_CLICK_BLOCK || e.getAction() == Action.RIGHT_CLICK_AIR) {
                String  Item = "§8[§a⚔§r§8] §3§lSenior Kard";
                if (e.getItem().equals(item.getSenior_sword())) {
                    Player p = e.getPlayer();
                    p.sendMessage("asd");
                    for (Entity en : p.getNearbyEntities(5, 5, 5)) {
                        k.add((LivingEntity) en);

                    }
                    for (LivingEntity h : k) {
                        double hp = h.getHealth();

                           h.setCustomName("§c§l❤ §4§l"+ (int) h.getMaxHealth() + " §8/  §c§l" +(int) h.getHealth());
                           h.damage(10);
                    }

                }
            }

        } catch (NullPointerException err) {

        }
    }

    @EventHandler
    public void clickikktem(PlayerInteractEvent e) {
        Player p = e.getPlayer();
        Block bc = e.getClickedBlock();
        Location loc = e.getClickedBlock().getLocation();
        if (p.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase("§cNAGY arató kapa")) {
            if (e.getClickedBlock().getType() == Material.CARROTS || e.getClickedBlock().getType() == Material.NETHER_WART || e.getClickedBlock().getType() == Material.POTATOES) {
                if (e.getHand() != EquipmentSlot.HAND) {
                    return;
                } else if (e.getAction() == Action.RIGHT_CLICK_BLOCK) {
                    int bx = (int) loc.getBlock().getLocation().getX();
                    int by = (int) loc.getBlock().getLocation().getY();
                    int bz = (int) loc.getBlock().getLocation().getZ();
                    World world = loc.getBlock().getWorld();
                    List<Block> blocks = new ArrayList<>();
                    for (int x = bx - 1; x <= bx + 1; x++) {
                        p.sendMessage("X: " + x);


                        for (int z = bz - 1; z <= bz + 1; z++) {
                            blocks.add(new Location(world, (double) x, (double) by, (double) z).getBlock());
                            p.sendMessage("Z: " + z);


                        }
                    }

                    for (Block b : blocks) {

                        if (b.getType() == Material.CARROTS) {
                            if (b.getData() == (byte) 7 ||b.getData() == (byte) 6) {
                                b.breakNaturally();
                                b.setType(Material.CARROTS);
                            }
                        } else if (b.getType() == Material.NETHER_WART) {

                            b.breakNaturally();
                            b.setType(Material.NETHER_WART);
                        }
                    }

                }
            }
            e.setCancelled(true);
        }
    }
    @EventHandler
    public void repafarm(PlayerInteractEvent e) {
        try{
            if(e.getItem().getItemMeta().getDisplayName().equalsIgnoreCase("§6§lRépa Farm §7§o(Jobb kattintás)")){
                if(e.getAction() != Action.RIGHT_CLICK_BLOCK){
                    e.setCancelled(true);
                    return;

                }
                e.getPlayer().sendMessage(var.Prefix()+" §cTerület vizsgálata....");
                if(e.getClickedBlock().getType() == Material.GRASS_BLOCK || e.getClickedBlock().getType() == Material.DIRT) {
                    e.setCancelled(true);

                    Location Block_loc = e.getClickedBlock().getLocation();
                    double bx = Block_loc.getX();
                    double bz = Block_loc.getZ();
                    for (double x = bx - 4; x <= bx + 4; x++) {
                        for (double z = bz - 4; z <= bz + 4; z++) {
                            Location maked = new Location(e.getClickedBlock().getWorld(), x, Block_loc.getY(), z);
                           if(maked.getBlock().getType() == Material.DIRT || maked.getBlock().getType() == Material.GRASS_BLOCK ){
                           } else {
                               e.getPlayer().sendMessage(var.Prefix()+" §4Nem megfelelő terület:  §cFüves földnek vagy földnek kell leni a 9x9-es blockos körzetében.");
                               return;
                           }

                        }
                    }
                    e.getPlayer().sendMessage(var.Prefix()+" §aMegfelelő terület.");

                    for (double x = bx - 4; x <= bx + 4; x++) {
                        for (double z = bz - 4; z <= bz + 4; z++) {
                            Location maked = new Location(e.getClickedBlock().getWorld(), x, Block_loc.getY(), z);
                            maked.getBlock().setType(Material.FARMLAND);

                        }
                    }
                    for (double x = bx - 4; x <= bx + 4; x++) {
                        for (double z = bz - 4; z <= bz + 4; z++) {
                            Location maked = new Location(e.getClickedBlock().getWorld(), x, Block_loc.getY() + 1, z);
                            maked.getBlock().setType(Material.CARROTS);

                        }
                    }
                    e.getClickedBlock().setType(Material.WATER);
                    Location glow = e.getClickedBlock().getLocation().add(0, 1, 0);
                    glow.getBlock().setType(Material.LEGACY_GLOWSTONE);
                    Location loc= e.getClickedBlock().getLocation().add(0.4, 2.1, 0.4);
                    ArmorStand as = (ArmorStand) loc.getWorld().spawn(loc, ArmorStand.class);
                    as.setGravity(true);
                    as.setCanPickupItems(false);
                    as.setCustomName(ChatColor.translateAlternateColorCodes('&', "§6§lA RÉPA FARM ELKÉSZŰLT"));
                    as.setCustomNameVisible(true);
                    as.setInvisible(true);
                    as.setMarker(true);
                    Bukkit.getScheduler().runTaskLater(skyblock.me.jack.Skyblock.getPlugin(skyblock.me.jack.Skyblock.class), new Runnable() {

                        @Override
                        public void run() {
                            as.remove();

                        }
                    }, 120);
                    e.getPlayer().sendMessage(var.Prefix()+" §aSikeren le helyezted.");
                    if(e.getPlayer().getGameMode() == GameMode.CREATIVE){
                        return;
                    }
                    e.getItem().setAmount(e.getItem().getAmount()-1);




                } else {
                    e.getPlayer().sendMessage(var.Prefix()+" §4Nem megfelelő terület: §cFüves földre vagy földre helyezhető le.");
                    e.setCancelled(true);
                }


            }
        }catch (NullPointerException c){

        }

    }

}





