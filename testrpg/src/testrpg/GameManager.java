package testrpg;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

public class GameManager {
	private static GameManager instance = new GameManager();
	
	private StringBuffer buffer = new StringBuffer();
	private BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
	
	private Map<String, Stage> stageList = new HashMap<String, Stage>();
	
	private boolean gamePlay = true;
	
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
	
	private void changeStage() {
		String stageInfo = String.format("<< Now: %s → Next: %s >>", currnetStage, nextStage);
		buffer.append(stageInfo);
		try {
			writer.append(buffer);
			writer.flush();
			buffer.delete(0, buffer.length());
			
			currnetStage = nextStage;
			
			Stage stage = stageList.get(currnetStage);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void run() { // 게임 실행 메소드
		while(gamePlay) {
			changeStage();
			break;
		}
		
	}
}
