package de.mcsocial.gui.items;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.conversations.ConversationContext;
import org.bukkit.conversations.ConversationFactory;
import org.bukkit.conversations.ConversationPrefix;
import org.bukkit.conversations.Prompt;
import org.bukkit.conversations.StringPrompt;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import de.mcsocial.economy.Account;
import de.mcsocial.gui.Gui;
import de.mcsocial.gui.MenuItem;
import de.mcsocial.gui.Menus.AccountMenu;
import de.mcsocial.gui.Menus.PlayerMenu;
import de.mcsocial.main.MCSocial;

public class AccountItem extends MenuItem {

	private ConversationFactory conversationFactory;

	public AccountItem(String text, Material icon) {

		super(text, new ItemStack(icon, 1));
	}

	@Override
	public void onClick(Player p) {

		switch (this.getText()) {
			case "Spieler Menu":

				Gui.switchMenu(p, AccountMenu.menu, PlayerMenu.menu);
				break;
			case "Spieler Geld geben":
				this.conversationFactory = new ConversationFactory(MCSocial.instance).withModality(true)
						.withPrefix(new SummoningConversationPrefix()).withFirstPrompt(new AccountPrompt())
						.withEscapeSequence("/quit").withTimeout(15).thatExcludesNonPlayersWithMessage("Go away evil console!");
				conversationFactory.buildConversation(p).begin();
				AccountMenu.menu.closeMenu(p);
				break;
			case "Kontostand":

				p.sendMessage("Kontoverwalter: Aktueller Kontostand: " + p.getMetadata("account").get(0).asInt() + " SD");
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
			try {
				Player sender = (Player) arg0.getForWhom();
				@SuppressWarnings("deprecation")
				Player reciver = (Player) Bukkit.getOfflinePlayer(arg1.split(" ")[0]);
				Double amount = Double.parseDouble(arg1.split(" ")[1]);

				Account.trans(sender, reciver, amount);
			} catch (Exception e) {
			}
			return null;
		}

		@Override
		public String getPromptText(ConversationContext arg0) {

			return "Gib nun den SPIELERNAMEN und den BETRAG im Chat ein: Beispiel: MuellerMH 1000";
		}

	}

	private class SummoningConversationPrefix implements ConversationPrefix {

		public String getPrefix(ConversationContext context) {
			String what = (String) context.getSessionData("type");
			Integer count = (Integer) context.getSessionData("count");
			Player who = (Player) context.getSessionData("who");

			if (what != null && count == null && who == null) {
				return ChatColor.GREEN + "Kontoverwalter " + what + ": " + ChatColor.WHITE;
			}
			if (what != null && count != null && who == null) {
				return ChatColor.GREEN + "Kontoverwalter " + count + " " + what + ": " + ChatColor.WHITE;
			}
			if (what != null && count != null && who != null) {
				return ChatColor.GREEN + "Kontoverwalter " + count + " " + what + " to " + who.getName() + ": "
						+ ChatColor.WHITE;
			}
			return ChatColor.GREEN + "Kontoverwalter: " + ChatColor.WHITE;
		}
	}

}
