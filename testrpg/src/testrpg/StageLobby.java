package testrpg;

public class StageLobby extends Stage {
	@Override
	public void init() {}

	@Override
	public void start() {
		try {
			String textTitle = String.format("============ LOBBY ============\n   [1] 전투  [2] 설정  [3] 종료\n");
			IOManager.append(textTitle);

			String input = reader.readLine();
			int select = Integer.parseInt(input);

			if (select == 1)
				GameManager.nextStage = "BATTLE";
			else if (select == 2)
				GameManager.nextStage = "SETTING";
			else if (select == 3)
				GameManager.gamePlay = false;

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}