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
        ore.setDisplayName("§8[§a§l⚔§r§8]"+net.md_5.bungee.api.ChatColor.of("#00B9FF")+ " §lSenior Kard ");
        item.setItemMeta(ore);
        ArrayList<String> sen_lore = new ArrayList<String>();
        sen_lore.add("");
        sen_lore.add("§a§lJOBB KATTINTÁS:");
        sen_lore.add("");
        sen_lore.add("    §f» §eSebzés §c20§! §4❤");
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
}
