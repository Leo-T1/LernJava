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
			Label titleLabel = new Label("Bitte schreibe eine Bewerbung:");
			Label endLabel = new Label("");
			TextArea areaField = new TextArea();
			areaField.setPrefHeight(150);
			areaField.setText("Hallo, das ist meine Bewerbung...");
			areaField.setWrapText(true);
			Button sendButton = new Button("Jetzt Abschicken");
			sendButton.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent arg0) {
					String text = areaField.getText();
					int laenge = text.length();
					if(laenge>10 && laenge<50) {
						endLabel.setText("Deine Bewerbung befindet sich in Bearbeitung.");
					}else if(laenge==0) {
						endLabel.setText("Ein leeres Dokument kann nicht abgeschickt werden.");
					}else if(laenge<10 || laenge>50) {
						endLabel.setText("Momentan können wir leider keine neuen Bewerbungen mehr annehmen.");
					}
				}
				
			});
			
			root.getChildren().addAll(titleLabel,areaField,sendButton,endLabel);
			
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
