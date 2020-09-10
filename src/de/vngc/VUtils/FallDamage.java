package de.vngc.VUtils;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;


public class FallDamage implements Listener {

    @Deprecated
    @EventHandler
    public void onFallDMG(EntityDamageEvent event) {
        if (event.getEntity() instanceof Player) {
            if (Settings.falldmg && Main.timerRunning) {
                if (event.getCause() == EntityDamageEvent.DamageCause.FALL) {
                    for (Player players : Bukkit.getOnlinePlayers()) {
                        players.sendMessage("§koooooooooooooooooooo");
                        players.sendMessage(" ");
                        players.sendMessage("§aDie Challenge wurde nicht geschafft!");
                        players.sendMessage("§aDer Seed war: §9" + Bukkit.getWorld("world").getSeed());
                        players.sendMessage(" ");
                        players.sendMessage("§koooooooooooooooooooo");
                        players.setGameMode(GameMode.valueOf(Main.getPlugin().getConfig().getString("gamemode")));
                    }
                    TimerClass.resetTimerArgument((Player) event.getEntity());
                }
            }
        }
    }
}
