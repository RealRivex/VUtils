package de.vngc.VUtils;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityRegainHealthEvent;

public class Regeneration implements Listener {
    @EventHandler
    public void onPlayerRegainHealth(EntityRegainHealthEvent event) {
        if (Main.timerRunning)
            if (Settings.inthardcore == 3) {
                if (event.getRegainReason() == EntityRegainHealthEvent.RegainReason.SATIATED || event.getRegainReason() == EntityRegainHealthEvent.RegainReason.REGEN)
                    event.setCancelled(true);
            } else if (Settings.inthardcore == 2) {
                event.setCancelled(true);
            } else if (Settings.inthardcore == 1) {
                return;
            }
    }
}
