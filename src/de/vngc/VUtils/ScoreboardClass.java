package de.vngc.VUtils;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.*;


@SuppressWarnings("deprecation")
public class ScoreboardClass {

    public static Scoreboard sb = Bukkit.getScoreboardManager().getNewScoreboard();

    public static void setTabHealth(Player player) {
        Objective obj = sb.getObjective("hbn");
        if (obj == null) {
            obj = sb.registerNewObjective("hbn", "health", "hp");
        }
        obj.setDisplaySlot(DisplaySlot.PLAYER_LIST);
        double health = (player.getHealth() * 5);
        obj.setRenderType(RenderType.HEARTS);
        obj.setDisplayName(ChatColor.RED + "\u2665");
        for (Player players : Bukkit.getOnlinePlayers()) {
            players.setScoreboard(sb);
        }
    }
}