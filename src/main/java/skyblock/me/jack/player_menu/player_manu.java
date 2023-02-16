package skyblock.me.jack.player_menu;

import org.bukkit.*;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import skyblock.me.jack.variables.var;

import java.util.ArrayList;

public class player_manu {
    public static void open(Player p){
        Inventory inv = Bukkit.createInventory(null, 27, "§aJátékos menü");
        for (int i = 0; i <9 ; i++){
            inv.setItem(i, new ItemStack(Material.BLACK_STAINED_GLASS_PANE));

        }
        for (int i = 18; i <27 ; i++){
            inv.setItem(i, new ItemStack(Material.BLACK_STAINED_GLASS_PANE));

        }
        inv.setItem(9, new ItemStack(Material.BLACK_STAINED_GLASS_PANE));
        inv.setItem(17, new ItemStack(Material.BLACK_STAINED_GLASS_PANE));
        ItemStack profile = new ItemStack(Material.ENCHANTED_BOOK);
        ItemMeta pitem = profile.getItemMeta();
        pitem.setDisplayName("§e§l⌂ §aProfil");
        ArrayList<String> lore = new ArrayList<>();
        lore.add("§8- §fJátékos§e » §6" +p.getName());
        lore.add("§8- §fCredit§e » §6" + var.getCredit(p));
        lore.add("§8- §fJátékmód§e » §6" +p.getGameMode().toString().toLowerCase());
        lore.add("§8- §fSzint§e » §6" + var.getLevel(p));
        lore.add("§8- §fXp§e » §6" + var.get_xp(p));
        lore.add("§8- §fA következő szinthez§e » §6" + var.getmost_xp(p)+ "§f kell még.");
        pitem.setLore(lore);
        pitem.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        profile.setItemMeta(pitem);
        profile.addUnsafeEnchantment(Enchantment.MENDING, 1);
        inv.setItem(10, profile);
        //news
        ItemStack ni = new ItemStack(Material.FIREWORK_ROCKET);
        ItemMeta nimeta = ni.getItemMeta();
        nimeta.setDisplayName("§a✕ §bNapi újdonságok / hírek");
        ArrayList<String> news = new ArrayList<>();
        nimeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        ni.setItemMeta(nimeta);
        ni.addUnsafeEnchantment(Enchantment.MENDING, 1);
        inv.setItem(13, ni);

        //set news


        p.openInventory(inv);


    }
}
