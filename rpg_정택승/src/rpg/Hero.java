package rpg;

public class Hero extends Unit {

	static final int DEALER = 1; // 아이템 공격력 2배
	static final int HEALER = 2; // 던전 라운드 종료시 마다 모든 파티원 체력 회복 +10
	static final int TANKER = 3; // 아이템 방어력 2배
	
	private int exp;
	private boolean party;
	private Item weapon;
	private Item armor;
	private Item ring;
	private int job;
	
	public Hero(String n, int l, int h, int a, int d, int e, int j) {
		super(n, l, h, a, d);
		this.exp = e;
		this.party = false;
		this.job = j;
		this.weapon = null;
		this.armor = null;
		this.ring = null;
	}

	public Hero(String n, int l, int h, int a, int d, int e, boolean p, int j) {
		super(n, l, h, a, d);
		this.exp = e;
		this.party = p;
		this.job = j;
		this.weapon = null;
		this.armor = null;
		this.ring = null;
	}
	
	public void setItem(Item w, Item a, Item r) {
		this.weapon = w;
		this.armor = a;
		this.ring = r;
	}
	
	public void printStatusHero() {
		System.out.println("[이름: " + getName() + "]");
		System.out.print("=[레벨: " + getLevel() + "]");
		if (getRing() != null) {
			System.out.print(" [체력: " + getHp() + " (+" + getRing().getPower());
		} else {
			System.out.print(" [체력: " + getHp());
		}
		if (getRing() != null) {
			System.out.println(")/" + getMaxHp() + " (+" + getRing().getPower() + ")]");
		} else {
			System.out.println("/" + getMaxHp() + "]");
		}
		if (getWeapon() != null) {
			System.out.print("=[공격력: " + getAtt() + " (+" + getWeapon().getPower() + ")]");
		} else {
			System.out.print("=[공격력: " + getAtt() + "]");
		}
		if (getArmor() != null) {
			System.out.println(" [방어력: " + getDef() + " + " + getArmor().getPower() + "]");
		} else {
			System.out.println(" [방어력: " + getDef() + "]");
		}
		System.out.print("=[파티중: " + isParty() + "]");
		System.out.println("[직업: " + getJobString(getJob()) + "]");
	}
	
	public void printEquitedItem() {
		if (getWeapon() == null) {
			System.out.println("[무기: 없음 ]");
		} else {
			System.out.println("[무기: " + getWeapon().getName() + "]");
		}
		if (getArmor() == null) {
			System.out.println("[방어구: 없음 ]");
		} else {
			System.out.println("[방어구: " + getArmor().getName() + "]");
		}
		if (getRing() == null) {
			System.out.println("[반지: 없음 ]");
		} else {
			System.out.println("[반지: " + getRing().getName() + "]");
		}
	}

	public int getExp() {
		return exp;
	}

	public void setExp(int exp) {
		this.exp = exp;
	}

	public boolean isParty() {
		return party;
	}

	public void setParty(boolean party) {
		this.party = party;
	}

	public Item getWeapon() {
		return weapon;
	}

	public void setWeapon(Item weapon) {
		this.weapon = weapon;
	}

	public Item getArmor() {
		return armor;
	}

	public void setArmor(Item armor) {
		this.armor = armor;
	}

	public Item getRing() {
		return ring;
	}

	public void setRing(Item ring) {
		this.ring = ring;
	}

	public int getJob() {
		return job;
	}
	
	public String getJobString(int job) {
		if(job == DEALER)
			return "딜러";
		else if(job == HEALER)
			return "힐러";
		else
			return "탱커";
	}

	public void setJob(int job) {
		this.job = job;
	}
}
