package ru.andrewzex.tMEPlugin.listener;

import ru.andrewzex.tMEPlugin.task.CountdownTask;
import ru.andrewzex.tMEPlugin.util.MetadataUtil;

import org.bukkit.entity.minecart.ExplosiveMinecart;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.vehicle.VehicleCreateEvent;
import org.bukkit.event.vehicle.VehicleMoveEvent;
import org.bukkit.plugin.Plugin;

import java.util.Random;

public class IgniteListener implements Listener {

    private final Plugin plugin;

    public IgniteListener(Plugin plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onMove(VehicleMoveEvent event) {
        if (!(event.getVehicle() instanceof ExplosiveMinecart cart)) return;
        if (cart.getVelocity().lengthSquared() < 0.01) return;

        if (!cart.hasMetadata("exploding")) {
            int seconds;
            if (plugin.getConfig().getBoolean("randomizer")) {
                int min = plugin.getConfig().getInt("min-explosion-duration");
                int max = plugin.getConfig().getInt("max-explosion-duration");
                seconds = new Random().nextInt(max - min + 1) + min;
            } else {
                seconds = MetadataUtil.getTimer(cart, plugin);
            }

            cart.setMetadata("exploding", MetadataUtil.fixed(true));
            new CountdownTask(cart, seconds, plugin).start();
        }
    }
}
