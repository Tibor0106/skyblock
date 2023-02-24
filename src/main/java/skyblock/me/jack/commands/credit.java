package skyblock.me.jack.commands;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import skyblock.me.jack.variables.var;

public class credit implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(args.length == 0){
            Player p = (Player) sender;
            sender.sendMessage(var.Prefix()+" §eEgyenleged §f"+var.getCredit(p)+" §ecredit.");


        } else if (args.length == 1) {
            OfflinePlayer p = Bukkit.getOfflinePlayer(args[0]);
            if(var.getCredit(p) == -1){
                sender.sendMessage(var.Prefix()+" §cNincs ilyen játékos.");
                return true;
            }
            sender.sendMessage(var.Prefix()+" §f"+p.getName()+" §e egyenlege §f"+var.getCredit(p)+" §ecredit.");

        } else {
            sender.sendMessage(var.Prefix()+" §eHelyes használat: /credit <játékos>");
        }
        return false;
    }
}
