package me.derpy.extrammo.Stats;

import me.derpy.extrammo.Main;
import org.bukkit.entity.Player;
import redempt.redlib.sql.SQLHelper;

import java.util.HashMap;

public class StatsSystem {
    public HashMap<Player, HashMap<String, Integer>> playersStats;

    public void init(Main plugin) {
        plugin.sql.execute("CREATE TABLE IF NOT EXISTS Stats (uuid STRING, strength INT, health INT, regeneration INT, luck INT, wisdom INT, defense INT);");
    }

    public void getPlayerDataFromDatabase(Main plugin, Player player) {
        SQLHelper.Results result = plugin.sql.querySingleResult("SELECT * FROM Stats WHERE uuid=?;", player.getUniqueId().toString());
        result.forEach(r -> {
            String s = r.getString(1);
            plugin.getServer().broadcastMessage(s);
        });

    }

    public HashMap PlayerJoin(Main plugin, Player player) {
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
