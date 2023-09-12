package com.mcfrens.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.List;

public class SendToServer implements CommandExecutor {
    private final Plugin plugin;

    public SendToServer(Plugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        String serverName = args[0];

        if (args.length != 1) {
            return false;
        }

        List<Entity> entities = Bukkit.selectEntities(sender, "@p");

        for (Entity entity : entities) {
            if (entity instanceof Player player) {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                DataOutputStream outputStream = new DataOutputStream(byteArrayOutputStream);

                try {
                    outputStream.writeUTF("ConnectOther");
                    outputStream.writeUTF(player.getName());
                    outputStream.writeUTF(serverName);
                } catch (IOException e) {
                    return false;
                }

                Bukkit.getServer().sendPluginMessage(plugin, "BungeeCord", byteArrayOutputStream.toByteArray());

                return true;
            }
        }

        return false;
    }
}
