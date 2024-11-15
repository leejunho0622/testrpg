package testrpg;

import java.util.ArrayList;

public class Guild {
	private static ArrayList<Player> guildList = new ArrayList<Player>();
	private static ArrayList<Player> partyList = new ArrayList<Player>();
	
	public void init() {
		setUser();
	}
	
	private void setUser() {
		Player user = getGuildPlayer(0);
		if(user.getName().equals("플레이어"))
			user.joinParty();
	}
	
	public static int getPartyCount() {
		return partyList.size();
	}
	
	public static void setGuildPlayer(Player player) {
		guildList.add(player);
	}
	
	public static Player getGuildPlayer(int number) {
		return guildList.get(number);
	}
	
	public static Player getPartyPlayer(int number) {
		return partyList.get(number);
	}
}
