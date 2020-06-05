package unterordner;


import java.util.Scanner;

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
import javafx.scene.text.FontWeight;
import javafx.scene.web.HTMLEditor;


@SuppressWarnings("unused")
public class Main extends Application {
	
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		try {
			BorderPane rootPane = new BorderPane();
			HBox root = new HBox(25);
			Scene home = new Scene(rootPane,615,315);
			home.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
			
			//Vertical Boxes
			VBox leftBox = new VBox(25);
			VBox rightBox =new VBox(25);
			
			//Adding Padding
			Insets pad = new Insets(20,10,20,10);
			leftBox.setPadding(pad);
			rightBox.setPadding(pad);
			
			//Left Box Buttons
			Button buttonUsers = new Button("Benutzer");
			Button buttonBooks = new Button("Bücher"); 
			
			//Right Box Buttons
			Button buttonBorrow = new Button("Ausleihe");
			Button buttonHistory =new Button("Verlauf"); 
			
			//Back Button
			Button buttonBack = new Button("<");
			
			//Height and Width - Buttons
			int buttonWidth = 700;
			int buttonHeight = 400;
			styleButton(buttonUsers, buttonHeight, buttonWidth);
			styleButton(buttonBooks, buttonHeight, buttonWidth);
			styleButton(buttonBorrow, buttonHeight, buttonWidth);
			styleButton(buttonHistory, buttonHeight, buttonWidth);
			buttonBack.setVisible(false);
			buttonBooks.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent arg0) {
					rootPane.setCenter(Scenes.sceneBooks());
					buttonBack.setVisible(true);
				}
				
			});
			
			buttonBack.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent arg0) {
					rootPane.setCenter(root);
					buttonBack.setVisible(false);
				}
				
			});
			
			
			//Add Buttons to Boxes
			leftBox.getChildren().addAll(buttonUsers,buttonBooks);
			rightBox.getChildren().addAll(buttonBorrow,buttonHistory);
			
			
			//Add Boxes to root
			root.getChildren().addAll(leftBox,rightBox);
			rootPane.setCenter(root);
			rootPane.setTop(buttonBack);
			
			primaryStage.setScene(home);
			primaryStage.setTitle("Ausleihe");
			primaryStage.show();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void styleButton(Button button, int buttonHeight, int buttonWidth) {
		button.setPrefHeight(buttonHeight);
		button.setPrefWidth(buttonWidth);
		button.setFont(Font.font("Courier New", FontWeight.BOLD, 25));
		
	}
	
	@Override
	public void init() throws Exception {
		
	}
	@Override
	public void stop() throws Exception {
		
	}
	
}
