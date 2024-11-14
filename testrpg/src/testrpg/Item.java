package testrpg;

public class Item {
	  public final int WEAPON = 1;
	  public final int ARMOR = 2;
	  public final int RING = 3;
	  
	  public final int TYPE_DAMAGE = 1;
	  public final int TYPE_HP = 2;
	  public final int TYPE_MP = 3;
	  public final int TYPE_ARMOR = 4;
	  
	  int type;
	  String name;
	  int power;
	  int price;

	  public void setItem(int type, String name, int power, int price) {
		this.type = type;
		this.name = name;
		this.power = power;
		this.price = price;
	  }
}
