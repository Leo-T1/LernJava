package unterordner;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.util.Pair;

public class Scenes {
	@SuppressWarnings("rawtypes")
	static ListView listView = new ListView();
	static ObservableList<String> bookList = FXCollections.observableArrayList();
	static CheckBox checkUpdate = new CheckBox("Update?");
	static Slider updateRate = new Slider(1000,6000,3000);
	
	@SuppressWarnings("unchecked")
	public static void updateBooks() {
		System.out.println("Updated");
		JSONArray jArray = Books.getBooks();
		bookList.clear();
    	for(Object lines : jArray) {
			JSONObject line = (JSONObject) lines;
			String status = "Verfügbar";
			if(!(line.get("status").toString().equals("home"))) {
				status = line.get("status").toString();
			}
			String input = line.get("name").toString()+" | "+status+" | "+line.get("id").toString();
			bookList.add(input);
		}
    	listView.setItems(bookList);
    	listView.scrollTo(listView.getItems().size());
	}
	public static Thread getThread(VBox root) {
		Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                Runnable updater = new Runnable() {

                    @Override
                    public void run() {
                    	//root.getChildren().remove(0);
                    	if(checkUpdate.isSelected()) {
                    		updateBooks();
                    	}
                    }
                };

                while (true) {
                    try {
                        Thread.sleep((int)updateRate.getValue());
                    } catch (InterruptedException ex) {
                    }

                    // UI update is run on the Application thread
                    Platform.runLater(updater);
                }
            }

        });
		return thread;
	}
	
	public static Node sceneBooks() {
		VBox root = new VBox(10);
		updateBooks();
    	Button buttonAddBook = new Button("Buch Hinzufügen");
    	updateRate.setShowTickMarks(true);
        updateRate.setShowTickLabels(true);
        updateRate.setBlockIncrement(500);
        updateRate.setMajorTickUnit(500);
        updateRate.setMinorTickCount(0);
        updateRate.setSnapToTicks(true);
        Thread thread = getThread(root);
        thread.setDaemon(true);
        thread.start();
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
		        updateBooks();
			}
    		
    	});
    	
    	HBox sides = new HBox(10);
    	sides.getChildren().addAll(buttonAddBook,checkUpdate,updateRate);
        root.getChildren().addAll(listView,sides);
		
		return root;
	}
	
	
}
