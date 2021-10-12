package me.derpy.extrammo.Stats;

import me.derpy.extrammo.Main;
import org.bukkit.entity.Player;

import java.util.HashMap;

public class StatsSystem {
    public HashMap<Player, HashMap<String, Integer>> playerStats;

    public void init(Main plugin) {
        plugin.sql.execute("CREATE TABLE IF NOT EXISTS stats ();");
    }

}
