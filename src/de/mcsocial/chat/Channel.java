package de.mcsocial.chat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import org.bukkit.entity.Player;
import org.bukkit.metadata.FixedMetadataValue;

import de.mcsocial.main.MCSocial;
import de.mcsocial.protection.Jail;

public class Channel {
<<<<<<< HEAD
	
	private static List<String>channels;
	private static HashMap<UUID,List<String>>inChannel;
	
	public Channel(){
		Channel.inChannel = new HashMap<UUID,List<String>>();
		Channel.channels = new ArrayList<String>();
	}

	public static void create(String name) {		
=======

	private static List<String> channels;
	private static HashMap<UUID, List<String>> inChannel;

	public Channel() {
		Channel.inChannel = new HashMap<UUID, List<String>>();
		Channel.channels = new ArrayList<String>();
	}

	public static void create(String name) {
>>>>>>> b4ade11... add new directory
		Channel.channels.add(name);
	}

	public static void delete(String name) {
		Channel.channels.remove(name);
	}
<<<<<<< HEAD
	
	public static Boolean isInChat(Player p, String name){
		if(!Channel.inChannel.containsKey(p.getUniqueId())){
=======

	public static Boolean isInChat(Player p, String name) {
		if (!Channel.inChannel.containsKey(p.getUniqueId())) {
>>>>>>> b4ade11... add new directory
			Channel.inChannel.put(p.getUniqueId(), new ArrayList<String>());
		}
		return Channel.inChannel.get(p.getUniqueId()).contains(name);
	}
<<<<<<< HEAD
	
	public static void join(Player p, String name) {
		if(Jail.isInJail(p)){
			p.sendMessage("Du bist im Gefängniss und kannst keinen anderen Channel beitreten.");
			return;
		}
		if(Channel.inChannel == null){
			Channel.inChannel = new HashMap<UUID,List<String>>();
		}
		if(!Channel.inChannel.containsKey(p.getUniqueId())){
=======

	public static void join(Player p, String name) {
		if (Jail.isInJail(p)) {
			p.sendMessage("Du bist im Gefï¿½ngniss und kannst keinen anderen Channel beitreten.");
			return;
		}
		if (Channel.inChannel == null) {
			Channel.inChannel = new HashMap<UUID, List<String>>();
		}
		if (!Channel.inChannel.containsKey(p.getUniqueId())) {
>>>>>>> b4ade11... add new directory
			Channel.inChannel.put(p.getUniqueId(), new ArrayList<String>());
		}
		Channel.inChannel.get(p.getUniqueId()).add(name);
		p.setMetadata("channel", new FixedMetadataValue(MCSocial.instance, name));
	}
<<<<<<< HEAD
	
	public static void leave(Player p, String name) {
		if(Jail.isInJail(p)){
			p.sendMessage("Du bist im Gefängniss und kannst keine anderen Channel verlassen.");
			return;
		}
		if(!Channel.channels.contains(name)){
			p.sendMessage("Channel "+name+" existiert nicht.");
			return;
		}
		if(!Channel.inChannel.containsKey(p.getUniqueId())){
			Channel.inChannel.put(p.getUniqueId(), new ArrayList<String>());	
=======

	public static void leave(Player p, String name) {
		if (Jail.isInJail(p)) {
			p.sendMessage("Du bist im Gefï¿½ngniss und kannst keine anderen Channel verlassen.");
			return;
		}
		if (!Channel.channels.contains(name)) {
			p.sendMessage("Channel " + name + " existiert nicht.");
			return;
		}
		if (!Channel.inChannel.containsKey(p.getUniqueId())) {
			Channel.inChannel.put(p.getUniqueId(), new ArrayList<String>());
>>>>>>> b4ade11... add new directory
			return;
		}
		Channel.inChannel.get(p.getUniqueId()).remove(name);
		p.setMetadata("channel", new FixedMetadataValue(MCSocial.instance, "local"));
		p.sendMessage("Du bist nun im Lokalem Chat.");
	}

<<<<<<< HEAD

=======
>>>>>>> b4ade11... add new directory
	public static List<String> getList() {
		// TODO Auto-generated method stub
		return Channel.channels;
	}

	static boolean channelExist(String string) {
		// TODO Auto-generated method stub
		return Channel.channels.contains(string);
	}
<<<<<<< HEAD
	
=======

>>>>>>> b4ade11... add new directory
}
