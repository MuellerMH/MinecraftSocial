package de.mcsocial.notification;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandPlayer implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String alias,
			String[] args) {
		// TODO Auto-generated method stub
		if(!(sender instanceof Player))
		{
			return false;
		}
		
		Player p = (Player)sender;
		
		switch(cmd.getName()){
			case "home":
				p.teleport(p.getBedSpawnLocation());
				return true;
			case "spawn":
				p.teleport(p.getBedSpawnLocation());
				return true;
			case "money":
				p.sendMessage("§r§l§4Kontoverwalter: Aktueller Kontostand: " +p.getMetadata("account").get(0).asInt()+ " SD");
				return true;
			case "ts":
				p.sendMessage("§r§l§4ServerInfo: TeamSpeak: ts.minecraft-social.de:17700 ");
				return true;
			case "vote":
				p.sendMessage("§r§l§4ServerInfo: https://minecraft-server.eu/server/index/107161/minecraft_social ");
				return true;
			default: return false;
		}
	}

}
