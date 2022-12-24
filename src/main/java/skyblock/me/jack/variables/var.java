package skyblock.me.jack.variables;

import org.bukkit.OfflinePlayer;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import skyblock.me.jack.Database.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

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

            String q1 = "SELECT * FROM level WHERE uuid='" + p.getUniqueId()+ "';";
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

            String q1 = "SELECT * FROM level WHERE uuid='" + p.getUniqueId()+ "';";
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

            String q1 = "SELECT * FROM level WHERE uuid='" + p.getUniqueId()+ "';";
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
        int e = c*420;
        int b = e*c-e;


        String sql_1 = "UPDATE level SET level="+c+", xp="+b+", most_xp="+e+"  WHERE uuid='"+p.getUniqueId()+"';";
        PreparedStatement stmt;

        try {

            stmt = connection.prepareStatement(sql_1);
            stmt.executeUpdate();

        } catch (SQLException e1) {


            e1.printStackTrace();
        }

    }
    public static void setmost_xp( OfflinePlayer p, int add) {


        Connection connection = mysql.getConnection();
        long mx = getmost_xp(p)-add;


        String sql_1 = "UPDATE level SET most_xp="+mx+"  WHERE uuid='"+p.getUniqueId()+"';";
        PreparedStatement stmt;

        try {

            stmt = connection.prepareStatement(sql_1);
            stmt.executeUpdate();

        } catch (SQLException e1) {


            e1.printStackTrace();
        }
        if(getmost_xp(p) <= 0){
            setLevel(p, getLevel(p)+1);
            p.getPlayer().sendMessage(""+prefix+" §eSzintet léptél! Mostantól "+getLevel(p)+" vagy.");

        }
    }
    public static void setCredit(OfflinePlayer p, int c) {

        Connection connection = mysql.getConnection();
        String sql_1 = "UPDATE credit SET credit="+c+" WHERE uuid='"+p.getUniqueId()+"';";
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

            String q1 = "SELECT * FROM credit WHERE uuid='" + p.getUniqueId()+ "';";
            PreparedStatement stmt = connection.prepareStatement(q1);
            ResultSet rs = stmt.executeQuery(q1);
            if (rs.next()) {
                String name = rs.getString("uuid");
                credit= rs.getInt("credit");


            } else {
                return -1;
            }
        } catch (SQLException s) {
        }
        return credit;
    }


}
