package de.vngc.VUtils;

import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Break implements Listener {

    public ArrayList<Block> getVerticalBlocks(World w, Double x, Double z) {
        ArrayList<Block> blocks = new ArrayList<Block>();
        for (int y = 0; y < w.getMaxHeight(); y++) {
            Location loc = new Location(w, x, y, z);
            blocks.add(loc.getBlock());
        }

        return blocks;

    }


    @EventHandler
    public void handleBreak(BlockBreakEvent event) {
        Player player = event.getPlayer();
        if (Settings.blockbreak && Main.timerRunning) {
            event.setCancelled(true);
            for (Player players : Bukkit.getOnlinePlayers()) {
                players.sendMessage("§koooooooooooooooooooo");
                players.sendMessage(" ");
                players.sendMessage("§aDie Challenge wurde nicht geschafft!");
                players.sendMessage("§aDer Seed war: §9" + Bukkit.getWorld("world").getSeed());
                players.sendMessage(" ");
                players.sendMessage("§koooooooooooooooooooo");
                players.setGameMode(GameMode.valueOf(Main.getPlugin().getConfig().getString("gamemode")));
                TimerClass.pauseTimerArgument(player);
            }
        }
        if (Main.timerRunning && Settings.air2) {
            World w = event.getPlayer().getWorld();
            Double x = event.getBlock().getLocation().getX();
            Double z = event.getBlock().getLocation().getZ();
            ArrayList<Block> blocks = getVerticalBlocks(w, x, z);
            Bukkit.getScheduler().runTaskLater(Main.getPlugin(), () -> {
                for (Block b : blocks) {
                    if (!(b.getType() == Material.BEDROCK)) {
                        b.setType(Material.AIR);
                    }
                }
            }, 1L);
        }
    }
}
