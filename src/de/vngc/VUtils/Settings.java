package de.vngc.VUtils;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.Arrays;

public class Settings implements CommandExecutor, Listener {
    public static Inventory settings = Bukkit.createInventory(null, 54, "§6Challenge-Settings");
    public static Inventory settings2 = Bukkit.createInventory(null, 54, "§6Challenge-Settings §7| §62");
    public static Inventory gamerules = Bukkit.createInventory(null, 54, "§6Gamerule-Settings");
    public static Inventory findItems = Bukkit.createInventory(null, 54, "§bChallenge-Settings §7| §bvs");

    public static boolean blockplace = false;
    public static boolean blockbreak = false;
    public static boolean cutclean = Main.getPlugin().getConfig().getBoolean("cutclean");
    public static boolean chatdamage = Main.getPlugin().getConfig().getBoolean("chatdamage");
    public static boolean crafting = false;
    public static boolean keepinv = false;
    public static boolean air = false;
    public static boolean lavabool = false;
    public static int inthardcore = 1;
    public static boolean randomdrops = false;
    public static boolean sneak = false;
    public static boolean damage = false;
    public static int hp = 20;
    public static boolean falldmg = false;
    public static boolean xp = false;
    public static boolean mlg = false;
    public static boolean elytra = false;
    public static boolean diamond = false;
    public static boolean mycelium = false;
    public static boolean forceItem = false;
    public static boolean forceBlock = false;
    public static boolean air2 = false;
    public static boolean forceYCoord = false;
    public static int collectDamage = 0;
    public static boolean mirrorDamage = false;
    public static boolean splitHP = false;
    public static boolean damageClear = false;
    public static boolean randomCrafting = false;
    public static boolean forceEntity = false;
    public static boolean doubleHealth = false;
    public static int moreDamage = 0;
    public static boolean randomEntities = false;
    public static boolean timber = Main.getPlugin().getConfig().getBoolean("timber");
    public static boolean removeChunks = false;
    public static boolean fallingAnvil = false;
    public static boolean forceBiome = false;

    @Deprecated
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        ItemStack cobble = new ItemStack(Material.COBBLESTONE);
        ItemStack pickaxe = new ItemStack(Material.DIAMOND_PICKAXE);
        ItemStack disabled = new ItemStack(Material.RED_DYE);
        ItemStack enabled = new ItemStack(Material.LIME_DYE);
        ItemStack site2 = new ItemStack(Material.RED_MUSHROOM);
        ItemStack craftingtable = new ItemStack(Material.CRAFTING_TABLE);
        ItemStack airitem = new ItemStack(Material.GRASS_BLOCK);
        ItemStack lava = new ItemStack(Material.LAVA_BUCKET);
        ItemStack sneakItem = new ItemStack(Material.GOLDEN_BOOTS);
        ItemStack damageItem = new ItemStack(Material.RED_BED);

        ItemMeta cobblemeta = cobble.getItemMeta();
        ItemMeta pickaxemeta = pickaxe.getItemMeta();
        ItemMeta disabledmeta = disabled.getItemMeta();
        ItemMeta enabledmeta = enabled.getItemMeta();
        ItemMeta site2meta = site2.getItemMeta();
        ItemMeta craftingmeta = craftingtable.getItemMeta();
        ItemMeta airmeta = airitem.getItemMeta();
        ItemMeta lavameta = lava.getItemMeta();
        ItemMeta sneakmeta = sneakItem.getItemMeta();
        ItemMeta damageMeta = damageItem.getItemMeta();

        cobblemeta.setDisplayName("§6Block platzieren = Tod");
        pickaxemeta.setDisplayName("§6Block abbauen = Tod");
        disabledmeta.setDisplayName("§cdeaktiviert");
        enabledmeta.setDisplayName("§aaktiviert");
        site2meta.setDisplayName("§a§l->");
        craftingmeta.setDisplayName("§6Crafting = Tod");
        airmeta.setDisplayName("§6Der Boden verschwindet");
        lavameta.setDisplayName("§6Der Boden ist Lava");
        sneakmeta.setDisplayName("§6Sneak = Tod");
        damageMeta.setDisplayName("§6Schaden = Tod");
        cobble.setItemMeta(cobblemeta);
        pickaxe.setItemMeta(pickaxemeta);
        disabled.setItemMeta(disabledmeta);
        enabled.setItemMeta(enabledmeta);
        site2.setItemMeta(site2meta);
        craftingtable.setItemMeta(craftingmeta);
        airitem.setItemMeta(airmeta);
        lava.setItemMeta(lavameta);
        sneakItem.setItemMeta(sneakmeta);
        damageItem.setItemMeta(damageMeta);


        ItemStack hpItem = new ItemStack(Material.DEAD_BUSH);
        ItemStack hp1 = new ItemStack(Material.LIGHT_BLUE_DYE);
        ItemStack hp2 = new ItemStack(Material.LIGHT_BLUE_DYE);
        ItemStack hp3 = new ItemStack(Material.LIGHT_BLUE_DYE);
        ItemStack hp4 = new ItemStack(Material.LIGHT_BLUE_DYE);
        ItemStack hp5 = new ItemStack(Material.LIGHT_BLUE_DYE);
        ItemStack hp6 = new ItemStack(Material.LIGHT_BLUE_DYE);
        ItemStack hp7 = new ItemStack(Material.LIGHT_BLUE_DYE);
        ItemStack hp8 = new ItemStack(Material.LIGHT_BLUE_DYE);
        ItemStack hp9 = new ItemStack(Material.LIGHT_BLUE_DYE);
        ItemStack hp10 = new ItemStack(Material.LIGHT_BLUE_DYE);
        ItemStack hp11 = new ItemStack(Material.LIGHT_BLUE_DYE);
        ItemStack hp12 = new ItemStack(Material.LIGHT_BLUE_DYE);
        ItemStack hp13 = new ItemStack(Material.LIGHT_BLUE_DYE);
        ItemStack hp14 = new ItemStack(Material.LIGHT_BLUE_DYE);
        ItemStack hp15 = new ItemStack(Material.LIGHT_BLUE_DYE);
        ItemStack hp16 = new ItemStack(Material.LIGHT_BLUE_DYE);
        ItemStack hp17 = new ItemStack(Material.LIGHT_BLUE_DYE);
        ItemStack hp18 = new ItemStack(Material.LIGHT_BLUE_DYE);
        ItemStack hp19 = new ItemStack(Material.LIGHT_BLUE_DYE);
        ItemStack hp20 = new ItemStack(Material.LIGHT_BLUE_DYE);
        ItemMeta hpMeta = hpItem.getItemMeta();
        ItemMeta hpmeta1 = hp1.getItemMeta();
        ItemMeta hpmeta2 = hp1.getItemMeta();
        ItemMeta hpmeta3 = hp1.getItemMeta();
        ItemMeta hpmeta4 = hp1.getItemMeta();
        ItemMeta hpmeta5 = hp1.getItemMeta();
        ItemMeta hpmeta6 = hp1.getItemMeta();
        ItemMeta hpmeta7 = hp1.getItemMeta();
        ItemMeta hpmeta8 = hp1.getItemMeta();
        ItemMeta hpmeta9 = hp1.getItemMeta();
        ItemMeta hpmeta10 = hp1.getItemMeta();
        ItemMeta hpmeta11 = hp1.getItemMeta();
        ItemMeta hpmeta12 = hp1.getItemMeta();
        ItemMeta hpmeta13 = hp1.getItemMeta();
        ItemMeta hpmeta14 = hp1.getItemMeta();
        ItemMeta hpmeta15 = hp1.getItemMeta();
        ItemMeta hpmeta16 = hp1.getItemMeta();
        ItemMeta hpmeta17 = hp1.getItemMeta();
        ItemMeta hpmeta18 = hp1.getItemMeta();
        ItemMeta hpmeta19 = hp1.getItemMeta();
        ItemMeta hpmeta20 = hp1.getItemMeta();
        hpMeta.setDisplayName("§6HP");
        hpmeta1.setDisplayName("§cHP §7= §b1");
        hpmeta2.setDisplayName("§cHP §7= §b2");
        hpmeta3.setDisplayName("§cHP §7= §b3");
        hpmeta4.setDisplayName("§cHP §7= §b4");
        hpmeta5.setDisplayName("§cHP §7= §b5");
        hpmeta6.setDisplayName("§cHP §7= §b6");
        hpmeta7.setDisplayName("§cHP §7= §b7");
        hpmeta8.setDisplayName("§cHP §7= §b8");
        hpmeta9.setDisplayName("§cHP §7= §b9");
        hpmeta10.setDisplayName("§cHP §7= §b10");
        hpmeta11.setDisplayName("§cHP §7= §b11");
        hpmeta12.setDisplayName("§cHP §7= §b12");
        hpmeta13.setDisplayName("§cHP §7= §b13");
        hpmeta14.setDisplayName("§cHP §7= §b14");
        hpmeta15.setDisplayName("§cHP §7= §b15");
        hpmeta16.setDisplayName("§cHP §7= §b16");
        hpmeta17.setDisplayName("§cHP §7= §b17");
        hpmeta18.setDisplayName("§cHP §7= §b18");
        hpmeta19.setDisplayName("§cHP §7= §b19");
        hpmeta20.setDisplayName("§cHP §7= §b20");
        hpItem.setItemMeta(hpMeta);
        hp1.setItemMeta(hpmeta1);
        hp2.setItemMeta(hpmeta2);
        hp3.setItemMeta(hpmeta3);
        hp4.setItemMeta(hpmeta4);
        hp5.setItemMeta(hpmeta5);
        hp6.setItemMeta(hpmeta6);
        hp7.setItemMeta(hpmeta7);
        hp8.setItemMeta(hpmeta8);
        hp9.setItemMeta(hpmeta9);
        hp10.setItemMeta(hpmeta10);
        hp11.setItemMeta(hpmeta11);
        hp12.setItemMeta(hpmeta12);
        hp13.setItemMeta(hpmeta13);
        hp14.setItemMeta(hpmeta14);
        hp15.setItemMeta(hpmeta15);
        hp16.setItemMeta(hpmeta16);
        hp17.setItemMeta(hpmeta17);
        hp18.setItemMeta(hpmeta18);
        hp19.setItemMeta(hpmeta19);
        hp20.setItemMeta(hpmeta20);
        ItemStack fallItem = new ItemStack(Material.DIAMOND_BOOTS);
        ItemMeta fallMeta = fallItem.getItemMeta();
        fallMeta.setDisplayName("§6Fallschaden = Tod");
        fallItem.setItemMeta(fallMeta);
        ItemStack xpItem = new ItemStack(Material.EXPERIENCE_BOTTLE);
        ItemMeta xpMeta = xpItem.getItemMeta();
        xpMeta.setDisplayName("§6XP einsammeln = Tod");
        xpItem.setItemMeta(xpMeta);
        ItemStack mlgItem = new ItemStack(Material.WATER_BUCKET);
        ItemMeta mlgMeta = xpItem.getItemMeta();
        mlgMeta.setDisplayName("§6ForceMLG");
        mlgItem.setItemMeta(mlgMeta);
        ItemStack forceItemItem = new ItemStack(Material.RED_GLAZED_TERRACOTTA);
        ItemMeta forceItemMeta = forceItemItem.getItemMeta();
        forceItemMeta.setDisplayName("§6ForceItem");
        forceItemItem.setItemMeta(forceItemMeta);
        ItemStack forceBlockItem = new ItemStack(Material.GREEN_GLAZED_TERRACOTTA);
        ItemMeta forceBlockMeta = forceBlockItem.getItemMeta();
        forceBlockMeta.setDisplayName("§6ForceBlock");
        forceBlockItem.setItemMeta(forceBlockMeta);
        ItemStack air2Item = new ItemStack(Material.STICK);
        ItemMeta air2meta = air2Item.getItemMeta();
        air2meta.setDisplayName("§6Jackhammer-Challenge");
        air2Item.setItemMeta(air2meta);
        ItemStack yCoordItem = new ItemStack(Material.OAK_PLANKS);
        ItemMeta yCoordMeta = yCoordItem.getItemMeta();
        yCoordMeta.setDisplayName("§6ForceY");
        yCoordItem.setItemMeta(yCoordMeta);
        ItemStack collectItem = new ItemStack(Material.DIRT);
        ItemMeta collectMeta = collectItem.getItemMeta();
        collectMeta.setDisplayName("§6Neues Item einsammeln = Damage");
        collectItem.setItemMeta(collectMeta);
        ItemStack cd0 = new ItemStack(Material.LIGHT_BLUE_DYE);
        ItemStack cd1 = new ItemStack(Material.LIGHT_BLUE_DYE);
        ItemStack cd2 = new ItemStack(Material.LIGHT_BLUE_DYE);
        ItemStack cd3 = new ItemStack(Material.LIGHT_BLUE_DYE);
        ItemStack cd4 = new ItemStack(Material.LIGHT_BLUE_DYE);
        ItemStack cd5 = new ItemStack(Material.LIGHT_BLUE_DYE);
        ItemStack cd6 = new ItemStack(Material.LIGHT_BLUE_DYE);
        ItemStack cd7 = new ItemStack(Material.LIGHT_BLUE_DYE);
        ItemStack cd8 = new ItemStack(Material.LIGHT_BLUE_DYE);
        ItemStack cd9 = new ItemStack(Material.LIGHT_BLUE_DYE);
        ItemStack cd10 = new ItemStack(Material.LIGHT_BLUE_DYE);
        ItemStack cd11 = new ItemStack(Material.LIGHT_BLUE_DYE);
        ItemStack cd12 = new ItemStack(Material.LIGHT_BLUE_DYE);
        ItemStack cd13 = new ItemStack(Material.LIGHT_BLUE_DYE);
        ItemStack cd14 = new ItemStack(Material.LIGHT_BLUE_DYE);
        ItemStack cd15 = new ItemStack(Material.LIGHT_BLUE_DYE);
        ItemStack cd16 = new ItemStack(Material.LIGHT_BLUE_DYE);
        ItemStack cd17 = new ItemStack(Material.LIGHT_BLUE_DYE);
        ItemStack cd18 = new ItemStack(Material.LIGHT_BLUE_DYE);
        ItemStack cd19 = new ItemStack(Material.LIGHT_BLUE_DYE);
        ItemStack cd20 = new ItemStack(Material.LIGHT_BLUE_DYE);
        ItemMeta cdmeta0 = cd1.getItemMeta();
        ItemMeta cdmeta1 = cd1.getItemMeta();
        ItemMeta cdmeta2 = cd1.getItemMeta();
        ItemMeta cdmeta3 = cd1.getItemMeta();
        ItemMeta cdmeta4 = cd1.getItemMeta();
        ItemMeta cdmeta5 = cd1.getItemMeta();
        ItemMeta cdmeta6 = cd1.getItemMeta();
        ItemMeta cdmeta7 = cd1.getItemMeta();
        ItemMeta cdmeta8 = cd1.getItemMeta();
        ItemMeta cdmeta9 = cd1.getItemMeta();
        ItemMeta cdmeta10 = cd1.getItemMeta();
        ItemMeta cdmeta11 = cd1.getItemMeta();
        ItemMeta cdmeta12 = cd1.getItemMeta();
        ItemMeta cdmeta13 = cd1.getItemMeta();
        ItemMeta cdmeta14 = cd1.getItemMeta();
        ItemMeta cdmeta15 = cd1.getItemMeta();
        ItemMeta cdmeta16 = cd1.getItemMeta();
        ItemMeta cdmeta17 = cd1.getItemMeta();
        ItemMeta cdmeta18 = cd1.getItemMeta();
        ItemMeta cdmeta19 = cd1.getItemMeta();
        ItemMeta cdmeta20 = cd1.getItemMeta();
        cdmeta0.setDisplayName("§bDamage §7= §b0");
        cdmeta1.setDisplayName("§bDamage §7= §b0,5");
        cdmeta2.setDisplayName("§bDamage §7= §b1");
        cdmeta3.setDisplayName("§bDamage §7= §b1,5");
        cdmeta4.setDisplayName("§bDamage §7= §b2");
        cdmeta5.setDisplayName("§bDamage §7= §b2,5");
        cdmeta6.setDisplayName("§bDamage §7= §b3");
        cdmeta7.setDisplayName("§bDamage §7= §b3,5");
        cdmeta8.setDisplayName("§bDamage §7= §b4");
        cdmeta9.setDisplayName("§bDamage §7= §b4,5");
        cdmeta10.setDisplayName("§bDamage §7= §b5");
        cdmeta11.setDisplayName("§bDamage §7= §b5,5");
        cdmeta12.setDisplayName("§bDamage §7= §b6");
        cdmeta13.setDisplayName("§bDamage §7= §b6,5");
        cdmeta14.setDisplayName("§bDamage §7= §b7");
        cdmeta15.setDisplayName("§bDamage §7= §b7,5");
        cdmeta16.setDisplayName("§bDamage §7= §b8");
        cdmeta17.setDisplayName("§bDamage §7= §b8,5");
        cdmeta18.setDisplayName("§bDamage §7= §b9");
        cdmeta19.setDisplayName("§bDamage §7= §b9,5");
        cdmeta20.setDisplayName("§bDamage §7= §b10");
        cd0.setItemMeta(cdmeta0);
        cd1.setItemMeta(cdmeta1);
        cd2.setItemMeta(cdmeta2);
        cd3.setItemMeta(cdmeta3);
        cd4.setItemMeta(cdmeta4);
        cd5.setItemMeta(cdmeta5);
        cd6.setItemMeta(cdmeta6);
        cd7.setItemMeta(cdmeta7);
        cd8.setItemMeta(cdmeta8);
        cd9.setItemMeta(cdmeta9);
        cd10.setItemMeta(cdmeta10);
        cd11.setItemMeta(cdmeta11);
        cd12.setItemMeta(cdmeta12);
        cd13.setItemMeta(cdmeta13);
        cd14.setItemMeta(cdmeta14);
        cd15.setItemMeta(cdmeta15);
        cd16.setItemMeta(cdmeta16);
        cd17.setItemMeta(cdmeta17);
        cd18.setItemMeta(cdmeta18);
        cd19.setItemMeta(cdmeta19);
        cd20.setItemMeta(cdmeta20);
        ItemStack mirrorItem = new ItemStack(Material.BLUE_STAINED_GLASS_PANE);
        ItemMeta mirrorMeta = collectItem.getItemMeta();
        mirrorMeta.setDisplayName("§6Mirror-Challenge");
        mirrorItem.setItemMeta(mirrorMeta);
        ItemStack clearItem = new ItemStack(Material.SHIELD);
        ItemMeta clearMeta = clearItem.getItemMeta();
        clearMeta.setDisplayName("§6Damage-Clear");
        clearItem.setItemMeta(clearMeta);
        ItemStack challenge2 = new ItemStack(Material.SHIELD);
        ItemMeta challenge2Meta = challenge2.getItemMeta();
        challenge2Meta.setDisplayName("§6Challenges §7| §62");
        challenge2.setItemMeta(challenge2Meta);

        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (cmd.getName().equals("settings")) {
                settings.setItem(0, yCoordItem);
                settings.setItem(1, cobble);
                settings.setItem(2, pickaxe);
                settings.setItem(3, craftingtable);
                settings.setItem(4, airitem);
                settings.setItem(5, lava);
                settings.setItem(6, air2Item);
                settings.setItem(7, sneakItem);
                settings.setItem(8, collectItem);
                settings.setItem(27, mirrorItem);
                settings.setItem(28, damageItem);
                settings.setItem(29, hpItem);
                settings.setItem(30, fallItem);
                settings.setItem(31, xpItem);
                settings.setItem(32, mlgItem);
                settings.setItem(33, forceItemItem);
                settings.setItem(34, forceBlockItem);
                settings.setItem(35, clearItem);
                settings.setItem(26, site2);
                settings.setItem(49, challenge2);
                if (forceYCoord) {
                    settings.setItem(9, enabled);
                } else {
                    settings.setItem(9, disabled);
                }
                if (blockplace) {
                    settings.setItem(10, enabled);
                } else {
                    settings.setItem(10, disabled);
                }
                if (blockbreak) {
                    settings.setItem(11, enabled);
                } else {
                    settings.setItem(11, disabled);
                }
                if (crafting) {
                    settings.setItem(12, enabled);
                } else {
                    settings.setItem(12, disabled);
                }
                if (air) {
                    settings.setItem(13, enabled);
                } else {
                    settings.setItem(13, disabled);
                }
                if (lavabool) {
                    settings.setItem(14, enabled);
                } else {
                    settings.setItem(14, disabled);
                }
                if (air2) {
                    settings.setItem(15, enabled);
                } else {
                    settings.setItem(15, disabled);
                }
                if (sneak) {
                    settings.setItem(16, enabled);
                } else {
                    settings.setItem(16, disabled);
                }

                if (collectDamage == 0) {
                    settings.setItem(17, cd0);
                } else if (collectDamage == 1) {
                    settings.setItem(17, cd1);
                } else if (collectDamage == 2) {
                    settings.setItem(17, cd2);
                } else if (collectDamage == 3) {
                    settings.setItem(17, cd3);
                } else if (collectDamage == 4) {
                    settings.setItem(17, cd4);
                } else if (collectDamage == 5) {
                    settings.setItem(17, cd5);
                } else if (collectDamage == 6) {
                    settings.setItem(17, cd6);
                } else if (collectDamage == 7) {
                    settings.setItem(17, cd7);
                } else if (collectDamage == 8) {
                    settings.setItem(17, cd8);
                } else if (collectDamage == 9) {
                    settings.setItem(17, cd9);
                } else if (collectDamage == 10) {
                    settings.setItem(17, cd10);
                } else if (collectDamage == 11) {
                    settings.setItem(17, cd11);
                } else if (collectDamage == 12) {
                    settings.setItem(17, cd12);
                } else if (collectDamage == 13) {
                    settings.setItem(17, cd13);
                } else if (collectDamage == 14) {
                    settings.setItem(17, cd14);
                } else if (collectDamage == 15) {
                    settings.setItem(17, cd15);
                } else if (collectDamage == 16) {
                    settings.setItem(17, cd16);
                } else if (collectDamage == 17) {
                    settings.setItem(17, cd17);
                } else if (collectDamage == 18) {
                    settings.setItem(17, cd18);
                } else if (collectDamage == 19) {
                    settings.setItem(17, cd19);
                } else if (collectDamage == 20) {
                    settings.setItem(17, cd20);
                }
                if (mirrorDamage) {
                    settings.setItem(36, enabled);
                } else {
                    settings.setItem(36, disabled);
                }
                if (damage) {
                    settings.setItem(37, enabled);
                } else {
                    settings.setItem(37, disabled);
                }
                if (hp == 1) {
                    settings.setItem(38, hp1);
                } else if (hp == 2) {
                    settings.setItem(38, hp2);
                } else if (hp == 3) {
                    settings.setItem(38, hp3);
                } else if (hp == 4) {
                    settings.setItem(38, hp4);
                } else if (hp == 5) {
                    settings.setItem(38, hp5);
                } else if (hp == 6) {
                    settings.setItem(38, hp6);
                } else if (hp == 7) {
                    settings.setItem(38, hp7);
                } else if (hp == 8) {
                    settings.setItem(38, hp8);
                } else if (hp == 9) {
                    settings.setItem(38, hp9);
                } else if (hp == 10) {
                    settings.setItem(38, hp10);
                } else if (hp == 11) {
                    settings.setItem(38, hp11);
                } else if (hp == 12) {
                    settings.setItem(38, hp12);
                } else if (hp == 13) {
                    settings.setItem(38, hp13);
                } else if (hp == 14) {
                    settings.setItem(38, hp14);
                } else if (hp == 15) {
                    settings.setItem(38, hp15);
                } else if (hp == 16) {
                    settings.setItem(38, hp16);
                } else if (hp == 17) {
                    settings.setItem(38, hp17);
                } else if (hp == 18) {
                    settings.setItem(38, hp18);
                } else if (hp == 19) {
                    settings.setItem(38, hp19);
                } else if (hp == 20) {
                    settings.setItem(38, hp20);
                }
                if (falldmg) {
                    settings.setItem(39, enabled);
                } else {
                    settings.setItem(39, disabled);
                }
                if (xp) {
                    settings.setItem(40, enabled);
                } else {
                    settings.setItem(40, disabled);
                }
                if (mlg) {
                    settings.setItem(41, enabled);
                } else {
                    settings.setItem(41, disabled);
                }
                if (forceItem) {
                    settings.setItem(42, enabled);
                } else {
                    settings.setItem(42, disabled);
                }
                if (forceBlock) {
                    settings.setItem(43, enabled);
                } else {
                    settings.setItem(43, disabled);
                }
                if (damageClear) {
                    settings.setItem(44, enabled);
                } else {
                    settings.setItem(44, disabled);
                }
                player.openInventory(settings);
            }
        }
        return false;
    }

    @Deprecated
    @EventHandler
    public void handleClick(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();
        if (event.getCurrentItem() != null) {
            ItemStack disabled = new ItemStack(Material.RED_DYE);
            ItemStack enabled = new ItemStack(Material.LIME_DYE);
            ItemStack cobble = new ItemStack(Material.COBBLESTONE);
            ItemStack pickaxe = new ItemStack(Material.DIAMOND_PICKAXE);
            ItemStack cutcleanitem = new ItemStack(Material.IRON_INGOT);
            ItemStack chatdamageitem = new ItemStack(Material.RED_STAINED_GLASS);
            ItemStack craftingtable = new ItemStack(Material.CRAFTING_TABLE);
            ItemStack hardcore = new ItemStack(Material.INK_SAC);
            ItemStack uhc = new ItemStack(Material.APPLE);
            ItemStack uuhc = new ItemStack(Material.GOLDEN_APPLE);
            ItemStack uhcenabled = new ItemStack(Material.RED_DYE);
            ItemStack keepinvitem = new ItemStack(Material.CHEST);
            ItemStack lava = new ItemStack(Material.LAVA_BUCKET);
            ItemStack airitem = new ItemStack(Material.GRASS_BLOCK);
            ItemStack site1 = new ItemStack(Material.BROWN_MUSHROOM);
            ItemStack site2 = new ItemStack(Material.RED_MUSHROOM);
            ItemStack sneakitem = new ItemStack(Material.GOLDEN_BOOTS);
            ItemStack damageItem = new ItemStack(Material.RED_BED);

            ItemMeta disabledmeta = disabled.getItemMeta();
            ItemMeta enabledmeta = enabled.getItemMeta();
            ItemMeta cobblemeta = cobble.getItemMeta();
            ItemMeta pickaxemeta = pickaxe.getItemMeta();
            ItemMeta cutcleanmeta = cutcleanitem.getItemMeta();
            ItemMeta chatdamagemeta = chatdamageitem.getItemMeta();
            ItemMeta craftingmeta = craftingtable.getItemMeta();
            ItemMeta hardcoremeta = hardcore.getItemMeta();
            ItemMeta uhcmeta = uhc.getItemMeta();
            ItemMeta uuhcmeta = uuhc.getItemMeta();
            ItemMeta uhcenabledmeta = uhcenabled.getItemMeta();
            ItemMeta keepinvmeta = keepinvitem.getItemMeta();
            ItemMeta airmeta = airitem.getItemMeta();
            ItemMeta lavameta = lava.getItemMeta();
            ItemMeta site1meta = site1.getItemMeta();
            ItemMeta site2meta = site2.getItemMeta();
            ItemMeta sneakmeta = sneakitem.getItemMeta();
            ItemMeta damageMeta = damageItem.getItemMeta();

            cobblemeta.setDisplayName("§6Block platzieren = Tod");
            pickaxemeta.setDisplayName("§6Block abbauen = Tod");
            disabledmeta.setDisplayName("§cdeaktiviert");
            enabledmeta.setDisplayName("§aaktiviert");
            cutcleanmeta.setDisplayName("§6CutClean");
            chatdamagemeta.setDisplayName("§6ChatDamage");
            craftingmeta.setDisplayName("Crafting = Tod");
            hardcoremeta.setDisplayName("§6Regeneration");
            site2meta.setDisplayName("§a§l->");
            uhcmeta.setDisplayName("§aRegeneration aktiviert");
            uuhcmeta.setDisplayName("§cNatürliche Regeneration deaktiviert");
            uhcenabledmeta.setDisplayName("§cRegeneration deaktiviert");
            keepinvmeta.setDisplayName("§6Keep-Inventory");
            airmeta.setDisplayName("§6Der Boden verschwindet");
            lavameta.setDisplayName("§6Der Boden ist Lava");
            site1meta.setDisplayName("§c§l<-");
            sneakmeta.setDisplayName("§6Sneak = Tod");
            damageMeta.setDisplayName("§6Schaden = Tod");

            site2.setItemMeta(site2meta);
            cobble.setItemMeta(cobblemeta);
            pickaxe.setItemMeta(pickaxemeta);
            disabled.setItemMeta(disabledmeta);
            enabled.setItemMeta(enabledmeta);
            cutcleanitem.setItemMeta(cutcleanmeta);
            chatdamageitem.setItemMeta(chatdamagemeta);
            craftingtable.setItemMeta(craftingmeta);
            hardcore.setItemMeta(hardcoremeta);
            uhcenabled.setItemMeta(uhcenabledmeta);
            uhc.setItemMeta(uhcmeta);
            uuhc.setItemMeta(uuhcmeta);
            keepinvitem.setItemMeta(keepinvmeta);
            airitem.setItemMeta(airmeta);
            lava.setItemMeta(lavameta);
            site1.setItemMeta(site1meta);
            sneakitem.setItemMeta(sneakmeta);
            damageItem.setItemMeta(damageMeta);

            ItemStack settings2Item = new ItemStack(Material.RED_MUSHROOM);
            ItemMeta settings2Meta = settings2Item.getItemMeta();
            settings2Meta.setDisplayName("§a§l->");
            settings2Item.setItemMeta(settings2Meta);
            ItemStack elytraItem = new ItemStack(Material.ELYTRA);
            ItemMeta elytraMeta = elytraItem.getItemMeta();
            elytraMeta.setDisplayName("§6Elytra finden");
            elytraItem.setItemMeta(elytraMeta);
            ItemStack diamondItem = new ItemStack(Material.DIAMOND);
            ItemMeta diamondMeta = diamondItem.getItemMeta();
            diamondMeta.setDisplayName("§6Diamanten finden");
            diamondItem.setItemMeta(diamondMeta);
            ItemStack mycelItem = new ItemStack(Material.MYCELIUM);
            ItemMeta mycelMeta = mycelItem.getItemMeta();
            mycelMeta.setDisplayName("§6Myzel-Biom finden");
            mycelItem.setItemMeta(mycelMeta);
            ItemStack hpItem = new ItemStack(Material.DEAD_BUSH);
            ItemStack hp1 = new ItemStack(Material.LIGHT_BLUE_DYE);
            ItemStack hp2 = new ItemStack(Material.LIGHT_BLUE_DYE);
            ItemStack hp3 = new ItemStack(Material.LIGHT_BLUE_DYE);
            ItemStack hp4 = new ItemStack(Material.LIGHT_BLUE_DYE);
            ItemStack hp5 = new ItemStack(Material.LIGHT_BLUE_DYE);
            ItemStack hp6 = new ItemStack(Material.LIGHT_BLUE_DYE);
            ItemStack hp7 = new ItemStack(Material.LIGHT_BLUE_DYE);
            ItemStack hp8 = new ItemStack(Material.LIGHT_BLUE_DYE);
            ItemStack hp9 = new ItemStack(Material.LIGHT_BLUE_DYE);
            ItemStack hp10 = new ItemStack(Material.LIGHT_BLUE_DYE);
            ItemStack hp11 = new ItemStack(Material.LIGHT_BLUE_DYE);
            ItemStack hp12 = new ItemStack(Material.LIGHT_BLUE_DYE);
            ItemStack hp13 = new ItemStack(Material.LIGHT_BLUE_DYE);
            ItemStack hp14 = new ItemStack(Material.LIGHT_BLUE_DYE);
            ItemStack hp15 = new ItemStack(Material.LIGHT_BLUE_DYE);
            ItemStack hp16 = new ItemStack(Material.LIGHT_BLUE_DYE);
            ItemStack hp17 = new ItemStack(Material.LIGHT_BLUE_DYE);
            ItemStack hp18 = new ItemStack(Material.LIGHT_BLUE_DYE);
            ItemStack hp19 = new ItemStack(Material.LIGHT_BLUE_DYE);
            ItemStack hp20 = new ItemStack(Material.LIGHT_BLUE_DYE);
            ItemMeta hpMeta = hpItem.getItemMeta();
            ItemMeta hpmeta1 = hp1.getItemMeta();
            ItemMeta hpmeta2 = hp1.getItemMeta();
            ItemMeta hpmeta3 = hp1.getItemMeta();
            ItemMeta hpmeta4 = hp1.getItemMeta();
            ItemMeta hpmeta5 = hp1.getItemMeta();
            ItemMeta hpmeta6 = hp1.getItemMeta();
            ItemMeta hpmeta7 = hp1.getItemMeta();
            ItemMeta hpmeta8 = hp1.getItemMeta();
            ItemMeta hpmeta9 = hp1.getItemMeta();
            ItemMeta hpmeta10 = hp1.getItemMeta();
            ItemMeta hpmeta11 = hp1.getItemMeta();
            ItemMeta hpmeta12 = hp1.getItemMeta();
            ItemMeta hpmeta13 = hp1.getItemMeta();
            ItemMeta hpmeta14 = hp1.getItemMeta();
            ItemMeta hpmeta15 = hp1.getItemMeta();
            ItemMeta hpmeta16 = hp1.getItemMeta();
            ItemMeta hpmeta17 = hp1.getItemMeta();
            ItemMeta hpmeta18 = hp1.getItemMeta();
            ItemMeta hpmeta19 = hp1.getItemMeta();
            ItemMeta hpmeta20 = hp1.getItemMeta();
            hpMeta.setDisplayName("§6Maximale HP");
            hpmeta1.setDisplayName("§cHP §7= §b1");
            hpmeta2.setDisplayName("§cHP §7= §b2");
            hpmeta3.setDisplayName("§cHP §7= §b3");
            hpmeta4.setDisplayName("§cHP §7= §b4");
            hpmeta5.setDisplayName("§cHP §7= §b5");
            hpmeta6.setDisplayName("§cHP §7= §b6");
            hpmeta7.setDisplayName("§cHP §7= §b7");
            hpmeta8.setDisplayName("§cHP §7= §b8");
            hpmeta9.setDisplayName("§cHP §7= §b9");
            hpmeta10.setDisplayName("§cHP §7= §b10");
            hpmeta11.setDisplayName("§cHP §7= §b11");
            hpmeta12.setDisplayName("§cHP §7= §b12");
            hpmeta13.setDisplayName("§cHP §7= §b13");
            hpmeta14.setDisplayName("§cHP §7= §b14");
            hpmeta15.setDisplayName("§cHP §7= §b15");
            hpmeta16.setDisplayName("§cHP §7= §b16");
            hpmeta17.setDisplayName("§cHP §7= §b17");
            hpmeta18.setDisplayName("§cHP §7= §b18");
            hpmeta19.setDisplayName("§cHP §7= §b19");
            hpmeta20.setDisplayName("§cHP §7= §b20");
            hpItem.setItemMeta(hpMeta);
            hp1.setItemMeta(hpmeta1);
            hp2.setItemMeta(hpmeta2);
            hp3.setItemMeta(hpmeta3);
            hp4.setItemMeta(hpmeta4);
            hp5.setItemMeta(hpmeta5);
            hp6.setItemMeta(hpmeta6);
            hp7.setItemMeta(hpmeta7);
            hp8.setItemMeta(hpmeta8);
            hp9.setItemMeta(hpmeta9);
            hp10.setItemMeta(hpmeta10);
            hp11.setItemMeta(hpmeta11);
            hp12.setItemMeta(hpmeta12);
            hp13.setItemMeta(hpmeta13);
            hp14.setItemMeta(hpmeta14);
            hp15.setItemMeta(hpmeta15);
            hp16.setItemMeta(hpmeta16);
            hp17.setItemMeta(hpmeta17);
            hp18.setItemMeta(hpmeta18);
            hp19.setItemMeta(hpmeta19);
            hp20.setItemMeta(hpmeta20);
            ItemStack fallItem = new ItemStack(Material.DIAMOND_BOOTS);
            ItemMeta fallMeta = fallItem.getItemMeta();
            fallMeta.setDisplayName("§6Fallschaden = Tod");
            fallItem.setItemMeta(fallMeta);
            ItemStack xpItem = new ItemStack(Material.EXPERIENCE_BOTTLE);
            ItemMeta xpMeta = xpItem.getItemMeta();
            xpMeta.setDisplayName("§6XP einsammeln = Tod");
            xpItem.setItemMeta(xpMeta);
            ItemStack mlgItem = new ItemStack(Material.WATER_BUCKET);
            ItemMeta mlgMeta = xpItem.getItemMeta();
            mlgMeta.setDisplayName("§6ForceMLG");
            mlgItem.setItemMeta(mlgMeta);
            ItemStack forceItemItem = new ItemStack(Material.RED_GLAZED_TERRACOTTA);
            ItemMeta forceItemMeta = forceItemItem.getItemMeta();
            forceItemMeta.setDisplayName("§6ForceItem");
            forceItemItem.setItemMeta(forceItemMeta);
            ItemStack forceBlockItem = new ItemStack(Material.GREEN_GLAZED_TERRACOTTA);
            ItemMeta forceBlockMeta = forceBlockItem.getItemMeta();
            forceBlockMeta.setDisplayName("§6ForceBlock");
            forceBlockItem.setItemMeta(forceBlockMeta);
            ItemStack air2Item = new ItemStack(Material.STICK);
            ItemMeta air2meta = air2Item.getItemMeta();
            air2meta.setDisplayName("Jackhammer-Challenge");
            air2Item.setItemMeta(air2meta);
            ItemStack yCoordItem = new ItemStack(Material.OAK_PLANKS);
            ItemMeta yCoordMeta = yCoordItem.getItemMeta();
            yCoordMeta.setDisplayName("§6ForceY");
            yCoordItem.setItemMeta(yCoordMeta);
            ItemStack collectItem = new ItemStack(Material.DIRT);
            ItemMeta collectMeta = collectItem.getItemMeta();
            collectMeta.setDisplayName("§6Neues Item einsammeln = Damage");
            collectItem.setItemMeta(collectMeta);
            ItemStack cd0 = new ItemStack(Material.LIGHT_BLUE_DYE);
            ItemStack cd1 = new ItemStack(Material.LIGHT_BLUE_DYE);
            ItemStack cd2 = new ItemStack(Material.LIGHT_BLUE_DYE);
            ItemStack cd3 = new ItemStack(Material.LIGHT_BLUE_DYE);
            ItemStack cd4 = new ItemStack(Material.LIGHT_BLUE_DYE);
            ItemStack cd5 = new ItemStack(Material.LIGHT_BLUE_DYE);
            ItemStack cd6 = new ItemStack(Material.LIGHT_BLUE_DYE);
            ItemStack cd7 = new ItemStack(Material.LIGHT_BLUE_DYE);
            ItemStack cd8 = new ItemStack(Material.LIGHT_BLUE_DYE);
            ItemStack cd9 = new ItemStack(Material.LIGHT_BLUE_DYE);
            ItemStack cd10 = new ItemStack(Material.LIGHT_BLUE_DYE);
            ItemStack cd11 = new ItemStack(Material.LIGHT_BLUE_DYE);
            ItemStack cd12 = new ItemStack(Material.LIGHT_BLUE_DYE);
            ItemStack cd13 = new ItemStack(Material.LIGHT_BLUE_DYE);
            ItemStack cd14 = new ItemStack(Material.LIGHT_BLUE_DYE);
            ItemStack cd15 = new ItemStack(Material.LIGHT_BLUE_DYE);
            ItemStack cd16 = new ItemStack(Material.LIGHT_BLUE_DYE);
            ItemStack cd17 = new ItemStack(Material.LIGHT_BLUE_DYE);
            ItemStack cd18 = new ItemStack(Material.LIGHT_BLUE_DYE);
            ItemStack cd19 = new ItemStack(Material.LIGHT_BLUE_DYE);
            ItemStack cd20 = new ItemStack(Material.LIGHT_BLUE_DYE);
            ItemMeta cdmeta0 = cd1.getItemMeta();
            ItemMeta cdmeta1 = cd1.getItemMeta();
            ItemMeta cdmeta2 = cd1.getItemMeta();
            ItemMeta cdmeta3 = cd1.getItemMeta();
            ItemMeta cdmeta4 = cd1.getItemMeta();
            ItemMeta cdmeta5 = cd1.getItemMeta();
            ItemMeta cdmeta6 = cd1.getItemMeta();
            ItemMeta cdmeta7 = cd1.getItemMeta();
            ItemMeta cdmeta8 = cd1.getItemMeta();
            ItemMeta cdmeta9 = cd1.getItemMeta();
            ItemMeta cdmeta10 = cd1.getItemMeta();
            ItemMeta cdmeta11 = cd1.getItemMeta();
            ItemMeta cdmeta12 = cd1.getItemMeta();
            ItemMeta cdmeta13 = cd1.getItemMeta();
            ItemMeta cdmeta14 = cd1.getItemMeta();
            ItemMeta cdmeta15 = cd1.getItemMeta();
            ItemMeta cdmeta16 = cd1.getItemMeta();
            ItemMeta cdmeta17 = cd1.getItemMeta();
            ItemMeta cdmeta18 = cd1.getItemMeta();
            ItemMeta cdmeta19 = cd1.getItemMeta();
            ItemMeta cdmeta20 = cd1.getItemMeta();
            cdmeta0.setDisplayName("§bDamage §7= §b0");
            cdmeta1.setDisplayName("§bDamage §7= §b0,5");
            cdmeta2.setDisplayName("§bDamage §7= §b1");
            cdmeta3.setDisplayName("§bDamage §7= §b1,5");
            cdmeta4.setDisplayName("§bDamage §7= §b2");
            cdmeta5.setDisplayName("§bDamage §7= §b2,5");
            cdmeta6.setDisplayName("§bDamage §7= §b3");
            cdmeta7.setDisplayName("§bDamage §7= §b3,5");
            cdmeta8.setDisplayName("§bDamage §7= §b4");
            cdmeta9.setDisplayName("§bDamage §7= §b4,5");
            cdmeta10.setDisplayName("§bDamage §7= §b5");
            cdmeta11.setDisplayName("§bDamage §7= §b5,5");
            cdmeta12.setDisplayName("§bDamage §7= §b6");
            cdmeta13.setDisplayName("§bDamage §7= §b6,5");
            cdmeta14.setDisplayName("§bDamage §7= §b7");
            cdmeta15.setDisplayName("§bDamage §7= §b7,5");
            cdmeta16.setDisplayName("§bDamage §7= §b8");
            cdmeta17.setDisplayName("§bDamage §7= §b8,5");
            cdmeta18.setDisplayName("§bDamage §7= §b9");
            cdmeta19.setDisplayName("§bDamage §7= §b9,5");
            cdmeta20.setDisplayName("§bDamage §7= §b10");
            cd0.setItemMeta(cdmeta0);
            cd1.setItemMeta(cdmeta1);
            cd2.setItemMeta(cdmeta2);
            cd3.setItemMeta(cdmeta3);
            cd4.setItemMeta(cdmeta4);
            cd5.setItemMeta(cdmeta5);
            cd6.setItemMeta(cdmeta6);
            cd7.setItemMeta(cdmeta7);
            cd8.setItemMeta(cdmeta8);
            cd9.setItemMeta(cdmeta9);
            cd10.setItemMeta(cdmeta10);
            cd11.setItemMeta(cdmeta11);
            cd12.setItemMeta(cdmeta12);
            cd13.setItemMeta(cdmeta13);
            cd14.setItemMeta(cdmeta14);
            cd15.setItemMeta(cdmeta15);
            cd16.setItemMeta(cdmeta16);
            cd17.setItemMeta(cdmeta17);
            cd18.setItemMeta(cdmeta18);
            cd19.setItemMeta(cdmeta19);
            cd20.setItemMeta(cdmeta20);
            ItemStack mirrorItem = new ItemStack(Material.BLUE_STAINED_GLASS_PANE);
            ItemMeta mirrorMeta = collectItem.getItemMeta();
            mirrorMeta.setDisplayName("§6Mirror-Challenge");
            mirrorItem.setItemMeta(mirrorMeta);
            ItemStack splitItem = new ItemStack(Material.RED_GLAZED_TERRACOTTA);
            ItemMeta splitMeta = splitItem.getItemMeta();
            splitMeta.setDisplayName("§6Split-Health");
            splitItem.setItemMeta(splitMeta);
            ItemStack clearItem = new ItemStack(Material.SHIELD);
            ItemMeta clearMeta = clearItem.getItemMeta();
            clearMeta.setDisplayName("§6Damage-Clear");
            clearItem.setItemMeta(clearMeta);
            ItemStack randomItems = new ItemStack(Material.NETHER_STAR);
            ItemMeta randomMeta = randomItems.getItemMeta();
            randomMeta.setDisplayName("§6Zufällige Block-Drops");
            randomItems.setItemMeta(randomMeta);
            ItemStack randomCraftingItem = new ItemStack(Material.CRAFTING_TABLE);
            ItemMeta randomCraftingMeta = randomCraftingItem.getItemMeta();
            randomCraftingMeta.setDisplayName("§6Zufällige Crafting-Results");
            randomCraftingItem.setItemMeta(randomCraftingMeta);
            ItemStack challenge1 = new ItemStack(Material.RED_STAINED_GLASS_PANE);
            ItemMeta challenge1Meta = challenge1.getItemMeta();
            challenge1Meta.setDisplayName("§6Challenges §7| §61");
            challenge1.setItemMeta(challenge1Meta);
            ItemStack challenge2 = new ItemStack(Material.BLUE_STAINED_GLASS_PANE);
            ItemMeta challenge2Meta = challenge2.getItemMeta();
            challenge2Meta.setDisplayName("§6Challenges §7| §62");
            challenge2.setItemMeta(challenge2Meta);
            ItemStack forceEntityItem = new ItemStack(Material.CHICKEN_SPAWN_EGG);
            ItemMeta forceEntityMeta = forceEntityItem.getItemMeta();
            forceEntityMeta.setDisplayName("§6ForceEntity");
            forceEntityItem.setItemMeta(forceEntityMeta);
            ItemStack doubleHealthItem = new ItemStack(Material.ZOMBIE_HEAD);
            ItemMeta doubleHealthMeta = doubleHealthItem.getItemMeta();
            doubleHealthMeta.setDisplayName("§6Mob-Health");
            doubleHealthItem.setItemMeta(doubleHealthMeta);
            ItemStack moreDamageItem = new ItemStack(Material.CREEPER_HEAD);
            ItemMeta moreDamageMeta = moreDamageItem.getItemMeta();
            moreDamageMeta.setDisplayName("§6Schaden-Multiplikator");
            moreDamageItem.setItemMeta(moreDamageMeta);

            ItemStack dmg0 = new ItemStack(Material.LIME_DYE);
            ItemMeta dmg0Meta = dmg0.getItemMeta();
            dmg0Meta.setDisplayName("§anormal");
            dmg0.setItemMeta(dmg0Meta);

            ItemStack dmg1 = new ItemStack(Material.ORANGE_DYE);
            ItemMeta dmg1Meta = dmg1.getItemMeta();
            dmg1Meta.setDisplayName("§6x2");
            dmg1.setItemMeta(dmg1Meta);

            ItemStack dmg2 = new ItemStack(Material.RED_DYE);
            ItemMeta dmg2Meta = dmg2.getItemMeta();
            dmg2Meta.setDisplayName("§cx3");
            dmg2.setItemMeta(dmg2Meta);

            ItemStack randomEnt = new ItemStack(Material.SKELETON_SKULL);
            ItemMeta randomEntMeta = randomEnt.getItemMeta();
            randomEntMeta.setDisplayName("§6Zufällige Entities");
            randomEntMeta.setLore(Arrays.asList("§cACHTUNG - Es werden mind. 4GB Server-Ram empfohlen!"));
            randomEnt.setItemMeta(randomEntMeta);

            ItemStack timberItem = new ItemStack(Material.OAK_LOG);
            ItemMeta timberMeta = timberItem.getItemMeta();
            timberMeta.setDisplayName("§6Timber");
            timberItem.setItemMeta(timberMeta);

            ItemStack chunkItem = new ItemStack(Material.CREEPER_HEAD);
            ItemMeta chunkMeta = chunkItem.getItemMeta();
            chunkMeta.setDisplayName("§6Chunk-Remover");
            chunkItem.setItemMeta(chunkMeta);

            ItemStack anvilItem = new ItemStack(Material.ANVIL);
            ItemMeta anvilMeta = anvilItem.getItemMeta();
            anvilMeta.setDisplayName("§6AnvilFall");
            anvilItem.setItemMeta(anvilMeta);

            ItemStack forceBiomeItem = new ItemStack(Material.GRASS_PATH);
            ItemMeta forceBiomeMeta = forceBiomeItem.getItemMeta();
            forceBiomeMeta.setDisplayName("§6Force-Biome");
            forceBiomeItem.setItemMeta(forceBiomeMeta);

            if (event.getView().getTitle().equals("§6Challenge-Settings")) {
                event.setCancelled(true);
                if (event.getSlot() == 9) {
                    if (forceYCoord) {
                        forceYCoord = false;
                        settings.setItem(9, disabled);
                    } else {
                        forceYCoord = true;
                        settings.setItem(9, enabled);
                    }
                    player.openInventory(settings);
                } else if (event.getSlot() == 10) {
                    if (blockplace) {
                        blockplace = false;
                        settings.setItem(10, disabled);
                    } else {
                        blockplace = true;
                        settings.setItem(10, enabled);
                    }
                    player.openInventory(settings);
                } else if (event.getSlot() == 11) {
                    if (blockbreak) {
                        blockbreak = false;
                        settings.setItem(11, disabled);
                    } else {
                        blockbreak = true;
                        settings.setItem(11, enabled);
                    }
                    player.openInventory(settings);
                } else if (event.getSlot() == 26) {
                    gamerules.setItem(0, timberItem);
                    gamerules.setItem(1, cutcleanitem);
                    gamerules.setItem(2, chatdamageitem);
                    gamerules.setItem(3, hardcore);
                    gamerules.setItem(4, keepinvitem);
                    gamerules.setItem(5, splitItem);
                    gamerules.setItem(18, site1);
                    gamerules.setItem(26, site2);
                    if (timber) {
                        gamerules.setItem(9, enabled);
                    } else {
                        gamerules.setItem(9, disabled);
                    }
                    if (cutclean) {
                        gamerules.setItem(10, enabled);
                    } else {
                        gamerules.setItem(10, disabled);
                    }
                    if (chatdamage) {
                        gamerules.setItem(11, enabled);
                    } else {
                        gamerules.setItem(11, disabled);
                    }
                    if (inthardcore == 1) {
                        gamerules.setItem(12, uhc);
                    } else if (inthardcore == 2) {
                        gamerules.setItem(12, uuhc);
                    } else if (inthardcore == 3) {
                        gamerules.setItem(12, uhcenabled);
                    }
                    if (keepinv) {
                        gamerules.setItem(13, enabled);
                    } else {
                        gamerules.setItem(13, disabled);
                    }
                    if (splitHP) {
                        gamerules.setItem(14, enabled);
                    } else {
                        gamerules.setItem(14, disabled);
                    }
                    player.openInventory(gamerules);

                } else if (event.getSlot() == 12) {
                    if (crafting) {
                        crafting = false;
                        settings.setItem(12, disabled);
                    } else {
                        crafting = true;
                        settings.setItem(12, enabled);
                    }
                    player.openInventory(settings);
                } else if (event.getSlot() == 13) {
                    if (air) {
                        air = false;
                        settings.setItem(13, disabled);
                    } else {
                        air = true;
                        settings.setItem(13, enabled);
                    }
                    player.openInventory(settings);
                } else if (event.getSlot() == 14) {
                    if (lavabool) {
                        lavabool = false;
                        settings.setItem(14, disabled);
                    } else {
                        lavabool = true;
                        settings.setItem(14, enabled);
                    }
                    player.openInventory(settings);
                } else if (event.getSlot() == 15) {
                    if (air2) {
                        air2 = false;
                        settings.setItem(15, disabled);
                    } else {
                        air2 = true;
                        settings.setItem(15, enabled);
                    }
                    player.openInventory(settings);
                } else if (event.getSlot() == 16) {
                    if (sneak) {
                        sneak = false;
                        settings.setItem(16, disabled);
                    } else {
                        sneak = true;
                        settings.setItem(16, enabled);
                    }
                    player.openInventory(settings);
                } else if (event.getSlot() == 17) {
                    if (collectDamage == 0) {
                        collectDamage = 1;
                        settings.setItem(17, cd1);
                    } else if (collectDamage == 1) {
                        collectDamage = 2;
                        settings.setItem(17, cd2);
                    } else if (collectDamage == 2) {
                        collectDamage = 3;
                        settings.setItem(17, cd3);
                    } else if (collectDamage == 3) {
                        collectDamage = 4;
                        settings.setItem(17, cd4);
                    } else if (collectDamage == 4) {
                        collectDamage = 5;
                        settings.setItem(17, cd5);
                    } else if (collectDamage == 5) {
                        collectDamage = 6;
                        settings.setItem(17, cd6);
                    } else if (collectDamage == 6) {
                        collectDamage = 7;
                        settings.setItem(17, cd7);
                    } else if (collectDamage == 7) {
                        collectDamage = 8;
                        settings.setItem(17, cd8);
                    } else if (collectDamage == 8) {
                        collectDamage = 9;
                        settings.setItem(17, cd9);
                    } else if (collectDamage == 9) {
                        collectDamage = 10;
                        settings.setItem(17, cd10);
                    } else if (collectDamage == 10) {
                        collectDamage = 11;
                        settings.setItem(17, cd11);
                    } else if (collectDamage == 11) {
                        collectDamage = 12;
                        settings.setItem(17, cd12);
                    } else if (collectDamage == 12) {
                        collectDamage = 13;
                        settings.setItem(17, cd13);
                    } else if (collectDamage == 13) {
                        collectDamage = 14;
                        settings.setItem(17, cd14);
                    } else if (collectDamage == 14) {
                        collectDamage = 15;
                        settings.setItem(17, cd15);
                    } else if (collectDamage == 15) {
                        collectDamage = 16;
                        settings.setItem(17, cd16);
                    } else if (collectDamage == 16) {
                        collectDamage = 17;
                        settings.setItem(17, cd17);
                    } else if (collectDamage == 17) {
                        collectDamage = 18;
                        settings.setItem(17, cd18);
                    } else if (collectDamage == 18) {
                        collectDamage = 19;
                        settings.setItem(17, cd19);
                    } else if (collectDamage == 19) {
                        collectDamage = 20;
                        settings.setItem(17, cd20);
                    } else if (collectDamage == 20) {
                        collectDamage = 0;
                        settings.setItem(17, cd0);
                    }
                    player.openInventory(settings);
                } else if (event.getSlot() == 36) {
                    if (mirrorDamage) {
                        mirrorDamage = false;
                        settings.setItem(36, disabled);
                    } else {
                        mirrorDamage = true;
                        settings.setItem(36, enabled);
                    }
                    player.openInventory(settings);
                } else if (event.getSlot() == 37) {
                    if (damage) {
                        damage = false;
                        settings.setItem(37, disabled);
                    } else {
                        damage = true;
                        settings.setItem(37, enabled);
                    }
                    player.openInventory(settings);
                } else if (event.getSlot() == 38) {
                    if (hp == 1) {
                        hp = 2;
                        settings.setItem(38, hp2);
                        for (Player players : Bukkit.getOnlinePlayers()) {
                            players.setMaxHealth(2);
                            players.addPotionEffect(new PotionEffect(PotionEffectType.HEAL, 1, 4));
                        }
                    } else if (hp == 2) {
                        hp = 3;
                        settings.setItem(38, hp3);
                        for (Player players : Bukkit.getOnlinePlayers()) {
                            players.setMaxHealth(3);
                            players.addPotionEffect(new PotionEffect(PotionEffectType.HEAL, 1, 4));
                        }
                    } else if (hp == 3) {
                        hp = 4;
                        settings.setItem(38, hp4);
                        for (Player players : Bukkit.getOnlinePlayers()) {
                            players.setMaxHealth(4);
                            players.addPotionEffect(new PotionEffect(PotionEffectType.HEAL, 1, 4));
                        }
                    } else if (hp == 4) {
                        hp = 5;
                        settings.setItem(38, hp5);
                        for (Player players : Bukkit.getOnlinePlayers()) {
                            players.setMaxHealth(5);
                            players.addPotionEffect(new PotionEffect(PotionEffectType.HEAL, 1, 4));
                        }
                    } else if (hp == 5) {
                        hp = 6;
                        settings.setItem(38, hp6);
                        for (Player players : Bukkit.getOnlinePlayers()) {
                            players.setMaxHealth(6);
                            players.addPotionEffect(new PotionEffect(PotionEffectType.HEAL, 1, 4));
                        }
                    } else if (hp == 6) {
                        hp = 7;
                        settings.setItem(38, hp7);
                        for (Player players : Bukkit.getOnlinePlayers()) {
                            players.setMaxHealth(7);
                            players.addPotionEffect(new PotionEffect(PotionEffectType.HEAL, 1, 4));
                        }
                    } else if (hp == 7) {
                        hp = 8;
                        settings.setItem(38, hp8);
                        for (Player players : Bukkit.getOnlinePlayers()) {
                            players.setMaxHealth(8);
                            players.addPotionEffect(new PotionEffect(PotionEffectType.HEAL, 1, 4));
                        }
                    } else if (hp == 8) {
                        hp = 9;
                        settings.setItem(38, hp9);
                        for (Player players : Bukkit.getOnlinePlayers()) {
                            players.setMaxHealth(9);
                            players.addPotionEffect(new PotionEffect(PotionEffectType.HEAL, 1, 4));
                        }
                    } else if (hp == 9) {
                        hp = 10;
                        settings.setItem(38, hp10);
                        for (Player players : Bukkit.getOnlinePlayers()) {
                            players.setMaxHealth(10);
                            players.addPotionEffect(new PotionEffect(PotionEffectType.HEAL, 1, 4));
                        }
                    } else if (hp == 10) {
                        hp = 11;
                        settings.setItem(38, hp11);
                        for (Player players : Bukkit.getOnlinePlayers()) {
                            players.setMaxHealth(11);
                            players.addPotionEffect(new PotionEffect(PotionEffectType.HEAL, 1, 4));
                        }
                    } else if (hp == 11) {
                        hp = 12;
                        settings.setItem(38, hp12);
                        for (Player players : Bukkit.getOnlinePlayers()) {
                            players.setMaxHealth(12);
                            players.addPotionEffect(new PotionEffect(PotionEffectType.HEAL, 1, 4));
                        }
                    } else if (hp == 12) {
                        hp = 13;
                        settings.setItem(38, hp13);
                        for (Player players : Bukkit.getOnlinePlayers()) {
                            players.setMaxHealth(13);
                            players.addPotionEffect(new PotionEffect(PotionEffectType.HEAL, 1, 4));
                        }
                    } else if (hp == 13) {
                        hp = 14;
                        settings.setItem(38, hp14);
                        for (Player players : Bukkit.getOnlinePlayers()) {
                            players.setMaxHealth(14);
                            players.addPotionEffect(new PotionEffect(PotionEffectType.HEAL, 1, 4));
                        }
                    } else if (hp == 14) {
                        hp = 15;
                        settings.setItem(38, hp15);
                        for (Player players : Bukkit.getOnlinePlayers()) {
                            players.setMaxHealth(15);
                            players.addPotionEffect(new PotionEffect(PotionEffectType.HEAL, 1, 4));
                        }
                    } else if (hp == 15) {
                        hp = 16;
                        settings.setItem(38, hp16);
                        for (Player players : Bukkit.getOnlinePlayers()) {
                            players.setMaxHealth(16);
                            players.addPotionEffect(new PotionEffect(PotionEffectType.HEAL, 1, 4));
                        }
                    } else if (hp == 16) {
                        hp = 17;
                        settings.setItem(38, hp17);
                        for (Player players : Bukkit.getOnlinePlayers()) {
                            players.setMaxHealth(17);
                            players.addPotionEffect(new PotionEffect(PotionEffectType.HEAL, 1, 4));
                        }
                    } else if (hp == 17) {
                        hp = 18;
                        settings.setItem(38, hp18);
                        for (Player players : Bukkit.getOnlinePlayers()) {
                            players.setMaxHealth(18);
                            players.addPotionEffect(new PotionEffect(PotionEffectType.HEAL, 1, 4));
                        }
                    } else if (hp == 18) {
                        hp = 19;
                        settings.setItem(38, hp19);
                        for (Player players : Bukkit.getOnlinePlayers()) {
                            players.setMaxHealth(19);
                            players.addPotionEffect(new PotionEffect(PotionEffectType.HEAL, 1, 4));
                        }
                    } else if (hp == 19) {
                        hp = 20;
                        settings.setItem(38, hp20);
                        for (Player players : Bukkit.getOnlinePlayers()) {
                            players.setMaxHealth(20);
                            players.addPotionEffect(new PotionEffect(PotionEffectType.HEAL, 1, 4));
                        }
                    } else if (hp == 20) {
                        hp = 1;
                        settings.setItem(38, hp1);
                        for (Player players : Bukkit.getOnlinePlayers()) {
                            player.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(1);
                        }
                    }
                    player.openInventory(settings);

                } else if (event.getSlot() == 39) {
                    if (falldmg) {
                        falldmg = false;
                        settings.setItem(39, disabled);
                    } else {
                        falldmg = true;
                        settings.setItem(39, enabled);
                    }
                    player.openInventory(settings);
                } else if (event.getSlot() == 40) {
                    if (xp) {
                        xp = false;
                        settings.setItem(40, disabled);
                    } else {
                        xp = true;
                        settings.setItem(40, enabled);
                    }
                    player.openInventory(settings);
                } else if (event.getSlot() == 41) {
                    if (mlg) {
                        mlg = false;
                        settings.setItem(41, disabled);
                    } else {
                        mlg = true;
                        settings.setItem(41, enabled);
                    }
                    player.openInventory(settings);
                } else if (event.getSlot() == 42) {
                    if (forceItem) {
                        forceItem = false;
                        settings.setItem(42, disabled);
                    } else {
                        forceItem = true;
                        forceBlock = false;
                        settings.setItem(42, enabled);
                        settings.setItem(43, disabled);
                    }
                } else if (event.getSlot() == 43) {
                    if (forceBlock) {
                        forceBlock = false;
                        settings.setItem(43, disabled);
                    } else {
                        forceBlock = true;
                        forceItem = false;
                        settings.setItem(43, enabled);
                        settings.setItem(42, disabled);
                    }
                } else if (event.getSlot() == 44) {
                    if (damageClear) {
                        damageClear = false;
                        settings.setItem(44, disabled);
                    } else {
                        damageClear = true;
                        settings.setItem(44, enabled);
                    }
                } else if (event.getSlot() == 49) {
                    settings2.setItem(4, challenge1);
                    settings2.setItem(9, randomItems);
                    settings2.setItem(10, randomCraftingItem);
                    settings2.setItem(11, forceEntityItem);
                    settings2.setItem(12, doubleHealthItem);
                    settings2.setItem(13, moreDamageItem);
                    settings2.setItem(14, randomEnt);
                    settings2.setItem(15, chunkItem);
                    settings2.setItem(16, anvilItem);
                    settings2.setItem(17, forceBiomeItem);
                    if (randomdrops) {
                        settings2.setItem(18, enabled);
                    } else {
                        settings2.setItem(18, disabled);
                    }
                    if (randomCrafting) {
                        settings2.setItem(19, enabled);
                    } else {
                        settings2.setItem(19, disabled);
                    }
                    if (forceEntity) {
                        settings2.setItem(20, enabled);
                    } else {
                        settings2.setItem(20, disabled);
                    }
                    if (doubleHealth) {
                        settings2.setItem(21, enabled);
                    } else {
                        settings2.setItem(21, disabled);
                    }
                    if (moreDamage == 0) {
                        settings2.setItem(22, dmg0);
                    } else if (moreDamage == 1) {
                        settings2.setItem(22, dmg1);
                    } else if (moreDamage == 2) {
                        settings2.setItem(22, dmg2);
                    }
                    if (randomEntities) {
                        settings2.setItem(23, enabled);
                    } else {
                        settings2.setItem(23, disabled);
                    }
                    if (removeChunks) {
                        settings2.setItem(24, enabled);
                    } else {
                        settings2.setItem(24, disabled);
                    }
                    if (fallingAnvil) {
                        settings2.setItem(25, enabled);
                    } else {
                        settings2.setItem(25, disabled);
                    }
                    if (forceBiome) {
                        settings2.setItem(26, enabled);
                    } else {
                        settings2.setItem(26, disabled);
                    }
                    player.openInventory(settings2);
                }
            } else if (event.getView().getTitle().equals("§6Gamerule-Settings")) {
                event.setCancelled(true);
                if (event.getSlot() == 9) {
                    if (timber) {
                        timber = false;
                        gamerules.setItem(9, disabled);
                    } else {
                        timber = true;
                        gamerules.setItem(9, enabled);
                    }
                    player.openInventory(gamerules);
                } else if (event.getSlot() == 10) {
                    if (cutclean) {
                        cutclean = false;
                        gamerules.setItem(10, disabled);
                    } else {
                        cutclean = true;
                        gamerules.setItem(10, enabled);
                    }
                    player.openInventory(gamerules);
                } else if (event.getSlot() == 11) {
                    if (chatdamage) {
                        chatdamage = false;
                        gamerules.setItem(11, disabled);
                    } else {
                        chatdamage = true;
                        gamerules.setItem(11, enabled);
                    }
                    player.openInventory(gamerules);
                } else if (event.getSlot() == 12) {
                    if (inthardcore == 1) {
                        inthardcore = 2;
                        gamerules.setItem(12, uuhc);
                        player.openInventory(gamerules);
                    } else if (inthardcore == 2) {
                        inthardcore = 3;
                        gamerules.setItem(12, uhcenabled);
                        player.openInventory(gamerules);
                    } else if (inthardcore == 3) {
                        inthardcore = 1;
                        gamerules.setItem(12, uhc);
                        player.openInventory(gamerules);
                    }
                    player.openInventory(gamerules);
                } else if (event.getSlot() == 13) {
                    if (keepinv) {
                        keepinv = false;
                        gamerules.setItem(13, disabled);
                    } else {
                        keepinv = true;
                        gamerules.setItem(13, enabled);
                    }
                    player.openInventory(gamerules);
                } else if (event.getSlot() == 14) {
                    if (splitHP) {
                        splitHP = false;
                        gamerules.setItem(14, disabled);
                    } else {
                        splitHP = true;
                        gamerules.setItem(14, enabled);
                    }
                    player.openInventory(gamerules);
                } else if (event.getSlot() == 18) {
                    if (blockplace) {
                        settings.setItem(10, enabled);
                    } else {
                        settings.setItem(10, disabled);
                    }
                    if (blockbreak) {
                        settings.setItem(11, enabled);
                    } else {
                        settings.setItem(11, disabled);
                    }
                    if (crafting) {
                        settings.setItem(12, enabled);
                    } else {
                        settings.setItem(12, disabled);
                    }
                    if (air) {
                        settings.setItem(13, enabled);
                    } else {
                        settings.setItem(13, disabled);
                    }
                    if (lavabool) {
                        settings.setItem(14, enabled);
                    } else {
                        settings.setItem(14, disabled);
                    }
                    if (randomdrops) {
                        settings.setItem(15, enabled);
                    } else {
                        settings.setItem(15, disabled);
                    }
                    if (sneak) {
                        settings.setItem(16, enabled);
                    } else {
                        settings.setItem(16, disabled);
                    }
                    if (damage) {
                        settings.setItem(28, enabled);
                    } else {
                        settings.setItem(28, disabled);
                    }
                    player.openInventory(settings);

                } else if (event.getSlot() == 26) {
                    findItems.setItem(1, elytraItem);
                    findItems.setItem(2, diamondItem);
                    findItems.setItem(3, mycelItem);
                    ;
                    findItems.setItem(18, site1);

                    if (elytra) {
                        findItems.setItem(10, enabled);
                    } else {
                        findItems.setItem(10, disabled);
                    }
                    if (diamond) {
                        findItems.setItem(11, enabled);
                    } else {
                        findItems.setItem(11, disabled);
                    }
                    if (mycelium) {
                        findItems.setItem(12, enabled);
                    } else {
                        findItems.setItem(12, disabled);
                    }
                    player.openInventory(findItems);
                }

            } else if (event.getView().getTitle().equals("§bChallenge-Settings §7| §bvs")) {
                event.setCancelled(true);
                if (event.getSlot() == 10) {
                    if (elytra) {
                        elytra = false;
                        findItems.setItem(10, disabled);
                    } else {
                        elytra = true;
                        findItems.setItem(10, enabled);

                    }
                    player.openInventory(findItems);

                } else if (event.getSlot() == 11) {
                    if (diamond) {
                        diamond = false;
                        findItems.setItem(11, disabled);
                    } else {
                        diamond = true;
                        findItems.setItem(11, enabled);
                    }
                    player.openInventory(findItems);

                } else if (event.getSlot() == 12) {
                    if (mycelium) {
                        mycelium = false;
                        findItems.setItem(12, disabled);
                    } else {
                        mycelium = true;
                        findItems.setItem(12, enabled);
                    }
                    player.openInventory(findItems);

                } else if (event.getSlot() == 18) {
                    player.openInventory(gamerules);
                }
            } else if (event.getView().getTitle().equals("§6Challenge-Settings §7| §62")) {
                event.setCancelled(true);
                if (event.getSlot() == 4) {
                    player.openInventory(settings);

                } else if (event.getSlot() == 18) {
                    if (randomdrops) {
                        randomdrops = false;
                        settings2.setItem(18, disabled);
                    } else {
                        randomdrops = true;
                        settings2.setItem(18, enabled);

                    }
                    player.openInventory(settings2);

                } else if (event.getSlot() == 19) {
                    if (randomCrafting) {
                        randomCrafting = false;
                        settings2.setItem(19, disabled);
                    } else {
                        randomCrafting = true;
                        settings2.setItem(19, enabled);

                    }
                    player.openInventory(settings2);

                } else if (event.getSlot() == 20) {
                    if (forceEntity) {
                        forceEntity = false;
                        settings2.setItem(20, disabled);
                    } else {
                        forceEntity = true;
                        settings2.setItem(20, enabled);

                    }
                    player.openInventory(settings2);

                } else if (event.getSlot() == 21) {
                    if (doubleHealth) {
                        doubleHealth = false;
                        settings2.setItem(21, disabled);
                    } else {
                        doubleHealth = true;
                        settings2.setItem(21, enabled);

                    }
                    player.openInventory(settings2);

                } else if (event.getSlot() == 22) {
                    if (moreDamage == 0) {
                        moreDamage = 1;
                        settings2.setItem(22, dmg1);
                    } else if (moreDamage == 1) {
                        moreDamage = 2;
                        settings2.setItem(22, dmg2);
                    } else if (moreDamage == 2) {
                        moreDamage = 0;
                        settings2.setItem(22, dmg0);
                    }
                    player.openInventory(settings2);

                } else if (event.getSlot() == 23) {
                    if (randomEntities) {
                        randomEntities = false;
                        settings2.setItem(23, disabled);
                    } else {
                        randomEntities = true;
                        settings2.setItem(23, enabled);

                    }
                    player.openInventory(settings2);

                } else if (event.getSlot() == 24) {
                    if (removeChunks) {
                        removeChunks = false;
                        settings2.setItem(24, disabled);
                    } else {
                        removeChunks = true;
                        settings2.setItem(24, enabled);

                    }
                    player.openInventory(settings2);

                } else if (event.getSlot() == 25) {
                    if (fallingAnvil) {
                        fallingAnvil = false;
                        settings2.setItem(25, disabled);
                    } else {
                        fallingAnvil = true;
                        settings2.setItem(25, enabled);

                    }
                    player.openInventory(settings2);

                } else if (event.getSlot() == 26) {
                    if (forceBiome) {
                        forceBiome = false;
                        settings2.setItem(26, disabled);
                    } else {
                        forceBiome = true;
                        settings2.setItem(26, enabled);

                    }
                    player.openInventory(settings2);

                }
            }
        }
    }
}
