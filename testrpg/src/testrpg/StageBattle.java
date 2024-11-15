package testrpg;

import java.util.Random;

public class StageBattle extends Stage{
	
	private Random ran = new Random();
	
	@Override
	public void init() {}
	
	private void printDashBoard() {
		System.out.println("====== BATTLE ======");
		System.out.println("====== PLAYER ======");
		for (int i = 0; i < Guild.getPartyCount(); i++) {
			IOManager.append(Guild.getPartyPlayer(i).toString());
		}
		System.out.println("====== MONSTER ======");
		for (int i = 0; i < MonsterManager.getMonsterListSize(); i++) {
			IOManager.append(MonsterManager.getMonster(i).toString());
		}
	}
	
	private boolean selectAttack() {
		for(int i=0; i<Guild.getPartyCount(); i++) {
			Player user = Guild.getPartyPlayer(i);
			String selectMenu = String.format("[%s:%s] [1. 공격][2. 스킬]", user.getName(), user.getjob());
			IOManager.append(selectMenu);
			try {
				String input = reader.readLine();
				int select = Integer.parseInt(input);
				
				if(select == 1) {
					int rNum = ran.nextInt(MonsterManager.getMonsterListSize());
					user.attack(MonsterManager.getMonster(rNum));
				}
				else if(select == 2) {
					Skill.useSkill(user);
				}
					
			} catch (Exception e) {
			}
			
		}
		return true;
		
	}
	
	@Override
	public void start() {
		Guild.createParty();
		MonsterManager.makeMonsters();
		printDashBoard();
		while(true) {
			if(selectAttack())
				break;
		}
		
	}
}
