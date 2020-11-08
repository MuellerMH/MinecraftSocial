package de.mcsocial.gui.items;

import java.util.UUID;

import org.bukkit.ChatColor;
import org.bukkit.Chunk;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.conversations.ConversationContext;
import org.bukkit.conversations.ConversationFactory;
import org.bukkit.conversations.ConversationPrefix;
import org.bukkit.conversations.Prompt;
import org.bukkit.conversations.StringPrompt;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import de.mcsocial.city.City;
import de.mcsocial.economy.Account;
import de.mcsocial.gui.Gui;
import de.mcsocial.gui.Menu;
import de.mcsocial.gui.MenuItem;
import de.mcsocial.gui.Menus.CityManagerMenu;
import de.mcsocial.gui.Menus.CityMenu;
import de.mcsocial.gui.Menus.Hauptmenu;
import de.mcsocial.main.MCSocial;
import de.mcsocial.protection.ChunkHandler;
import de.mcsocial.protection.Jail;

public class CityItem extends MenuItem {
<<<<<<< HEAD
	
	private Location loc;
	private ConversationFactory conversationFactory;
	public static String cityName = null; 



	public CityItem(String text, Material icon) {
		// TODO Auto-generated constructor stub
		super(text, new ItemStack(icon,1));
	}
	
	public void setLocation(Location loc){
		this.loc = loc;
	}
		
	@Override
	public void onClick(Player p) {
		
		switch(this.getText()){
			case "Grundstueck kaufen":
				ChunkHandler.claimChunk(p, 4000.00);
				Hauptmenu.menu.closeMenu(p);				
			break;
			case "Grundstueck verkaufen":
				ChunkHandler.unclaimChunk(p, 2000.00);
				Hauptmenu.menu.closeMenu(p);				
			break;
			case "Stadt verlassen":
				if(!p.hasMetadata("city"))
					return;
				try{
=======

	private Location loc;
	private ConversationFactory conversationFactory;
	public static String cityName = null;

	public CityItem(String text, Material icon) {
		// TODO Auto-generated constructor stub
		super(text, new ItemStack(icon, 1));
	}

	public void setLocation(Location loc) {
		this.loc = loc;
	}

	@SuppressWarnings("unlikely-arg-type")
	@Override
	public void onClick(Player p) {

		switch (this.getText()) {
			case "Grundstueck kaufen":
				ChunkHandler.claimChunk(p, 4000.00);
				Hauptmenu.menu.closeMenu(p);
				break;
			case "Grundstueck verkaufen":
				ChunkHandler.unclaimChunk(p, 2000.00);
				Hauptmenu.menu.closeMenu(p);
				break;
			case "Stadt verlassen":
				if (!p.hasMetadata("city"))
					return;
				try {
>>>>>>> b4ade11... add new directory
					City.leave(p, City.cityList.get(UUID.fromString(p.getMetadata("city").get(0).asString())));
					City.residentList.remove(p.getUniqueId());
					Hauptmenu.menu.closeMenu(p);
					p.sendMessage("Du bist aus der Stadt ausgetreten");
<<<<<<< HEAD
				}catch(NullPointerException e){
					p.removeMetadata("city", MCSocial.instance);
					p.sendMessage("Du konntest die Stadt nicht verlassen. Versuch es sp�ter noch einmal.");
				}
				
			break;
			case "St�dte Menu":
				// TODO Auto-generated method stub
				Menu cityMenu = new Menu("City",4);
				Gui.switchMenu(p, Hauptmenu.menu, cityMenu);
				CityMenu.loadMenu(cityMenu,p);
			break;
			case "Stadt gr�nden":
				if(!p.isOp()){
					
					if(Account.getBalance(p) < 15000.00){
						p.sendMessage("Du hast nicht gen�gend Geld. Du ben�tigst 15000 SD");
						return;
					}
					if(City.cityList.containsKey(p.getUniqueId())) {
						p.sendMessage(ChatColor.GREEN + "CityEditor: " + "Gr�ndung nicht M�glich. Du bist bereits B�rgermeister einer Stadt.");
						return;
					}
					
					if(City.residentList.containsValue(p.getUniqueId())) {
						p.sendMessage(ChatColor.GREEN + "CityEditor: " + "Gr�ndung nicht M�glich. Du bist bereits B�rgermeister einer Stadt.");
						return;
					}
				}
										
				 this.conversationFactory = new ConversationFactory(MCSocial.instance)
	                .withModality(true)                
	                .withPrefix(new SummoningConversationPrefix())
	                .withFirstPrompt(new CityNamePrompt())
	                .withEscapeSequence("/quit")
	                .withTimeout(5)
	                .thatExcludesNonPlayersWithMessage("Go away evil console!");
			     conversationFactory.buildConversation(p).begin();

				CityMenu.menu.closeMenu(p);
			break;
			case "Stadt verwalten":
				// TODO Auto-generated method stub
				Menu cityManagerMenu = new Menu("Stadt verwalten",3);
				CityManagerMenu.loadMenu(cityManagerMenu,p);
				Gui.switchMenu(p, CityMenu.menu, cityManagerMenu);
				
			break;
=======
				} catch (NullPointerException e) {
					p.removeMetadata("city", MCSocial.instance);
					p.sendMessage("Du konntest die Stadt nicht verlassen. Versuch es sp�ter noch einmal.");
				}

				break;
			case "St�dte Menu":
				// TODO Auto-generated method stub
				Menu cityMenu = new Menu("City", 4);
				Gui.switchMenu(p, Hauptmenu.menu, cityMenu);
				CityMenu.loadMenu(cityMenu, p);
				break;
			case "Stadt gr�nden":
				if (!p.isOp()) {

					if (Account.getBalance(p) < 15000.00) {
						p.sendMessage("Du hast nicht gen�gend Geld. Du ben�tigst 15000 SD");
						return;
					}
					if (City.cityList.containsKey(p.getUniqueId())) {
						p.sendMessage(ChatColor.GREEN + "CityEditor: "
								+ "Gr�ndung nicht M�glich. Du bist bereits B�rgermeister einer Stadt.");
						return;
					}

					if (City.residentList.containsValue(p.getUniqueId())) {
						p.sendMessage(ChatColor.GREEN + "CityEditor: "
								+ "Gr�ndung nicht M�glich. Du bist bereits B�rgermeister einer Stadt.");
						return;
					}
				}

				this.conversationFactory = new ConversationFactory(MCSocial.instance).withModality(true)
						.withPrefix(new SummoningConversationPrefix()).withFirstPrompt(new CityNamePrompt())
						.withEscapeSequence("/quit").withTimeout(5).thatExcludesNonPlayersWithMessage("Go away evil console!");
				conversationFactory.buildConversation(p).begin();

				CityMenu.menu.closeMenu(p);
				break;
			case "Stadt verwalten":
				// TODO Auto-generated method stub
				Menu cityManagerMenu = new Menu("Stadt verwalten", 3);
				CityManagerMenu.loadMenu(cityManagerMenu, p);
				Gui.switchMenu(p, CityMenu.menu, cityManagerMenu);

				break;
>>>>>>> b4ade11... add new directory
			case "Grundstueck belegt":
			case "GS Information":
				// TODO Auto-generated method stub
				ChunkHandler.markEdges(p);
				Chunk chunkinfo = p.getLocation().getChunk();
<<<<<<< HEAD
				if(ChunkHandler.ownedChunks.containsKey(chunkinfo.toString())) {
					String owner = ChunkHandler.getOwnerName(chunkinfo.toString());
					if(owner == null)
						p.sendMessage("Grundst�ck geh�rt: unbekannt");
					else
						p.sendMessage("Grundst�ck geh�rt: " + owner);
				}								

				Hauptmenu.menu.closeMenu(p);
			break;
=======
				if (ChunkHandler.ownedChunks.containsKey(chunkinfo.toString())) {
					String owner = ChunkHandler.getOwnerName(chunkinfo.toString());
					if (owner == null)
						p.sendMessage("Grundst�ck geh�rt: unbekannt");
					else
						p.sendMessage("Grundst�ck geh�rt: " + owner);
				}

				Hauptmenu.menu.closeMenu(p);
				break;
>>>>>>> b4ade11... add new directory
			case "Hauptmenu":
				// TODO Auto-generated method stub
				Gui.switchMenu(p, CityMenu.menu, Hauptmenu.menu);
				break;
<<<<<<< HEAD
				
		   default:
			   if(Jail.isInJail(p)){
				   break;
			   }
			   if(Account.getBalance(p) < 500.00){
					p.sendMessage("Schnellreise nicht m�glich. Du hast nicht gen�gend Geld. Du ben�tigst 500 SD");
					return;
				}
			   p.teleport(this.loc);
			   break;
		}
		
	}
	
=======

			default:
				if (Jail.isInJail(p)) {
					break;
				}
				if (Account.getBalance(p) < 500.00) {
					p.sendMessage("Schnellreise nicht m�glich. Du hast nicht gen�gend Geld. Du ben�tigst 500 SD");
					return;
				}
				p.teleport(this.loc);
				break;
		}

	}

>>>>>>> b4ade11... add new directory
	private class CityNamePrompt extends StringPrompt {

		@Override
		public Prompt acceptInput(ConversationContext arg0, String arg1) {
			// TODO Auto-generated method stub
			City city = new City();
<<<<<<< HEAD
			city.create(((Player)arg0.getForWhom()),arg1);
=======
			city.create(((Player) arg0.getForWhom()), arg1);
>>>>>>> b4ade11... add new directory
			return null;
		}

		@Override
		public String getPromptText(ConversationContext arg0) {
			// TODO Auto-generated method stub
<<<<<<< HEAD
			 return "Gibt den Namen deiner Stadt im Chat ein, du hast 5 Sekunden Zeit:";
		}
		
	}
	
	private class SummoningConversationPrefix implements ConversationPrefix {

        public String getPrefix(ConversationContext context) {
            String what = (String)context.getSessionData("type");
            Integer count = (Integer)context.getSessionData("count");
            Player who = (Player)context.getSessionData("who");
            
            if (what != null && count == null && who == null) {
                return ChatColor.GREEN + "CityEditor " + what + ": " + ChatColor.WHITE;
            }
            if (what != null && count != null && who == null) {
                return ChatColor.GREEN + "CityEditor " + count + " " + what + ": " + ChatColor.WHITE;
            }
            if (what != null && count != null && who != null) {
                return ChatColor.GREEN + "CityEditor " + count + " " + what + " to " + who.getName() + ": " + ChatColor.WHITE;
            }
            return ChatColor.GREEN + "CityEditor: " + ChatColor.WHITE;
        }
    }

=======
			return "Gibt den Namen deiner Stadt im Chat ein, du hast 5 Sekunden Zeit:";
		}

	}

	private class SummoningConversationPrefix implements ConversationPrefix {

		public String getPrefix(ConversationContext context) {
			String what = (String) context.getSessionData("type");
			Integer count = (Integer) context.getSessionData("count");
			Player who = (Player) context.getSessionData("who");

			if (what != null && count == null && who == null) {
				return ChatColor.GREEN + "CityEditor " + what + ": " + ChatColor.WHITE;
			}
			if (what != null && count != null && who == null) {
				return ChatColor.GREEN + "CityEditor " + count + " " + what + ": " + ChatColor.WHITE;
			}
			if (what != null && count != null && who != null) {
				return ChatColor.GREEN + "CityEditor " + count + " " + what + " to " + who.getName() + ": " + ChatColor.WHITE;
			}
			return ChatColor.GREEN + "CityEditor: " + ChatColor.WHITE;
		}
	}
>>>>>>> b4ade11... add new directory

}
