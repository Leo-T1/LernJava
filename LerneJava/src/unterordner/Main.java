package unterordner;

import javafx.application.Application;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;


public class Main extends Application {
	public static void main(String[] args) {
		//System.out.println("Vor Launch");
		//launch(args);
		//System.out.println("Nach Launch");
		System.out.println(MysteryClass.mysteryMethod(10, 20));
		System.out.println(MysteryClass.mysteryMethod(10, 10));
		System.out.println(MysteryClass.mysteryMethod(15, 15));
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
