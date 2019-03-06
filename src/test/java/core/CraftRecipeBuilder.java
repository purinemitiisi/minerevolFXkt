package core;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import static com.sun.javafx.scene.control.skin.Utils.getResource;

public class CraftRecipeBuilder {
	static ObjectMapper mapper = new ObjectMapper();
	static JsonNode root;

	static {
		URI uri = null;
		try {
			uri = CraftRecipeBuilder.class.getResource("ItemRecipe.json").toURI();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		try {
			root = mapper.readTree(new File(uri));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static CraftRecipe get(String name) {
		String outName = root.get(name).get("out").fieldNames().next();
		int outNum = root.get(name).get("out").get(outName).asInt();
		Item out = new Item(outName, outNum);

		List<Item> inList = new ArrayList<Item>();
		for (Iterator<String> it = root.get(name).get("in").fieldNames(); it.hasNext();) {
			String inName = it.next();
			int inNum = root.get(name).get("in").get(inName).asInt();
			inList.add(new Item(inName,inNum));
		}
		return new CraftRecipe(out, inList);
	}

}
