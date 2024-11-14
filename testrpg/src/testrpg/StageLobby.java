package testrpg;

public class StageLobby extends Stage {
	@Override
	public void init() {}

	@Override
	public void start() {
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