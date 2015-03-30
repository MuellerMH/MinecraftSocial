package de.mcsocial.books;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;

public class WelcomeBook {
	
	private String author;
	private String title;
	private List<String> customPages;
	private BookMeta bm;
	protected ItemStack book;
	
	public WelcomeBook(){
		author = "MuellerMH";
		title = "Willkommen!";
		customPages = new ArrayList<String>();
	}

	
	private void addPage(String string) {
		// TODO Auto-generated method stub
		customPages.add(string);		
	}
	
	public ItemStack getBook(){
		ItemStack book = new ItemStack(Material.BOOK_AND_QUILL, 1);			
		BookMeta bm = (BookMeta) book.getItemMeta();
		bm.setAuthor(author);
		bm.setDisplayName(title);
		Page1(bm);
		Page2(bm);
		Page3(bm);
		Page4(bm);
		Page5(bm);
		Page6(bm);
		Page7(bm);
		book.setItemMeta(bm);
		return book;
	}
	
	private void Page1(BookMeta bm2){
		bm2.addPage("1");
		List<String> content = new LinkedList<String>();
		content.add("Willkommen auf dem Minecraft Social Server.\n");
		content.add("Wenn du neu auf unserem Server bist kannst du zu erst ein Volk und anschliessend einen Beruf waehlen.\n");
		content.add("Wenn du im Chat /m eingibst wirst du nach deiner Volkswahl gefragt.\n");		
		bm2.setPage(1,content.toString());
	}


	private void Page2(BookMeta bm2){
		bm2.addPage("2");
		List<String> content = new LinkedList<String>();
		content.add("Diese Entscheidung kann nicht Rueckgaengig gemacht werden also waehle weise.\n");
		content.add("Wenn du nun wieder das Menu mit /m aufrufst hast du eine groessere Auswahl.\n");
		content.add("Darunter findest du das Spieler Menu, hier kannst du deinen Beruf waehlen.\n");
		content.add("Diesen kannst du maximal...\n");	
		bm2.setPage(2,content.toString());
	}
	
	private void Page3(BookMeta bm2){
		bm2.addPage("3");
		List<String> content = new LinkedList<String>();
		content.add("alle 7 Tage wechseln.\n");
		content.add("Der Beruf gibt dir die Moeglichkeit Geld zu verdienen und Berufsbezogene Items herzustellen.\n");
		content.add("Items die anderen Berufen angehoeren kannst du nicht herstellen.\n");
		content.add("Weiter bietet dir das Menu Moeglichkeiten zur Schnellreise, ...\n");		
		bm2.setPage(3,content.toString());
	}
	
	private void Page4(BookMeta bm2){
		bm2.addPage("4");
		List<String> content = new LinkedList<String>();
		content.add("Staedteverwaltung und vieles mehr.\n");
		content.add("Wir wuenschen dir Viel Spass.\n");
		content.add("Technische Daten:\n");
		content.add("Teamspeak: ts84.nitrado.net\n");
		content.add("Webseite: http://minecraft-social.de\n");
		content.add("Weiter zu den Regeln...\n");		
		bm2.setPage(4,content.toString());
		
	}
	
	private void Page5(BookMeta bm2){
		bm2.addPage("5");
		List<String> content = new LinkedList<String>();
		content.add("I. Geht Respektvoll miteinander um. Keine Beleidigung, Mobbing, Diskriminierung, Rasismus koennen zum Ban fuehren.\n");
		content.add("II. Behandel andere wie dua auch behandelt werden moechtest. Griefe nicht, toete keine unbewaffneten, toete keinen NewSpawn, toete nicht in Staedten.\n");
		
		bm2.setPage(5,content.toString());
	}
	
	private void Page6(BookMeta bm2){
		bm2.addPage("6");
		List<String> content = new LinkedList<String>();
		content.add("Bei missachtung droht das Gefaengniss.\n");
		content.add("III. Nutze die Farmwelt um abzubauen und lasse die Optik der Welt bestehen.\n");
		content.add("IV. Belate den Server nicht unnoetig (Clocks, Sammelfarmen) die anderen Spieler werden es dir Danken.\n");
		content.add("V. Fehler, bitte melden!\n");	
		bm2.setPage(6,content.toString());	
	}
	
	private void Page7(BookMeta bm2){
		bm2.addPage("7");
		List<String> content = new LinkedList<String>();
		content.add("VI. Erlaubte Mods: -keine-\n");
		content.add("Wir sind ein Survuval Server!\n");
		content.add("Hilfe Videos findets du auf unserem YouTube Channel Minecraft Social\n");
		content.add("https://www.youtube.com/channel/UCSAgTrlzVwA9syFkjsXHd6Q\n");
		content.add("oder auf unserer Webseite:\n");
		content.add("http://minecraft-social.de\n");	
		bm2.setPage(7,content.toString());
		
	}
}
