package unterordner;




import javax.swing.event.ChangeEvent;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.application.Application;
import javafx.beans.Observable;
import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldListCell;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;



@SuppressWarnings("unused")
public class Main extends Application {
	public int degree = 0;
	public static void main(String[] args) {
		launch(args);
	}
	@SuppressWarnings("unchecked")
	@Override
	public void start(Stage primaryStage) throws Exception {
		try {
			VBox root = new VBox();
			Scene scene = new Scene(root,400,300);
			
			
			TreeItem<String> ti = new TreeItem<>("Tiere");
			TreeItem<String> ti2 = new TreeItem<>("Vögel");
			TreeItem<String> ti3 = new TreeItem<>("Amsel");
			TreeItem<String> ti4 = new TreeItem<>("Blaumeise");
			TreeItem<String> ti42 = new TreeItem<>("Taube");
			
			TreeItem<String> ti5 = new TreeItem<>("Fische");
			TreeItem<String> ti6 = new TreeItem<>("Aal");
			TreeItem<String> ti7 = new TreeItem<>("Makrele");
			TreeItem<String> ti8 = new TreeItem<>("Seelachs");
			
			
			TreeView<String> tv = new TreeView<>(ti);
			ti.getChildren().addAll(ti2,ti5);
			ti2.getChildren().addAll(ti3,ti4,ti42);
			ti5.getChildren().addAll(ti6,ti7,ti8);
			
			ti.setExpanded(true);
			ti2.setExpanded(true);
			ti5.setExpanded(true);
			root.getChildren().addAll(tv);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("-");
			
			primaryStage.show();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public ObservableList<Car> getAllCars(){
		ObservableList<Car> carList = FXCollections.observableArrayList();
		carList.add(new Car("Ibiza", "Seat", 110));
		carList.add(new Car("Ibiza1", "Seat1", 120));
		carList.add(new Car("Ibiza2", "Seat2", 130));
		carList.add(new Car("Ibiza3", "Seat3", 140));
		
		return carList;
	}
	
	@Override
	public void init() throws Exception {
		
	}
	@Override
	public void stop() throws Exception {
		
	}
	
}
