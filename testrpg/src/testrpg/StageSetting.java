package testrpg;

public class StageSetting extends Stage{
	@Override
	public void init() {}

	@Override
	public void start() {
		try {
			String textSetting = String.format("============ SETTING ============\n[1] 길드관리  [2] 상점  [3] 인벤토리\n[4] 저장  [5] 로드  [0] 종료");
			IOManager.append(textSetting);

			String input = reader.readLine();
			int select = Integer.parseInt(input);

//			if (select == 1)
//				guild();
//			else if (select == 2)
//				shop();
//			else if (select == 3)
//				inventory();
//			else if (select == 4)
//				save();
//			else if (select == 5)
//				load();
//			else if (select == 0)
//				GameManager.gamePlay = false;

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
