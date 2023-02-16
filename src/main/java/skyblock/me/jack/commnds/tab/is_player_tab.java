package skyblock.me.jack.commnds.tab;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.ArrayList;
import java.util.List;

public class is_player_tab implements TabCompleter {
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        if (args.length == 1) {
            List<String> cmds = new ArrayList<>();
            List<String> comp = new ArrayList<>();
            comp.add("info");
            comp.add("credit-give");
            comp.add("credit-set");
            comp.add("level-set");
            comp.add("level-give");
            comp.add("mute-history");

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
