package de.vngc.VUtils;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import java.util.Random;

public class DamageMirror implements Listener {

    @EventHandler
    public void mirror(EntityDamageByEntityEvent event) {
        if (Settings.mirrorDamage) {
            if (!(event.getEntity() instanceof Player)) {
                Entity entity = event.getEntity();
                Player damager = (Player) event.getDamager();
                Random random = new Random();
                int rnd = random.nextInt(100);
                if (rnd <= 50) {
                    return;
                } else {
                    event.setCancelled(true);
                    Double damage = event.getFinalDamage();
                    damager.damage(damage);
                }
            }
        }
    }
}