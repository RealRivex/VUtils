package de.vngc.VUtils;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class DamageClear implements Listener {

    ArrayList<Integer> filledSlots = new ArrayList<>();

    @EventHandler
    public void onDamage(EntityDamageEvent event) {
        if (Main.timerRunning && Settings.damageClear) {
            if (event.getEntity() instanceof Player) {
                if (event.getFinalDamage() > 0) {
                    filledSlots.clear();
                    for (Player players : Bukkit.getOnlinePlayers()) {
                        for (int i = 0; i < 40; i++) {
                            if (players.getInventory().getItem(i) != null) {
                                filledSlots.add(i);
                            }
                        }
                        Bukkit.getScheduler().runTaskLater(Main.getPlugin(), () -> {
                            int slot = filledSlots.get(ThreadLocalRandom.current().nextInt(filledSlots.size()));
                            int amount = players.getInventory().getItem(slot).getAmount();
                            String type = players.getInventory().getItem(slot).getType().toString().toUpperCase().replace("_", " ");
                            players.getInventory().setItem(slot, new ItemStack(Material.AIR));
                            players.updateInventory();
                            players.sendMessage("§cDir wurde(n) §9" + amount + " " + type + " §caus dem Inventar entfernt.");
                        }, 5L);
                    }
                }
            }
        }
    }
}