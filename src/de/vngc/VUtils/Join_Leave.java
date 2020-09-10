package de.vngc.VUtils;

import org.bukkit.Bukkit;
import org.bukkit.Difficulty;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class Join_Leave implements Listener {
    private static final String HOST = "https://api.spigotmc.org/simple/0.1/index.php?action=getResource&id=";

    private static final String USER_AGENT = "Updater";


    @Deprecated
    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        if (Bukkit.getWorld("mlg") != null) {
            if (Bukkit.getWorld("world_mlg").getDifficulty() != Difficulty.PEACEFUL) {
                Bukkit.getWorld("world_mlg").setDifficulty(Difficulty.PEACEFUL);
            }
        }
        ScoreboardClass.setTabHealth(event.getPlayer());
        player.setPlayerListHeader(Main.getPlugin().getConfig().getString("header"));
        player.setPlayerListFooter(Main.getPlugin().getConfig().getString("footer"));
        event.setJoinMessage("§a§l» §8" + player.getName());
        if (!player.hasPlayedBefore()) {
            player.sendMessage("§aUm die Challenges zu konfigurieren, nutze §6/settings");
            player.sendMessage(" ");
            player.sendMessage("§aUm den Timer zu nutzen, nutze §6/timer §7<§6set (sekunden)§7|§6resume§7|§6pause§7|§6reset§7>");
        }

        player.setHealth(Settings.hp);

        UpdateChecker.init(Main.getPlugin(), 80158).requestUpdateCheck().whenComplete((result, exception) -> {
            if (result.requiresUpdate()) {
                if (player.isOp()) {
                    player.sendMessage("§aDie neueste Version von §9VUtils ist installiert!");
                }
            } else {
                if (player.isOp()) {
                    player.sendMessage("§cEs gibt eine neuere Version von VUtils! Aktuelle Version: §9" + Main.getPlugin().getDescription().getVersion() + " §7| §cNeueste Version: §9" + result.getNewestVersion());
                }
            }
        });

    }

    @EventHandler
    public void onQuit(PlayerQuitEvent event) {
        Player player = event.getPlayer();
        event.setQuitMessage("§c§l« §8" + player.getName());
    }
}
