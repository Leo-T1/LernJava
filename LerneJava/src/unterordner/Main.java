package unterordner;


import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;



@SuppressWarnings("unused")
public class Main extends Application {
	public int degree = 0;
	public static void main(String[] args) {
		launch(args);
	}
	@Override
	public void start(Stage primaryStage) throws Exception {
		try {
			VBox root = new VBox();
			Scene scene = new Scene(root,400,300);
			
			Label bf = new Label("Bewerbungsformular:");
			TextField nameField = new TextField();
			nameField.setPromptText("Gebe deinen vollständigen Namen ein");
			ComboBox<String> gesc1 = new ComboBox<>(FXCollections.observableArrayList("Männlich","Weiblich","Anders"));
			ComboBox<String> age1 = new ComboBox<>(FXCollections.observableArrayList("10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30"));
			TextField wordField = new TextField();
			wordField.setPromptText("Beschreibe dich mit einem Wort");
			Button sendData = new Button("Daten jetzt abschicken");
			gesc1.setPromptText("Wähle dein Geschlecht");
			age1.setPromptText("Wähle dein Alter");
			
			sendData.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent arg0) {
					int points = 0;
					if(gesc1.getValue().equals("Weiblich")) {
						points++;
					}
					
					if(Integer.parseInt(age1.getValue())>16) {
						points++;
					}

					if(!wordField.getText().toLowerCase().equals("faul")) {
						points++;
					}
					if(points==3) {
						System.out.println("Diese Bewerberin in Betracht ziehen.");
					}
					if(points<3) {
						System.out.println("Diese Bewerbung aussortieren");
					}
					
				}
				
			});
			
			
			root.getChildren().addAll(bf,nameField,gesc1,age1,wordField,sendData);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("-");
			
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
