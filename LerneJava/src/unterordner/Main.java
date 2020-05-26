package unterordner;






import javax.swing.event.ChangeEvent;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.application.Application;
import javafx.beans.Observable;
import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldListCell;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.web.HTMLEditor;



@SuppressWarnings("unused")
public class Main extends Application {
	public int degree = 0;
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		try {
			
			TabPane root = new TabPane();
			Scene scene = new Scene(root,400,300);
			Tab eingabe = new Tab("Eingabe");
			Tab ausgabe = new Tab("Ausgabe");
			eingabe.setClosable(false);
			ausgabe.setClosable(false);
			
			VBox eVBox = new VBox(10);
			eVBox.getChildren().add(new Label("Satz um den Buchstaben 'a' zu Zählen:"));
			TextField tf = new TextField();
			Button send = new Button("Absenden");
			send.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent arg0) {
					if(!tf.getText().isBlank()) {
						int count = 0;
						for (char c: tf.getText().toCharArray()) {
							if(c=='a') {
								count++;
							}
						}
						ausgabe.setContent(new Label("Satz enthält "+count+" mal den Buchstaben 'a'."));
						root.getSelectionModel().select(ausgabe);
						System.out.println(count);
					}else {
						Alert alert = new Alert(AlertType.ERROR);
						alert.setTitle("Error");
						alert.setHeaderText("TextField is blank!!!");
						alert.showAndWait();
					}
					
				}
				
			});
			
			
			eVBox.getChildren().addAll(tf,send);
			
			eingabe.setContent(eVBox);
			ausgabe.setContent(new Label("Bitte einen Satz eingeben und über den Button absenden!"));
			
			root.getTabs().addAll(eingabe,ausgabe);
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
