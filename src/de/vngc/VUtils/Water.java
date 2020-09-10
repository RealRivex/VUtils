package de.vngc.VUtils;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBucketEmptyEvent;

public class Water implements Listener {

    @EventHandler
    public void waterplace(PlayerBucketEmptyEvent event) {
        if (event.getBlockClicked().getWorld().getName().equals("mlg")) {
            if (event.getBucket() == Material.WATER_BUCKET) {
                Bukkit.getScheduler().runTaskLater(Main.getPlugin(), () -> {
                    Location loc = event.getBlockClicked().getLocation().add(0, 1, 0);
                    loc.getBlock().setType(Material.AIR);

                }, 20L);
            }
        }
    }
}
