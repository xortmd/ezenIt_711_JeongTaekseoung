package rpg;

import java.util.ArrayList;

public class Dungeon {
	
	private ArrayList<Monster> monsters = new ArrayList<>();;
	private String dungeonName;
	private int dungeonLv;
	private int prize;
	private int round;
	private String bossName;
	private boolean clear;
	
	public Dungeon(String dn, int dl, int p, int r) {
		this.monsters = getDungeonMonsters(dl);
		this.dungeonName = dn;
		this.dungeonLv = dl;
		this.prize = p;
		this.round = r;
		this.bossName = monsters.get(monsters.size() - 1).getName();
		this.clear = false;
	}

	public ArrayList<Monster> getDungeonMonsters(int dl) {
		ArrayList<Monster> result = new ArrayList<>();
		Monster temp = null;
		if(dl == 1) {
			temp = new Monster("닭", 1, 20, 1, 1, false, 310);
			result.add(temp);
			temp = new Monster("토끼", 1, 30, 3, 1, false, 15);
			result.add(temp);
			temp = new Monster("돼지", 2, 50, 5, 2, false, 20);
			result.add(temp);
			temp = new Monster("황소", 3, 70, 10, 3, true, 30);
			result.add(temp);
		} else if(dl == 2) {
			temp = new Monster("앵무새", 2, 40, 5, 1, false, 20);
			result.add(temp);
			temp = new Monster("아나콘다", 3, 60, 10, 2, false, 40);
			result.add(temp);
			temp = new Monster("악어", 3, 70, 15, 3, false, 50);
			result.add(temp);
			temp = new Monster("고릴라", 4, 100, 30, 5, true, 80);
			result.add(temp);
		} else if(dl == 3) {
			temp = new Monster("늑대", 3, 60, 20, 2, false, 50);
			result.add(temp);
			temp = new Monster("독수리", 4, 80, 25, 2, false, 60);
			result.add(temp);
			temp = new Monster("호랑이", 5, 100, 50, 4, false, 80);
			result.add(temp);
			temp = new Monster("불곰", 6, 150, 60, 6, true, 120);
			result.add(temp);
		} else if(dl == 4) {
			temp = new Monster("얼룩말", 4, 80, 30, 3, false, 100);
			result.add(temp);
			temp = new Monster("기린", 5, 100, 45, 5, false, 140);
			result.add(temp);
			temp = new Monster("사자", 6, 100, 70, 4, false, 200);
			result.add(temp);
			temp = new Monster("코끼리", 8, 250, 100, 10, true, 500);
			result.add(temp);
		}
		return result;
	}

	public ArrayList<Monster> getMonsters() {
		return monsters;
	}

	public void setMonsters(ArrayList<Monster> monsters) {
		this.monsters = monsters;
	}

	public String getDungeonName() {
		return dungeonName;
	}

	public void setDungeonName(String dungeonName) {
		this.dungeonName = dungeonName;
	}

	public int getDungeonLv() {
		return dungeonLv;
	}

	public void setDungeonLv(int dungeonLv) {
		this.dungeonLv = dungeonLv;
	}

	public int getPrize() {
		return prize;
	}

	public void setPrize(int prize) {
		this.prize = prize;
	}

	public int getRound() {
		return round;
	}

	public void setRound(int round) {
		this.round = round;
	}

	public String getBossName() {
		return bossName;
	}

	public void setBossName(String bossName) {
		this.bossName = bossName;
	}
	
	public boolean isClear() {
		return clear;
	}

	public void setClear(boolean clear) {
		this.clear = clear;
	}
}
