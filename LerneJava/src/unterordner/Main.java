package unterordner;


import javafx.application.Application;
import javafx.beans.binding.Bindings;
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
			ToggleGroup tgroup = new ToggleGroup();
			ToggleButton tb1 = new ToggleButton("Button1");
			ToggleButton tb2 = new ToggleButton("Button1");
			ToggleButton tb3 = new ToggleButton("Button1");
			tb1.setToggleGroup(tgroup);
			tb2.setToggleGroup(tgroup);
			tb3.setToggleGroup(tgroup);
			
			root.getChildren().addAll(tb1,tb2,tb3);
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
