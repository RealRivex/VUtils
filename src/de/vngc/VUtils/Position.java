package de.vngc.VUtils;

import java.util.HashMap;

import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

public class Position implements CommandExecutor {

    public static HashMap<String, Location> locations = new HashMap<>();

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player)
            if (Main.timerRunning) {
                Player player = (Player) sender;
                if (args.length == 1) {
                    if (!locations.containsKey(args[0].toLowerCase())) {
                        Location location = player.getLocation();
                        TextComponent component = new TextComponent();
                        component.setText("§2§l[" + args[0].toLowerCase() + "§2§l]");
                        component.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/position " + args[0]
                                .toLowerCase()));
                        for (Player all : Bukkit.getOnlinePlayers())
                            all.spigot().sendMessage(new TextComponent("§aPosition gesetzt: §b" + args[0]
                                    .toLowerCase() + " §6| §8[§9" + location.getBlockX() + " §8| §9" + location
                                    .getBlockY() + " §8| §9" + location.getBlockZ() + " §8| §b" + Bukkit.getPlayer(sender.getName()).getWorld().getName() + "§8 ]"));
                        locations.put(args[0].toLowerCase(), location);
                    } else {
                        String id = args[0].toLowerCase();
                        Location location = locations.get(id);
                        player.spigot()
                                .sendMessage(new TextComponent("§aPosition §b" + args[0]
                                        .toLowerCase() + " §6| §8[§9" + location.getBlockX() + " §8| §9" + location
                                        .getBlockY() + " §8| §9" + location.getBlockZ() + " §8| §b" + Bukkit.getPlayer(sender.getName()).getWorld().getName() + "§8 ]"));
                    }
                } else {
                    player.sendMessage("");
                }
            } else {
                sender.sendMessage("§6/position <pos-name>");
            }
        return true;
    }
}
