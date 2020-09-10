package de.vngc.VUtils;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.world.TimeSkipEvent;

public class DaylightChange implements Listener {

    @EventHandler
    public void daylight(TimeSkipEvent event) {
        if (!Main.timerRunning) {
            event.setCancelled(true);
        }
    }
}
