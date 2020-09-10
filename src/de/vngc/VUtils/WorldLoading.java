package de.vngc.VUtils;

import org.bukkit.Bukkit;
import org.bukkit.Difficulty;
import org.bukkit.WorldCreator;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.world.WorldLoadEvent;

public class WorldLoading implements Listener {

    @EventHandler
    public void onLoad(WorldLoadEvent event) {
        if (event.getWorld().getName().equalsIgnoreCase("world_the_end")) {
            for (Player players : Bukkit.getOnlinePlayers()) {
                players.sendMessage("§6MLG-Welt wird nun erstellt/geladen");
            }
            Bukkit.createWorld(new WorldCreator("world_mlg"));
            Bukkit.createWorld(new WorldCreator("jnr"));
        } else if (event.getWorld().getName().equalsIgnoreCase("world_mlg")) {
            event.getWorld().setDifficulty(Difficulty.PEACEFUL);
            for (Player players : Bukkit.getOnlinePlayers()) {
                players.sendMessage("MLG-Welt erfolgreich erstellt/geladen");
            }
        }
    }
}