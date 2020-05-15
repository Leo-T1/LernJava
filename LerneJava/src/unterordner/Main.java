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
			Label lab = new Label("Hey");
			slid.setMin(0);
			slid.setMax(200);
			slid.setValue(20);
			slid.setShowTickLabels(true);
			slid.setShowTickMarks(true);
			
			slid.valueProperty().addListener(new ChangeListener<Number>(){

				@Override
				public void changed(ObservableValue<? extends Number> arg0, Number oldVal, Number newVal) {
					lab.setFont(new Font(newVal.doubleValue()));
				}
				
			});

			root.getChildren().addAll(slid,lab);
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
