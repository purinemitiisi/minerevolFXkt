package core;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ItemDataBuilder {
	static ObjectMapper mapper = new ObjectMapper();
	static JsonNode root;

	static {
		try {
			root = mapper.readTree(new File("src/core/ItemData.json"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static ItemData get(String name) {
		int id = root.get(name).get("id").asInt();
		String jname = root.get(name).get("name").asText();
		return new ItemData(id ,jname, name);
	}
}
