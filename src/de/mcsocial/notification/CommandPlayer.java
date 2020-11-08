package de.mcsocial.notification;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandPlayer implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String alias, String[] args) {

		if (!(sender instanceof Player)) {
			return false;
		}

		Player p = (Player) sender;

		switch (cmd.getName()) {
			case "home":
				if (p.getBedSpawnLocation() == null) {
					p.sendMessage("ï¿½eDu setzt einen Home, wenn du dich in ein Bett legst.");
				} else {
					p.teleport(p.getBedSpawnLocation());
				}

				return true;
			case "spawn":
				if (p.getBedSpawnLocation() == null) {
					p.sendMessage("ï¿½eDu setzt einen Home, wenn du dich in ein Bett legst.");
				} else {
					p.teleport(p.getBedSpawnLocation());
				}
				return true;
			case "money":
				p.sendMessage("ï¿½rï¿½lï¿½4Kontoverwalter: Aktueller Kontostand: " + p.getMetadata("account").get(0).asInt() + " SD");
				return true;
			case "ts":
				p.sendMessage("ï¿½rï¿½lï¿½4ServerInfo: TeamSpeak: ts.minecraft-social.de:17700 ");
				return true;
			case "vote":
				p.sendMessage("ï¿½rï¿½lï¿½4ServerInfo: https://minecraft-server.eu/server/index/107161/minecraft_social ");
				return true;
			default:
				return false;
		}
	}

}
