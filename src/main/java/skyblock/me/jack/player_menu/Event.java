package skyblock.me.jack.player_menu;

import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.*;
import org.bukkit.inventory.ItemStack;

public class Event implements Listener {

    @EventHandler
    public void onFkeyPress(PlayerSwapHandItemsEvent event) {
        try{
            if (event.getPlayer().getInventory().getItem(8).getItemMeta().getDisplayName().equalsIgnoreCase("§aJátékos menü")) {
                event.setCancelled(true);
            }

        }catch (NullPointerException b){

        }

    }

    @EventHandler
    public void onFkeyPress(InventoryClickEvent event) {
        try{
            if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aJátékos menü")) {
                event.setCancelled(true);
            }
            if(event.getWhoClicked().getOpenInventory().getTitle().equalsIgnoreCase("§aJátékos menü")){
                event.setCancelled(true);
            }

        }catch (NullPointerException b){

        }

    }

    @EventHandler
    public void onDrop(PlayerDropItemEvent e) {
        try{
            Item item = e.getItemDrop();
            Player p = e.getPlayer();
            if (e.getItemDrop().getItemStack().getItemMeta().getDisplayName().equalsIgnoreCase("§aJátékos menü")) {
                e.setCancelled(true);
            }

        }catch (NullPointerException b){

        }

    }
    @EventHandler
    public void onDie(PlayerDeathEvent e){
        if(e.getEntity() instanceof Player){
            for(ItemStack i : e.getDrops()) {
                if (i.getItemMeta().getDisplayName().equalsIgnoreCase("§aJátékos menü")) {
                    e.getDrops().remove(i);
                    menu.add(e.getEntity());
                }
            }


            } else {
            return;
           }
    }
    @EventHandler
    public void onrespawn(PlayerRespawnEvent e){
        menu.add(e.getPlayer());
    }

    @EventHandler
    public void onjoin(PlayerJoinEvent e){
        menu.add(e.getPlayer());

    }
    @EventHandler
    public void open(PlayerInteractEvent e){
        try{
            if (e.getItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aJátékos menü")){
                player_manu.open(e.getPlayer());

            }

        }catch (NullPointerException b){

        }

    }



}





