package unterordner;

import javafx.application.Application;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;


public class Main extends Application {
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		try {
			VBox root = new VBox();
			
			Label label = new Label("Hallo dies ist ein viel viel viel viel viel viel viel zu langes label");
			root.getChildren().add(label);
			//label.setRotate(180);
			label.setUnderline(true);
			label.setTextFill(Color.BROWN);
			label.setWrapText(true);
			
			Scene scene = new Scene(root,300,300);
			
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("Unser JavaFX Fenster");
			
			primaryStage.show();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void init() throws Exception {
		
	}
	@Override
	public void stop() throws Exception {
		
	}
	
}
