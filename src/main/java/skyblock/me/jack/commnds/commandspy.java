package skyblock.me.jack.commnds;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import skyblock.me.jack.variables.var;

public class commandspy implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(args.length != 0){
            sender.sendMessage(var.Prefix()+" §cHelytelen használat. §aHelyes használat: §e/commandspy");
            return true;
        }
        Player p = (Player) sender;
        if(var.command_spy.contains(p.getUniqueId())){
            var.command_spy.remove(p.getUniqueId());
            p.sendMessage(var.Prefix()+" §cCommandspy letíltva!");
        } else {
            var.command_spy.add(p.getUniqueId());
            p.sendMessage(var.Prefix()+" §cCommandspy §aengedélyezve!");
        }
        return false;
    }
}
