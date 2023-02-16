package skyblock.me.jack.Level;

import org.bukkit.ChatColor;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import skyblock.me.jack.commnds.items.item;
import skyblock.me.jack.variables.var;

public class Event implements Listener {
    @EventHandler
    public void level(AsyncPlayerChatEvent e){
        Player p = e.getPlayer();
        e.setFormat("§7(§a"+ var.getLevel(p)+"§7) "+p.getDisplayName() + ChatColor.DARK_GRAY + ": " + ChatColor.WHITE + e.getMessage());
    }
    @EventHandler
    public void onEDeath(EntityDeathEvent event) {
        LivingEntity en = event.getEntity();
        Player p = event.getEntity().getKiller();
        if(p == null){
            return;
        }
        int pp = event.getDroppedExp();
        if(p.getInventory().getItemInHand().equals(item.getSenior_sword())){
            pp=pp*2;

        }

        p.sendMessage(var.Prefix()+" §e+ "+pp+" XP");
        var.setmost_xp(p, pp);
    }
}
