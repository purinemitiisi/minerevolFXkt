package application;

import core.Item;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ItemProperty {
	Item item;
	IntegerProperty idProperty;
	IntegerProperty numProperty;
	StringProperty nameProperty;
	DoubleProperty progressProperty;

	public ItemProperty(Item item) {
		this.item = item;
		idProperty   = new SimpleIntegerProperty(item.data.id);
		numProperty  = new SimpleIntegerProperty(item.num);
		nameProperty = new SimpleStringProperty(item.data.jname);
	//	progressProperty = new SimpleDoubleProperty(item.progress);
	}

	void update() {
		numProperty.set(item.num);
	//	progressProperty.set(item.progress);
	}

	public IntegerProperty idProperty() {
		return idProperty;
	}

	public IntegerProperty numProperty() {
		return numProperty;
	}

	public StringProperty nameProperty() {
		return nameProperty;
	}

	public DoubleProperty progressProperty() {
		return progressProperty;
	}
}
