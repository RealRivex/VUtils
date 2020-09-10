package de.vngc.VUtils;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerToggleSneakEvent;

public class Sneak implements Listener {

    @EventHandler
    public void sneak(PlayerToggleSneakEvent event) {
        if (Settings.sneak && Main.timerRunning) {
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
    }

}
