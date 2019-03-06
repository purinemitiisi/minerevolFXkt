package application;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import core.Item;
import core.ItemData;
import core.ItemMap;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.ProgressBarTableCell;
import javafx.scene.control.cell.PropertyValueFactory;

public class ItemTableController implements Initializable {
    @FXML
    private TableView<ItemProperty> table;
    @FXML
    private TableColumn<ItemProperty, Integer> idColumn;
    @FXML
    private TableColumn<ItemProperty, String> nameColumn;
    @FXML
    private TableColumn<ItemProperty, Integer> numColumn;
    @FXML
    private TableColumn<ItemProperty, Double> progressColumn;

    private ItemMap itemMap;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    	idColumn.setCellValueFactory(new PropertyValueFactory<ItemProperty, Integer>("id"));
    	nameColumn.setCellValueFactory(new PropertyValueFactory<ItemProperty, String>("name"));
    	numColumn.setCellValueFactory(new PropertyValueFactory<ItemProperty, Integer>("num"));
    	progressColumn.setCellValueFactory(new PropertyValueFactory<ItemProperty, Double>("progress"));
    	progressColumn.setCellFactory(ProgressBarTableCell.forTableColumn());

//    	Timeline tl = new Timeline(new KeyFrame(Duration.millis(100), e -> update()));
//    	tl.setCycleCount(Animation.INDEFINITE);
//    	tl.play();

    }

    void updateItem(ItemData itemData) {
    	ItemProperty ip = new ItemProperty(new Item(itemData,itemMap.get(itemData)));
    	table.getItems().add(ip);
    }

    void addItem(Item item) {
    	for (ItemProperty ip : table.getItems()){
    		if (!ip.item.equals(item)) continue;
    		ip.item.num += item.num;
    		ip.update();
    		return;
    	}
    	ItemProperty ip = new ItemProperty(new Item(item));
    	table.getItems().add(ip);
    }

    boolean subItem(Item item) {
    	for (ItemProperty ip : table.getItems()){
    		if (!ip.item.equals(item)) continue;
    		if (ip.item.num < item.num) break;

    		ip.item.num -= item.num;
    		ip.update();
    		return true;
    	}
    	return false;
    }

    boolean hasItem(Item item) {
    	for (ItemProperty ip : table.getItems()){
    		if (!ip.item.equals(item)) continue;
    		if (ip.item.num < item.num) break;
    		return true;
    	}
    	return false;
    }

    boolean hasItemList(List<Item> list) {
   		for (Item item : list) {
   			if (!hasItem(item)) return false;
   		}
    	return true;
    }

    void setItemMap(ItemMap im) {
    	itemMap = im;
    }


}
