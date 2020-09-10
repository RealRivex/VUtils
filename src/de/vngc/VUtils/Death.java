package de.vngc.VUtils;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.PlayerDeathEvent;

public class Death implements Listener {

    @EventHandler
    public void onDeath(PlayerDeathEvent event) {
        Player player = event.getEntity();
        EntityDamageEvent event2 = event.getEntity().getLastDamageCause();
        EntityDamageEvent.DamageCause dc = event2.getCause();
        for (Player players : Bukkit.getOnlinePlayers()) {
            players.sendMessage("§koooooooooooooooooooo");
            players.sendMessage(" ");
            players.sendMessage("§a" + player.getName() + " §aist gestorben!");
            players.sendMessage("§aDer Seed war: §9" + Bukkit.getWorld("world").getSeed());
            players.sendMessage(" ");
            players.sendMessage("§koooooooooooooooooooo");
            players.setGameMode(GameMode.valueOf(Main.getPlugin().getConfig().getString("gamemode")));
        }
        TimerClass.pauseTimerArgument(player);
    }
}
