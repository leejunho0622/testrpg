package testrpg;

public abstract class Monster {
	String name;
	int hp;
	int maxHp;
	int damage;
	
	public Monster(String name, int hp, int maxHp, int damage) {
		this.name = name;
		this.hp = hp;
		this.maxHp = maxHp;
		this.damage = damage;
	}
}
