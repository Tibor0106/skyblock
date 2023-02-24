package skyblock.me.jack.commands.tab;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.ArrayList;
import java.util.List;

public class island_tab implements TabCompleter {
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        if (args.length == 1) {
            List<String> cmds = new ArrayList<>();
            List<String> comp = new ArrayList<>();
            comp.add("home");
            comp.add("create");
            comp.add("settings");
            comp.add("leave");
            comp.add("spawn");
            comp.add("h");

            for (String s : comp) {
                if (s.toLowerCase().startsWith(args[0].toLowerCase())) {
                    cmds.add(s);

                }


            }
            return cmds;
        }


        return null;
    }

}
