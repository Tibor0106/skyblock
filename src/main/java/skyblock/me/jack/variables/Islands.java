package skyblock.me.jack.variables;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import skyblock.me.jack.Skyblock;



public class Islands {
    public static Location getPlayerIsland(String p){
        double x = Skyblock.Islands.getDouble("Islands."+p+".spawn.X");
        double y = Skyblock.Islands.getDouble("Islands."+p+".spawn.Y");
        double z = Skyblock.Islands.getDouble("Islands."+p+".spawn.Z");
        World world = Bukkit.getWorld(Skyblock.Islands.get("Island_world").toString());
        Location island = new Location(world, x ,y , z);
        island.add(0, 1 ,0);

        return island;
    }
    public static boolean HasIsland(String pname){

        if(Skyblock.Islands.contains("Islands."+pname)){
            return true;
        }
        return false;
    }
}
