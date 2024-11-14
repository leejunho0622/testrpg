package testrpg;

import java.util.HashMap;
import java.util.Map;

public class GameManager {
	private static GameManager instance = new GameManager();
	
	Map<String, Stage> stageList = new HashMap<String, Stage>();
	
	private boolean gamePlay = true;
	
	private GameManager() {}
	
	public static GameManager getInstance() {
		return instance;
	}
	
	public void init() { // 초기화 함수
		stageList.put("TITLE", new StageTitle());
		stageList.put("LOBBY", new StageLobby());
		stageList.put("BATTLE", new StageBattle());
		stageList.put("SETTING", new StageSetting());
	} 
	
	
	public void run() { // 게임 실행 메소드
		while(gamePlay) {
			
		}
		
	}
}
