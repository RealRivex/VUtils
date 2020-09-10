package de.vngc.VUtils;

import org.bukkit.*;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.FallingBlock;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityChangeBlockEvent;

import java.util.Random;

public class AnvilChallenge implements Listener {
    private static final Random random = new Random();

    public static void triggerAnvil() {
        Bukkit.getScheduler().runTaskTimer(Main.getPlugin(), () -> {
            for (Player player : Bukkit.getOnlinePlayers()) {
                Chunk chunk = player.getLocation().getChunk();
                for (int i = 0; i < 6; ++i) {
                    Location loc = chunk.getBlock(random.nextInt(16), player.getLocation().getBlockY(), random.nextInt(16)).getLocation().add(0, random.nextInt((15 - 10) + 1) + 10, 0);
                    if (Main.timerRunning && Settings.fallingAnvil)
                        loc.getBlock().setType(Material.ANVIL);
                }
            }
        }, 10 * 20, 10 * 20);
    }

    @EventHandler
    public void onAnvilFall(EntityChangeBlockEvent event) {
        if (Settings.fallingAnvil) {
            if (event.getEntityType().equals(EntityType.FALLING_BLOCK)) {
                FallingBlock fb = (FallingBlock) event.getEntity();
                if (fb.getBlockData().getMaterial().equals(Material.ANVIL) || fb.getBlockData().getMaterial().equals(Material.CHIPPED_ANVIL) || fb.getBlockData().getMaterial().equals(Material.DAMAGED_ANVIL)) {
                    if (event.getBlock().getType().equals(Material.AIR) || event.getBlock().getType().equals(Material.GRASS) || event.getBlock().getType().equals(Material.TALL_GRASS)) {
                        fb.getWorld().playSound(fb.getLocation(), Sound.BLOCK_ANVIL_BREAK, 1, 1);
                        fb.remove();
                        event.getBlock().setType(Material.AIR);
                        event.getBlock().getLocation().subtract(0, 1, 0).getBlock().setType(Material.AIR);
                        event.setCancelled(true);
                    }
                }
            }
        }
    }
}