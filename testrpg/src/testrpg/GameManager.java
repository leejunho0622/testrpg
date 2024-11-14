package testrpg;

import java.util.HashMap;
import java.util.Map;

public class GameManager implements IOManager{
	private static GameManager instance = new GameManager();
	
	private Map<String, Stage> stageList = new HashMap<String, Stage>();
	
	public static boolean gamePlay = true;
	
	public static String currnetStage = "";
	public static String nextStage = "";
	
	private GameManager() {}
	
	public static GameManager getInstance() {
		return instance;
	}
	
	public void init() { // 초기화 함수
		stageList.put("TITLE", new StageTitle());
		stageList.put("LOBBY", new StageLobby());
		stageList.put("BATTLE", new StageBattle());
		stageList.put("SETTING", new StageSetting());
		nextStage = "TITLE";
	} 
	
	private void changeStage() { // 스테이지 변경 메소드
		String stageInfo = String.format(" << Now: %s → Next: %s >>\n", currnetStage, nextStage);
		
		IOManager.append(stageInfo);

		currnetStage = nextStage;
		
		Stage stage = stageList.get(currnetStage);
		
		while(true) {
			stage.start();
			break;
		}
	}
	
	public void run() { // 게임 실행 메소드
		while(gamePlay) {
			changeStage();
		}
		
	}
}
