package de.mcsocial.gui.items;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.conversations.ConversationContext;
import org.bukkit.conversations.ConversationFactory;
import org.bukkit.conversations.ConversationPrefix;
import org.bukkit.conversations.Prompt;
import org.bukkit.conversations.StringPrompt;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import de.mcsocial.gui.Gui;
import de.mcsocial.gui.MenuItem;
import de.mcsocial.gui.Menus.AccountMenu;
import de.mcsocial.gui.Menus.PlayerMenu;
import de.mcsocial.main.MCSocial;


public class AccountItem extends MenuItem {

	private ConversationFactory conversationFactory;

	public AccountItem(String text, Material icon) {
		// TODO Auto-generated constructor stub
		super(text, new ItemStack(icon,1));
	}

	@Override
	public void onClick(Player p) {
		// TODO Auto-generated method stub
		switch(this.getText()){
			case "Spieler Menu":
				// TODO Auto-generated method stub
				Gui.switchMenu(p, AccountMenu.menu, PlayerMenu.menu);
				break;
			case "Spieler Geld geben":
				this.conversationFactory = new ConversationFactory(MCSocial.instance)
                .withModality(true)                
                .withPrefix(new SummoningConversationPrefix())
                .withFirstPrompt(new AccountPrompt())
                .withEscapeSequence("/quit")
                .withTimeout(15)
                .thatExcludesNonPlayersWithMessage("Go away evil console!");
				conversationFactory.buildConversation(p).begin();	
				AccountMenu.menu.closeMenu(p);	     
				break;
			case "Kontostand":
				// TODO Auto-generated method stub
				p.sendMessage("§r§l§4Kontoverwalter: Aktueller Kontostand: " +p.getMetadata("account").get(0).asInt()+ " SD");
				AccountMenu.menu.closeMenu(p);	     
				break;	
			default:
			   p.sendMessage("Button Klick: " + this.getText());
			   break;
		}
	}
	
	private class AccountPrompt extends StringPrompt {

		@Override
		public Prompt acceptInput(ConversationContext arg0, String arg1) {
			// TODO Auto-generated method stub
			
			return null;
		}

		@Override
		public String getPromptText(ConversationContext arg0) {
			// TODO Auto-generated method stub
			 return "Gib nun den SPIELERNAMEN und den BETRAG im Chat ein: Beispiel: MuellerMH 1000";
		}
		
	}
	
	private class SummoningConversationPrefix implements ConversationPrefix {

        public String getPrefix(ConversationContext context) {
            String what = (String)context.getSessionData("type");
            Integer count = (Integer)context.getSessionData("count");
            Player who = (Player)context.getSessionData("who");
            
            if (what != null && count == null && who == null) {
                return ChatColor.GREEN + "Kontoverwalter " + what + ": " + ChatColor.WHITE;
            }
            if (what != null && count != null && who == null) {
                return ChatColor.GREEN + "Kontoverwalter " + count + " " + what + ": " + ChatColor.WHITE;
            }
            if (what != null && count != null && who != null) {
                return ChatColor.GREEN + "Kontoverwalter " + count + " " + what + " to " + who.getName() + ": " + ChatColor.WHITE;
            }
            return ChatColor.GREEN + "Kontoverwalter: " + ChatColor.WHITE;
        }
    }

}
