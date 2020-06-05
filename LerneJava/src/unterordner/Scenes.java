package unterordner;


import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.util.Pair;

public class Scenes {
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static Node sceneBooks() {
		VBox root = new VBox(10);
		ListView listView = new ListView();
		
		JSONArray jArray = Books.getBooks();
		List<String> rows = new ArrayList<String>();
		
    	for(Object lines : jArray) {
			JSONObject line = (JSONObject) lines;
			String status = "Verfügbar";
			if(!(line.get("status").toString().equals("home"))) {
				status = line.get("status").toString();
			}
			String input = line.get("name").toString()+" | "+status+" | "+line.get("id").toString();
			rows.add(input);
			listView.getItems().add(input);
		}
    	
    	Button buttonAddBook = new Button("Buch Hinzufügen");
    	
    	buttonAddBook.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				Dialog<Pair<String, String>> dialog = new Dialog<>();
				dialog.setTitle("Neues Buch");
				dialog.setHeaderText("Geben sie hier die Informationen für das neue Buch ein.");

				ButtonType loginButtonType = new ButtonType("Fertig", ButtonData.OK_DONE);
				dialog.getDialogPane().getButtonTypes().addAll(loginButtonType, ButtonType.CANCEL);

				GridPane grid = new GridPane();
				grid.setHgap(10);
				grid.setVgap(10);
				grid.setPadding(new Insets(20, 150, 10, 10));

				TextField nameField = new TextField();
				nameField.setPromptText("Name");
				TextField statusField = new TextField();
				statusField.setPromptText("Status?");
				statusField.setText("home");
				TextField idField = new TextField();
				idField.setPromptText("Id?");
				idField.setText("0");
				
				
				grid.add(new Label("Name:"), 0, 0);
				grid.add(nameField, 1, 0);
				grid.add(new Label("Status:"), 0, 1);
				grid.add(statusField, 1, 1);
				grid.add(new Label("Id:"), 0, 2);
				grid.add(idField, 1, 2);

				// Enable/Disable button depending on whether a name was entered.
				Button loginButton = (Button) dialog.getDialogPane().lookupButton(loginButtonType);
				loginButton.setDisable(true);

				// Do some validation (using the Java 8 lambda syntax).
				nameField.textProperty().addListener((observable, oldValue, newValue) -> {
				    loginButton.setDisable(newValue.trim().isEmpty());
				});
				loginButton.setOnAction(new EventHandler<ActionEvent>() {

					@Override
					public void handle(ActionEvent arg0) {
						System.out.println("MouseEvent");
					    try {
					    	int a = Integer.parseInt(idField.getText());
					    	if(a==0) {}
					    	try {
						    	Books.createBooks(nameField.getText(), Integer.parseInt(idField.getText()), statusField.getText());
							} catch (Exception e) {
								Alert alert = new Alert(AlertType.ERROR);
						    	alert.setTitle("Error Dialog");
						    	alert.setHeaderText("Unbekannter Error!");
						    	alert.setContentText(e.toString());
						    	alert.showAndWait();
							}
					    }catch(Exception e) {
					    	Alert alert = new Alert(AlertType.ERROR);
					    	alert.setTitle("Error Dialog");
					    	alert.setHeaderText("Id ist keine Zahl!");
					    	alert.setContentText("Ändere die Id zu einer Zahl oder trage eine 0 ein falls sie automatisch generiert werden soll!");
					    	alert.showAndWait();
					    }
					}
				});
				
				dialog.getDialogPane().setContent(grid);
				dialog.showAndWait();
		        
			}
    		
    	});
    	
    	
        root.getChildren().addAll(listView,buttonAddBook);
		
		return root;
	}
	
	
}
