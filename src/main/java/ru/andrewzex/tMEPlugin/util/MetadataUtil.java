package ru.andrewzex.tMEPlugin.util;

import org.bukkit.entity.minecart.ExplosiveMinecart;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.plugin.Plugin;
import ru.andrewzex.tMEPlugin.TMEPlugin;

public class MetadataUtil {
    private static final String KEY = "tnt_timer";

    public static int getTimer(ExplosiveMinecart cart, Plugin plugin) {
        if (cart.hasMetadata(KEY)) {
            return cart.getMetadata(KEY).get(0).asInt();
        }
        return plugin.getConfig().getInt("min-explosion-duration");
    }

    public static void setTimer(ExplosiveMinecart cart, int seconds, Plugin plugin) {
        cart.setMetadata(KEY, new FixedMetadataValue(plugin, seconds));
        cart.setCustomName("§c" + seconds + "s");
        cart.setCustomNameVisible(true);
    }

    public static FixedMetadataValue fixed(Object obj) {
        return new FixedMetadataValue(Plugin.class.cast(TMEPlugin.getInstance()), obj);
    }
}
