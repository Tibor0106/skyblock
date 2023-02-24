package skyblock.me.jack.commands;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import skyblock.me.jack.variables.var;

public class commandspy_listener implements Listener {
    @EventHandler
    public void onPlayerCommandPreprocess(PlayerCommandPreprocessEvent event){
        String cmd = event.getMessage();
        Player ply = event.getPlayer();
        for(Player p : Bukkit.getOnlinePlayers()){
            if(var.command_spy.contains(p.getUniqueId())) {
                p.sendMessage(var.Prefix() + " §c§lCommandspy: §e§l" + ply.getName() + ": §a§o" + cmd);
            }
        }
    }
}
