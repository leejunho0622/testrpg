package testrpg;

public abstract class Monster {
	private String name;
	private int hp;
	private int maxHp;
	private int damage;
	
	public Monster(String name, int hp, int damage) {
		this.name = name;
		this.hp = hp;
		this.maxHp = hp;
		this.damage = damage;
	}
	
	public int getHp() {
		return this.hp;
	}
	
	public void setHp(int hp) {
		this.hp = hp;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void attack(Unit target) {
		int playerhp = target.getHp() - damage;
		String damageLog = String.format("[%d]가 [%s]에게 %d의 데미지를 입힙니다. ", name, target.getName(), damage);
		IOManager.append(damageLog);
		if (playerhp <= 0) {
			String.format("[%s]을(를) 처치했습니다.", target.getName());
			target.setHp(0);
		}
		target.setHp(playerhp);
	}
	@Override
	public String toString() {
		return String.format("[%s|HP:%d/%d]\n", name, hp, maxHp);
	}
}
