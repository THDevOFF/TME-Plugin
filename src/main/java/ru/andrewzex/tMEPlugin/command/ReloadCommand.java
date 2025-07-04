package ru.andrewzex.tMEPlugin.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import ru.andrewzex.tMEPlugin.TMEPlugin;

public class ReloadCommand implements CommandExecutor {

    private final TMEPlugin plugin;

    public ReloadCommand(TMEPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!sender.hasPermission("TME.admin")) {
            sender.sendMessage("§cYou do not have permission.");
            return true;
        }

        plugin.reloadAll();
        sender.sendMessage("§aTMEPlugin reloaded.");
        return true;
    }
}
