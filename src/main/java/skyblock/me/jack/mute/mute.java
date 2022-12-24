package skyblock.me.jack.mute;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import skyblock.me.jack.variables.var;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

public class mute {
    public static HashMap<UUID, Integer> mutecd = new HashMap<UUID, Integer>();
    public static ArrayList<UUID> muted = new ArrayList<UUID>();

    public static HashMap<UUID, Integer> getMutecd() {
        return mutecd;
    }
    public static void runnableRunner() {
        new BukkitRunnable() {

            @Override
            public void run() {

                if (mutecd.isEmpty()) {
                    return;
                }

                for (UUID uuid : mutecd.keySet()) {
                    int timeleft = mutecd.get(uuid);

                    if (timeleft <= 0) {
                        mutecd.remove(uuid);
                        try{
                            Player p = Bukkit.getPlayer(uuid);
                            p.sendMessage(var.Prefix()+ " §aÚjra tudsz írni.");
                        }catch (NullPointerException v){

                        }

                    } else {
                        mutecd.put(uuid, timeleft - 1);
                    }
                }

            }

        }.runTaskTimer(skyblock.me.jack.Skyblock.getPlugin(skyblock.me.jack.Skyblock.class), 0, 20);
    }
}
