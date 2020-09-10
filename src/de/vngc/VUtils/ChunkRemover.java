package de.vngc.VUtils;

import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class ChunkRemover implements Listener {

    public static void removeChunks() {
        Bukkit.getScheduler().runTaskTimer(Main.getPlugin(), () -> {
            for (Player players : Bukkit.getOnlinePlayers()) {
                Chunk chunk = players.getLocation().getChunk();
                int chunkX = chunk.getX() << 4;
                int chunkZ = chunk.getZ() << 4;
                World w = chunk.getWorld();

                for (int x = 0; x < 16; x++) {
                    for (int z = 0; z < 16; z++) {
                        Block b = w.getHighestBlockAt(chunkX + x, chunkZ + z).getLocation().getBlock();
                        b.setType(Material.AIR);

                    }
                }
            }
        }, 200L, 200L);
    }
}
