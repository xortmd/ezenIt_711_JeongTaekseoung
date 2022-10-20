package rpg;

public class Monster extends Unit {
	
	private boolean boss; // 보스 처치시 던전 클리어
	
	public Monster(String name, int level, int hp, int att, int def, boolean boss) {
		super(name, level, hp, att, def);
		this.boss = boss;
	}

	public boolean isBoss() {
		return boss;
	}
}
