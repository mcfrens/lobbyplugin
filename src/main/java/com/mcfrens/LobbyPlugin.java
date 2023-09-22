package com.mcfrens;

import com.mcfrens.commands.SendToServer;
import com.mcfrens.commands.SetLobbySpawn;
import com.mcfrens.listeners.PlayerJoinListener;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.plugin.messaging.PluginMessageListener;
import org.jetbrains.annotations.NotNull;

public final class LobbyPlugin extends JavaPlugin implements @NotNull PluginMessageListener {

    @Override
    public void onEnable() {
        this.getServer().getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");
        this.getServer().getMessenger().registerIncomingPluginChannel(this, "BungeeCord", this);

        registerCommands();
        registerListeners();
    }

    private void registerCommands() {
        this.getCommand("sendtoserver").setExecutor(new SendToServer(this));
        this.getCommand("setlobbyspawn").setExecutor(new SetLobbySpawn(this));
    }

    private void registerListeners() {
        this.getServer().getPluginManager().registerEvents(new PlayerJoinListener(this), this);
    }

    @Override
    public void onDisable() {
        this.getServer().getMessenger().unregisterOutgoingPluginChannel(this);
        this.getServer().getMessenger().unregisterIncomingPluginChannel(this);
    }

    @Override
    public void onPluginMessageReceived(@NotNull String channel, @NotNull Player player, @NotNull byte[] message) {

    }
}
