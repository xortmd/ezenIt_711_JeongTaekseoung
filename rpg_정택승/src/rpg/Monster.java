package rpg;

public class Monster extends Unit {
	
	private boolean boss; // 보스 처치시 던전 클리어
	
	public Monster(String n, int l, int h, int a, int d, boolean b) {
		super(n, l, h, a, d);
		this.boss = b;
	}

	public boolean isBoss() {
		return boss;
	}
}
