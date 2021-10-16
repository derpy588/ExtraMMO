package me.derpy.extrammo.Stats;

import me.derpy.extrammo.Main;
import org.bukkit.entity.Player;
import redempt.redlib.sql.SQLCache;
import redempt.redlib.sql.SQLHelper;

import java.util.HashMap;
import java.util.Locale;

public class StatsSystem {
    //Stats
    public SQLCache strength;
    public SQLCache health;
    public SQLCache regeneration;
    public SQLCache luck;
    public SQLCache wisdom;
    public SQLCache toughness;

    //Skills
    public SQLCache farming;
    public SQLCache foraging;
    public SQLCache mining;
    public SQLCache fishing;
    public SQLCache excavation;
    public SQLCache archery;
    public SQLCache defense;
    public SQLCache fighting;
    public SQLCache endurance;
    public SQLCache agility;
    public SQLCache alchemy;
    public SQLCache enchanting;
    public SQLCache healing;
    public SQLCache forging;

    public void init(Main plugin) {
        //Stats
        plugin.sql.execute("CREATE TABLE IF NOT EXISTS Stats (uuid STRING PRIMARY KEY, strength INT, health INT, regeneration INT, luck INT, wisdom INT, toughness INT);");


        //Stats
        strength = plugin.sql.createCache("Stats", "strength", "uuid");
        health = plugin.sql.createCache("Stats", "health", "uuid");
        regeneration = plugin.sql.createCache("Stats", "regeneration", "uuid");
        luck = plugin.sql.createCache("Stats", "luck", "uuid");
        wisdom = plugin.sql.createCache("Stats", "wisdom", "uuid");
        toughness = plugin.sql.createCache("Stats", "toughness", "uuid");

        //Skills
        plugin.sql.execute("CREATE TABLE IF NOT EXISTS Skills (uuid STRING PRIMARY KEY, farming INT, foraging INT, mining INT, fishing INT, excavation INT, archery INT, defense INT, fighting INT, endurance INT, agility INT, alchemy INT, enchanting INT, healing INT, forging INT);");

        farming = plugin.sql.createCache("Skills", "farming", "uuid");
        foraging = plugin.sql.createCache("Skills", "foraging", "uuid");
        mining = plugin.sql.createCache("Skills", "mining", "uuid");
        fishing = plugin.sql.createCache("Skills", "fishing", "uuid");
        excavation = plugin.sql.createCache("Skills", "excavation", "uuid");
        archery = plugin.sql.createCache("Skills", "archery", "uuid");
        defense = plugin.sql.createCache("Skills", "defense", "uuid");
        fighting = plugin.sql.createCache("Skills", "fighting", "uuid");
        endurance = plugin.sql.createCache("Skills", "endurance", "uuid");
        agility = plugin.sql.createCache("Skills", "agility", "uuid");
        alchemy = plugin.sql.createCache("Skills", "alchemy", "uuid");
        enchanting = plugin.sql.createCache("Skills", "enchanting", "uuid");
        healing = plugin.sql.createCache("Skills", "healing", "uuid");
        forging = plugin.sql.createCache("Skills", "forging", "uuid");
    }

    //Stats
    public Integer calculatePlayerStat(Player player, String stat){
        return 100;
    }

    public HashMap getPlayerStats(Player player) {
        HashMap<String, Integer> data = new HashMap<String, Integer>();
        data.put("Strength", strength.select(player.getUniqueId().toString()));
        data.put("health", health.select(player.getUniqueId().toString()));
        data.put("regeneration", regeneration.select(player.getUniqueId().toString()));
        data.put("luck", luck.select(player.getUniqueId().toString()));
        data.put("wisdom", wisdom.select(player.getUniqueId().toString()));
        data.put("defense", toughness.select(player.getUniqueId().toString()));
        if (data.get("Strength") == null){
            setPlayerStrength(player, calculatePlayerStat(player, "Strength"));
            setPlayerHealth(player, calculatePlayerStat(player, "Health"));
            setPlayerRegeneration(player, calculatePlayerStat(player, "Regeneration"));
            setPlayerLuck(player, calculatePlayerStat(player, "Luck"));
            setPlayerWisdom(player, calculatePlayerStat(player, "Wisdom"));
            setPlayerToughness(player, calculatePlayerStat(player, "Toughness"));

            data.put("Strength", strength.select(player.getUniqueId().toString()));
            data.put("health", health.select(player.getUniqueId().toString()));
            data.put("regeneration", regeneration.select(player.getUniqueId().toString()));
            data.put("luck", luck.select(player.getUniqueId().toString()));
            data.put("wisdom", wisdom.select(player.getUniqueId().toString()));
            data.put("defense", toughness.select(player.getUniqueId().toString()));
        }
        return data;
    }
    public void setPlayerStrength(Player player, Integer data) {
        strength.update(data, player.getUniqueId().toString());
    }
    public void setPlayerHealth(Player player, Integer data) {
        health.update(data, player.getUniqueId().toString());
    }
    public void setPlayerRegeneration(Player player, Integer data) {
        regeneration.update(data, player.getUniqueId().toString());
    }
    public void setPlayerLuck(Player player, Integer data) {
        luck.update(data, player.getUniqueId().toString());
    }
    public void setPlayerWisdom(Player player, Integer data) {
        wisdom.update(data, player.getUniqueId().toString());
    }
    public void setPlayerToughness(Player player, Integer data) {
        toughness.update(data, player.getUniqueId().toString());
    }

    //Skills
    public void setPlayerSkill(Player player, String skill, Integer value){
        switch (skill.toLowerCase()){
            case "farming":
                farming.update(value, player.getUniqueId().toString());
                break;
            case "foraging":
                foraging.update(value, player.getUniqueId().toString());
                break;
            case "mining":
                mining.update(value, player.getUniqueId().toString());
                break;
            case "fishing":
                fishing.update(value, player.getUniqueId().toString());
                break;
            case "excavation":
                excavation.update(value, player.getUniqueId().toString());
                break;
            case "archery":
                archery.update(value, player.getUniqueId().toString());
                break;
            case "defense":
                defense.update(value, player.getUniqueId().toString());
                break;
            case "fighting":
                fighting.update(value, player.getUniqueId().toString());
                break;
            case "endurance":
                endurance.update(value, player.getUniqueId().toString());
                break;
            case "agility":
                agility.update(value, player.getUniqueId().toString());
                break;
            case "alchemy":
                alchemy.update(value, player.getUniqueId().toString());
                break;
            case "enchanting":
                enchanting.update(value, player.getUniqueId().toString());
                break;
            case "healing":
                healing.update(value, player.getUniqueId().toString());
                break;
            case "forging":
                forging.update(value, player.getUniqueId().toString());
                break;
        }
    }

    public HashMap getPlayerSkills(Player player){
        HashMap<String, Integer> data = new HashMap<String, Integer>();
        data.put("farming", farming.select(player.getUniqueId().toString()));
        data.put("foraging", foraging.select(player.getUniqueId().toString()));
        data.put("mining", mining.select(player.getUniqueId().toString()));
        data.put("fishing", fishing.select(player.getUniqueId().toString()));
        data.put("excavation", excavation.select(player.getUniqueId().toString()));
        data.put("archery", archery.select(player.getUniqueId().toString()));
        data.put("defense", defense.select(player.getUniqueId().toString()));
        data.put("fighting", fighting.select(player.getUniqueId().toString()));
        data.put("endurance", endurance.select(player.getUniqueId().toString()));
        data.put("agility", agility.select(player.getUniqueId().toString()));
        data.put("alchemy", alchemy.select(player.getUniqueId().toString()));
        data.put("enchanting", enchanting.select(player.getUniqueId().toString()));
        data.put("healing", healing.select(player.getUniqueId().toString()));
        data.put("forging", forging.select(player.getUniqueId().toString()));

        if (data.get("farming") == null){
            setPlayerSkill(player, "farming", 0);
            setPlayerSkill(player, "foraging", 0);
            setPlayerSkill(player, "mining", 0);
            setPlayerSkill(player, "fishing", 0);
            setPlayerSkill(player, "excavation", 0);
            setPlayerSkill(player, "archery", 0);
            setPlayerSkill(player, "defense", 0);
            setPlayerSkill(player, "fighting", 0);
            setPlayerSkill(player, "endurance", 0);
            setPlayerSkill(player, "agility", 0);
            setPlayerSkill(player, "alchemy", 0);
            setPlayerSkill(player, "enchanting", 0);
            setPlayerSkill(player, "healing", 0);
            setPlayerSkill(player, "forging", 0);

            data.put("farming", farming.select(player.getUniqueId().toString()));
            data.put("foraging", foraging.select(player.getUniqueId().toString()));
            data.put("mining", mining.select(player.getUniqueId().toString()));
            data.put("fishing", fishing.select(player.getUniqueId().toString()));
            data.put("excavation", excavation.select(player.getUniqueId().toString()));
            data.put("archery", archery.select(player.getUniqueId().toString()));
            data.put("defense", defense.select(player.getUniqueId().toString()));
            data.put("fighting", fighting.select(player.getUniqueId().toString()));
            data.put("endurance", endurance.select(player.getUniqueId().toString()));
            data.put("agility", agility.select(player.getUniqueId().toString()));
            data.put("alchemy", alchemy.select(player.getUniqueId().toString()));
            data.put("enchanting", enchanting.select(player.getUniqueId().toString()));
            data.put("healing", healing.select(player.getUniqueId().toString()));
            data.put("forging", forging.select(player.getUniqueId().toString()));
        }

        return data;
    }

}
