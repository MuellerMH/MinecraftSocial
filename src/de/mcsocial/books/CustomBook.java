package de.mcsocial.books;

import java.util.List;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;

public class CustomBook {
	
	private String author;
	private String title;
	private List<String> customPages;
	private BookMeta bm;
	protected ItemStack book;
	
	public CustomBook(){
		this.book = new ItemStack(Material.WRITTEN_BOOK, 1);			
		this.bm = (BookMeta) this.book.getItemMeta();
	}
	
	protected void addPage(String content){
		this.bm.addPage(content);
	}
	
	protected void setTitle(String title){
		this.bm.setDisplayName(title);	
	}
	
	protected void setAuthor(String author){
		this.bm.setAuthor(author);	
	}
	
	protected void setPages(){
		
		this.bm.setPages(this.customPages);
	}
		
	protected ItemStack writeBook(){
		this.book.setItemMeta(this.bm);
		return this.book;
	}
		
		
}




