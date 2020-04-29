package unterordner;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;


public class Main extends Application {
	int rotate = 0;
	public static void main(String[] args) {
		launch(args);
	}
	@Override
	public void start(Stage primaryStage) throws Exception {
		try {
			VBox root = new VBox();
			VBox root2 = new VBox();
			
			Button button = new Button("Hier klicken um für Szene 2");
			Button button1 = new Button("Hier klicken um für Szene 1");
			
			Label label = new Label("Willkommen zu Szene 1");
			Label label1 = new Label("Willkommen zu Szene 2");
			
			
			Scene scene = new Scene(root,300,300);
			Scene scene2 = new Scene(root2,400,300);
			EventHandler<MouseEvent> changeSzene = new EventHandler<MouseEvent>() {

				@Override
				public void handle(MouseEvent arg0) {
					if(primaryStage.getScene()==scene) {
						primaryStage.setScene(scene2);
					}else {
						primaryStage.setScene(scene);
					}
				}
				
			};
			button.setOnMouseClicked(changeSzene);
			button1.setOnMouseClicked(changeSzene);
			
			
			root.getChildren().add(label);
			root.getChildren().add(button);
			
			root2.getChildren().add(label1);
			root2.getChildren().add(button1);
			
			
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
