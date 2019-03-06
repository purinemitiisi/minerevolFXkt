package core;

public class Adventure {
	static Item get() {
		int rand = (int) (Math.random()*10);
		return new Item("wood", rand);
	}
}
