package skyblock.me.jack.island_settings;

import org.bukkit.entity.Player;
import skyblock.me.jack.Skyblock;

public class settings {
    public static Boolean IslandSettingsKillMobsOtherPlayer(Player p){

        return Skyblock.Islands.getBoolean("Islands."+p.getName()+".settings.kill_mobs_other_player");
    }
    public static void IslandSettingsKillMobsOtherPlayerSET(Player p,Boolean a){
        Skyblock.Islands.set("Islands."+p.getName()+".settings.kill_mobs_other_player", a);
    }
}
