package skyblock.me.jack.mana_system;

import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import skyblock.me.jack.variables.var;

import java.util.HashMap;
import java.util.UUID;

/*public class mana {
    public static HashMap<UUID, Integer> player_mana = new HashMap<>();
    public static void load(){
        mana m = new mana();
        for(Player p : Bukkit.getOnlinePlayers()){

            m.player_mana.put(p.getUniqueId(), 10);
        }


        Bukkit.getScheduler().runTaskTimer(skyblock.me.jack.Skyblock.getPlugin(skyblock.me.jack.Skyblock.class), new Runnable() {
            @Override
            public void run() {
                for (Player p : Bukkit.getOnlinePlayers()){
                    if(m.player_mana.get(p.getUniqueId()).intValue() < 20){
                        player_mana.put(p.getUniqueId(), getPlayer_mana(p)+2);
                    }
                    p.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent("§cMana: "+m.player_mana.get(p.getUniqueId()).intValue()));
                }
            }
        }, 20, 20);

    }

    public static int getPlayer_mana(Player p) {
        return player_mana.get(p.getUniqueId()).intValue();
    }
}*/
