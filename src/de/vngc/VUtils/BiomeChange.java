package de.vngc.VUtils;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.block.Biome;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class BiomeChange implements Listener {

    @EventHandler
    public void biomeChange(PlayerMoveEvent event) {
        Player player = event.getPlayer();
        if ((Main.timerRunning) && (Settings.mycelium)) {
            if ((player.getLocation().getBlock().getBiome() == Biome.MUSHROOM_FIELDS)
                    || (player.getLocation().getBlock().getBiome() == Biome.MUSHROOM_FIELD_SHORE)) {
                if (player.getGameMode() == GameMode.SURVIVAL) {
                    for (Player players : Bukkit.getOnlinePlayers()) {
                        players.sendMessage("§koooooooooooooooooooo");
                        players.sendMessage(" ");
                        players.sendMessage("§b" + player.getName() + " §ahat die Challenge abgeschlossen!");
                        players.sendMessage("§aDer Seed war: §9" + Bukkit.getWorld("world").getSeed());
                        players.sendMessage(" ");
                        players.sendMessage("§koooooooooooooooooooo");
                        players.setGameMode(GameMode.SPECTATOR);
                    }
                    if (Main.timerRunning) {
                        TimerClass.pauseTimerArgument(player);
                    }
                }
            }
        }
    }
}
