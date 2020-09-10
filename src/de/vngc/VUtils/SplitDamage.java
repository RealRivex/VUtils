package de.vngc.VUtils;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityRegainHealthEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;

public class SplitDamage implements Listener {

    @EventHandler
    public void splitDmg(EntityDamageEvent event) {
        if (Settings.splitHP) {
            if (!(event.getCause() == EntityDamageEvent.DamageCause.CUSTOM)) {
                if (event.getEntity() instanceof Player) {
                    double damage = event.getFinalDamage();
                    event.setCancelled(true);
                    for (Player players : Bukkit.getOnlinePlayers()) {
                        players.damage(damage);
                    }
                }
            }
        }
    }

    @EventHandler
    public void splitReg(EntityRegainHealthEvent event) {
        if (Settings.splitHP) {
            if (event.getEntity() instanceof Player) {
                double amount = event.getAmount();
                event.setCancelled(true);
                for (Player players : Bukkit.getOnlinePlayers()) {
                    players.setHealth(players.getHealth() + amount);
                }
            }
        }
    }

    @EventHandler
    public void splitSat(FoodLevelChangeEvent event) {
        if (Settings.splitHP) {
            if (event.getEntity() instanceof Player) {
                int amount = event.getFoodLevel();
                event.setCancelled(true);
                for (Player players : Bukkit.getOnlinePlayers()) {
                    players.setFoodLevel(amount);
                }
            }
        }
    }
}