package unterordner;




import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

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
import javafx.scene.web.HTMLEditor;



@SuppressWarnings("unused")
public class Main extends Application {
	public int degree = 0;
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		try {
			VBox root = new VBox();
			Scene scene = new Scene(root,400,300);
			
			TextArea ta = new TextArea();
			Button open = new Button("Datei öffnen");
			
			open.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent arg0) {
					FileChooser fc = new FileChooser();
					File f = fc.showOpenDialog(null);
					ta.setText(readLine(f));
				}
				
			});
			
			
			root.getChildren().addAll(ta,open);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("-");
			
			primaryStage.show();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static String readLine(File f) {
		
		try {
			FileReader fr = new FileReader(f.getAbsolutePath());
			BufferedReader br = new BufferedReader(fr);
			String firstLine = null;
			try {
				firstLine = br.readLine();
			} catch (IOException e) {
				
			}
			return firstLine;
		} catch (FileNotFoundException e) {
			
		}
		
		return null;
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
