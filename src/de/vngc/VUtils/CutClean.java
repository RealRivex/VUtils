package de.vngc.VUtils;

import java.util.Random;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;

public class CutClean implements Listener {
    @EventHandler
    public void handleEntityDeath(EntityDeathEvent event) {
        if (Settings.cutclean && Main.timerRunning) {
            LivingEntity livingEntity = event.getEntity();
            if (livingEntity.getType() == EntityType.SHEEP) {
                event.getDrops().clear();
                Random rand = new Random();
                int newnumber = rand.nextInt(100);
                if (newnumber < 30) {
                    event.getDrops().add(new ItemStack(Material.COOKED_MUTTON, 1));
                } else {
                    event.getDrops().add(new ItemStack(Material.COOKED_MUTTON, 2));
                }

            } else if (livingEntity.getType() == EntityType.COW) {
                event.getDrops().clear();
                Random rand1 = new Random();
                int newnumber1 = rand1.nextInt(100);
                if (newnumber1 < 30) {
                    event.getDrops().add(new ItemStack(Material.COOKED_BEEF, 1));
                    event.getDrops().add(new ItemStack(Material.LEATHER, 1));
                } else {
                    event.getDrops().add(new ItemStack(Material.COOKED_BEEF, 2));
                }
                event.getDrops().add(new ItemStack(Material.LEATHER, 2));
            } else if (livingEntity.getType() == EntityType.CHICKEN) {
                event.getDrops().clear();
                Random rand2 = new Random();
                int newnumber2 = rand2.nextInt(100);
                if (newnumber2 < 30) {
                    event.getDrops().add(new ItemStack(Material.COOKED_CHICKEN, 1));
                } else {
                    event.getDrops().add(new ItemStack(Material.COOKED_CHICKEN, 2));
                }
            } else if (livingEntity.getType() == EntityType.BLAZE) {
                event.getDrops().clear();
                event.getDrops().add(new ItemStack(Material.BLAZE_ROD));
            } else if (livingEntity.getType() == EntityType.PIG) {
                event.getDrops().clear();
                Random rand3 = new Random();
                int newnumber3 = rand3.nextInt(100);
                if (newnumber3 < 30) {
                    event.getDrops().add(new ItemStack(Material.COOKED_PORKCHOP, 1));
                } else {
                    event.getDrops().add(new ItemStack(Material.COOKED_PORKCHOP, 2));
                }
            }
        }
    }

    @EventHandler
    public void ore(BlockBreakEvent event) {
        if (Settings.cutclean && Main.timerRunning) {
            Block block = event.getBlock();
            if (block.getType() == Material.IRON_ORE) {
                block.setType(Material.AIR);
                event.getBlock().getWorld().dropItemNaturally(event.getBlock().getLocation(), new ItemStack(Material.IRON_INGOT));
            } else if (block.getType() == Material.GOLD_ORE) {
                block.setType(Material.AIR);
                event.getBlock().getWorld().dropItemNaturally(event.getBlock().getLocation(), new ItemStack(Material.GOLD_INGOT));
            } else if (block.getType() == Material.GRAVEL) {
                block.setType(Material.AIR);
                event.getBlock().getWorld().dropItemNaturally(event.getBlock().getLocation(), new ItemStack(Material.FLINT));
            }
        }
    }
}
