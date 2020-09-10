package de.vngc.VUtils;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class Place implements Listener {

    @EventHandler
    public void handlePlace(BlockPlaceEvent event) {
        if (Settings.blockplace && Main.timerRunning) {
            if (event.getBlock().getType() == Material.END_PORTAL_FRAME)
                return;
            if (event.getBlock().getType() == Material.FIRE)
                return;
            event.setCancelled(true);
            for (Player players : Bukkit.getOnlinePlayers()) {
                players.sendMessage("§koooooooooooooooooooo");
                players.sendMessage(" ");
                players.sendMessage("§aDie Challenge wurde nicht geschafft!");
                players.sendMessage("§aDer Seed war: §9" + Bukkit.getWorld("world").getSeed());
                players.sendMessage(" ");
                players.sendMessage("§koooooooooooooooooooo");
                players.setGameMode(GameMode.SPECTATOR);
            }
            TimerClass.pauseTimerArgument(event.getPlayer());
        }
        if (event.getBlock().getWorld().getName().equals("mlg")) {
            Bukkit.getScheduler().runTaskLater(Main.getPlugin(), () -> {

            }, 40L);
        }
    }
}
