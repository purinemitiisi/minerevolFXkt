package application;

import java.net.URL;
import java.util.ResourceBundle;

import core.Item;
import core.ItemDataBuilder;
import core.ItemMap;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

public class Controller implements Initializable{

	@FXML
	ItemTableController itemTableController;
	@FXML
	CraftTableController craftTableController;

	ItemMap itemMap = new ItemMap();

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		craftTableController.setItemTableController(itemTableController);
		itemTableController.setItemMap(itemMap);
		craftTableController.setItemMap(itemMap);
	}

    @FXML
    public void onButton() {
    	itemMap.add(new Item(ItemDataBuilder.get("wood"),1));
    	itemTableController.addItem(new Item(ItemDataBuilder.get("wood"),1));
    }

}
