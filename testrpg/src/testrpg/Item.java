package testrpg;

public class Item {
	private final String WEAPON = "WEAPON";
	private final String ARMOR = "ARMOR";
	private final String ARTIFACT = "ARTIFACT";

	public static final int TYPE_DAMAGE = 1;
	public static final int TYPE_HP = 2;
	public static final int TYPE_MP = 3;
	public static final int TYPE_ARMOR = 4;

	private String type;
	private String name;
	private int effect;
	private int value;
	private int price;

	public void setItem(String type, int effect, String name, int value, int price) {
		this.type = type;
		this.name = name;
		this.effect = effect;
		this.value = value;
		this.price = price;
	}
	
	public String getItemType() {
		return this.type;
	}
	
	public int getItemEffect() {
		return this.effect;
	}
	
	public int getItemValue() {
		return this.value;
	}
}
