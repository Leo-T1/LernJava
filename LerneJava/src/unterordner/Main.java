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
			
			BorderPane bp = new BorderPane();
			Scene scene = new Scene(bp,400,300);
			
			HBox htop = new HBox();
			
			Button starter = new Button("Editor starten");
			Button stopper = new Button("Beenden");
			htop.getChildren().addAll(starter,stopper);
			bp.setTop(htop);
			Label cen = new Label("Wähle eine Aktion");
			starter.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent arg0) {
					bp.setCenter(new HTMLEditor());
				}
				
			});
			stopper.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent arg0) {
					bp.setCenter(cen);
				}
				
			});
			
			bp.setCenter(cen);
			bp.setBottom(new Label("Nicht erstellt von Hendrik"));
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
