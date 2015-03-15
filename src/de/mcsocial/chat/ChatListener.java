package de.mcsocial.chat;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import de.mcsocial.main.MCSocial;
import de.mcsocial.protection.Jail;
import de.mcsocial.protection.JailChunk;

public class ChatListener implements Listener, CommandExecutor {


	@SuppressWarnings("static-access")
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label,
			String[] args) {
		
		if(!(sender instanceof Player))
		{
			return false;
		}
		
		Player p = (Player)sender;

		if(cmd.getName().equalsIgnoreCase("list")) {
			System.out.println("Command list");
			p.sendMessage("---------------------------");
			p.sendMessage("Verfügbare Chat Kanäle");
			p.sendMessage("---------------------------");
			
			List<String> channels = MCSocial.channel.getList();
			
			for(String name: channels){
				p.sendMessage(name);				
			}
			p.sendMessage("---------------------------");
			return true;
		}
		
		if(args.length == 0){
			p.sendMessage("Bitte Chat Namen angeben");
			return true;
		}
			
		if(cmd.getName().equalsIgnoreCase("join")) {
			System.out.println("Command join");
			if(!MCSocial.channel.channelExist(args[0]))
			{
				MCSocial.channel.create(args[0]);
			}

			MCSocial.channel.join(p, args[0]);
			p.sendMessage("Chat " + args[0]+ " beigetreten.");
			return true;
		}
		
		if(cmd.getName().equalsIgnoreCase("leave")) {
			System.out.println("Command leave");
			MCSocial.channel.leave(p, args[0]);
			p.sendMessage("Chat " + args[0]+ " verlassen.");
			return true;
		}
				
		// TODO Auto-generated method stub
		return false;
	}
	@SuppressWarnings("static-access")
	@EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent event) {
		  
        if(event.getMessage().equalsIgnoreCase("MuellerMH") 
        		|| event.getMessage().equalsIgnoreCase("mueller")
        ) {
            event.getPlayer().sendMessage(ChatColor.RED + "Bei Fragen kommen sie persönlich zu einer Audienz.");
            event.setCancelled(true);
            return;
        }
        
        if(event.getMessage().equalsIgnoreCase("admin")
        		|| event.getMessage().equalsIgnoreCase("op")
        		|| event.getMessage().equalsIgnoreCase("hilfe")
        ) {
            event.getPlayer().sendMessage(ChatColor.RED + "Bitte betreten Sie für Fragen den Supportchannel. Zu finden in Ihrem Menu.");
            event.setCancelled(true);
            return;
        }
        
        if(Jail.isInJail(event.getPlayer())){
        	event.getPlayer().sendMessage(ChatColor.RED + "Du bist im Gefängniss. Schweige und schreibe deine Sünden in das Buch!");
 			MCSocial.channel.join(event.getPlayer(),"Lokal");
        }
        
        List<Player>notInChat = new ArrayList<Player>();
        Set<Player> playerList = event.getRecipients();
        
        if(Jail.isJailChunks(event.getPlayer().getLocation().getChunk()))
		{
			MCSocial.channel.join(event.getPlayer(), "Lokal");
		}
        
		for (Player recPlayer : playerList) {	
			
			if(Jail.isJailChunks( recPlayer.getLocation().getChunk()))
			{
				MCSocial.channel.join(recPlayer, "Lokal");
			}
			
			if(!MCSocial.channel.isInChat(recPlayer,event.getPlayer().getMetadata("channel").get(0).asString())){
				notInChat.add(recPlayer);
			}
			if(event.getPlayer().hasMetadata("channel")){
				if(event.getPlayer().getMetadata("channel").get(0).asString() == "Lokal"){
					if(outOfRange(event.getPlayer().getLocation(),recPlayer.getLocation(),200)){
						notInChat.add(recPlayer);
					}
				}
				if(Jail.isInJail(recPlayer)){
					notInChat.add(recPlayer);
				}
			}
        }
				
		for(Player p: notInChat){
			event.getRecipients().remove(p);
		}
        
        String messagePrefix = ChatColor.WHITE  + "";        
        
        if(event.getPlayer().isOp()){
        	messagePrefix += ChatColor.RED +"[OP] ";
        }
        else if(event.getPlayer().hasMetadata("isAdmin") && event.getPlayer().getMetadata("isAdmin").get(0).asBoolean()){
        	messagePrefix += ChatColor.RED +""+ ChatColor.BOLD +"[A] ";
        }
        else if(event.getPlayer().hasMetadata("isSupporter") && event.getPlayer().getMetadata("isSupporter").get(0).asBoolean()){
        	messagePrefix += ChatColor.RED +""+ ChatColor.BOLD +"[S] ";
        }
        else if(event.getPlayer().hasMetadata("isModerator") && event.getPlayer().getMetadata("isModerator").get(0).asBoolean()){
        	messagePrefix += ChatColor.RED +""+ ChatColor.BOLD +"[M] ";
        }
        
        if(event.getPlayer().hasMetadata("newPlayer")){
        	messagePrefix += ChatColor.GREEN + "[New] ";
        }        
        else if(event.getPlayer().hasMetadata("cityowner")){
        	messagePrefix += ChatColor.BLUE +"Lehnsherr ";
        }
        //Beruf
        else if(event.getPlayer().hasMetadata("job") && event.getPlayer().getMetadata("job").get(0).asString() != null){
        	messagePrefix += ChatColor.DARK_GRAY +" "+ event.getPlayer().getMetadata("job").get(0).asString()+" ";
        }

        if(event.getPlayer().hasMetadata("isDonator") && event.getPlayer().getMetadata("isDonator").get(0).asBoolean()){
        	messagePrefix = ChatColor.GOLD +"[D] " + messagePrefix + "" + ChatColor.GOLD;
        }
				        
    	event.setFormat("%2$s");
        event.setMessage(ChatColor.BOLD + "<" + event.getPlayer().getMetadata("channel").get(0).asString() + "> " +messagePrefix +  event.getPlayer().getName() + ChatColor.WHITE+ ": "+ event.getMessage().replace("$",""));
        
        if(event.getRecipients().size() == 1)
        {
        	event.getPlayer().sendMessage("Niemand kann dich hören.");
        }
        return;
        
    }
	private Boolean outOfRange(Location l, Location ll,Integer range) {  
		if(l.equals(ll)){
			return false;
		}
		if(!l.getWorld().equals(ll.getWorld())){
			return true;
		}
        return l.distanceSquared(ll) > 460;
    }
	private Boolean outOfRange(Location l, Location ll) {  
		if(l.equals(ll)){
			return false;
		}
		if(!l.getWorld().equals(ll.getWorld())){
			return true;
		}
        return l.distanceSquared(ll) > 460;
    }

}
