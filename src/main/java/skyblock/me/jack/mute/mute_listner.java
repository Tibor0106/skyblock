package skyblock.me.jack.mute;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class mute_listner implements Listener {
    @EventHandler
    public void onchat(AsyncPlayerChatEvent e){
        if(mute.getMutecd().containsKey(e.getPlayer().getUniqueId())){
            e.getPlayer().sendMessage("muted");
            e.setCancelled(true);
        }
    }
}
