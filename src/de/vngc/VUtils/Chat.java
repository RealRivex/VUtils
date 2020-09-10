package de.vngc.VUtils;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class Chat implements Listener {
    @EventHandler
    public void chat(AsyncPlayerChatEvent event) {
        Player player = event.getPlayer();
        String message = event.getMessage();
        String replace = message.replace("&0", "§0").replace("&1", "§1").replace("&2", "§2").replace("&3", "§3").replace("&4", "§4")
                .replace("&5", "§5").replace("&6", "§6").replace("&7", "§7").replace("&8", "§8").replace("&9", "§9")
                .replace("&2", "§2").replace("&a", "§a").replace("&b", "§b").replace("&c", "§c").replace("&d", "§d")
                .replace("&e", "§e").replace("&f", "§f").replace("&k", "§k").replace("&l", "§l").replace("&m", "§m")
                .replace("&n", "§n");

        if (Mute.muted.contains(player)) {
            event.setCancelled(true);
            player.sendMessage("§cDu bist leider gemuted!");
        }
        event.setFormat("§7| §b" + player.getName() + " §7| §7" + replace);
        if (Main.getPlugin().getConfig().getBoolean("mute")) {
            event.setCancelled(true);
            player.sendMessage("§cDer Chat ist aktuell gemuted!");
        }
    }
}
