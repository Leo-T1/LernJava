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
			Label endLabel = new Label("Data:");
			Label cb1Label = new Label();
			Label cb2Label = new Label();
			Label cb3Label = new Label();
			
			CheckBox cb1 = new CheckBox("schwarz");
			CheckBox cb2 = new CheckBox("rot");
			CheckBox cb3 = new CheckBox("gelb");
			cb1.setSelected(true);
			cb1Label.textProperty().bind(Bindings.concat("CheckBox1:",cb1.selectedProperty()));
			cb2Label.textProperty().bind(Bindings.concat("CheckBox2:",cb2.selectedProperty()));
			cb3Label.textProperty().bind(Bindings.concat("CheckBox3:",cb3.selectedProperty()));
			
			
			
			
			root.getChildren().addAll(cb1,cb2,cb3,endLabel,cb1Label,cb2Label,cb3Label);
			
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
