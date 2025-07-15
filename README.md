# TMEPlugin

A lightweight Minecraft plugin that gives you full control over TNT minecart explosion timing.

![GitHub](https://img.shields.io/github/v/release/THDevOFF/TME-Plugin?label=Version)
![MC Version](https://img.shields.io/badge/Minecraft-1.18%2B-green)
![License](https://img.shields.io/github/license/THDevOFF/TME-Plugin)

---

## ⭐Aviable on <br>
-   <a href="https://modrinth.com/plugin/TME-Plugin">
    <img src="https://img.shields.io/badge/dynamic/json?color=158000&label=downloads&prefix=+%20&query=downloads&url=https://api.modrinth.com/v2/project/B38Erf5M&logo=modrinth" alt="Modrinth Downloads">
  </a>
  
-   <a href="https://www.spigotmc.org/resources/tme-plugin.126652/">
    <img src="https://img.shields.io/badge/SpigotMC-Download-orange?logo=spigotmc&style=flat" alt="SpigotMC">
  </a>

---

## 📋 Features

- Dynamically set TNT minecart explosion timers using Redstone Dust.
- Display countdown above the minecart in real-time.
- Randomized explosion timing (optional).
- Full localization support with external YAML files.
- `/tme reload` command for reloading configuration and language.
- Simple config and permissions setup.

---

## 🛠 Installation

1. Download the plugin JAR from [Releases](https://github.com/THDevOFF/TME-Plugin/releases).
2. Drop it into your server’s `plugins` folder.
3. Start or restart your server.

---

## ⚙ Configuration

### `config.yml`

```yaml
min-explosion-duration: 1
max-explosion-duration: 60
randomizer: false
lang: en_US
```
