package me.derpy.extrammo;

import me.derpy.extrammo.Listeners.PlayerJoin;
import me.derpy.extrammo.Stats.StatsSystem;
import org.bukkit.plugin.java.JavaPlugin;
import redempt.redlib.sql.SQLHelper;

public final class Main extends JavaPlugin {
    //Stuff to do
    //TODO: Skills/Stats System
    //TODO: Item Builder
    //TODO: Crafting Recipe Builder
    //TODO: Mob Level System

    public SQLHelper sql;
    public StatsSystem statsSystem;

    @Override
    public void onEnable() {
        sql = new DatabaseManager().init(this);
        statsSystem = new StatsSystem();
        statsSystem.init(this);
        this.getServer().getPluginManager().registerEvents(new PlayerJoin(this), this);

    }

    @Override
    public void onDisable() {
    }
}
