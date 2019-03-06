package core;

public class ItemData {
//	WOOD(0,"木", "wood"),
//	TABLE(1,"机", "table"),
//	STICK(2,"棒" ,"stick"),
//	STONE(3,"石","stone"),
//	SAND(4,"砂","sand"),
//	GLASS(5,"ガラス","glass"),
//	IRON(6,"鉄","iron"),
//	GOLD(7,"金","gold"),
//	EMPTY(999,"空" ,"empty");

	public int id;
	public String jname;
	public String ename;

	ItemData(int id, String jname, String ename) {
		this.id = id;
		this.jname = jname;
		this.ename = ename;
	}

	public String getName() {
		return jname;
	}

	public boolean equals(ItemData data) {
		return id == data.id;
	}
}
