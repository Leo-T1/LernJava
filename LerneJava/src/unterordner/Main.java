package unterordner;

import javafx.application.Application;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.binding.Bindings;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;


public class Main extends Application {
	public static void main(String[] args) {
		//System.out.println("Vor Launch");
		//launch(args);
		//System.out.println("Nach Launch");
		StringProperty fileName = new SimpleStringProperty("first");
		StringProperty fileSuffix = new SimpleStringProperty(".txt");
		StringProperty completlyfileName = new SimpleStringProperty();
		
		completlyfileName.bind(Bindings.concat(fileName,fileSuffix));
		
		fileName.addListener(new ChangeListener<String>() {
			
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldVal, String newVal) {
				System.out.println("Alt: "+oldVal);
				System.out.println("New: "+newVal);
			}
			
		});
		
		
		fileName.addListener(new InvalidationListener() {

			@Override
			public void invalidated(Observable observable) {
				System.out.println("Wert nun invalide");
				
			}
			
		});
		
		System.out.println(completlyfileName.getValue());
		fileName.set("secound");
		fileName.set("third");
		
		System.out.println(completlyfileName.getValue());
		fileSuffix.set(".zip");
		System.out.println(completlyfileName.getValue());
		
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		try {
			System.out.println("Start Methode");
			VBox root = new VBox();
			Scene scene = new Scene(root,300,300);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("Unser JavaFX Fenster");
			Label text = new Label("Hallo");
			root.getChildren().add(text);
			primaryStage.show();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void init() throws Exception {
		System.out.println("Init Methode");
	}
	@Override
	public void stop() throws Exception {
		System.out.println("Stop Methode");
	}
	
}
