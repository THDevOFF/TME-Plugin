package ru.andrewzex.tMEPlugin.task;

import org.bukkit.Bukkit;
import org.bukkit.entity.minecart.ExplosiveMinecart;
import org.bukkit.plugin.Plugin;

public class CountdownTask implements Runnable {

    private final ExplosiveMinecart cart;
    private int seconds;
    private final Plugin plugin;
    private int taskId = -1;

    public CountdownTask(ExplosiveMinecart cart, int seconds, Plugin plugin) {
        this.cart = cart;
        this.seconds = seconds;
        this.plugin = plugin;
    }

    public void start() {
        taskId = Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin, this, 0, 20);
    }

    @Override
    public void run() {
        if (cart.isDead() || !cart.isValid()) {
            Bukkit.getScheduler().cancelTask(taskId);
            return;
        }

        if (seconds <= 0) {
            cart.getWorld().createExplosion(cart.getLocation(), 4.0F);
            cart.remove();
            Bukkit.getScheduler().cancelTask(taskId);
            return;
        }

        cart.setCustomName("§c" + seconds + "s");
        cart.setCustomNameVisible(true);
        seconds--;
    }
}

