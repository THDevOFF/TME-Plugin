package ru.andrewzex.tMEPlugin.util;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

import java.io.File;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class LangUtil {

    private static YamlConfiguration langConfig;

    public static void load(Plugin plugin, String code) {
        File langFile = new File(plugin.getDataFolder(), "lang/" + code + ".yml");

        if (!langFile.exists()) {
            plugin.saveResource("lang/" + code + ".yml", false);
        }

        langConfig = YamlConfiguration.loadConfiguration(langFile);

        // fallback
        if (langConfig.getKeys(false).isEmpty()) {
            try (InputStreamReader reader = new InputStreamReader(plugin.getResource("lang/" + code + ".yml"), StandardCharsets.UTF_8)) {
                langConfig = YamlConfiguration.loadConfiguration(reader);
            } catch (Exception e) {
                plugin.getLogger().warning("Failed to load fallback language: " + code);
            }
        }
    }

    public static String format(String key, Object... args) {
        String msg = langConfig.getString(key, key);
        return String.format(msg, args);
    }
}
