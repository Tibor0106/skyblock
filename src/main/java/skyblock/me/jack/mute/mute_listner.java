package skyblock.me.jack.mute;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import skyblock.me.jack.variables.var;

import java.util.UUID;

public class mute_listner implements Listener {
    @EventHandler
    public void onchat(AsyncPlayerChatEvent e){
        if(mute.getMutecd().containsKey(e.getPlayer().getUniqueId())){
            for (UUID i : mute.getMutecd().keySet()) {
                if(i.toString().equalsIgnoreCase(e.getPlayer().getUniqueId().toString())){
                    e.getPlayer().sendMessage(var.Prefix()+"§c Le vagy némítva! Még §f"+var.sec_to_time_format(mute.getMutecd().get(i))+"§c van hátra.");
                    e.setCancelled(true);
                }

            }

        }
    }
}
