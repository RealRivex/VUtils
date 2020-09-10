package de.vngc.VUtils;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.CraftItemEvent;

public class Crafting implements Listener {

    @EventHandler
    public void handleCrafting(CraftItemEvent event) {
        if (Settings.crafting && Main.timerRunning) {
            if (event.getRecipe().getResult().getType() == Material.BLAZE_POWDER)
                return;
            if (event.getRecipe().getResult().getType() == Material.ENDER_EYE)
                return;
            for (Player players : Bukkit.getOnlinePlayers()) {
                players.sendMessage("§koooooooooooooooooooo");
                players.sendMessage(" ");
                players.sendMessage("§aDie Challenge wurde nicht geschafft!");
                players.sendMessage("§aDer Seed war: §9" + Bukkit.getWorld("world").getSeed());
                players.sendMessage(" ");
                players.sendMessage("§koooooooooooooooooooo");
                players.setGameMode(GameMode.valueOf(Main.getPlugin().getConfig().getString("gamemode")));
            }
            TimerClass.pauseTimerArgument((Player) event.getWhoClicked());
        }
    }
}