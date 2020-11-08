package de.mcsocial.docctorsAddons;

import java.io.File;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

public class SimpleConfigHandler {
	public static FileConfiguration getConfig;

	public static void loadConfig() {
		File file = new File("./plugins/MinecraftSocial/config.yml");
		getConfig = YamlConfiguration.loadConfiguration(file);
		if (getConfig.getString("mysql.password") == null)
			getConfig.set("mysql.password", "");
	}
}
