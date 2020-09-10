package de.vngc.VUtils;

import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitTask;

import java.util.ArrayList;
import java.util.Random;

public class BingoSelect implements CommandExecutor, Listener {

    public static Inventory bingoInv = Bukkit.createInventory(null, 9, "§b§lBingo-Items");
    public static ArrayList<Material> matList = new ArrayList<>();
    public static int startTime = 60;
    public static int runningTime;
    public static BukkitTask startTimer;
    public static BukkitTask runTimer;
    public static BukkitTask checkProgress;
    public static boolean gameStarting;
    public static boolean gameRunning;
    public static ArrayList<String> blue = new ArrayList<>();
    public static ArrayList<String> red = new ArrayList<>();
    public static ArrayList<String> green = new ArrayList<>();

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (args.length == 1) {
                if (args[0].equalsIgnoreCase("start")) {
                    if (!gameStarting && !gameRunning) {
                        Random rnd1 = new Random();
                        Random rnd2 = new Random();
                        Random rnd3 = new Random();
                        Random rnd4 = new Random();
                        Random rnd5 = new Random();
                        Random rnd6 = new Random();
                        Random rnd7 = new Random();
                        Random rnd8 = new Random();
                        Random rnd9 = new Random();

                        Material mat1 = Main.matList.get(rnd1.nextInt(Main.matList.size()));
                        Material mat2 = Main.matList.get(rnd2.nextInt(Main.matList.size()));
                        Material mat3 = Main.matList.get(rnd3.nextInt(Main.matList.size()));
                        Material mat4 = Main.matList.get(rnd4.nextInt(Main.matList.size()));
                        Material mat5 = Main.matList.get(rnd5.nextInt(Main.matList.size()));
                        Material mat6 = Main.matList.get(rnd6.nextInt(Main.matList.size()));
                        Material mat7 = Main.matList.get(rnd7.nextInt(Main.matList.size()));
                        Material mat8 = Main.matList.get(rnd8.nextInt(Main.matList.size()));
                        Material mat9 = Main.matList.get(rnd9.nextInt(Main.matList.size()));

                        matList.add(mat1);
                        matList.add(mat2);
                        matList.add(mat3);
                        matList.add(mat4);
                        matList.add(mat5);
                        matList.add(mat6);
                        matList.add(mat7);
                        matList.add(mat8);
                        matList.add(mat9);

                        gameStarting = true;
                        startTime = 60;
                        TimerClass.pausedTimer.cancel();

                        startTimer = Bukkit.getScheduler().runTaskTimer(Main.getPlugin(), () -> {
                            startTime--;
                            Bukkit.broadcastMessage("§6Bingo startet in §9" + startTime + " Sekunden");
                            if (startTime == 0) {
                                startTimer.cancel();
                                gameStarting = false;
                                gameRunning = true;
                                Bukkit.broadcastMessage("§aBingo wurde gestartet");
                                runTimer = Bukkit.getScheduler().runTaskTimer(Main.getPlugin(), () -> {
                                    runningTime++;
                                    for (Player players : Bukkit.getOnlinePlayers()) {
                                        players.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent("§6Bingo: " + getTimeString(runningTime)));
                                    }
                                }, 0L, 20L);
                            }
                        }, 0L, 20L);
                    }
                } else if (args[0].equalsIgnoreCase("forcestart")) {
                    Random rnd1 = new Random();
                    Random rnd2 = new Random();
                    Random rnd3 = new Random();
                    Random rnd4 = new Random();
                    Random rnd5 = new Random();
                    Random rnd6 = new Random();
                    Random rnd7 = new Random();
                    Random rnd8 = new Random();
                    Random rnd9 = new Random();

                    Material mat1 = Main.matList.get(rnd1.nextInt(Main.matList.size()));
                    Material mat2 = Main.matList.get(rnd2.nextInt(Main.matList.size()));
                    Material mat3 = Main.matList.get(rnd3.nextInt(Main.matList.size()));
                    Material mat4 = Main.matList.get(rnd4.nextInt(Main.matList.size()));
                    Material mat5 = Main.matList.get(rnd5.nextInt(Main.matList.size()));
                    Material mat6 = Main.matList.get(rnd6.nextInt(Main.matList.size()));
                    Material mat7 = Main.matList.get(rnd7.nextInt(Main.matList.size()));
                    Material mat8 = Main.matList.get(rnd8.nextInt(Main.matList.size()));
                    Material mat9 = Main.matList.get(rnd9.nextInt(Main.matList.size()));

                    matList.add(mat1);
                    matList.add(mat2);
                    matList.add(mat3);
                    matList.add(mat4);
                    matList.add(mat5);
                    matList.add(mat6);
                    matList.add(mat7);
                    matList.add(mat8);
                    matList.add(mat9);
                    TimerClass.pausedTimer.cancel();
                    gameStarting = false;
                    gameRunning = true;
                    Bukkit.broadcastMessage("§aBingo wurde gestartet");
                    runTimer = Bukkit.getScheduler().runTaskTimer(Main.getPlugin(), () -> {
                        runningTime++;
                        for (Player players : Bukkit.getOnlinePlayers()) {
                            players.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent("§6Bingo: " + getTimeString(runningTime)));
                        }
                    }, 0L, 20L);
                    checkProgress = Bukkit.getScheduler().runTaskTimer(Main.getPlugin(), () -> {
                        for (Player players : Bukkit.getOnlinePlayers()) {
                            if (players.getInventory().contains(mat1)
                                    && players.getInventory().contains(mat2)
                                    && players.getInventory().contains(mat3)
                                    && players.getInventory().contains(mat4)
                                    && players.getInventory().contains(mat5)
                                    && players.getInventory().contains(mat6)
                                    && players.getInventory().contains(mat7)
                                    && players.getInventory().contains(mat8)
                                    && players.getInventory().contains(mat9)) {
                                checkProgress.cancel();
                                runTimer.cancel();
                                gameRunning = false;
                                for (Player all : Bukkit.getOnlinePlayers()) {
                                    if (players.getPlayerListName().contains("§9Team 1")) {
                                        all.sendMessage("§aTeam 1 hat gewonnen!");
                                    } else if (players.getPlayerListName().contains("§cTeam 2")) {
                                        all.sendMessage("§aTeam 2 hat gewonnen!");
                                    } else if (players.getPlayerListName().contains("§aTeam 3")) {
                                        all.sendMessage("§aTeam 3 hat gewonnen!");
                                    }
                                    all.setGameMode(GameMode.SPECTATOR);
                                }
                            }
                        }
                    }, 0L, 10L);
                } else {
                    player.sendMessage("§cEines der eingegebenen Argumente existiert nicht oder ist falsch geschrieben");
                }
            } else if (args.length == 0) {
                if (gameRunning) {
                    Material mat1 = matList.get(0);
                    Material mat2 = matList.get(1);
                    Material mat3 = matList.get(2);
                    Material mat4 = matList.get(3);
                    Material mat5 = matList.get(4);
                    Material mat6 = matList.get(5);
                    Material mat7 = matList.get(6);
                    Material mat8 = matList.get(7);
                    Material mat9 = matList.get(8);

                    if (!player.getInventory().contains(mat1)) {
                        bingoInv.setItem(0, new ItemStack(mat1));
                    } else {
                        bingoInv.setItem(0, new ItemStack(Material.AIR));
                    }
                    if (!player.getInventory().contains(mat2)) {
                        bingoInv.setItem(1, new ItemStack(mat2));
                    } else {
                        bingoInv.setItem(1, new ItemStack(Material.AIR));
                    }
                    if (!player.getInventory().contains(mat3)) {
                        bingoInv.setItem(2, new ItemStack(mat3));
                    } else {
                        bingoInv.setItem(2, new ItemStack(Material.AIR));
                    }
                    if (!player.getInventory().contains(mat4)) {
                        bingoInv.setItem(3, new ItemStack(mat4));
                    } else {
                        bingoInv.setItem(3, new ItemStack(Material.AIR));
                    }
                    if (!player.getInventory().contains(mat5)) {
                        bingoInv.setItem(4, new ItemStack(mat5));
                    } else {
                        bingoInv.setItem(4, new ItemStack(Material.AIR));
                    }
                    if (!player.getInventory().contains(mat6)) {
                        bingoInv.setItem(5, new ItemStack(mat6));
                    } else {
                        bingoInv.setItem(5, new ItemStack(Material.AIR));
                    }
                    if (!player.getInventory().contains(mat7)) {
                        bingoInv.setItem(6, new ItemStack(mat7));
                    } else {
                        bingoInv.setItem(6, new ItemStack(Material.AIR));
                    }
                    if (!player.getInventory().contains(mat8)) {
                        bingoInv.setItem(7, new ItemStack(mat8));
                    } else {
                        bingoInv.setItem(7, new ItemStack(Material.AIR));
                    }
                    if (!player.getInventory().contains(mat9)) {
                        bingoInv.setItem(8, new ItemStack(mat9));
                    } else {
                        bingoInv.setItem(8, new ItemStack(Material.AIR));
                    }


                    player.openInventory(bingoInv);


                } else {
                    player.sendMessage("§6Bitte starte zuerst Bingo!");
                }
            } else if (args.length == 2) {
                if (args[0].equalsIgnoreCase("team")) {
                    if ((args[1].equalsIgnoreCase("1")) || (args[1].equalsIgnoreCase("blue"))) {
                        blue.add(player.getName());
                        if (red.contains(player.getName())) {
                            red.remove(player.getName());
                        }
                        if (green.contains(player.getName())) {
                            green.remove(player.getName());
                        }
                        player.setPlayerListName("§9Team 1 §7| §9" + player.getName());
                        Bukkit.broadcastMessage("§9" + player.getName() + " §aist §bTeam 1 §abeigetreten!");
                    } else if ((args[1].equalsIgnoreCase("2")) || (args[1].equalsIgnoreCase("red"))) {
                        red.add(player.getName());
                        if (blue.contains(player.getName())) {
                            blue.remove(player.getName());
                        }
                        if (green.contains(player.getName())) {
                            green.remove(player.getName());
                        }
                        player.setPlayerListName("§cTeam 2 §7| §c" + player.getName());
                        Bukkit.broadcastMessage("§9" + player.getName() + " §aist §cTeam 2 §abeigetreten!");

                    } else if ((args[1].equalsIgnoreCase("3")) || (args[1].equalsIgnoreCase("green"))) {
                        green.add(player.getName());
                        if (red.contains(player.getName())) {
                            red.remove(player.getName());
                        }
                        if (blue.contains(player.getName())) {
                            blue.remove(player.getName());
                        }
                        player.setPlayerListName("§aTeam 3 §7| §a" + player.getName());
                        Bukkit.broadcastMessage("§9" + player.getName() + " §aist §2Team 3 §abeigetreten!");

                    } else {
                        player.sendMessage("§aDieses Team existiert nicht!");
                    }
                }
            }
        }
        return false;
    }

    private static String getTimeString(int runningTime) {
        int hours = runningTime / 3600;
        int minutes = runningTime % 3600 / 60;
        int seconds = runningTime % 60;
        return String.format("§b%02d§7:§b%02d§7:§b%02d", new Object[]{
                Integer.valueOf(hours), Integer.valueOf(minutes), Integer.valueOf(seconds)});
    }

    @EventHandler
    public void onClick(InventoryClickEvent event) {
        if (event.getView().getTitle().equals("§b§lBingo-Items")) {
            event.setCancelled(true);
        }
    }
}
