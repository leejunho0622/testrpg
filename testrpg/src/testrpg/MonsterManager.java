package testrpg;

import java.util.ArrayList;
import java.util.Random;

public class MonsterManager {
	private static ArrayList<Monster> monsterList = new ArrayList<Monster>();
	
	private static Random ran = new Random();
	
	public static Monster getMonster(int number) {
		return monsterList.get(number);
	}
	
	public static int getMonsterListSize() {
		return monsterList.size();
	}
	
	private static int setMonsterCount() {
		return ran.nextInt(Guild.getPartyCount())+1;
	}
	
	public static void makeMonsters() {
		String packageName = "testrpg.";
		String[] classNames = { "MonsterSlime", "MonsterOak", "MonsterDragon" };
		String[] names = { "슬라임", "오크", "드래곤" };

		for (int i = 0; i < setMonsterCount(); i++) {
			int rIdx = ran.nextInt(classNames.length);
			int hp = 0, damage = 0;
			if (rIdx == 0) {
				hp = 800;
				damage = 20;
			} else if (rIdx == 1) {
				hp = 1000;
				damage = 40;
			} else if (rIdx == 2) {
				hp = 1400;
				damage = 80;
			}

			try {
				Class<?> clazz = Class.forName(packageName + classNames[rIdx]);

				Class<?>[] argsTypes = new Class<?>[] { String.class, int.class, int.class };
				Object obj = clazz.getConstructor(argsTypes).newInstance(names[rIdx], hp, damage);

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
