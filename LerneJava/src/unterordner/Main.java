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
			
			ComboBox<String> cb = new ComboBox<>(FXCollections.observableArrayList("Hendrik","Peter","Franz","Kai","Marc","Leo"));
			Button button = new Button("Ein Button");
			Label label = new Label("Der Name ist:");
			cb.setPromptText("Wähle einen Namen");
			cb.setEditable(true);
			cb.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent arg0) {
					degree+=180;
					button.setRotate(degree);
					label.setText("Der Name ist: "+cb.getValue());
				}
				
			});
			
			
			root.getChildren().addAll(button,cb,label);
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
