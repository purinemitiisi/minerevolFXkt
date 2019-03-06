package core;

import java.util.HashMap;

public class ItemMap extends HashMap<ItemData, Integer> {

	public ItemMap() {
		super();
	}

	public void add(Item item) {
		int n = item.num;
		if (containsKey(item.data)) {
			n += get(item.data);
		}
		put(item.data, n);
	}

	void sub(Item item) {
		add(new Item(item.data, -item.num));
	}

	boolean contains(Item item) {
		if (!containsKey(item.data)) return false;
		if (get(item.data) < item.num) return false;
		return true;
	}

	boolean craft(CraftRecipe recipe) {
		for (Item item : recipe.inItemList) {
			if (!contains(item)) return false;
		}

		for (Item item : recipe.inItemList) {
			sub(item);
		}
		add(recipe.outItem);

		return true;
	}
}
