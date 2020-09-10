package de.vngc.VUtils;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

public class ChatDamage implements Listener {

    @EventHandler
    public void onDamage(EntityDamageEvent event) {
        if (event.getEntity() instanceof Player) {
            Player player = (Player) event.getEntity();
            double damage = event.getFinalDamage() / 2;
            EntityDamageEvent.DamageCause cause = event.getCause();
            damage = Double.parseDouble(Double.toString(damage).substring(0, Double.toString(damage).indexOf(".") + 2));
            if (Settings.chatdamage && Main.timerRunning) {
                if (event.getFinalDamage() > 0) {
                    if (Settings.moreDamage == 1) {
                        Bukkit.broadcastMessage("§9" + player.getName() + " §ahat §5" + damage * 2 + " Herzen §aSchaden bekommen. §7[§9" + cause + "§7]");
                    } else if (Settings.moreDamage == 2) {
                        Bukkit.broadcastMessage("§9" + player.getName() + " §ahat §5" + damage * 3 + " Herzen §aSchaden bekommen. §7[§9" + cause + "§7]");
                    } else {
                        Bukkit.broadcastMessage("§9" + player.getName() + " §ahat §5" + damage + " Herzen §aSchaden bekommen. §7[§9" + cause + "§7]");
                    }
                }
            }
        }
    }
}
