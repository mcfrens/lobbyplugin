package com.mcfrens.commands;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

public class SetLobbySpawn implements CommandExecutor {
    private final Plugin plugin;

    public SetLobbySpawn(Plugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        Player player = (Player) sender;
        Location location = player.getLocation();

        plugin.getConfig().set("locations.spawn", location);
        plugin.saveConfig();

        return true;
    }
}
