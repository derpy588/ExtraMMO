package me.derpy.extrammo.Stats;

import me.derpy.extrammo.Main;
import org.bukkit.entity.Player;

import java.util.HashMap;

public class StatsSystem {
    public HashMap<Player, HashMap<String, Integer>> playersStats;

    public void init(Main plugin) {
        plugin.sql.execute("CREATE TABLE IF NOT EXISTS stats (uuid STRING, strength INT, health INT, regeneration INT, luck INT, wisdom INT, defense INT);");
    }

    public HashMap PlayerJoin(Player player) {
        HashMap<String, Integer> data = new HashMap<String, Integer>();
        data.put("Strength", 100);
        data.put("Health", 100);
        data.put("Regeneration", 100);
        data.put("Luck", 100);
        data.put("Wisdom", 100);
        data.put("Defense", 100);
        playersStats.put(player, data);
        return data;
    }
    public void PlayerLeave(Player player) {
        playersStats.remove(player);
    }

}
