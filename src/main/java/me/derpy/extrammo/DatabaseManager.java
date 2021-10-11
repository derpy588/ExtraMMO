package me.derpy.extrammo;

import redempt.redlib.sql.SQLHelper;

import java.sql.Connection;

public class DatabaseManager {

    SQLHelper sql;

    public SQLHelper init(Main plugin) {
        Connection connection = SQLHelper.openSQLite(plugin.getDataFolder().toPath().resolve("database.db"));
        SQLHelper sql = new SQLHelper(connection);
        return sql;
    }
}
