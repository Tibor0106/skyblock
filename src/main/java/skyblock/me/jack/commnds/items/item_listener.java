package skyblock.me.jack.commnds.items;

import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import java.util.ArrayList;

public class item_listener implements Listener {
    @EventHandler
    public void onClick(PlayerInteractEvent e) {
        try {

            ArrayList<LivingEntity> k = new ArrayList<LivingEntity>();
            if (e.getAction() == Action.RIGHT_CLICK_BLOCK || e.getAction() == Action.RIGHT_CLICK_AIR) {
                Player p = e.getPlayer();
                for (Entity en : p.getNearbyEntities(5, 5, 5)) {
                    k.add((LivingEntity) en);

                }
                for (LivingEntity h : k) {
                    double hp = h.getHealth();
                    hp-=15;
                    if(hp <= 0){
                        h.setHealth(0);
                    } else {
                        h.setHealth(hp);
                    }

                }

            }

        } catch (NullPointerException err) {

        }
    }

}
