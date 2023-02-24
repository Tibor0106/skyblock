package skyblock.me.jack.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import skyblock.me.jack.variables.Islands;
import skyblock.me.jack.variables.var;

public class is_island implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(!(sender instanceof Player)){
            sender.sendMessage(var.Prefix()+" §cEzt a parancsot csak a játékban lehet használni!");
            return true;

        }
        if(args[0].equalsIgnoreCase("visit")){
            if(args.length != 2){
                sender.sendMessage(var.Prefix()+" §cHasználat: §e/is-island visit <playername>");
                return true;
            }
            Player p = (Player) sender;

            if(Islands.HasIsland(args[1].toString())){
                p.teleport(Islands.getPlayerIsland(args[1].toString()));

            } else {
                sender.sendMessage(var.Prefix()+" §cNincs ilyen játékos vagy nincs szigete!");
            }

        }
        return false;
    }
}
