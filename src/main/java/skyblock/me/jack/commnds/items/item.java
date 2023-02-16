package skyblock.me.jack.commnds.items;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class item {
    public static ItemStack getSenior_sword(){
        ItemStack item = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta ore = item.getItemMeta();
        ore.setDisplayName("§8[§a⚔§r§8] §3§lSenior Kard");
        item.setItemMeta(ore);
        ArrayList<String> sen_lore = new ArrayList<String>();
        sen_lore.add("");
        sen_lore.add("§a§lJOBB KATTINTÁS:");
        sen_lore.add("");
        sen_lore.add("    §f» §eSebzés §c25§! §4❤");
        sen_lore.add("    §f» §eMobok ölésekor 2x annyi xp-t kapsz");
        sen_lore.add("");
        sen_lore.add("§a§lBAL KATTINTÁS:");
        sen_lore.add(" ");
        sen_lore.add("     §f» §e6x6 Területen lévő szörnyek 15 §4❤ §esebzést kapnak.");
        ore.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        ore.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        ore.setLore(sen_lore);
        item.setItemMeta(ore);
        item.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 25);
        item.addUnsafeEnchantment(Enchantment.DIG_SPEED, 10);
        return item;
    }

    public static ItemStack getlegend_miner(){
        ItemStack item = new ItemStack(Material.NETHERITE_PICKAXE);
        ItemMeta ore = item.getItemMeta();
        ore.setDisplayName("§8[§a§l⛏§r§8]"+net.md_5.bungee.api.ChatColor.of("#5ac200")+ " §lLegend Miner");
        item.setItemMeta(ore);
        ArrayList<String> sen_lore = new ArrayList<String>();
        sen_lore.add("");
        sen_lore.add("§8 - §e§lSzerncse: V");
        sen_lore.add("");
        sen_lore.add("§8 - §e§lHatékonyság: X");
        sen_lore.add("");
        sen_lore.add("§8 - §e§lTörhetetlenség: XI");
        sen_lore.add("");
        sen_lore.add("§8 - §e§lÖnjaítás: -");
        sen_lore.add("");
        ore.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        ore.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        ore.setLore(sen_lore);
        item.setItemMeta(ore);
        item.addUnsafeEnchantment(Enchantment.DIG_SPEED, 10);
        item.addUnsafeEnchantment(Enchantment.DURABILITY, 11);
        item.addUnsafeEnchantment(Enchantment.LUCK, 5);

        return item;
    }
    public static ItemStack get_speed_hoe(){
        ItemStack item = new ItemStack(Material.NETHERITE_HOE);
        ItemMeta ore = item.getItemMeta();
        ore.setDisplayName("§cNAGY arató kapa");
        item.setItemMeta(ore);
        ArrayList<String> sen_lore = new ArrayList<String>();
        sen_lore.add("");
        ore.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        ore.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        ore.setLore(sen_lore);
        item.setItemMeta(ore);
    item.addUnsafeEnchantment(Enchantment.MENDING, 1);
        return item;
    }
    public static ItemStack get_carrot_farm(){
        ItemStack item = new ItemStack(Material.CARROT);
        ItemMeta ore = item.getItemMeta();
        ore.setDisplayName("§6§lRépa Farm §7§o(Jobb kattintás)");
        item.setItemMeta(ore);
        ArrayList<String> sen_lore = new ArrayList<String>();
        sen_lore.add("");
        sen_lore.add("§7 - §6§lRépa Farm:");
        sen_lore.add("§7 - §aKészít egy 9x9-es Répa Farmot. §7§o(Az ábrán is látható)");
        sen_lore.add("§7 - §c 1DB §4Csak egyszer használható.");
        sen_lore.add("");
        sen_lore.add("                 §a■  ■  ■  ■  ■  ■  ■  ■  ■");
        sen_lore.add("                 §a■  ■  ■  ■  ■  ■  ■  ■  ■");
        sen_lore.add("                 §a■  ■  ■  ■  ■  ■  ■  ■  ■");
        sen_lore.add("                 §a■  ■  ■  ■  ■  ■  ■  ■  ■");
        sen_lore.add("                 §a■  ■  ■  ■  §b■  §a■  ■  ■  ■");
        sen_lore.add("                 §a■  ■  ■  ■  ■  ■  ■  ■  ■");
        sen_lore.add("                 §a■  ■  ■  ■  ■  ■  ■  ■  ■");
        sen_lore.add("                 §a■  ■  ■  ■  ■  ■  ■  ■  ■");
        sen_lore.add("                 §a■  ■  ■  ■  ■  ■  ■  ■  ■");
        sen_lore.add("");


        ore.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        ore.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        ore.setLore(sen_lore);
        item.setItemMeta(ore);
        item.addUnsafeEnchantment(Enchantment.MENDING, 5);

        return item;
    }
    public static ItemStack get_shade_bow(){
        ItemStack item = new ItemStack(Material.BOW);
        ItemMeta ore = item.getItemMeta();
        ore.setDisplayName("§8§lShade Bow");
        item.setItemMeta(ore);
        ArrayList<String> sen_lore = new ArrayList<String>();
        sen_lore.add("");
        ore.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        ore.setLore(sen_lore);
        item.setItemMeta(ore);
        item.addUnsafeEnchantment(Enchantment.ARROW_DAMAGE, 22);
        return item;
    }
}
