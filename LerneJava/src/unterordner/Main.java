package unterordner;

import java.awt.Color;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;



public class Main extends Application {
	public static void main(String[] args) {
		launch(args);
	}
	@Override
	public void start(Stage primaryStage) throws Exception {
		try {
			VBox root = new VBox();
			Scene scene = new Scene(root,300,300);
			
			Label labelAge = new Label("Dein Passwort:");
			PasswordField ageField = new PasswordField();
			Label labelAge2 = new Label("Dein Passwort wiederholen:");
			PasswordField ageField2 = new PasswordField();
			
			Button sendButton = new Button("Absenden");
			sendButton.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent arg0) {
					if(ageField.getText().equals(ageField2.getText())) {
						sendButton.setStyle("-fx-background-color: green; ");
					}else {
						sendButton.setStyle("-fx-background-color: red; ");
					}
					//System.out.println(ageField.getText());
					//System.out.println(ageField2.getText());
					ageField.clear();
					ageField2.clear();
					
				}
				
			});
			
			

			root.getChildren().addAll(labelAge,ageField,labelAge2,ageField2,sendButton);
			
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
