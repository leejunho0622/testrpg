package testrpg;

import java.util.ArrayList;
import java.util.Random;

public class StageBattle extends Stage{
	
	private Random ran = new Random();
	
	@Override
	public void init() {}
	

	
	private void printDashBoard() {
		System.out.println("====== BATTLE ======");
		System.out.println("====== PLAYER ======");
		for (int i = 0; i < Guild.getPartyCount(); i++) {
			Guild.getPartyPlayer(i);
		}
		System.out.println("====== MONSTER ======");
		for (int i = 0; i < MonsterManager.getMonsterListSize(); i++) {
			MonsterManager.getMonster(i);
		}
	}
	
	@Override
	public void start() {
		
	}
}
