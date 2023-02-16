package skyblock.me.jack;

import org.bukkit.Bukkit;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;
import skyblock.me.jack.Database.mysql;
import skyblock.me.jack.commnds.*;
import skyblock.me.jack.commnds.items.item_listener;
import skyblock.me.jack.commnds.tab.is_items_tab;
import skyblock.me.jack.commnds.tab.is_player_tab;
import skyblock.me.jack.mute.mute;
import skyblock.me.jack.mute.mute_cmd;
import skyblock.me.jack.mute.mute_listner;
import skyblock.me.jack.player_menu.Event;
import skyblock.me.jack.player_menu.menu;
import skyblock.me.jack.variables.var;

import java.io.File;
import java.io.IOException;


public final class Skyblock extends JavaPlugin implements Listener {

    public static File file;
    public static FileConfiguration customFile;

    @Override
    public void onEnable() {
        // Plugin startup logic
       /* mana.load();*/
        getServer().getPluginManager().registerEvents(new Event(), this);
        getServer().getPluginManager().registerEvents(new skyblock.me.jack.Level.Event(), this);
        getServer().getPluginManager().registerEvents(this, this);
        getServer().getPluginManager().registerEvents(new item_listener(), this);
        getServer().getPluginManager().registerEvents(new mute_listner(), this);
        getServer().getPluginManager().registerEvents(new commandspy_listener(), this);
        getServer().getPluginManager().registerEvents(new island_protection(), this);
        getServer().getPluginCommand("plugin").setExecutor(new pluginhider());
        getServer().getPluginCommand("is-player").setExecutor(new is_player());
        getServer().getPluginCommand("is-social").setExecutor(new is_social());
        getServer().getPluginCommand("is-player").setTabCompleter(new is_player_tab());
        getServer().getPluginCommand("credit").setExecutor(new credit());
        getServer().getPluginCommand("is-items").setExecutor(new is_items());
        getServer().getPluginCommand("mute").setExecutor(new mute_cmd());
        getServer().getPluginCommand("commandspy").setExecutor(new commandspy());
        getServer().getPluginCommand("is-items").setTabCompleter(new is_items_tab());
        getServer().getPluginCommand("island").setExecutor(new island());

        mute.runnableRunner();
        saveDefaultConfig();
        Bukkit.getLogger().info(var.Prefix()+" Tesing database.....");
        if(mysql.getConnection() != null){
            Bukkit.getLogger().info(var.Prefix()+" §aDatabase works.");

        } else {
            Bukkit.getLogger().info(var.Prefix()+" §cDatabase fail to connect");
        }
        Bukkit.getLogger().info(var.Prefix()+" §bPlugin loading...");
        for(Player p : Bukkit.getOnlinePlayers()){
            menu.add(p);
        }
        createIslandDataStroage();


    }
    public static YamlConfiguration  Islands;
    public void createIslandDataStroage() {

        file = new File(this.getDataFolder(),   "islands.yml");

        if (!file.exists()) {
            try {
                file.createNewFile();

            } catch (IOException e) {
                e.printStackTrace();
            }
            customFile = YamlConfiguration.loadConfiguration(file);
        } else {
             Islands = new YamlConfiguration();
            try {
                Islands.load(file);

            } catch (IOException | InvalidConfigurationException e) {
                e.printStackTrace();
            }

        }
        if(file.exists()){
            if(!Skyblock.Islands.contains("Island_world")){
                Islands.set("Island_world", "islands");
                Islands.set("next-free-pos.X", 0);
                Islands.set("next-free-pos.Y", 50);
                Islands.set("next-free-pos.Z", 0);
                save();
            }
        }
    }
    public static void save() {
        try {
            Islands.save(file);
        } catch (IOException e) {
           e.printStackTrace();
        }
    }
    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
    @EventHandler
    public void a(PlayerJoinEvent e){
        mysql.register(e.getPlayer());

    }
    @EventHandler
    public void welcome(PlayerJoinEvent e){
         e.getPlayer().sendMessage(var.Prefix()+" §eSzia §a"+e.getPlayer().getName()+" §e! §eÜdvözöllek a szerveren!");
    }



}
