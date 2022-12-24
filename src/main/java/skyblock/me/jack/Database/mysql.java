package skyblock.me.jack.Database;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import skyblock.me.jack.variables.var;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class mysql {
    private Connection connection;


    public static Connection getConnection(){
        Plugin plugin = skyblock.me.jack.Skyblock.getPlugin(skyblock.me.jack.Skyblock.class);
        final String username = plugin.getConfig().getString("db_username");
        final String password= plugin.getConfig().getString("db_password");
        final String db = plugin.getConfig().getString("db");
        final String address = plugin.getConfig().getString("db_address");
        final Integer port = plugin.getConfig().getInt("db_port");


        final String url = "jdbc:mysql://"+address+":"+port+"/"+db+"";
        Connection connection = null;
        try {

            connection = DriverManager.getConnection(url, username, password);


        } catch (SQLException eq) {
            eq.printStackTrace();

        }

        return connection;
    }
    public static void register(Player p) {
        Connection connection = mysql.getConnection();
        try {

            String q1 = "SELECT * FROM level WHERE uuid='" + p.getUniqueId() + "';";
            PreparedStatement stmt = connection.prepareStatement(q1);
            ResultSet rs = stmt.executeQuery(q1);
            String q2 = "SELECT * FROM level WHERE uuid='" + p.getUniqueId() + "';";
            PreparedStatement stmt1 = connection.prepareStatement(q2);
            ResultSet rs1 = stmt1.executeQuery(q2);
            if (rs.next() && rs1.next()) {
                return;
            } else {

                String Query = "INSERT INTO level (uuid, level, most_xp, xp) VALUES (?, ?, ?, ?)";
                PreparedStatement prStmt = mysql.getConnection().prepareStatement(Query);
                prStmt.setString(1, p.getUniqueId().toString());
                prStmt.setInt(2, 1);
                prStmt.setInt(3, 430);
                prStmt.setInt(4, 0);
                prStmt.execute();

                Query = "INSERT INTO credit (uuid, credit) VALUES (?, ?)";
                prStmt = mysql.getConnection().prepareStatement(Query);
                prStmt.setString(1, p.getUniqueId().toString());
                prStmt.setInt(2, 0);
                prStmt.execute();
                p.sendMessage(var.Prefix()+" §cSikeresen regisztáltunk az adtabázisba.");

            }
        } catch (SQLException s) {
        }
    }
    public static void mute_log(String staff, String player, int time){
        try {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
            LocalDateTime now = LocalDateTime.now();
            String Query = "INSERT INTO mute_log (staff, player, time, date) VALUES (?, ?, ?, ?)";
            PreparedStatement prStmt = mysql.getConnection().prepareStatement(Query);
            prStmt.setString(1, staff);
            prStmt.setString(2, player);
            prStmt.setInt(3, time);
            prStmt.setString(4, dtf.format(now));
            prStmt.execute();

        }catch (SQLException b){
            b.printStackTrace();
        }

    }




}
