package de.vngc.VUtils;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Heal implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (player.isOp()) {
                if (args.length == 0) {
                    player.addPotionEffect(new PotionEffect(PotionEffectType.HEAL, 1, 4));
                    player.setFoodLevel(20);
                    player.setSaturation(20);
                    player.sendMessage("§aDu hast dich selbst geheilt!");
                } else if (args.length == 1) {
                    if (args[0].equalsIgnoreCase("all")) {
                        for (Player players : Bukkit.getOnlinePlayers()) {
                            players.addPotionEffect(new PotionEffect(PotionEffectType.HEAL, 1, 4));
                            players.setFoodLevel(20);
                            players.setSaturation(20);
                            for (Player players2 : Bukkit.getOnlinePlayers()) {
                                if (!players2.equals(player)) {
                                    players.sendMessage("§aDu wurdest geheilt von §b" + player.getName());
                                }
                            }
                        }
                        player.sendMessage("§aDu hast alle Spieler geheilt!");
                    } else {
                        Player target = Bukkit.getPlayer(args[0]);
                        if (target != null) {
                            target.addPotionEffect(new PotionEffect(PotionEffectType.HEAL, 1, 4));
                            target.setFoodLevel(20);
                            target.setSaturation(20);
                            target.sendMessage("§aDu wurdest geheilt von §b" + player.getName());
                            player.sendMessage("§aDu hast §b" + target.getName() + " §ageheilt!");
                        } else {
                            player.sendMessage("§cDieser Spieler ist leider nicht online!");
                        }
                    }
                } else {
                    player.sendMessage("§6/heal §7| §b<all§7|§b(target)§7>");
                }
            }
        }
        return false;
    }
}