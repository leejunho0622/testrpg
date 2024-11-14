package testrpg;

public class GameManager {
	private static GameManager instance = new GameManager();
	
	private GameManager() {}
	
	public static GameManager getInstance() {
		return instance;
	}
	
	public void init() {}
}
