package de.vngc.VUtils;

import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.*;
import org.bukkit.block.Biome;
import org.bukkit.block.BlockFace;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitTask;

import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class TimerClass implements CommandExecutor, Listener, TabCompleter {
    @SuppressWarnings("Deprecated")

    private static final Random random = new Random();

    public static int time = 0;

    private static BukkitTask pauseTimer;

    private static BukkitTask choose;

    private static BukkitTask collect;

    public static int collectTime;

    public static BukkitTask collectTimeTask;

    public static BukkitTask pausedTimer;

    public static BukkitTask showTimeTask;

    private static Main plugin = Main.getPlugin();

    private static BukkitTask timer;

    public static List<EntityType> entityList = new ArrayList<>();

    private static ArrayList<Biome> finalBiome = new ArrayList<>();

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player &&
                cmd.getName().equalsIgnoreCase("timer")) {
            Player player = (Player) sender;
            if (args.length == 1) {
                if (args[0].equalsIgnoreCase("resume")) {
                    for (Player players : Bukkit.getOnlinePlayers()) {
                        players.playSound(players.getLocation(), Sound.EVENT_RAID_HORN, 5, 1);
                        players.closeInventory();
                    }
                    resumeTimerArgument(player);
                    pausedTimer.cancel();
                } else if (args[0].equalsIgnoreCase("pause")) {
                    pauseTimerArgument(player);
                } else if (args[0].equalsIgnoreCase("reset")) {
                    resetTimerArgument(player);
                    timerPaused();
                } else {
                    player.sendMessage("§7[§bTimer§7] §6/timer §aresume §7| §aTimer fortsetzen");
                    player.sendMessage("§7[§bTimer§7] §6/timer §6pause §7| §6Timer pausieren");
                    player.sendMessage("§7[§bTimer§7] §6/timer §creset §7| §cTimer zurücksetzen");
                }
            } else if (args.length == 2) {
                if (isInt(args[1])) {
                    time = Integer.parseInt(args[1]) * 60;
                    Bukkit.broadcastMessage("§7[§bTimer§7] §6Der Timer wurde auf §b" + Integer.parseInt(args[1]) + " Minuten §6gesetzt");
                } else {
                    player.sendMessage("§7[§bTimer§7] §cBitte gib das Argument in Minuten an. §7[§b/timer set §7<§e60§7>§7]");
                }
            } else {
                player.sendMessage("§7[§bTimer§7] §6/timer §aresume §7| §aTimer fortsetzen");
                player.sendMessage("§7[§bTimer§7] §6/timer §6pause §7| §6Timer pausieren");
                player.sendMessage("§7[§bTimer§7] §6/timer §creset §7| §cTimer zurücksetzen");
            }

        }
        return false;
    }

    public static void resumeTimerArgument(Player player) {
        HashMap<Player, ItemStack[]> invContents = new HashMap<>();
        HashMap<Player, Location> location = new HashMap<>();
        if (!Main.timerRunning) {
            startTimer();
            showTime();
            stopPauseTimer();
            Main.timerRunning = true;
            if (time == 0) {
                Bukkit.broadcastMessage("§aTimer wurde gestartet.");
                if (Settings.mlg) {
                    Random randomNmb = new Random();
                    int rndTime = randomNmb.nextInt((14400 - 9600) + 1) + 9600;
                    Bukkit.getScheduler().runTaskTimer(Main.getPlugin(), () -> {
                        for (Player players : Bukkit.getOnlinePlayers()) {
                            invContents.put(players, players.getInventory().getContents());
                            location.put(players, players.getLocation());
                            players.getInventory().clear();
                            players.teleport(new Location(Bukkit.getWorld("mlg"), 500, 50, 500, 0, 80));
                            players.getInventory().setItemInMainHand(new ItemStack(Material.WATER_BUCKET));
                            Bukkit.getScheduler().runTaskLater(Main.getPlugin(), () -> {
                                if ((players.getInventory().contains(Material.WATER_BUCKET) || (players.getInventory().contains(Material.BUCKET)))) {
                                    players.getInventory().clear();
                                    players.teleport(location.get(players));
                                    players.getInventory().setContents(invContents.get(players));
                                    randomNmb.nextInt((12000 - 6000) + 1);
                                } else {
                                    players.sendMessage("§koooooooooooooooooooo");
                                    players.sendMessage(" ");
                                    players.sendMessage("§6Das MLG wurde nicht von allen Spielern geschafft!");
                                    players.sendMessage("§6Der Seed war: §b" + "" + Bukkit.getWorld("world").getSeed());
                                    players.sendMessage(" ");
                                    players.sendMessage("§koooooooooooooooooooo");
                                    players.setGameMode(GameMode.SPECTATOR);
                                }
                            }, 100L);
                        }
                    }, 0L, rndTime);
                }

                if (Settings.forceItem) forceItemRunnable();
                if (Settings.forceBlock) forceBlockRunnable();
                if (Settings.forceYCoord) forceYCoordsRunnable();
                if (Settings.forceEntity) forceEntityRunnable();
                if (Settings.removeChunks) ChunkRemover.removeChunks();
                if (Settings.fallingAnvil) AnvilChallenge.triggerAnvil();
                if (Settings.forceBiome) forceBiomeRunnable();

            } else {
                Bukkit.broadcastMessage("§aTimer fortgesetzt.");
            }
        } else {
            player.sendMessage("§cTimer ist bereits gestartet.");
        }
    }

    public static void pauseTimerArgument(Player player) {
        if (Main.timerRunning) {
            stopTimer();
            Main.timerRunning = false;
            Bukkit.broadcastMessage("§6Timer pausiert.");
            startPauseTimer();
        } else {
            player.sendMessage("§cTimer ist bereits pausiert.");
        }
    }

    public static void resetTimerArgument(Player player) {
        if (time != 0) {
            stopTimer();
            Main.timerRunning = false;
            Bukkit.broadcastMessage("§6Timer zurückgesetzt.");
            time = 0;
            stopPauseTimer();
        } else {
            player.sendMessage("§cTimer läuft nicht.");
        }
    }

    private static void startTimer() {
        timer = Bukkit.getScheduler().runTaskTimer(plugin, () -> {
            time++;
        }, 0L, 20L);
        Main.timerRunning = true;
    }

    private static void showTime() {
        showTimeTask = Bukkit.getScheduler().runTaskTimer(plugin, () -> {
            for (Player players : Bukkit.getOnlinePlayers()) {
                players.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent("§6Challenge: §b" + ChatColor.GREEN + getTimeString(time)));
            }
        }, 0L, 20);
    }

    private static void stopTimer() {
        Main.timerRunning = false;
        timer.cancel();
        showTimeTask.cancel();
    }

    private static void startPauseTimer() {
        pauseTimer = Bukkit.getScheduler().runTaskTimer(plugin, () -> {
            for (Player players : Bukkit.getOnlinePlayers())
                players.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent("§6Timer pausiert"));
        }, 0L, 20L);
    }

    private static void stopPauseTimer() {
        if (pauseTimer != null)
            pauseTimer.cancel();
    }

    private static String getTimeString(int time) {
        int hours = time / 3600;
        int minutes = time % 3600 / 60;
        int seconds = time % 60;
        return String.format("§b%02d§7:§b%02d§7:§b%02d", hours, minutes, seconds);
    }

    private static String getTimeString2(int collectTime) {
        int minutes = collectTime % 3600 / 60;
        int seconds = collectTime % 60;
        return String.format("§b%02d§7:§b%02d", minutes, seconds);
    }

    public static void timerPaused() {
        pausedTimer = Bukkit.getScheduler().runTaskTimer(Main.getPlugin(), () -> {
            for (Player players : Bukkit.getOnlinePlayers()) {
                players.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent("§6§lTimer pausiert"));
            }
        }, 0L, 20L);
    }

    @EventHandler
    public void dragon(EntityDeathEvent event) {
        if (Main.timerRunning) {
            if (!Settings.elytra) {
                if (event.getEntity() instanceof org.bukkit.entity.EnderDragon) {
                    Player player = event.getEntity().getKiller();
                    for (Player players : Bukkit.getOnlinePlayers()) {
                        players.sendMessage("  §koooooooooooooooooooo");
                        players.sendMessage(" ");
                        players.sendMessage("§aDer Enderdrache wurde getötet!");
                        players.sendMessage("§aDer Seed war: §9" + Bukkit.getWorld("world").getSeed());
                        players.sendMessage(" ");
                        players.sendMessage("  §koooooooooooooooooooo");
                    }
                    if (Main.timerRunning) {
                        resetTimerArgument(player);
                    }
                }
            }
        }
    }

    public static void forceItemRunnable() {
        Main.waitingForInstruction = true;
        Random rnd = new Random();
        int rndTime = rnd.nextInt((14400 - 9600) + 1) + 9600;
        choose = Bukkit.getScheduler().runTaskLater(Main.getPlugin(), () -> {
            Random rnd1 = new Random();
            Material mat = Main.matList.get(rnd1.nextInt(Main.matList.size()));
            Random rnd2 = new Random();
            int rndTime2 = rnd2.nextInt((6000 - 2400) + 1) + 2400;
            showTimeTask.cancel();
            collectTime = rndTime2 / 20;
            for (Player players : Bukkit.getOnlinePlayers()) {
                players.sendMessage("§aAnweisung: §9" + mat.toString().replace("_", " ") + " §ain §9" + getTimeString2(collectTime));
            }
            collectTime = rndTime2 / 20;
            Main.waitingForInstruction = false;
            collectTimeTask = Bukkit.getScheduler().runTaskTimer(Main.getPlugin(), () -> {
                collectTime--;
                for (Player players : Bukkit.getOnlinePlayers()) {
                    players.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent("§aAnweisung: §9" + mat.toString().replace("_", " ") + " §ain §9" + getTimeString2(collectTime)));
                }
            }, 0L, 20L);
            collect = Bukkit.getScheduler().runTaskLater(Main.getPlugin(), () -> {
                showTime();
                collectTimeTask.cancel();
                for (Player players : Bukkit.getOnlinePlayers()) {
                    if (players.getInventory().getItemInMainHand().getType() == mat) {
                        if (!choose.isCancelled()) {
                            choose.cancel();
                        }
                        if (!collect.isCancelled()) {
                            collect.cancel();
                        }
                        forceItemRunnable();
                        players.sendMessage("§aAnweisung befolgt.");
                    } else {
                        timerPaused();
                        collectTimeTask.cancel();
                        if (!choose.isCancelled()) {
                            choose.cancel();
                        }
                        if (!collect.isCancelled()) {
                            collect.cancel();
                        }
                        players.sendMessage("§koooooooooooooooooooo");
                        players.sendMessage(" ");
                        players.sendMessage("§aDie Anweisung wurde nicht befolgt!");
                        players.sendMessage("§aDer Seed war: §9" + Bukkit.getWorld("world").getSeed());
                        players.sendMessage(" ");
                        players.sendMessage("§koooooooooooooooooooo");
                        players.setGameMode(GameMode.SPECTATOR);
                        stopTimer();
                        time = 0;
                    }
                }
            }, rndTime2);
        }, rndTime);

    }

    public static void forceBlockRunnable() {
        Main.waitingForInstruction = true;
        Random rnd = new Random();
        int rndTime = rnd.nextInt((12000 - 6000) + 1) + 6000;
        choose = Bukkit.getScheduler().runTaskLater(Main.getPlugin(), () -> {
            Random rnd1 = new Random();
            Material block = Main.blockList.get(rnd1.nextInt(Main.blockList.size()));
            Random rnd2 = new Random();
            int rndTime2 = rnd2.nextInt((6000 - 2400) + 1) + 2400;
            showTimeTask.cancel();
            collectTime = rndTime2 / 20;
            for (Player players : Bukkit.getOnlinePlayers()) {
                players.sendMessage("§6");
            }
            collectTime = rndTime2 / 20;
            Main.waitingForInstruction = false;
            collectTimeTask = Bukkit.getScheduler().runTaskTimer(Main.getPlugin(), () -> {
                collectTime--;
                for (Player players : Bukkit.getOnlinePlayers()) {
                    players.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent("§aAnweisung: §9" + block.toString().replace("_", " ") + " §ain §9" + getTimeString2(collectTime)));
                }
            }, 0L, 20L);
            collect = Bukkit.getScheduler().runTaskLater(Main.getPlugin(), () -> {
                showTime();
                collectTimeTask.cancel();
                for (Player players : Bukkit.getOnlinePlayers()) {
                    if (players.getLocation().getBlock().getRelative(BlockFace.DOWN).getType() == block) {
                        if (!choose.isCancelled()) {
                            choose.cancel();
                        }
                        if (!collect.isCancelled()) {
                            collect.cancel();
                        }
                        forceBlockRunnable();
                        players.sendMessage("§aAnweisung: §9" + block.toString().replace("_", " ") + " §ain §9" + getTimeString2(collectTime));
                    } else {
                        timerPaused();
                        collectTimeTask.cancel();
                        if (!choose.isCancelled()) {
                            choose.cancel();
                        }
                        if (!collect.isCancelled()) {
                            collect.cancel();
                        }
                        players.sendMessage("§koooooooooooooooooooo");
                        players.sendMessage(" ");
                        players.sendMessage("§aDie Anweisung wurde nicht befolgt!");
                        players.sendMessage("§aDer Seed war: §9" + Bukkit.getWorld("world").getSeed());
                        players.sendMessage(" ");
                        players.sendMessage("§koooooooooooooooooooo");
                        players.setGameMode(GameMode.SPECTATOR);
                        stopTimer();
                        time = 0;
                    }
                }
            }, rndTime2);
        }, rndTime);
    }


    public static void forceYCoordsRunnable() {
        Main.waitingForInstruction = true;
        Random rnd = new Random();
        int rndTime = rnd.nextInt((12000 - 6000) + 1) + 6000;
        choose = Bukkit.getScheduler().runTaskLater(Main.getPlugin(), () -> {
            Random rnd1 = new Random();
            int coord = rnd1.nextInt((256 - 5) + 1) + 5;
            Random rnd2 = new Random();
            int rndTime2 = rnd2.nextInt((6000 - 2400) + 1) + 2400;
            showTimeTask.cancel();
            collectTime = rndTime2 / 20;
            for (Player players : Bukkit.getOnlinePlayers()) {
                players.sendMessage("§aAnweisung: §9Y-" + coord + " §ain §9" + getTimeString2(collectTime));
            }
            collectTime = rndTime2 / 20;
            Main.waitingForInstruction = false;
            collectTimeTask = Bukkit.getScheduler().runTaskTimer(Main.getPlugin(), () -> {
                collectTime--;
                for (Player players : Bukkit.getOnlinePlayers()) {
                    players.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(
                            "§aAnweisung: §9Y-" + coord + " §ain §9" + getTimeString2(collectTime)));
                }
            }, 0L, 20L);
            collect = Bukkit.getScheduler().runTaskLater(Main.getPlugin(), () -> {
                showTime();
                collectTimeTask.cancel();
                for (Player players : Bukkit.getOnlinePlayers()) {
                    if (players.getLocation().getBlockY() == coord) {
                        if (!choose.isCancelled()) {
                            choose.cancel();
                        }
                        if (!collect.isCancelled()) {
                            collect.cancel();
                        }
                        forceYCoordsRunnable();
                        players.sendMessage("§aAnweisung befolgt.");
                    } else {
                        timerPaused();
                        collectTimeTask.cancel();
                        if (!choose.isCancelled()) {
                            choose.cancel();
                        }
                        if (!collect.isCancelled()) {
                            collect.cancel();
                        }
                        players.sendMessage("§koooooooooooooooooooo");
                        players.sendMessage(" ");
                        players.sendMessage("§aDie Anweisung wurde nicht befolgt!");
                        players.sendMessage("§aDer Seed war: §9" + Bukkit.getWorld("world").getSeed());
                        players.sendMessage(" ");
                        players.sendMessage("§koooooooooooooooooooo");
                        players.setGameMode(GameMode.SPECTATOR);
                        stopTimer();
                        time = 0;
                    }
                }
            }, rndTime2);
        }, rndTime);
    }

    public static void forceEntityRunnable() {
        Main.waitingForInstruction = true;
        Random rnd = new Random();
        int rndTime = rnd.nextInt((12000 - 6000) + 1) + 6000;
        choose = Bukkit.getScheduler().runTaskLater(Main.getPlugin(), () -> {
            Random rnd1 = new Random();
            EntityType entity = Main.entityList.get(rnd1.nextInt(Main.entityList.size()));
            Random rnd2 = new Random();
            int rndTime2 = rnd2.nextInt((6000 - 2400) + 1) + 2400;
            showTimeTask.cancel();
            collectTime = rndTime2 / 20;
            for (Player players : Bukkit.getOnlinePlayers()) {
                players.sendMessage("§aAnweisung: §9" + entity.toString().replace("_", " ") + " §ain §9" + getTimeString2(collectTime));
            }
            collectTime = rndTime2 / 20;
            Main.waitingForInstruction = false;
            collectTimeTask = Bukkit.getScheduler().runTaskTimer(Main.getPlugin(), () -> {
                collectTime--;
                for (Player players : Bukkit.getOnlinePlayers()) {
                    players.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent("§aAnweisung: §9" + entity.toString().replace("_", " ") + " §ain §9" + getTimeString2(collectTime)));
                }
            }, 0L, 20L);
            collect = Bukkit.getScheduler().runTaskLater(Main.getPlugin(), () -> {
                showTime();
                collectTimeTask.cancel();
                for (Player players : Bukkit.getOnlinePlayers()) {
                    timerPaused();
                    collectTimeTask.cancel();
                    if (!choose.isCancelled()) {
                        choose.cancel();
                    }
                    if (!collect.isCancelled()) {
                        collect.cancel();
                    }
                    players.sendMessage("§koooooooooooooooooooo");
                    players.sendMessage(" ");
                    players.sendMessage("§aDie Anweisung wurde nicht befolgt!");
                    players.sendMessage("§aDer Seed war: §9" + Bukkit.getWorld("world").getSeed());
                    players.sendMessage(" ");
                    players.sendMessage("§koooooooooooooooooooo");
                    players.setGameMode(GameMode.SPECTATOR);
                    stopTimer();
                    time = 0;
                }
            }, rndTime2);
        }, rndTime);
    }

    public static void forceBiomeRunnable() {
        Main.waitingForInstruction = true;
        Random rnd = new Random();
        int rndTime = rnd.nextInt((12000 - 6000) + 1) + 6000;
        choose = Bukkit.getScheduler().runTaskLater(Main.getPlugin(), () -> {
            Random rnd1 = new Random();
            Biome biome = Main.biomeList.get(rnd1.nextInt(Main.biomeList.size()));
            finalBiome.add(biome);
            Random rnd2 = new Random();
            int rndTime2 = rnd2.nextInt((6000 - 2400) + 1) + 2400;
            showTimeTask.cancel();
            collectTime = rndTime2 / 20;
            for (Player players : Bukkit.getOnlinePlayers()) {
                players.sendMessage("§6Ein Spieler muss innerhalb von §9" + getTimeString(collectTime) + " §6folgendes Biom betreten haben: §b" + biome.toString().replace("_", " "));
            }
            collectTime = rndTime2 / 20;
            Main.waitingForInstruction = false;
            collectTimeTask = Bukkit.getScheduler().runTaskTimer(Main.getPlugin(), () -> {
                collectTime--;
                for (Player players : Bukkit.getOnlinePlayers()) {
                    players.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent("§aAnweisung §9" + biome.toString().replace("_", " ") + " §ain: §9" + getTimeString(collectTime)));
                }
            }, 0L, 20L);
            collect = Bukkit.getScheduler().runTaskLater(Main.getPlugin(), () -> {
                showTime();
                collectTimeTask.cancel();
                for (Player players : Bukkit.getOnlinePlayers()) {
                    timerPaused();
                    collectTimeTask.cancel();
                    if (!choose.isCancelled()) {
                        choose.cancel();
                    }
                    if (!collect.isCancelled()) {
                        collect.cancel();
                    }
                    players.sendMessage("§koooooooooooooooooooo");
                    players.sendMessage(" ");
                    players.sendMessage("§aDie Anweisung wurde nicht befolgt!");
                    players.sendMessage("§aDer Seed war: §9" + Bukkit.getWorld("world").getSeed());
                    players.sendMessage(" ");
                    players.sendMessage("§koooooooooooooooooooo");
                    players.setGameMode(GameMode.SPECTATOR);
                    stopTimer();
                    time = 0;
                }
            }, rndTime2);
        }, rndTime);
    }


    @EventHandler
    public void entity(EntityDeathEvent event) {
        if (Settings.forceEntity) {
            if (!Main.waitingForInstruction) {
                if (!collect.isCancelled()) {
                    if (!(event.getEntity() instanceof Player)) {
                        if (event.getEntity().getKiller() instanceof Player) {
                            if (!entityList.contains(event.getEntityType())) {
                                entityList.add(event.getEntityType());
                            }
                            Bukkit.getScheduler().runTaskLater(Main.getPlugin(), () -> {
                                for (Player players : Bukkit.getOnlinePlayers()) {
                                    if (entityList.contains(event.getEntityType())) {
                                        entityList.clear();
                                        if (!choose.isCancelled()) {
                                            choose.cancel();
                                        }
                                        if (!collect.isCancelled()) {
                                            collect.cancel();
                                        }
                                        collectTimeTask.cancel();
                                        showTime();
                                        forceEntityRunnable();
                                        players.sendMessage("§aAnweisung befolgt.");
                                    }
                                }
                            }, 20L);
                        }
                    }
                }
            }
        }
    }

    @EventHandler
    public void onBiomeChange(PlayerMoveEvent event) {
        if (Main.timerRunning && Settings.forceBiome && !Main.waitingForInstruction) {
            if (event.getPlayer().getLocation().getBlock().getBiome().equals(finalBiome.get(0))) {
                finalBiome.clear();
                if (!choose.isCancelled()) {
                    choose.cancel();
                }
                if (!collect.isCancelled()) {
                    collect.cancel();
                }
                showTime();
                forceBiomeRunnable();
                Bukkit.broadcastMessage("§aAnweisung befolgt.");
                collectTimeTask.cancel();
            }
        }
    }

    @EventHandler
    public void timerDamage(EntityDamageEvent event) {
        if (!Main.timerRunning) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void timerFoodbar(FoodLevelChangeEvent event) {
        if (!Main.timerRunning) {
            event.setCancelled(true);
        }
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command cmd, String label, String[] args) {
        List<String> tabComplete = new ArrayList<String>();
        if (args.length == 1) {
            tabComplete.add("resume");
            tabComplete.add("pause");
            tabComplete.add("reset");
            tabComplete.add("set");
        } else if (args.length == 2) {
            if (args[0].equalsIgnoreCase("set")) {
                tabComplete.add("<Minuten>");
            }
        }
        return tabComplete;
    }

    public boolean isInt(String string) {
        try {
            Integer.parseInt(string);
        } catch (Throwable e) {
            return false;
        }
        return true;
    }
}
