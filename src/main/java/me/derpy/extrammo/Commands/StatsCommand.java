package me.derpy.extrammo.Commands;

import dev.jorel.commandapi.CommandAPICommand;

public class StatsCommand {

    public void register() {
        new CommandAPICommand("stats")
                .executesPlayer((player, args) -> {

                })
                .register();
    }
}
