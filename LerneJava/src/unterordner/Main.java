package unterordner;


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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
			Scene scene = new Scene(root,300,300);
			TextArea areaField = new TextArea();
			areaField.setPrefHeight(200);
			areaField.setText("Handrik ist der Dozenz von diesem Kurs, denn er programmiert abscheinend sehr gerne. Er freut sich anscheinend das ich bei ihm zugucke.");
			areaField.setWrapText(true);
			Button sendButton = new Button("Abschicken");
			sendButton.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent arg0) {
					System.out.println(areaField.getText());
				}
				
			});
			
			root.getChildren().addAll(areaField,sendButton);
			
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
