package rpg;

import java.util.ArrayList;

public class Inventory {
	private ArrayList<Item> itemList = new ArrayList<>();

	public void inventoryMenu() {
		while (true) {
			System.out.println("============ [인벤메뉴] =============");
			System.out.println("[1.착용] [2.판매] [0.뒤로가기]");
			int sel = MainGame.scan.nextInt();
			if (sel == 1)
				equipMenu();
			else if (sel == 2)
				sellMenu();
			else if (sel == 0)
				break;				
		}
	}

	public void equipMenu() {
		Player.getGuild().printAllUnitStaus();
		System.out.println("아이템 착용할 길드원을 선택하세요 ");
		int selUnit = MainGame.scan.nextInt();
		while (true) {
			Player.getGuild().printUnitStaus(selUnit - 1);
			Player.getGuild().printUnitItem(selUnit - 1);
			printItemList();
			System.out.println("착용할 아이템 번호를 입력하세요 [0.뒤로가기]");
			int selEquip = MainGame.scan.nextInt();
			if (selEquip == 0)
				break;
			selEquip -= 1;
			if (getItemList().get(selEquip).getKind() == Item.WEAPON) {
				if (Player.getGuildUnit(selUnit - 1).getWeapon() != null) {
					getItemList().add(Player.getGuildUnit(selUnit - 1).getWeapon());
				}
				Player.getGuildUnit(selUnit - 1).setWeapon(getItemList().get(selEquip));
			} else if (getItemList().get(selEquip).getKind() == Item.ARMOR) {
				if (Player.getGuildUnit(selUnit - 1).getArmor() != null) {
					getItemList().add(Player.getGuildUnit(selUnit - 1).getArmor());
				}
				Player.getGuildUnit(selUnit - 1).setArmor(getItemList().get(selEquip));
			} else if (getItemList().get(selEquip).getKind() == Item.RING) {
				if (Player.getGuildUnit(selUnit - 1).getRing() != null) {
					getItemList().add(Player.getGuildUnit(selUnit - 1).getRing());
				}
				Player.getGuildUnit(selUnit - 1).setRing(getItemList().get(selEquip));
				if(Player.getGuildUnit(selUnit - 1).getJob() == 3)
					Player.getGuildUnit(selUnit - 1).setNewHp(Player.getGuildUnit(selUnit - 1).getHp() + getItemList().get(selEquip).getPower()*2);
				else
					Player.getGuildUnit(selUnit - 1).setNewHp(Player.getGuildUnit(selUnit - 1).getHp() + getItemList().get(selEquip).getPower());
			}
			getItemList().remove(selEquip);
		}
	}

	public void printItemList() {
		System.out.println("============ [아이템리스트] ==============");
		for (int i = 0; i < getItemList().size(); i++) {
			System.out.print("[" + (i + 1) + "번]");
			System.out.print("[이름: " + getItemList().get(i).getName() + "]");
			System.out.print("[능력: " + getItemList().get(i).getPower() + "]");
			System.out.print("[가격: " + getItemList().get(i).getPrice() + "]");
			System.out.println();
		}
	}

	public void sellMenu() {
		while (true) {
			printItemList();
			System.out.println("[골드 : " + Player.getMoney() + "]");
			System.out.println("판매할 아이템 번호를 입력하세요. (50 % 세금) [0.뒤로가기]");
			int selSell = MainGame.scan.nextInt();
			if(selSell == 0)
				break;
			
			System.out.println(getItemList().get(selSell - 1).getName() + "을 판매합니다.");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			Player.setMoney(Player.getMoney() + (getItemList().get(selSell - 1).getPrice() / 2));
			getItemList().remove(selSell - 1);
		}
	}

	public void addItem(Item item) {
		getItemList().add(item);
	}

	public ArrayList<Item> getItemList() {
		return itemList;
	}

	public void setItemList(ArrayList<Item> itemList) {
		this.itemList = itemList;
	}

}