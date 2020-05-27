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
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeLineCap;
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
			VBox set = new VBox(10);
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root,450,350);
			Label l1 = new Label("Höhe:");
			Label l2 = new Label("Breite:");
			Label l3 = new Label("Farbe:");
			
			Slider setHig = new Slider(10, 250, 10);
			Slider setWid = new Slider(10, 250, 10);
			
			ColorPicker cp = new ColorPicker();
			
			setHig.setValue(100);
			setWid.setValue(100);
			cp.setValue(Color.BLACK);
			
			Rectangle rec = new Rectangle(0,0,setWid.getValue(),setHig.getValue());
			
			ChangeListener<Number> ch = new ChangeListener<Number>(){

				@Override
				public void changed(ObservableValue<? extends Number> arg0, Number arg1, Number arg2) {
					Rectangle rec = new Rectangle(0,0,setWid.getValue(),setHig.getValue());
					rec.setFill(cp.getValue());
					root.setCenter(rec);
				}
				
			};
			setHig.valueProperty().addListener(ch);
			setWid.valueProperty().addListener(ch);
			
			cp.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent arg0) {
					Rectangle rec = new Rectangle(0,0,setWid.getValue(),setHig.getValue());
					rec.setFill(cp.getValue());
					root.setCenter(rec);
				}
				
			});
			
			set.getChildren().addAll(l1,setHig,l2,setWid,l3,cp);
			
			root.setTop(new Label("Rechteck-Konfigurator:"));
			root.setCenter(rec);
			root.setLeft(set);
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
