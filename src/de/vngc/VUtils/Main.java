package de.vngc.VUtils;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Biome;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.craftbukkit.libs.org.apache.commons.io.FileUtils;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main extends JavaPlugin implements Listener {

    @Deprecated
    private static Main plugin;

    public World world;
    public static boolean timerRunning = false;
    public static boolean waitingForInstruction = true;
    public static ArrayList<Material> mat = new ArrayList<>();
    public static ArrayList<Material> matList = new ArrayList<>();
    public static ArrayList<Material> blockList = new ArrayList<>();
    public static ArrayList<Material> concreteList = new ArrayList<>();
    public static ArrayList<EntityType> entityList = new ArrayList<>();
    public static ArrayList<Biome> biomeList = new ArrayList<>();
    public static Inventory bp;
    public static Material[] normalMaterials = Material.values();
    public static EntityType[] normalEntities = EntityType.values();
    public static HashMap<Material, Material> randomBlockDrops;
    public static HashMap<EntityType, EntityType> randomEntities = new HashMap<>();

    @Deprecated
    public void onEnable() {
        plugin = this;

        randomBlockDrops = Stream.of(normalMaterials)
                .filter(mat -> mat != Material.AIR)
                .filter(mat -> mat.isItem())
                .collect(Collectors.toMap(Function.identity(),
                        mat -> normalMaterials[ThreadLocalRandom.current().nextInt(normalMaterials.length)],
                        (v1, v2) -> v1,
                        HashMap::new));

        randomEntities = Stream.of(normalEntities)
                .filter(ent -> ent.isAlive())
                .collect(Collectors.toMap(Function.identity(),
                        ent -> normalEntities[ThreadLocalRandom.current().nextInt(normalEntities.length)],
                        (v1, v2) -> v1,
                        HashMap::new));

        bp = Bukkit.createInventory(null, 36, "§6§lBackpack");
        blocks();
        blocks2();
        saveDefaultConfig();
        FileConfiguration config = getPlugin().getConfig();

        PluginManager pm = Bukkit.getServer().getPluginManager();
        pm.registerEvents(this, this);
        pm.registerEvents(new Settings(), this);
        pm.registerEvents(new Place(), this);
        pm.registerEvents(new Break(), this);
        pm.registerEvents(new CutClean(), this);
        pm.registerEvents(new ChatDamage(), this);
        pm.registerEvents(new Crafting(), this);
        pm.registerEvents(new Regeneration(), this);
        pm.registerEvents(new TimerClass(), this);
        pm.registerEvents(new Death(), this);
        pm.registerEvents(new Join_Leave(), this);
        pm.registerEvents(new Sneak(), this);
        pm.registerEvents(new Anger(), this);
        pm.registerEvents(new FallDamage(), this);
        pm.registerEvents(new XP(), this);
        pm.registerEvents(new Water(), this);
        pm.registerEvents(new ItemPickup(), this);
        pm.registerEvents(new BiomeChange(), this);
        pm.registerEvents(new Chat(), this);
        pm.registerEvents(new WorldLoading(), this);
        pm.registerEvents(new DamageMirror(), this);
        pm.registerEvents(new SplitDamage(), this);
        pm.registerEvents(new BingoSelect(), this);
        pm.registerEvents(new DamageClear(), this);
        pm.registerEvents(new Randomizer(), this);
        pm.registerEvents(new DoubleMobHealth(), this);
        pm.registerEvents(new MorePlayerDamage(), this);
        pm.registerEvents(new DaylightChange(), this);
        pm.registerEvents(new Timber(), this);
        pm.registerEvents(new AnvilChallenge(), this);


        getCommand("settings").setExecutor(new Settings());
        getCommand("reset").setExecutor(new Reset());
        getCommand("timer").setExecutor(new TimerClass());
        getCommand("position").setExecutor(new Position());
        getCommand("heal").setExecutor(new Heal());
        getCommand("backpack").setExecutor(new Backpack());
        getCommand("mute").setExecutor(new Mute());
        getCommand("invsee").setExecutor(new Invsee());
        getCommand("bingo").setExecutor(new BingoSelect());
        getCommand("gm").setExecutor(new GamemodeCommand());
        Bukkit.getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");
        TimerClass.timerPaused();

        getCommand("timer").setTabCompleter(new TimerClass());

        //-------------------------------------
        if (config.getBoolean("reset")) {
            try {
                FileUtils.deleteDirectory(new File("world"));
                FileUtils.deleteDirectory(new File("world_nether"));
                FileUtils.deleteDirectory(new File("world_the_end"));
                FileUtils.deleteDirectory(new File("world_mlg"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            config.set("reset", false);
            saveConfig();
        }

        Blocks.addBlocks();
        Blocks.addMaterials();
        Blocks.addEntities();
        Blocks.addConcrete();
        Blocks.addForbiddenEntities();
        Blocks.addBiomes();

        int pluginId = 7893;
        new Metrics(this, pluginId);

        UpdateChecker.init(this, 80158);

    }


    public ArrayList<Block> b = new ArrayList<>();

    public void blocks() {
        new BukkitRunnable() {
            public void run() {
                if (Settings.lavabool && Main.timerRunning)
                    for (Player players : Bukkit.getServer().getOnlinePlayers()) {
                        Block block = players.getLocation().getBlock().getRelative(BlockFace.DOWN);
                        Material previous = players.getLocation().getBlock().getRelative(BlockFace.DOWN).getType();
                        Main.this.b.add(block);
                        mat.add(previous);
                        Main.this.lava(block, previous);
                    }
            }
        }.runTaskTimer(this, 0L, 1L);
    }

    public void lava(final Block block, final Material previous) {
        Bukkit.getScheduler().scheduleSyncDelayedTask(getPlugin(), () -> {
            if (Settings.lavabool && Main.timerRunning &&
                    block.getType() != Material.AIR) {
                block.setType(Material.MAGMA_BLOCK);
                Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, () -> {
                    block.setType(Material.LAVA);
                    Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, () ->
                            block.setType(previous), 90L);
                }, 60L);
            }
        }, 30L);
    }

    public ArrayList<Block> b2 = new ArrayList<>();

    public void blocks2() {
        new BukkitRunnable() {
            public void run() {
                if (Settings.air && Main.timerRunning)
                    for (Player players : Bukkit.getServer().getOnlinePlayers()) {
                        Block block2 = players.getLocation().getBlock().getRelative(BlockFace.DOWN);
                        if (!Main.this.b2.contains(block2)) {
                            Main.this.b2.add(block2);
                            Main.this.air(block2);
                        }
                    }
            }
        }.runTaskTimer(this, 0L, 1L);
    }

    public void air(final Block block) {
        Bukkit.getScheduler().scheduleSyncDelayedTask(getPlugin(), new Runnable() {
            public void run() {
                if (Settings.air && Main.timerRunning &&
                        block.getType() != Material.AIR)
                    block.setType(Material.AIR);
            }
        }, 30L);
    }

    public static Main getPlugin() {
        return plugin;
    }

    public ArrayList<Block> getVerticalBlocks(World w, Double x, Double z) {
        ArrayList<Block> blocks = new ArrayList<>();
        for (int y = 0; y < w.getMaxHeight(); y++) {
            Location loc = new Location(w, x, y, z);
            blocks.add(loc.getBlock());
        }
        return blocks;
    }

    public void air2() {
        Bukkit.getScheduler().runTaskTimer(Main.getPlugin(), () -> {
            for (Player player : Bukkit.getOnlinePlayers()) {
                if (Main.timerRunning && Settings.air2) {
                    Block block = player.getLocation().getBlock().getRelative(BlockFace.DOWN);
                    World w = player.getWorld();
                    Double x = block.getLocation().getX();
                    Double z = block.getLocation().getZ();
                    ArrayList<Block> blocks = getVerticalBlocks(w, x, z);
                    Bukkit.getScheduler().runTaskLater(Main.getPlugin(), () -> {
                        for (Block b : blocks) {
                            if (!(b.getType() == Material.BEDROCK)) {
                                b.setType(Material.AIR);
                            }
                        }
                    }, 100L);
                }
            }
        }, 0L, 20L);
    }

    HashMap<Player, ItemStack[]> items = new HashMap<>();

    @EventHandler
    public void Death(final PlayerDeathEvent event) {
        Player player = event.getEntity();
        event.setDeathMessage(" ");
        if (Settings.keepinv) {
            ItemStack[] content = player.getInventory().getContents();
            this.items.put(player, content);
            player.getInventory().clear();
            Bukkit.getServer().getScheduler().runTaskLater(this, () -> {
                World world = event.getEntity().getWorld();
                List<Entity> entList = world.getEntities();
                for (Entity current : entList) {
                    if (current instanceof Item) {
                        current.remove();
                    }
                }
            }, 1L);
        }
    }


    @EventHandler
    public void Respawn(PlayerRespawnEvent event) {
        if (Settings.keepinv) {
            Player player = event.getPlayer();
            ItemStack[] content = this.items.get(player);
            if (content != null)
                player.getInventory().setContents(content);
        }
    }
}
