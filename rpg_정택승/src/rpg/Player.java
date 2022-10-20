package rpg;

import java.util.ArrayList;

public class Player {
	private static int money;
	private static Guild guild = new Guild();
	private static Inventory inven = new Inventory();

	Player() {
		setMoney(100000);
		getGuild().setGuild();
	}

	public void guildMenu() {
		getGuild().guildMenu();
	}

	public void inventoryMenu() {
		getInven().inventoryMenu();
	}

	static public ArrayList<Hero> getGuildList() {
		return getGuild().getGuildList();
	}

	static public ArrayList<Item> getItemList() {
		return getInven().getItemList();
	}

	static public Hero getGuildUnit(int num) {
		return getGuild().getGuildUnit(num);
	}

	static public int getGuildSize() {
		return getGuild().getGuildList().size();
	}

	static public int getItemSize() {
		return getInven().getItemList().size();
	}

	public static int getMoney() {
		return money;
	}

	public static void setMoney(int money) {
		Player.money = money;
	}

	public static Inventory getInven() {
		return inven;
	}

	public static void setInven(Inventory inven) {
		Player.inven = inven;
	}

	public static Guild getGuild() {
		return guild;
	}

	public static void setGuild(Guild guild) {
		Player.guild = guild;
	}
}