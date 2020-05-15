package unterordner;




import javax.swing.event.ChangeEvent;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
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
			
			Slider slid = new Slider();
			slid.setMin(10);
			slid.setMax(30);
			slid.setValue(15);
			slid.setShowTickLabels(true);
			slid.setShowTickMarks(true);
			Label lab = new Label("Verändere über den Slider meine Schriftgröße");
			Label lab2 = new Label("");
			lab2.setText("Aktuelle Schriftgröße: "+Math.round(slid.getValue()));
			slid.valueProperty().addListener(new ChangeListener<Number>(){

				@Override
				public void changed(ObservableValue<? extends Number> arg0, Number oldVal, Number newVal) {
					lab.setFont(new Font(newVal.doubleValue()));
					lab2.setText("Aktuelle Schriftgröße: "+Math.round(slid.getValue()));
				}
				
			});

			root.getChildren().addAll(lab,slid,lab2);
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
