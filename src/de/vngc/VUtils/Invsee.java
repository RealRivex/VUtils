package de.vngc.VUtils;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class Invsee implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (args.length == 1) {
                ItemStack[] items = Bukkit.getPlayer(args[0]).getInventory().getContents();
                Inventory inv = Bukkit.createInventory(null, 54, "§6Inventar von §b" + args[0]);
                inv.setContents(items);
                player.openInventory(inv);
                try {
                    player.sendMessage("§aDu siehst nun das Inventar von §b" + Bukkit.getPlayer(args[0]));
                } catch (Exception exception) {
                    player.sendMessage("§cDieser Spieler ist leider nicht online!");
                }
            }
        }
        return false;
    }
}
