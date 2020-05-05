package unterordner;

import javafx.application.Application;
import javafx.event.ActionEvent;
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
			Scene scene = new Scene(root,300,300);
			
			Label labelAge = new Label("Dein Alter:");
			TextField ageField = new TextField();
			ageField.setPromptText("Alter:");
			Button sendButton = new Button("Absenden");
			sendButton.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent arg0) {
					if(validateInt(ageField.getText())) {
						//System.out.println(ageField.getText());
						ageField.setPromptText(ageField.getText());
						ageField.clear();
					}else {
						ageField.setPromptText("ungültige Eingabe!");
						ageField.clear();
					}
				}
				
			});
			
			
			

			

			root.getChildren().addAll(labelAge,ageField,sendButton);
			
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
	public boolean validateInt(String input) {
		
		try {
			int output = Integer.parseInt(input);
			return true;
		} catch (Exception e) {
			//System.out.println("ungültige Eingabe!");
			return false;
		}
	}
	public boolean validateInt(int input) {
		return true;
	}
	
}
