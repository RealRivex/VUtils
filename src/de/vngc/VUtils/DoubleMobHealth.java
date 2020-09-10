package de.vngc.VUtils;

import org.bukkit.attribute.Attribute;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntitySpawnEvent;

public class DoubleMobHealth implements Listener {

    @EventHandler
    public void doubleHealth(EntitySpawnEvent event) {
        if (Settings.doubleHealth && Main.timerRunning) {
            if (event.getEntity() instanceof LivingEntity) {
                LivingEntity entity = (LivingEntity) event.getEntity();
                if (entity.getType() != EntityType.PLAYER) {
                    entity.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(40);
                    entity.setHealth(40);
                }
            }
        }
    }
}
