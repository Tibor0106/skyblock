package skyblock.me.jack.player_menu;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class menu {
    public static void add(Player p ){
        ItemStack menu = new ItemStack(Material.NETHER_STAR);
        ItemMeta meta = menu.getItemMeta();
        meta.setDisplayName("§aJátékos menü");
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        menu.setItemMeta(meta);
        menu.addUnsafeEnchantment(Enchantment.MENDING, 1);
        p.getInventory().setItem(8, menu);


    }
}
