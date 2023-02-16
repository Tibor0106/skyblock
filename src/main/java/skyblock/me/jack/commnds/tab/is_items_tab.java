package skyblock.me.jack.commnds.tab;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.ArrayList;
import java.util.List;

public class is_items_tab implements TabCompleter {
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        if (args.length == 1) {
            List<String> cmds = new ArrayList<>();
            List<String> comp = new ArrayList<>();
            comp.add("give");
            comp.add("name-item");

            for (String s : comp) {
                if (s.toLowerCase().startsWith(args[0].toLowerCase())) {
                    cmds.add(s);

                }


            }
            return cmds;
        } else if (args.length == 2) {
            List<String> cmds = new ArrayList<>();
            List<String> comp = new ArrayList<>();
            comp.add("senior_sword");
            comp.add("legend_miner");
            comp.add("big_hoe");
            comp.add("carrot_farm");
            comp.add("shade_bow");

            for (String s : comp) {
                if (s.toLowerCase().startsWith(args[1].toLowerCase())) {
                    cmds.add(s);

                }


            }
            return cmds;
        }


        return null;
    }
}
