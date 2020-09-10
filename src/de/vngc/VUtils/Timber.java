package de.vngc.VUtils;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

public class Timber implements Listener {

    @EventHandler
    public void onBreak(BlockBreakEvent event) {
        if (Main.timerRunning && Settings.timber) {
            Player player = event.getPlayer();
            Location bLoc = event.getBlock().getLocation();
            double y = bLoc.getBlockY();
            double x = bLoc.getBlockX();
            double z = bLoc.getBlockZ();
            World currentWorld = event.getPlayer().getWorld();
            boolean logsLeft = true;
            while (logsLeft == true) {
                y++;
                Location blockAbove = new Location(currentWorld, x, y, z);
                Material blockAboveType = blockAbove.getBlock().getType();

                if (blockAboveType == Material.ACACIA_LOG
                        || blockAboveType == Material.BIRCH_LOG
                        || blockAboveType == Material.DARK_OAK_LOG
                        || blockAboveType == Material.JUNGLE_LOG
                        || blockAboveType == Material.SPRUCE_LOG
                        || blockAboveType == Material.OAK_LOG) {
                    currentWorld.dropItemNaturally(blockAbove, new ItemStack(blockAboveType));
                    blockAbove.getBlock().setType(Material.AIR);
                    logsLeft = true;
                } else {
                    logsLeft = false;
                }
            }
        }
    }
}