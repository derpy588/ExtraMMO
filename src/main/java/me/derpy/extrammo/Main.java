package me.derpy.extrammo;

import org.bukkit.plugin.java.JavaPlugin;
import redempt.redlib.sql.SQLHelper;

public final class Main extends JavaPlugin {
    //Stuff to do
    //TODO: Skills/Stats System
    //TODO: Item Builder
    //TODO: Crafting Recipe Builder
    //TODO: Mob Level System

    public SQLHelper sql;

    @Override
    public void onEnable() {
        SQLHelper sql = new DatabaseManager().init(this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
