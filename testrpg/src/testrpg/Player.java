package testrpg;

public class Player extends Unit{
	public static int money;
	
	public Player(String name, int level, int hp, int mp, int damage, int def, int exp) {
		super(name, level, hp, mp, damage, def, exp);
	}

}
