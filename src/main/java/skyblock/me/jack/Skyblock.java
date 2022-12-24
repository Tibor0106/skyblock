package skyblock.me.jack;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;
import skyblock.me.jack.Database.mysql;
import skyblock.me.jack.commnds.credit;
import skyblock.me.jack.commnds.is_items;
import skyblock.me.jack.commnds.is_player;
import skyblock.me.jack.commnds.items.item_listener;
import skyblock.me.jack.commnds.tab.is_items_tab;
import skyblock.me.jack.commnds.tab.is_player_tab;
import skyblock.me.jack.mute.mute;
import skyblock.me.jack.mute.mute_cmd;
import skyblock.me.jack.mute.mute_listner;
import skyblock.me.jack.player_menu.Event;
import skyblock.me.jack.player_menu.menu;
import skyblock.me.jack.variables.var;

public final class Skyblock extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getServer().getPluginManager().registerEvents(new Event(), this);
        getServer().getPluginManager().registerEvents(new skyblock.me.jack.Level.Event(), this);
        getServer().getPluginManager().registerEvents(this, this);
        getServer().getPluginManager().registerEvents(new item_listener(), this);
        getServer().getPluginManager().registerEvents(new mute_listner(), this);
        getServer().getPluginCommand("plugin").setExecutor(new pluginhider());
        getServer().getPluginCommand("is-player").setExecutor(new is_player());
        getServer().getPluginCommand("is-player").setTabCompleter(new is_player_tab());
        getServer().getPluginCommand("credit").setExecutor(new credit());
        getServer().getPluginCommand("is-items").setExecutor(new is_items());
        getServer().getPluginCommand("mute").setExecutor(new mute_cmd());
        getServer().getPluginCommand("is-items").setTabCompleter(new is_items_tab());
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

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
    @EventHandler
    public void a(PlayerJoinEvent e){
        mysql.register(e.getPlayer());

    }

}
