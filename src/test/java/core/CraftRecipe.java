package core;

import java.util.ArrayList;
import java.util.List;

public class CraftRecipe {
//	TABLE() {
//		@Override
//		void set() {
//			inputItemList.add(new Item(ItemDataBuilder.get("wood"), 4));
//			outputItem = new Item(ItemDataBuilder.get("wood"), 1);
//		}
//	},
//	STICK() {
//		@Override
//		void set() {
//			inputItemList.add(new Item(ItemDataBuilder.get("wood"), 2));
//			outputItem = new Item(ItemDataBuilder.get("stick"), 2);
//		}
//	};

	public Item outItem;
	public List<Item> inItemList = new ArrayList<Item>();
	public double craftSpeed;

	CraftRecipe(Item out, List<Item> inList) {
		outItem = out;
		inItemList = inList;
	}



}
