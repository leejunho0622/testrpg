package testrpg;

public abstract class Unit {
	private String name;
	private String job;
	
	private int level;
	private int hp;
	private int maxHp;
	private int mp;
	private int maxMp;
	private int damage;
	private int def;
	private int exp;
	
	private boolean party;
	
	private Item weapon;
	private Item armor;
	private Item artifact;
	
	private int damageBouns;
	private int armorBouns;
	private int hpBouns;
	private int mpBouns;
	
	public Unit(String name, String job, int level, int hp, int mp, int damage, int def, int exp) {
		this.name = name;
		this.job = job;
		this.level = level;
		this.hp = hp;
		this.maxHp = hp;
		this.mp = mp;
		this.maxMp = mp;
		this.damage = damage;
		this.def = def;
		this.exp = exp;
	}

	public void joinParty() {
		this.party = true;
	}
	
	public boolean isParty() {
		return this.party;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getHp() {
		return this.hp;
	}
	
	public void setHp(int hp) {
		this.hp = hp;
	}
	
	private void calculateAdditonalValue() {
		damageBouns = 0; armorBouns = 0; hpBouns = 0; mpBouns = 0;
	    if(weapon != null) { damageBouns += weapon.getItemValue(); }
	    if(armor != null) { armorBouns += armor.getItemValue(); }
	    if(artifact != null) {
	    	int artifactEffect = artifact.getItemEffect();
	    	int arifactValue = artifact.getItemValue();
	    	if(artifactEffect == Item.TYPE_DAMAGE) { damageBouns += arifactValue; }
	    	else if(artifactEffect == Item.TYPE_ARMOR) { armorBouns += arifactValue; }
	    	else if(artifactEffect == Item.TYPE_HP) { hpBouns += arifactValue; }
	    	else if(artifactEffect == Item.TYPE_MP) { mpBouns += arifactValue; }
	    }
	}
	
	public void printStatus() {
		calculateAdditonalValue();
		String status = "";
		status += String.format("[이름 : %s]\n[직업 : %s]\n[레벨 : %d]\n", name, job, level);
		status += String.format("[체력 : %d +%d / %d +%d]\n[마나 : %d +%d / %d +%d]\n", hp, hpBouns, maxHp, hpBouns, mp, mpBouns, maxMp, mpBouns);
		status += String.format("[공격력 : %d +%d]\n[방어력 : %d +%d]\n[파티상태 : %s]\n", damage, damageBouns, def, armorBouns, party == true ? "O" : "X");
		
		IOManager.append(status);
	}
	
	public void printEquitedItem() {}
	
	public void attack(Monster target) {
		calculateAdditonalValue();
		int monsterHp = target.getHp() - (damage + damageBouns);
		String damageLog = String.format("[%d]가 [%s]에게 %d의 데미지를 입힙니다. ", name, target.getName(), damage + damageBouns);
		IOManager.append(damageLog);
		if (monsterHp <= 0) {
			String.format("[%s]을(를) 처치했습니다.", target.getName());
			target.setHp(0);
		}
		target.setHp(monsterHp);
	}
	
	@Override
	public String toString() {
		calculateAdditonalValue();
		return String.format("[%s:%s|HP:%d/%d|MP:%d/%d]\n", name, job, hp, maxHp, mp, maxMp);
	}
}
