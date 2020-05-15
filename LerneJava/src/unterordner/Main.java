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
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;



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
			
			ListView<String> list = new ListView<String>();
			Button send = new Button("Send");
			list.getItems().addAll("1","2","3","4");
			list.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

			send.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent arg0) {
					String msg = "";
					ObservableList<String> list2 = list.getSelectionModel().getSelectedItems();
					for(String element : list2) {
						msg += element+"|";
					}
					System.out.println(msg);
				}
				
			});
			
			
			root.getChildren().addAll(list,send);
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
