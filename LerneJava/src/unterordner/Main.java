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
			Group root = new Group();
			Scene scene = new Scene(root,400,350);

			Line line1 = new Line(150,80,150,200);
			line1.setStrokeWidth(5.0);
			Line line2 = new Line(150,80,100,150);
			line2.setStrokeWidth(5.0);
			Line line3 = new Line(150,80,200,150);
			line3.setStrokeWidth(5.0);
			
			Line line4 = new Line(150,200,100,280);
			line4.setStrokeWidth(5.0);
			Line line5 = new Line(150,200,200,280);
			line5.setStrokeWidth(5.0);
			Circle circle1 = new Circle(150,50,30);
			Ellipse circle2 = new Ellipse(140,40,5,3);
			Ellipse circle3 = new Ellipse(160,40,5,3);
			Ellipse circle4 = new Ellipse(150,60,5,7);
			circle2.setFill(Color.WHITE);
			circle3.setFill(Color.WHITE);
			circle4.setFill(Color.WHITE);
			
			
			root.getChildren().addAll(line1,line2,line3,line4,line5,circle1,circle2,circle3,circle4);
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
