package ru.andrewzex.tMEPlugin;

import org.bukkit.plugin.java.JavaPlugin;
import ru.andrewzex.tMEPlugin.command.ReloadCommand;
import ru.andrewzex.tMEPlugin.listener.InteractionListener;
import ru.andrewzex.tMEPlugin.listener.IgniteListener;
import ru.andrewzex.tMEPlugin.util.LangUtil;

public final class TMEPlugin extends JavaPlugin {

    private static TMEPlugin instance;

    @Override
    public void onEnable() {
        saveDefaultConfig();

        saveResource("lang/en_US.yml", false);
        saveResource("lang/ru_RU.yml", false);
        saveResource("lang/uk_UA.yml", false);
        saveResource("lang/de_DE.yml", false);
        saveResource("lang/ru_RPR.yml", false);

        LangUtil.load(this, getConfig().getString("lang", "en_US"));

        getServer().getPluginManager().registerEvents(new InteractionListener(this), this);
        getServer().getPluginManager().registerEvents(new IgniteListener(this), this);

        getCommand("tme").setExecutor(new ReloadCommand(this));

        instance = this;
    }

    public static TMEPlugin getInstance() {
        return instance;
    }

    public void reloadAll() {
        reloadConfig();
        LangUtil.load(this, getConfig().getString("lang", "en_US"));
    }
}
