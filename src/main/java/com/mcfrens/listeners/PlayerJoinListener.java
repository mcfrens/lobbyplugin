package com.mcfrens.listeners;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.Plugin;

public class PlayerJoinListener implements Listener {
    Plugin plugin;

    public PlayerJoinListener(Plugin plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void OnPlayerJoinEvent(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        Location spawn = plugin.getConfig().getObject("locations.spawn", Location.class);

        if (spawn != null) {
            player.teleport(spawn);
        }
    }
}
