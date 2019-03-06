package core;

public class Item {
	public int num = 0;
	//public double progress = 0;
	public ItemData data;

	public Item(ItemData data, int num) {
		this.data = data;
		this.num = num;
	}

	public Item(String name, int num) {
		data = ItemDataBuilder.get(name);
		this.num = num;
	}

	public Item(Item item) {
		data = item.data;
		num = item.num;
	}

//	public void generate(Map<Item, String> map) {
//		progress += 0.1;
//		if (progress > 1.0) {
//			addNum(1);
//			progress -= 1;
//		}
//		progressProperty.set(progress);
//	}

	public void addNum(int n) {
		num += n;
	}

	public boolean equals(Item item) {
		return data.equals(item.data);
	}

}
