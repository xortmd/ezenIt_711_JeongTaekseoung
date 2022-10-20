package rpg;

import java.util.ArrayList;

public class Battle {
	
	private ArrayList<Dungeon> dungeonList = new ArrayList<>();
	
	public void setDungeonList() {
		Dungeon temp = null;
		temp = new Dungeon("농장", 1, 3000, 4);
		this.dungeonList.add(temp);
		temp = new Dungeon("정글", 2, 6000, 4);
		this.dungeonList.add(temp);
		temp = new Dungeon("산", 3, 9000, 4);
		this.dungeonList.add(temp);
		temp = new Dungeon("초원", 4, 15000, 4);
		this.dungeonList.add(temp);
	}
	
	public void dungeonMenu() {
		for(int i = 0; i < dungeonList.size(); i++) {
			Dungeon temp = dungeonList.get(i);
			System.out.println("[" + (i + 1) + "번] [" + temp.getDungeonName()
					+ "(보스: " + temp.getBossName() + ")]");
		}
		int sel = MainGame.scan.nextInt();
		if(0 < sel && sel < dungeonList.size())
			playDungeon(sel);
	}
	
	public void playDungeon(int dl) {
		Dungeon dungeon = null;
		for(int i = 0; i < dungeonList.size(); i++) {
			if(dl == dungeonList.get(i).getDungeonLv()) {
				dungeon = dungeonList.get(i);
			}
		}
		System.out.println(dungeon.getDungeonName() + "에 입장했습니다.");
		
		Hero[] party = Player.getGuild().getPartyList();
		int idx = 0; // 파티원 순서 & 파티원 사망 체크
		
		for(int i = 0; i < dungeon.getRound(); i++) {
			Monster monster = dungeon.getMonsters().get(i);
			System.out.println("몬스터 등장!");
			if(i == dungeon.getRound() - 1)
				System.out.println("보스가 등장했습니다. 조심하세요!");
			System.out.print("[몬스터 정보]");
			System.out.println(" [이름: " + monster.getName() + "]");
			System.out.print("=[레벨: " + monster.getLevel() + "]");
			System.out.println(" [체력: " + monster.getHp() + "]");
			System.out.print(" [공격력: " + monster.getAtt() + "]");
			System.out.println("=[방어력: " + monster.getDef() + "]");
			
			System.out.println("[1. 전투]");
			System.out.println("[2. 도망]");
			int sel = MainGame.scan.nextInt();
			
			if(sel == 1) {
				while(monster.isLive()) {
					// 몬스터는 가장 앞에 있는 파티원부터 공격
					System.out.println(party[idx].getName() + "<<<" + monster.getName() + "공격!");
					
					try {
						Thread.sleep(1000);
					} catch(Exception e) {
						e.printStackTrace();
					}
					
					int damage;
					if(party[idx].getArmor() != null)
						damage = monster.getAtt() - (party[idx].getDef() + party[idx].getArmor().getPower());
					else
						damage = monster.getAtt() - party[idx].getDef();
					
					if(damage < 0)
						damage = 0;
					
					party[idx].setNewHp(party[idx].getNewHp() - damage);
					
					System.out.println(party[idx].getName() + " " + damage + " 피해! (체력: " + party[idx].getNewHp());
					if (party[idx].getRing() != null) {
						if(party[idx].getJob() == Hero.TANKER)
							System.out.println("/" + party[idx].getMaxHp() + "(+" + party[idx].getRing().getPower()*2 + ")]");
						else
							System.out.println(")/" + party[idx].getMaxHp() + "(+" + party[idx].getRing().getPower() + ")]");
					} else {
						System.out.println("/" + party[idx].getMaxHp() + "]");
					}
					
					if(party[idx].getNewHp() <= 0) {
						System.out.println(party[idx].getName() + " 사망!");
						party[idx].setLive(false);
						idx++;
					}
					
					if(idx == party.length) {
						System.out.println("파티원이 전원 사망했습니다. 마을로 돌아갑니다.");
						return;
					}
					
					try {
						Thread.sleep(1000);
					} catch(Exception e) {
						e.printStackTrace();
					}
					
					// 파티원은 총 공격력의 합으로 몬스터 공격
					System.out.println("파티원 >>>" + monster.getName() + "공격!");
					
					try {
						Thread.sleep(1000);
					} catch(Exception e) {
						e.printStackTrace();
					}
					
					int attTotal = 0;
					for(int j = 0; j < party.length; j++) {
						attTotal += party[i].getAtt();
						if(party[i].getWeapon() != null) {
							if(party[i].getJob() == Hero.DEALER)
								attTotal += party[i].getWeapon().getPower()*2;
							else
								attTotal += party[i].getWeapon().getPower();
						}
					}
					
					damage = attTotal - monster.getDef();
					
					if(damage < 0)
						damage = 0;
					
					monster.setHp(monster.getHp() - damage);
					
					if(monster.getHp() <= 0) {
						if(i == dungeon.getRound() - 1) {
							System.out.println("축하합니다! " + dungeon.getDungeonName() + "을 클리어했습니다.");
							System.out.println("보상으로 " + dungeon.getPrize() + "골드가 지급됩니다.");
							Player.setMoney(Player.getMoney() + dungeon.getPrize());
						} else {
							System.out.println(monster.getName() + "을(를) 처치했습니다. 다음 라운드로 이동합니다.");
							monster.setLive(false);
						}
					}
					
					int healCnt = 0;
					for(int j = 0; j < party.length; j++) {
						if(party[j].getJob() == Hero.HEALER && party[j].isLive())
							healCnt++;
					}
					
					if(healCnt > 0) {
						for(int j = idx; j < party.length; j++) {
							party[j].setNewHp(party[j].getNewHp() + 10*healCnt);
							System.out.println("힐러 능력 발동!");
							System.out.println("모든 파티원 체력이 " + 10*healCnt + " 회복됩니다.");
						}
					}
					
					try {
						Thread.sleep(1000);
					} catch(Exception e) {
						e.printStackTrace();
					}
				}
			} else if(sel == 2) {
				break;
			} else {
				System.out.println("화면의 번호중에 입력하세요.");
				i--;
			}
			
		}
	}
}
