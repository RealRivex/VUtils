package de.vngc.VUtils;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GamemodeCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (args.length == 1) {
                if (args[0].equalsIgnoreCase("0")) {
                    player.setGameMode(GameMode.SURVIVAL);
                    player.sendMessage("§aGamemode zu §9Survival §ageändert...");
                } else if (args[0].equalsIgnoreCase("1")) {
                    player.setGameMode(GameMode.CREATIVE);
                    player.sendMessage("§aGamemode zu §9Creative §ageändert...");
                } else if (args[0].equalsIgnoreCase("2")) {
                    player.setGameMode(GameMode.ADVENTURE);
                    player.sendMessage("§aGamemode zu §9Adventure §ageändert...");
                } else if (args[0].equalsIgnoreCase("3")) {
                    player.setGameMode(GameMode.SPECTATOR);
                    player.sendMessage("§aGamemode zu §9Spectator §ageändert...");
                } else {
                    player.sendMessage("§cGamemode existiert nicht!");
                }
            } else {
                player.sendMessage("§cBitte benutze §7/gamemode <Gamemode> §coder §7/gm <0|1|2|3>");
            }
        }
        return false;
    }
}
