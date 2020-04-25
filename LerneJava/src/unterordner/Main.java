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
			VBox root2 = new VBox();
			
			Label text = new Label("Hello World");
			root.getChildren().add(text);
			Scene scene = new Scene(root,400,400);
			Scene scene2 = new Scene(root2,200,200);
			
			//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.initStyle(StageStyle.TRANSPARENT);
			primaryStage.setFullScreen(false);
			primaryStage.show();
			
			Stage secoundStage = new Stage();
			secoundStage.setScene(scene2);
			
			secoundStage.show();
			
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
