package testrpg;

public abstract class Unit {
	String name;
	int level;
	int hp;
	int maxHp;
	int mp;
	int maxMp;
	int damage;
	int def;
	int exp;
	boolean party;
	Item weapon;
	Item armor;
	Item artifact;
	
	public Unit(String name, int level, int hp, int mp, int damage, int def, int exp) {
		this.name = name;
		this.level = level;
		this.hp = hp;
		this.mp = mp;
		this.damage = damage;
		this.def = def;
		this.exp = exp;
	}
	
	public void printStatus() {}
	
	public void printEquitedItem() {}
}
