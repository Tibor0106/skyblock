package skyblock.me.jack.variables;


import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;
import skyblock.me.jack.Database.mysql;
import skyblock.me.jack.Skyblock;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.UUID;

public class var {
    static Plugin plugin = skyblock.me.jack.Skyblock.getPlugin(skyblock.me.jack.Skyblock.class);
    public static String prefix = plugin.getConfig().getString("prefix").replace("&", "§");

    public static String Prefix() {
        return prefix;
    }

    public static int getLevel(OfflinePlayer p) {
        long coin_amount = 0;
        Connection connection = mysql.getConnection();
        try {

            String q1 = "SELECT * FROM level WHERE uuid='" + p.getUniqueId() + "';";
            PreparedStatement stmt = connection.prepareStatement(q1);
            ResultSet rs = stmt.executeQuery(q1);
            if (rs.next()) {
                String name = rs.getString("uuid");
                coin_amount = rs.getInt("level");


            } else {
                return -1;
            }
        } catch (SQLException s) {
        }
        return Math.toIntExact(coin_amount);
    }

    public static int getmost_xp(OfflinePlayer p) {
        long most_xp = 0;
        Connection connection = mysql.getConnection();
        try {

            String q1 = "SELECT * FROM level WHERE uuid='" + p.getUniqueId() + "';";
            PreparedStatement stmt = connection.prepareStatement(q1);
            ResultSet rs = stmt.executeQuery(q1);
            if (rs.next()) {
                String name = rs.getString("uuid");
                most_xp = rs.getInt("most_xp");


            } else {
                return -1;
            }
        } catch (SQLException s) {
        }
        return Math.toIntExact(most_xp);
    }

    public static int get_xp(OfflinePlayer p) {
        long xp = 0;
        Connection connection = mysql.getConnection();
        try {

            String q1 = "SELECT * FROM level WHERE uuid='" + p.getUniqueId() + "';";
            PreparedStatement stmt = connection.prepareStatement(q1);
            ResultSet rs = stmt.executeQuery(q1);
            if (rs.next()) {
                String name = rs.getString("uuid");
                xp = rs.getInt("xp");


            } else {
                return -1;
            }
        } catch (SQLException s) {
        }
        return Math.toIntExact(xp);
    }

    public static void setLevel(OfflinePlayer p, int c) {

        Connection connection = mysql.getConnection();
        int level = getLevel(p);
        int e = c * 420;
        int b = e * c - e;

        String sql_1 = "UPDATE level SET level=" + c + ", xp=" + b + ", most_xp=" + e + "  WHERE uuid='" + p.getUniqueId() + "';";
        PreparedStatement stmt;

        try {

            stmt = connection.prepareStatement(sql_1);
            stmt.executeUpdate();

        } catch (SQLException e1) {


            e1.printStackTrace();
        }

    }

    public static void setmost_xp(OfflinePlayer p, int add) {


        Connection connection = mysql.getConnection();
        long mx = getmost_xp(p) - add;


        String sql_1 = "UPDATE level SET most_xp=" + mx + "  WHERE uuid='" + p.getUniqueId() + "';";
        PreparedStatement stmt;

        try {

            stmt = connection.prepareStatement(sql_1);
            stmt.executeUpdate();

        } catch (SQLException e1) {


            e1.printStackTrace();
        }
        if (getmost_xp(p) <= 0) {
            setLevel(p, getLevel(p) + 1);
            p.getPlayer().sendMessage("" + prefix + " §eSzintet léptél! Mostantól " + getLevel(p) + " vagy.");

        }
    }

    public static void setCredit(OfflinePlayer p, int c) {

        Connection connection = mysql.getConnection();
        String sql_1 = "UPDATE credit SET credit=" + c + " WHERE uuid='" + p.getUniqueId() + "';";
        PreparedStatement stmt;

        try {

            stmt = connection.prepareStatement(sql_1);
            stmt.executeUpdate();

        } catch (SQLException e1) {


            e1.printStackTrace();
        }

    }

    public static int getCredit(OfflinePlayer p) {
        int credit = 0;
        Connection connection = mysql.getConnection();
        try {

            String q1 = "SELECT * FROM credit WHERE uuid='" + p.getUniqueId() + "';";
            PreparedStatement stmt = connection.prepareStatement(q1);
            ResultSet rs = stmt.executeQuery(q1);
            if (rs.next()) {
                String name = rs.getString("uuid");
                credit = rs.getInt("credit");


            } else {
                return -1;
            }
        } catch (SQLException s) {
        }
        return credit;
    }

    public static void mute_history(String p, CommandSender sender) {
        int credit = 0;

        Connection connection = mysql.getConnection();
        Player user = (Player) sender;
        try {

            String q1 = "SELECT * FROM mute_log WHERE player='" + p + "';";
            PreparedStatement stmt = connection.prepareStatement(q1);
            ResultSet rs = stmt.executeQuery(q1);
            String staff;
            String player = null;
            String time;
            String date;
            ArrayList<String> lore = new ArrayList<>();
            Inventory inv = Bukkit.createInventory(null, 54, "§cMute history");
            ItemStack item = new ItemStack(Material.PLAYER_HEAD);
            ItemMeta meta = item.getItemMeta();
            int count = 0;
            while (rs.next()) {
                if (count > 44) {
                    break;
                }
                staff = rs.getString("staff");
                player = rs.getString("player");
                time = rs.getString("time");
                date = rs.getString("date");
                lore.add("§7§l§m§o--------------------------------------");
                lore.add(" §7| §6§lStaff: §e§l" + staff);
                lore.add(" §7| §6§lIdő: §e§l" + time + "s");
                lore.add(" §7| §6§lDátum: §e§l" + date);
                lore.add("§7§l§m§o--------------------------------------");
                meta.setDisplayName("§aJátékos §f» §c" + player);
                meta.setLore(lore);
                item.setItemMeta(meta);
                inv.setItem(count, item);
                count++;
                lore.clear();
            }

            user.openInventory(inv);

        } catch (SQLException s) {
        }

    }

    public static String sec_to_time_format(int t) {
        int hours = t / 3600;
        int minutes = (t % 3600) / 60;
        int seconds = t % 60;

        String end = String.format("%02d:%02d:%02d", hours, minutes, seconds);
        return end;

    }

    public static ArrayList<UUID> command_spy = new ArrayList<>();


}



