package application

import core.Item
import core.ItemMap
import javafx.fxml.FXML
import javafx.fxml.Initializable
import java.net.URL
import java.util.*
import javax.swing.table.TableColumn
import javax.swing.text.TableView

class ItemTableController : Initializable{
    @FXML lateinit var table : TableView
    @FXML lateinit var idColumn : TableColumn
    @FXML lateinit var nameColumn : TableColumn
    @FXML lateinit var numColumn : TableColumn

    val itemMap = ItemMap()

    override fun initialize(location: URL?, resources: ResourceBundle?) {
        idColumn.
    }
}