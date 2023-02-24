package skyblock.me.jack.island_settings;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import skyblock.me.jack.Skyblock;

public class settings_gui_listener implements Listener {
    @EventHandler
    public void onInv(InventoryClickEvent e){
        Player p =(Player) e.getWhoClicked();
        try{
            if(p.getOpenInventory().getTitle().equalsIgnoreCase(settings_gui.GetSettingsGuiTitle())){
                e.setCancelled(true);
            }
        }catch (NullPointerException j){

        }
    }
    @EventHandler
    public void setting(InventoryClickEvent e){
        Player p = (Player) e.getWhoClicked();

        try{
            if(e.getCurrentItem().equals(settings_gui.IslandSettingsKillMobs(p))){
                if (settings.IslandSettingsKillMobsOtherPlayer(p)){
                     settings.IslandSettingsKillMobsOtherPlayerSET(p, false);
                     settings_gui.OpenIslandSettings(p);
                } else {
                    settings.IslandSettingsKillMobsOtherPlayerSET(p, true);
                    settings_gui.OpenIslandSettings(p);
                }
                Skyblock.save();

            }

        }catch (NullPointerException j){

        }
    }
}
