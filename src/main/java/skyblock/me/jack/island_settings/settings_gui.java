package skyblock.me.jack.island_settings;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.checkerframework.checker.units.qual.A;
import skyblock.me.jack.Skyblock;

import java.util.ArrayList;

public class settings_gui {

    private static String guiTitle = "§8|=» §aSziget beállítások §8«=|";
    public static void OpenIslandSettings(Player p){
        Inventory settings = Bukkit.createInventory(null, 27, guiTitle);


        for (int i = 0; i < 9; i++){
            settings.setItem(i, new ItemStack(Material.LIGHT_BLUE_STAINED_GLASS_PANE));
        }
        for (int i = 18; i < 27; i++){
            settings.setItem(i, new ItemStack(Material.LIGHT_BLUE_STAINED_GLASS_PANE));
        }
        settings.setItem(9, new ItemStack(Material.LIGHT_BLUE_STAINED_GLASS_PANE));
        settings.setItem(17, new ItemStack(Material.LIGHT_BLUE_STAINED_GLASS_PANE));

        settings.setItem(11, IslandSettingsKillMobs(p));
        p.openInventory(settings);






    }
    public static  String GetSettingsGuiTitle(){
        return guiTitle;
    }
    public static ItemStack IslandSettingsKillMobs(Player p){

        ItemStack item = new ItemStack(Material.ZOMBIE_HEAD);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§e§lMobok sebzése");
        ArrayList<String> lore = new ArrayList<>();
        lore.add("");

        if(settings.IslandSettingsKillMobsOtherPlayer(p)){
            lore.add("§a§lEngedélyezve");

        } else {
            lore.add("§c§lTíltva");
        }
        lore.add(" ");
        lore.add("§7§oA sziget tagok is sebezheti a mobokat.");
        meta.setLore(lore);
        item.setItemMeta(meta);


        return  item;
    }
}
