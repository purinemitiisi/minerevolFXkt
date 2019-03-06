package application;

import java.net.URL;
import java.util.ResourceBundle;

import core.CraftRecipe;
import core.CraftRecipeBuilder;
import core.Item;
import core.ItemMap;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class CraftTableController implements Initializable{
    @FXML
    private TableView<CraftRecipeProperty> outputTable;
    @FXML
    private TableColumn<CraftRecipeProperty, Integer> outputIdColumn;
    @FXML
    private TableColumn<CraftRecipeProperty, String> outputNameColumn;
    @FXML
    private TableColumn<CraftRecipeProperty, Integer> outputNumColumn;

    @FXML
    private TableView<ItemProperty> inputTable;
    @FXML
    private TableColumn<ItemProperty, Integer> inputIdColumn;
    @FXML
    private TableColumn<ItemProperty, String> inputNameColumn;
    @FXML
    private TableColumn<ItemProperty, Integer> inputNumColumn;

    @FXML
    private ProgressBar craftProgressBar;

    private ItemTableController itemTableController;
    private ItemMap itemMap;



    @Override
    public void initialize(URL location, ResourceBundle resources) {
    	outputIdColumn.setCellValueFactory(new PropertyValueFactory<CraftRecipeProperty, Integer>("outputId"));
    	outputNameColumn.setCellValueFactory(new PropertyValueFactory<CraftRecipeProperty, String>("outputName"));
    	outputNumColumn.setCellValueFactory(new PropertyValueFactory<CraftRecipeProperty, Integer>("outputNum"));

    	inputIdColumn.setCellValueFactory(new PropertyValueFactory<ItemProperty, Integer>("id"));
    	inputNameColumn.setCellValueFactory(new PropertyValueFactory<ItemProperty, String>("name"));
    	inputNumColumn.setCellValueFactory(new PropertyValueFactory<ItemProperty, Integer>("num"));

    	addCraftRecipe(CraftRecipeBuilder.get("table"));
    	addCraftRecipe(CraftRecipeBuilder.get("stick"));

    	outputTable.getSelectionModel().selectedItemProperty().addListener(
    			(ov, old, current) -> {
    				inputTable.getItems().clear();
    				for (Item item : current.craftRecipe.inItemList) {
    					inputTable.getItems().add(new ItemProperty(item));
    				}
    			}

    	);
    }


    @FXML
    private void onCraftButton() {
    	CraftRecipe recipe = outputTable.getSelectionModel().selectedItemProperty().get().craftRecipe;
    	if (!itemTableController.hasItemList(recipe.inItemList)) return;
    	for (Item item : recipe.inItemList)
    		itemTableController.subItem(item);
    	itemTableController.addItem(recipe.outItem);
    }

    void addCraftRecipe(CraftRecipe craftRecipe) {
    	outputTable.getItems().add(new CraftRecipeProperty(craftRecipe));
    	for (Item item : craftRecipe.inItemList) {
    		inputTable.getItems().add(new ItemProperty(item));
    	}
    }

    void setItemTableController(ItemTableController ctrl) {
    	itemTableController = ctrl;
    }

    void setItemMap(ItemMap im) {
    	itemMap = im;
    }
}
