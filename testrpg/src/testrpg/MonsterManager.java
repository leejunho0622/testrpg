package testrpg;

import java.util.ArrayList;
import java.util.Random;

public class MonsterManager {
	private static ArrayList<Monster> monsterList = new ArrayList<Monster>();
	
	Random ran = new Random();
	
	public static Monster getMonster(int number) {
		return monsterList.get(number);
	}
	
	public static int getMonsterListSize() {
		return monsterList.size();
	}
	
	private int setMonsterCount() {
		return ran.nextInt(Guild.getPartyCount())+1;
	}
	
	public void makeMonsters() {
		String packageName = "testrpg";
		String[] classNames = { "MonsterSlime", "MonsterOak", "MonsterDragon" };
		
		for(int i=0; i<setMonsterCount(); i++) {
		int rIdx = ran.nextInt(classNames.length);
		
		try {
			Class<?> clazz = Class.forName(packageName + classNames[rIdx]);
			
			Class<?>[] argsTypes = new Class<?>[] { String.class, int.class, int.class, int.class };
			MonsterSlime monster2 = new MonsterSlime("", 0, 0, 0);
			
			Object obj = clazz.getConstructor(argsTypes).newInstance(monster2);
			
			if (obj instanceof Monster) {
				Monster monster = (Monster) obj;
				monsterList.add(monster);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		}
	}
}
