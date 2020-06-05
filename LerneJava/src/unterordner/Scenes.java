package unterordner;


import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import javafx.scene.Node;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;

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
    	
        root.getChildren().addAll(listView);
		
		return root;
	}
	
	
}
