package me.derpy.extrammo.Listeners;

import me.derpy.extrammo.Main;
import me.derpy.extrammo.Stats.StatsSystem;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoin implements Listener {

    public Main plugin;
    public void PlayerJoin(Main pl) {
        plugin = pl;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        plugin.statsSystem.getPlayerDataFromDatabase(plugin, event.getPlayer());
    }
}
