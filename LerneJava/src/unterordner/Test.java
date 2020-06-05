package unterordner;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.scene.Scene;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Test extends Application {

    @Override
    public void start(Stage primaryStage) {
        ListView<String> listView = new ListView<>();
        listView.getItems().addAll("One", "Two", "Three");

        

        BorderPane root = new BorderPane(listView);
        primaryStage.setScene(new Scene(root, 250, 400));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
