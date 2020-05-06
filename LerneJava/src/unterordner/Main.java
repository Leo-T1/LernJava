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
			
			CheckBox cb1 = new CheckBox("Check 1");
			CheckBox cb2 = new CheckBox("Check 2");
			CheckBox cb3 = new CheckBox("Check 3");
			
			
			
			Button sendButton = new Button("Jetzt Abschicken");
			sendButton.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent arg0) {
					String text1 = cb1.getText()+": "+cb1.isSelected();
					String text2 = cb2.getText()+": "+cb2.isSelected();
					String text3 = cb3.getText()+": "+cb3.isSelected();
					
					endLabel.setText("Send\n"+text1+"\n"+text2+"\n"+text3);
					
				}
				
			});
			
			root.getChildren().addAll(titleLabel,cb1,cb2,cb3,sendButton,endLabel);
			
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
