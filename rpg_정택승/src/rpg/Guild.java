package rpg;

import java.util.ArrayList;

public class Guild {
	final int PARTY_SIZE = 4;
	private ArrayList<Hero> guildList = new ArrayList<>();
	private Hero[] partyList;

	public void setGuild() {
		Hero temp = new Hero("호랑이", 1, 100, 10, 5, 0, Unit.DEALER);
		guildList.add(temp);
		temp = new Hero("강아지", 1, 80, 7, 3, 0, Unit.HEALER);
		guildList.add(temp);
		temp = new Hero("사슴", 1, 50, 3, 1, 0, Unit.TANKER);
		guildList.add(temp);
		temp = new Hero("두더지", 1, 70, 5, 2, 0, Unit.DEALER);
		guildList.add(temp);
		temp = new Hero("돼지", 1, 200, 4, 8, 0, Unit.TANKER);
		guildList.add(temp);
		temp = new Hero("사자", 1, 120, 11, 7, 0, Unit.DEALER);
		guildList.add(temp);
		for (int i = 0; i < 4; i++) {
			guildList.get(i).setParty(true);
		}
		partyList = new Hero[PARTY_SIZE];
		int n = 0;
		for (int i = 0; i < guildList.size(); i++) {
			if (guildList.get(i).isParty() == true) {
				partyList[n] = guildList.get(i);
				n += 1;
			}
		}
	}

	public Hero getGuildUnit(int num) {
		return guildList.get(num);
	}

	public void printAllUnitStaus() {
		System.out.println("======================================");
		System.out.println("[골드 : " + Player.getMoney() + "]");
		System.out.println("============= [길드원] =================");
		for (int i = 0; i < guildList.size(); i++) {
			System.out.print("[" + (i + 1) + "번] ");
//			System.out.print(" [이름 : " + guildList.get(i).getName() + "]");
//			System.out.print(" [레벨 : " + guildList.get(i).getLevel() + "]");
//			System.out.print(" [체력 : " + guildList.get(i).getHp());
//			System.out.println(" / " + guildList.get(i).getMaxHp() + "]");
//			System.out.print("[공격력 : " + guildList.get(i).getAtt() + "]");
//			System.out.print(" [방어력 : " + guildList.get(i).getDef() + "]");
//			System.out.println(" [파티중 : " + guildList.get(i).isParty() + "]");
//			System.out.println();
			guildList.get(i).printStatusHero();
			System.out.println();
		}
		System.out.println("=================================");
	}

	public void printUnitStaus(int num) {
		guildList.get(num).printStatusHero();
	}

	public void printUnitItem(int num) {
		guildList.get(num).printEquitedItem();
	}

	public void buyUnit() {
		if (Player.getMoney() < 5000) {
			System.out.println("골드가 부족합니다.");
			return;
		}
		System.out.print("길드원 이름 입력: ");
		String name = MainGame.scan.next();
		
		for(Unit list : guildList) {
			if(list.getName().equals(name)) {
				System.out.println("사용중인 이름입니다.");
				return;
			}
		}
		
		System.out.print("길드원 직업 입력(딜러-1, 힐러-2, 탱커-3): ");
		int job = MainGame.scan.nextInt();
		
		while(job < 1 || 3 < job) {
			System.out.println("화면의 번호 중에 입력하세요.");
			System.out.print("다시 입력: ");
			job = MainGame.scan.nextInt();
		}
		
		int ran = MainGame.ran.nextInt(8) + 2;
		int hp = ran * 11;
		int att = ran + 1;
		int def = ran / 2 + 1;
		Hero temp = new Hero(name, 1, hp, att, def, 0, job);

		System.out.println("=====================================");
//		System.out.print("[이름 : " + name + "]");
//		System.out.print(" [레벨 : " + 1 + "]");
//		System.out.print(" [체력 : " + hp);
//		System.out.println(" / " + hp + "]");
//		System.out.print("[공격력 : " + att + "]");
//		System.out.print(" [방어력 : " + def + "]");
//		System.out.println(" [직업: " + temp.getJobString(job) + "]");
		temp.printStatusHero();
		System.out.println("길드원을 추가합니다.");
		System.out.println("=====================================");

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		guildList.add(temp);
		Player.setMoney(Player.getMoney() - 5000);
	}

	public void removeUnit() {
		printAllUnitStaus();
		System.out.println("삭제할 번호를 입력하세요 ");
		int sel = MainGame.scan.nextInt();
		if (guildList.get(sel - 1).isParty()) {
			System.out.println("파티중인 멤버는 삭제할수 없습니다.");
		} else {
			System.out.println("=================================");
			System.out.print("[이름 : " + guildList.get(sel - 1).getName() + "]");
			System.out.println("길드원을 삭제합니다.");
			System.out.println("=================================");
			guildList.remove(sel - 1);
		}
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void printParty() {
		System.out.println("================ [파티원] ===============");
		for (int i = 0; i < PARTY_SIZE; i++) {
			System.out.print("[" + (i + 1) + "번]");
			System.out.println(" [이름: " + partyList[i].getName() + "]");
			System.out.print("=[레벨: " + partyList[i].getLevel() + "]");
			System.out.print(" [체력: " + partyList[i].getHp());
			System.out.println("/" + partyList[i].getMaxHp() + "]");
			System.out.print("=[공격력: " + partyList[i].getAtt() + "]");
			System.out.println(" [방어력: " + partyList[i].getDef() + "]");
			System.out.print("=[파티중: " + partyList[i].isParty() + "]");
			System.out.println(" [직업: " + partyList[i].getJobString(partyList[i].getJob()) + "]");
			System.out.println("");
		}
		System.out.println("=====================================");
	}

	public void partyChange() {

		printParty();
		System.out.println("교체할 번호를 입력하세요 ");
		int partyNum = MainGame.scan.nextInt();
		printAllUnitStaus();
		System.out.println("참가할 번호를 입력하세요 ");
		int guildNum = MainGame.scan.nextInt();

		partyList[partyNum - 1].setParty(false);
		guildList.get(guildNum - 1).setParty(true);

		System.out.println("====================================");
		System.out.print("[이름 : " + partyList[partyNum - 1].getName() + "]");
		System.out.print("에서 ");
		System.out.print("[이름 : " + guildList.get(guildNum - 1).getName() + "]");
		System.out.println("으로 교체 합니다. ");
		System.out.println("====================================");

		int n = 0;
		for (int i = 0; i < guildList.size(); i++) {
			if (guildList.get(i).isParty()) {
				partyList[n] = guildList.get(i);
				n += 1;
			}
		}
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void guildMenu() {
		while (true) {
			System.out.println("=============== [길드관리] ================");
			System.out.println("[1.길드목록] [2.길드원추가] [3.길드원삭제]\n" + "[4.파티원교체] [5.정렬] [0.뒤로가기]");
			int sel = MainGame.scan.nextInt();
			if (sel == 1) {
				printAllUnitStaus();
			} else if (sel == 2) {
				buyUnit();
			} else if (sel == 3) {
				removeUnit();
			} else if (sel == 4) {
				partyChange();
			} else if (sel == 0) {
				break;
			}
		}
	}

	public ArrayList<Hero> getGuildList() {
		return guildList;
	}

	public void setGuildList(ArrayList<Hero> guildList) {
		this.guildList = guildList;
	}

}