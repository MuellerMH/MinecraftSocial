package de.mcsocial.nation;

import java.util.HashMap;

public class Folk {
	
	private String name;
	private static HashMap<String,Folk> allFolks;

	public static Folk getFolk(String name) {
		return Folk.allFolks.get(name);
	}

	public static void setFolk(Folk folk) {
		Folk.allFolks.put(folk.getName(),folk);
	}

	private String getName() {
		// TODO Auto-generated method stub
		return this.name;
	}
}
