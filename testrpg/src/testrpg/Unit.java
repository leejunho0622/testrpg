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
		this.mp = mp;
		this.damage = damage;
		this.def = def;
		this.exp = exp;
	}
	
	public void printStatus() {
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
	    	
		String status = "";
		status += String.format("[이름 : %s]\n[직업 : %s]\n[레벨 : %d]\n", name, job, level);
		status += String.format("[체력 : %d +%d / %d +%d]\n[마나 : %d +%d / %d +%d]\n", hp, hpBouns, maxHp, hpBouns, mp, mpBouns, maxMp, mpBouns);
		status += String.format("[공격력 : %d +%d]\n[방어력 : %d +%d]\n[파티상태 : %s]\n", damage, damageBouns, def, armorBouns, party == true ? "O" : "X");
		
		IOManager.append(status);
	}
	
	public void printEquitedItem() {}
}
