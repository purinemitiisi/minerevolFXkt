package application

import javafx.application.Application
import javafx.fxml.FXMLLoader
import javafx.scene.Scene
import javafx.stage.Stage

fun main(args : Array<String>) {Application.launch(Main::class.java, *args)}

class Main : Application() {

    override fun start(primaryStage: Stage) {
        val loader = FXMLLoader(this.javaClass.getResource("/Main.fxml"))
        val scene = Scene(loader.load())
        primaryStage.scene = scene
        primaryStage.show()
    }
}