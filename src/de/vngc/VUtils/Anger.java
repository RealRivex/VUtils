package de.vngc.VUtils;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityTargetLivingEntityEvent;

public class Anger implements Listener {

    @EventHandler
    public void anger(EntityTargetLivingEntityEvent event) {
        if (!Main.timerRunning) {
            event.setCancelled(true);
        }
    }

}
