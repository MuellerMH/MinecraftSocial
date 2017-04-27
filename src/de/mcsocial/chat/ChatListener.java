package de.mcsocial.chat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.inventory.ItemStack;

import de.mcsocial.city.City;
import de.mcsocial.economy.Account;
import de.mcsocial.main.MCSocial;
import de.mcsocial.notification.VoteNotificationEvent;
import de.mcsocial.notification.VoteNotify;
import de.mcsocial.notification.handler.WebChatHandler;
import de.mcsocial.permissions.PlayerPermissions;
import de.mcsocial.protection.Jail;

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
		if(cmd.getName().equalsIgnoreCase("g")) {
			MCSocial.channel.join(p, "Global");
			p.sendMessage("Chat [Global] betreten.");
			return true;
		}else
			
		if(cmd.getName().equalsIgnoreCase("h")) {
			MCSocial.channel.join(p, "Handel");
			p.sendMessage("Chat [Handel] betreten.");
			return true;
		}else
			
		if(cmd.getName().equalsIgnoreCase("a")) {
			MCSocial.channel.join(p, "Admin");
			p.sendMessage("Chat [Admin] betreten.");
			return true;
		}else
			
		if(cmd.getName().equalsIgnoreCase("l")) {
			MCSocial.channel.join(p, "Lokal");
			p.sendMessage("Chat [Lokal] betreten.");
			return true;
		}else
			
		if(cmd.getName().equalsIgnoreCase("join")) {

			
			if(args.length == 0){
				p.sendMessage(ChatColor.BOLD + "" +ChatColor.RED + "---------------------------");
				p.sendMessage(ChatColor.BOLD + "" +ChatColor.RED + "Bitte Chat Namen angeben");
				p.sendMessage(ChatColor.BOLD + "" +ChatColor.RED + "---------------------------");
				p.sendMessage(ChatColor.BOLD + "" +ChatColor.RED + "Verfügbare Chat Kanäle");
				p.sendMessage(ChatColor.BOLD + "" +ChatColor.RED + "---------------------------");
				
				List<String> channels = MCSocial.channel.getList();
				
				for(String name: channels){
					p.sendMessage(ChatColor.BOLD + "" +ChatColor.RED + "" + name);				
				}
				p.sendMessage("---------------------------");
				return true;
			}
						
			if(args[0].equalsIgnoreCase("Global")){
				MCSocial.channel.join(p, "Global");
				p.sendMessage("Chat [Global] beigetreten.");
			}else if(args[0].equalsIgnoreCase("Support")){
				MCSocial.channel.join(p, "Support");	
				p.sendMessage("Chat [Support] beigetreten.");	
			}else if(args[0].equalsIgnoreCase("Admin")){
				if(PlayerPermissions.hasAccess(p, "admin")){
					MCSocial.channel.join(p, "Admin");		
					p.sendMessage("Chat [Admin] beigetreten.");
				}else{
					MCSocial.channel.join(p, "Lokal");	
					p.sendMessage("Chat [Lokal] beigetreten.");	
				}
			}else if(args[0].equalsIgnoreCase("Handel")){
				MCSocial.channel.join(p, "Handel");	
				p.sendMessage("Chat [Handel] beigetreten.");		
			}else {
				MCSocial.channel.join(p, "Lokal");	
				p.sendMessage("Chat [Lokal] beigetreten.");			
			}
			return true;
		}else
		
		if(cmd.getName().equalsIgnoreCase("leave")) {

			
			if(args.length == 0){
				p.sendMessage(ChatColor.BOLD + "" +ChatColor.RED + "---------------------------");
				p.sendMessage(ChatColor.BOLD + "" +ChatColor.RED + "Bitte Chat Namen angeben");
				p.sendMessage(ChatColor.BOLD + "" +ChatColor.RED + "---------------------------");
				p.sendMessage(ChatColor.BOLD + "" +ChatColor.RED + "Verfügbare Chat Kanäle");
				p.sendMessage(ChatColor.BOLD + "" +ChatColor.RED + "---------------------------");
				
				List<String> channels = MCSocial.channel.getList();
				
				for(String name: channels){
					p.sendMessage(ChatColor.BOLD + "" +ChatColor.RED + "" + name);				
				}
				p.sendMessage("---------------------------");
				return true;
			}
			
			if(args[0].equalsIgnoreCase("Global")){
				MCSocial.channel.leave(p, "Global");
			}else if(args[0].equalsIgnoreCase("Support")){
				MCSocial.channel.leave(p, "Support");			
			}else if(args[0].equalsIgnoreCase("Admin")){
				MCSocial.channel.leave(p, "Admin");			
			}else if(args[0].equalsIgnoreCase("Handel")){
				MCSocial.channel.leave(p, "Handel");				
			}
			p.sendMessage("Chat " + args[0]+ " verlassen.");
			return true;
		}
			
		
		
		if(args.length >=1 ){
			@SuppressWarnings("deprecation")
			List<Player> allPlayer = Arrays.asList(Bukkit.getServer().getOnlinePlayers());

			if(Jail.isInJail(p)){
	        	p.sendMessage(ChatColor.RED + "Du bist im Gefängniss. Schweige und schreibe deine Sünden in das Buch!");
	 			MCSocial.channel.join(p,"Lokal");
	        }
	        
	        
	        if(Jail.isJailChunks(p.getLocation().getChunk()))
			{
				MCSocial.channel.join(p, "Lokal");
			}
	        
			for (Player chatPlayer: allPlayer){		        
					
				if(Jail.isJailChunks( chatPlayer.getLocation().getChunk()))
				{
					MCSocial.channel.join(chatPlayer, "Lokal");
				}
				
				if(!MCSocial.channel.isInChat(chatPlayer,p.getMetadata("channel").get(0).asString())){
					continue;
				}
				if(p.hasMetadata("channel")){
					if(p.getMetadata("channel").get(0).asString() == "Lokal"){
						if(outOfRange(p.getLocation(),chatPlayer.getLocation(),200)){
							continue;
						}
					}
					if(Jail.isInJail(chatPlayer)){
						continue;
					}
				}
				
				String messagePrefix = ChatColor.WHITE  + "";        
		        
		        if(p.isOp()){
		        	messagePrefix += ChatColor.RED +"[OP] ";
		        }
		        else if(p.hasMetadata("isAdmin") && p.getMetadata("isAdmin").get(0).asBoolean()){
		        	messagePrefix += ChatColor.RED +""+ ChatColor.BOLD +"[A] ";
		        }
		        else if(p.hasMetadata("isSupporter") && p.getMetadata("isSupporter").get(0).asBoolean()){
		        	messagePrefix += ChatColor.RED +""+ ChatColor.BOLD +"[S] ";
		        }
		        else if(p.hasMetadata("isModerator") && p.getMetadata("isModerator").get(0).asBoolean()){
		        	messagePrefix += ChatColor.RED +""+ ChatColor.BOLD +"[M] ";
		        }
		        
		        if(p.hasMetadata("newPlayer")){
		        	messagePrefix += ChatColor.GREEN + "[New] ";
		        }        
		        else if(p.hasMetadata("cityowner")){
		        	messagePrefix += ChatColor.BLUE +"Lehnsherr ";
		        }
		        //Beruf
		        else if(p.hasMetadata("job") && p.getMetadata("job").get(0).asString() != null){
		        	messagePrefix += ChatColor.DARK_GRAY +" "+ p.getMetadata("job").get(0).asString()+" ";
		        }


		        if(p.hasMetadata("city")){
		        	messagePrefix = ChatColor.GOLD +"<"+City.cityList.get(UUID.fromString(p.getMetadata("city").get(0).asString())).getName()+">" + messagePrefix + "" + ChatColor.GOLD;
		        }

		        if(p.hasMetadata("isDonator") && p.getMetadata("isDonator").get(0).asBoolean()){
		        	messagePrefix = ChatColor.GOLD +"[D] " + messagePrefix + "" + ChatColor.GOLD;
		        }

		        String message = "["+ p.getWorld().getName()+"] " + ChatColor.BOLD + "<" + p.getPlayer().getMetadata("channel").get(0).asString() + "> " +messagePrefix +  p.getPlayer().getName() + ChatColor.WHITE+ ":";
				for(String text: args){
					message+= " " +text;
				}
				chatPlayer.sendMessage(message);
				return true;
	        }
		}
		
		// TODO Auto-generated method stub
		return false;
	}
	
	@EventHandler
	public void onVote(VoteNotificationEvent event){
		VoteNotify vote = event.getVote();
		Bukkit.broadcastMessage(ChatColor.RED + "" + ChatColor.BOLD + "" + vote.getUsername() + " hat gevotet. Vielen Dank. Du sollst reich belohnt werden!");
		Bukkit.broadcastMessage(ChatColor.RED + "" + ChatColor.BOLD + "Vote auch du und werde belohnt! https://minecraft-server.eu/server/index/107161/minecraft_social");
		
		Player p = Bukkit.getPlayer(vote.getUsername());
		if(p == null) return;
		
		Account.add(p, 1000.00);
		List<Material> randomMat = new ArrayList<Material>();
		randomMat.add(Material.DIAMOND_AXE);
		randomMat.add(Material.DIAMOND);
		randomMat.add(Material.DIAMOND_SWORD);
		randomMat.add(Material.DIAMOND_BOOTS);
		randomMat.add(Material.DIAMOND_CHESTPLATE);
		randomMat.add(Material.DIAMOND_HELMET);
		randomMat.add(Material.DIAMOND_HOE);
		randomMat.add(Material.DIAMOND_PICKAXE);
		randomMat.add(Material.DIAMOND_LEGGINGS);
		Random r = new Random();
		int random = r.nextInt(randomMat.size());
		p.getInventory().addItem(new ItemStack(randomMat.get(random),1));
	}
	
	@SuppressWarnings("static-access")
	@EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent event) {
		try {
			ChatLogger.writeLog(event.getPlayer(), event.getMessage());
		} catch( Exception e){
			event.getPlayer().sendMessage(ChatColor.RED + e.getMessage());
		}
		try {
			WebChatHandler.executePost("http://hook.crank.zone/mc","{\"player\":\""+event.getPlayer()+"\",\"msg\":\""+event.getMessage()+"\"}");
		} catch( Exception e){
			event.getPlayer().sendMessage(ChatColor.RED + e.getMessage());
		}
		
		
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
        
        if(event.getPlayer().hasMetadata("folk") && event.getPlayer().getMetadata("folk").get(0).asString() != null){
        	messagePrefix += ChatColor.DARK_GREEN +" "+ event.getPlayer().getMetadata("folk").get(0).asString()+" ";
        }
        
        //Beruf
        if(event.getPlayer().hasMetadata("job") && event.getPlayer().getMetadata("job").get(0).asString() != null){
        	messagePrefix += ChatColor.DARK_GRAY +" "+ event.getPlayer().getMetadata("job").get(0).asString()+" ";
        }

        if(event.getPlayer().hasMetadata("city")){
        	try{
        		messagePrefix = ChatColor.GOLD +"<"+City.cityList.get(UUID.fromString(event.getPlayer().getMetadata("city").get(0).asString())).getName()+">" + messagePrefix + "" + ChatColor.GOLD;
        	}catch(IllegalArgumentException e){
        		
        	}catch(NullPointerException e){
            	
            }
        }

        if(event.getPlayer().hasMetadata("isDonator") && event.getPlayer().getMetadata("isDonator").get(0).asBoolean()){
        	messagePrefix = ChatColor.GOLD +"[D] " + messagePrefix + "" + ChatColor.GOLD;
        }
				        
    	event.setFormat("%2$s");
        event.setMessage(ChatColor.BOLD + "<" + event.getPlayer().getMetadata("channel").get(0).asString() + "> " +messagePrefix +  event.getPlayer().getName() + ChatColor.WHITE+ ": "+ event.getMessage().replace("$",""));
        
        if(event.getRecipients().size() == 1)
        {
        	event.getPlayer().sendMessage( ChatColor.BOLD + "" + ChatColor.RED + "Niemand kann dich hören.");
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
	@SuppressWarnings("unused")
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
