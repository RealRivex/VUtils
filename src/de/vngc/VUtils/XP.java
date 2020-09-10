package de.vngc.VUtils;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerExpChangeEvent;

public class XP implements Listener {
    @Deprecated
    @EventHandler
    public void xp(PlayerExpChangeEvent event) {
        Player player = event.getPlayer();
        if (Settings.xp && Main.timerRunning) {
            for (Player players : Bukkit.getOnlinePlayers()) {
                players.sendMessage("§koooooooooooooooooooo");
                players.sendMessage(" ");
                players.sendMessage("§aDie Challenge wurde nicht geschafft!");
                players.sendMessage("§aDer Seed war: §9" + Bukkit.getWorld("world").getSeed());
                players.sendMessage(" ");
                players.sendMessage("§koooooooooooooooooooo");
                players.setGameMode(GameMode.SPECTATOR);
            }
            TimerClass.resetTimerArgument(player);
        }
    }
}
