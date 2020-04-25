package unterordner;

import javafx.application.Application;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;


public class Main extends Application {
	public static void main(String[] args) {
		System.out.println("Vor Launch");
		launch(args);
		System.out.println("Nach Launch");
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		try {
			System.out.println("Start Methode");
			VBox root = new VBox();
			Label text = new Label("Das ist ein Label");
			Label text2 = new Label("Ich bin ein weiteres Label");
			
			root.getChildren().add(text);
			root.getChildren().add(text2);
			
			Scene scene = new Scene(root,400,400);
			//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setFullScreen(false);
			primaryStage.setResizable(false);
			primaryStage.setTitle("Unser JavaFX Fenster");
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
