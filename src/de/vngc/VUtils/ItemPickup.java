package de.vngc.VUtils;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityPickupItemEvent;

import java.util.ArrayList;
import java.util.List;

public class ItemPickup implements Listener {
    public static List<Material> collectList = new ArrayList<Material>();

    @EventHandler
    public void onPickup(EntityPickupItemEvent event) {
        if (event.getEntity() instanceof Player) {
            Player player = (Player) event.getEntity();
            if (event.getItem().getItemStack() != null) {
                if (Settings.elytra) {
                    if (event.getItem().getItemStack().getType() == Material.ELYTRA) {
                        for (Player players : Bukkit.getOnlinePlayers()) {
                            players.sendMessage("§koooooooooooooooooooo");
                            players.sendMessage(" ");
                            players.sendMessage("§b" + player.getName() + " §ahat die Challenge abgeschlossen!");
                            players.sendMessage("§aDer Seed war: §9" + Bukkit.getWorld("world").getSeed());
                            players.sendMessage(" ");
                            players.sendMessage("§koooooooooooooooooooo");
                            players.setGameMode(GameMode.valueOf(Main.getPlugin().getConfig().getString("gamemode")));
                        }
                        if (Main.timerRunning) {
                            TimerClass.resetTimerArgument(player);
                        }
                    }
                } else if (Settings.diamond) {
                    if (event.getItem().getItemStack().getType() == Material.DIAMOND) {
                        for (Player players : Bukkit.getOnlinePlayers()) {
                            players.sendMessage("§koooooooooooooooooooo");
                            players.sendMessage(" ");
                            players.sendMessage("§b" + player.getName() + " §ahat die Challenge abgeschlossen!");
                            players.sendMessage("§aDer Seed war: §9" + Bukkit.getWorld("world").getSeed());
                            players.sendMessage(" ");
                            players.sendMessage("§koooooooooooooooooooo");
                            players.setGameMode(GameMode.valueOf(Main.getPlugin().getConfig().getString("gamemode")));
                        }
                        if (Main.timerRunning) {
                            TimerClass.resetTimerArgument(player);
                        }
                    }
                }
            }
        }
        if (Settings.collectDamage != 0 && Main.timerRunning) {
            Material mat = event.getItem().getItemStack().getType();
            if (!collectList.contains(mat)) {
                collectList.add(mat);
                for (Player players : Bukkit.getOnlinePlayers()) {
                    players.damage(Settings.collectDamage);
                }
            }
        }
    }
}
