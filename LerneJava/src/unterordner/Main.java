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
			Scene scene = new Scene(root,400,300);
			
			Label labelName = new Label("Username:");
			TextField nameField = new TextField();
			Label labelPwd = new Label("Passwort:");
			PasswordField pwdField = new PasswordField();
			Label labelErr = new Label("");
			labelErr.setTextFill(Color.RED);
			Button sendButton = new Button("Login");
			sendButton.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent arg0) {
					String name = nameField.getText();
					String pwd = pwdField.getText();
					
					if((name.isBlank()) && (pwd.isBlank())){
						labelErr.setText("Bitte Benutzername und Passwort eingeben.");
					}else if((name.isBlank())) {
						labelErr.setText("Bitte Benutzername eingeben.");
					}else if((pwd.isBlank())) {
						labelErr.setText("Bitte Passwort eingeben.");
					}else if(name.equals("gamer10") && pwd.equals("passwort123")){
						labelErr.setText("Erfolgreich eingeloggt! Du wirst gleich weitergeleitet...");
						labelErr.setTextFill(Color.GREEN);
						nameField.setDisable(true);
						pwdField.setDisable(true);
						
					}else {
						labelErr.setText("Ungültiger Username oder ungültiges Passwort!");
					}
				}
				
			});
			
			root.getChildren().addAll(labelName,nameField,labelPwd,pwdField,sendButton,labelErr);
			
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
