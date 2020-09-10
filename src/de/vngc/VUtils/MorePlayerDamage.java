package de.vngc.VUtils;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

public class MorePlayerDamage implements Listener {

    @EventHandler
    public void damage(EntityDamageEvent event) {
        if (Settings.moreDamage != 0) {
            if (event.getEntity() instanceof Player) {
                if (event.getCause() != EntityDamageEvent.DamageCause.CUSTOM) {
                    Player player = (Player) event.getEntity();
                    Double damage = event.getFinalDamage();
                    if (Settings.moreDamage == 1) {
                        event.setDamage(damage * 2);
                    } else if (Settings.moreDamage == 2) {
                        event.setDamage(damage * 3);
                    }
                }
            }
        }
    }
}
