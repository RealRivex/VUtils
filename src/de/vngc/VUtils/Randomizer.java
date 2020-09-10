package de.vngc.VUtils;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class Randomizer implements Listener {
    public static List<EntityType> forbidden = new ArrayList<>();

    @EventHandler
    public void randomBreak(BlockBreakEvent event) {
        if (Settings.randomdrops && Main.timerRunning) {
            Material mat = event.getBlock().getType();
            Material randomDrops = Main.randomBlockDrops.get(mat);
            Location loc = event.getBlock().getLocation();
            System.out.println(randomDrops);
            event.setDropItems(false);
            loc.getWorld().dropItemNaturally(loc, new ItemStack(randomDrops));
        }
    }

    @EventHandler
    public void randomCrafting(CraftItemEvent event) {
        if (Settings.randomCrafting && Main.timerRunning) {
            Material mat = event.getRecipe().getResult().getType();
            int amount = event.getRecipe().getResult().getAmount();
            Material randomCrafting = Main.randomBlockDrops.get(mat);
            if (randomCrafting.isItem()) {
                event.getInventory().setResult(new ItemStack(randomCrafting, amount));
            }
        }
    }

    @EventHandler
    public void randomEntities(CreatureSpawnEvent event) {
        if (Settings.randomEntities && Main.timerRunning) {
            if (event.getSpawnReason() != CreatureSpawnEvent.SpawnReason.CUSTOM) {
                event.setCancelled(true);
                if (event.getEntityType().isSpawnable() && event.getEntityType().isAlive()) {
                    EntityType entityType = event.getEntity().getType();
                    EntityType randomEntities = Main.randomEntities.get(entityType);
                    Location loc = event.getLocation();
                    if (randomEntities.isAlive()) {
                        if (event.getLocation().getChunk().getEntities().length >= 24) {
                            System.out.println("Too Much Entities!");
                        } else {
                            if (!forbidden.contains(randomEntities)) {
                                loc.getWorld().spawnEntity(loc, randomEntities);
                            }
                        }
                    }
                }
            }
        }
    }
}
