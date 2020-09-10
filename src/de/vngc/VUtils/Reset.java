package de.vngc.VUtils;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Reset implements CommandExecutor {

    public boolean onCommand(final CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player && args.length == 0) {
            Main.bp.clear();
            for (Player player : Bukkit.getServer().getOnlinePlayers()) {
                player.getInventory().clear();
                ByteArrayOutputStream bytearray = new ByteArrayOutputStream();
                DataOutputStream out = new DataOutputStream(bytearray);
                try {
                    out.writeUTF("Connect");
                    out.writeUTF("" + Main.getPlugin().getConfig().get("reset-server"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                player.sendPluginMessage(Main.getPlugin(), "BungeeCord", bytearray.toByteArray());
                player.sendMessage("§aWelt wurde zurückgesetzt von §b" + sender.getName());
            }
            Main.getPlugin().getConfig().set("reset", true);
            Main.getPlugin().saveConfig();
            Bukkit.getScheduler().runTaskLater(Main.getPlugin(), () -> {
                for (Player players : Bukkit.getOnlinePlayers()) {
                    players.kickPlayer("§aWelt wurde zurückgesetzt von §b" + sender.getName());
                }
                Bukkit.spigot().restart();
            }, 100L);
        }
        return false;
    }
}