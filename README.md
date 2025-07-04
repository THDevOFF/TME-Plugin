# TMEPlugin

A lightweight Minecraft plugin that gives you full control over TNT minecart explosion timing.

![GitHub](https://img.shields.io/github/v/release/THDevOFF/TME-Plugin?label=Version)
![MC Version](https://img.shields.io/badge/Minecraft-1.18%2B-green)
![License](https://img.shields.io/github/license/THDevOFF/TME-Plugin)

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
