package rpg;

public class Unit {
	static final int DEALER = 1;
	static final int HEALER = 2;
	static final int TANKER = 3;
	
	private String name;
	private int level;
	private int hp;
	private int maxHp;
	private int att;
	private int def;
	
	public Unit(String n, int l, int h, int a, int d) {
		this.name = n;
		this.level = 1;
		this.maxHp = h;
		this.hp = maxHp;
		this.att = a;
		this.def = d;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public int getMaxHp() {
		return maxHp;
	}

	public void setMaxHp(int maxHp) {
		this.maxHp = maxHp;
	}

	public int getAtt() {
		return att;
	}

	public void setAtt(int att) {
		this.att = att;
	}

	public int getDef() {
		return def;
	}

	public void setDef(int def) {
		this.def = def;
	}
}