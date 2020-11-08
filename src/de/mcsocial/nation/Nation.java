package de.mcsocial.nation;

import java.util.HashMap;

public class Nation {

	private String name;
	private static HashMap<String,Nation> allNations;

	public static Nation getNation(String name) {
		return Nation.allNations.get(name);
	}

	public static void setNation(Nation nation) {
		Nation.allNations.put(nation.getName(),nation);
	}

	private String getName() {
		return this.name;
	}
}
