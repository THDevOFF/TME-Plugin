package ru.andrewzex.tMEPlugin.listener;

import ru.andrewzex.tMEPlugin.util.MetadataUtil;
import ru.andrewzex.tMEPlugin.util.LangUtil;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.entity.minecart.ExplosiveMinecart;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.plugin.Plugin;

public class InteractionListener implements Listener {

    private final Plugin plugin;

    public InteractionListener(Plugin plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onInteract(PlayerInteractEntityEvent event) {
        if (!(event.getRightClicked() instanceof ExplosiveMinecart cart)) return;

        Player player = event.getPlayer();
        if (plugin.getConfig().getBoolean("randomizer")) return;

        if (player.getInventory().getItemInMainHand().getType() != Material.REDSTONE) return;

        int min = plugin.getConfig().getInt("min-explosion-duration");
        int max = plugin.getConfig().getInt("max-explosion-duration");

        int current = MetadataUtil.getTimer(cart, plugin);
        boolean changed = false;

        if (player.isSneaking()) {
            if (current > min) {
                current--;
                changed = true;
            }
        } else {
            if (current < max) {
                current++;
                changed = true;
            }
        }

        if (changed) {
            MetadataUtil.setTimer(cart, current, plugin);
            player.sendActionBar(LangUtil.format("timer_set", current));
        }
    }
}
