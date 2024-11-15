package testrpg;

import java.io.IOException;

public class StageTitle extends Stage{
	@Override
	public void init() {}

	@Override
	public void start() {
		try {
			String textTitle = String.format("======== TEXT RPG ========\n[시작]을 입력하세요\n");
			IOManager.append(textTitle);

			String input = reader.readLine();

			if (input.equals("시작")) {
				GameManager.nextStage = "LOBBY";
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
