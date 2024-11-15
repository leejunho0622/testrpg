package testrpg;

import java.io.IOException;

public class StageLobby extends Stage {
	@Override
	public void init() {}
	
	private boolean selectJob() {
		try {
			String selectJob = String.format("원하시는 직업을 입력하세요 [1. 전사 2. 마법사 3. 힐러]\n");
			IOManager.append(selectJob);
			
			String input = reader.readLine();

			if(input.equals("전사"))
				Guild.setGuildPlayer(new Player("플레이어", "전사", 1, 1200, 100, 50, 50, 0));
			else if(input.equals("마법사"))
				Guild.setGuildPlayer(new Player("플레이어", "마법사", 1, 1000, 300, 70, 30, 0));
			else if(input.equals("힐러"))
				Guild.setGuildPlayer(new Player("플레이어", "힐러", 1, 1100, 200, 30, 70, 0));
			else
				return false;
		} catch (IOException e) {
			return false;
		}
		return true;
	}
	

	@Override
	public void start() {
		while(true)
			if(selectJob()) break;
		try {
			String textLobby = String.format("============ LOBBY ============\n   [1] 전투  [2] 설정  [0] 종료\n");
			IOManager.append(textLobby);

			String input = reader.readLine();
			int select = Integer.parseInt(input);

			if (select == 1)
				GameManager.nextStage = "BATTLE";
			else if (select == 2)
				GameManager.nextStage = "SETTING";
			else if (select == 0)
				GameManager.gamePlay = false;

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}