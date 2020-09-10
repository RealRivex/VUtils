package de.vngc.VUtils;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class Mute implements CommandExecutor {
    public static ArrayList<Player> muted = new ArrayList<>();

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender.hasPermission("vutils.mute"))
            if (sender instanceof Player) {
                Player player = (Player) sender;
                if (args.length == 0) {
                    if (Main.getPlugin().getConfig().getBoolean("mute")) {
                        Main.getPlugin().getConfig().set("mute", false);
                        Bukkit.broadcastMessage("§aChat wurde aktiviert");
                    } else {
                        Main.getPlugin().getConfig().set("mute", true);
                        Bukkit.broadcastMessage("§aChat wurde gemuted");
                    }
                    Main.getPlugin().saveConfig();
                } else if (args.length == 1) {
                    if (args[0] != null) {
                        Player target = Bukkit.getPlayer(args[0]);
                        if (muted.contains(target)) {
                            muted.remove(target);
                            Bukkit.broadcastMessage("§aDu wurdest entmuted");
                        } else {
                            muted.add(target);
                            Bukkit.broadcastMessage("Du wurdest gemuted");
                        }
                    }
                }
            }
        return false;
    }
}
