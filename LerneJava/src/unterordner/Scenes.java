package unterordner;


import java.io.FileWriter;
import javafx.scene.Scene;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
 
public class Scenes {
	public static Scene sceneBooks() {
		
		
		return null;
	}
	
	@SuppressWarnings("unchecked")
	public static void createBooks() {
		JSONObject employeeDetails = new JSONObject();
        employeeDetails.put("firstName", "Lokesh");
        employeeDetails.put("lastName", "Gupta");
        employeeDetails.put("website", "howtodoinjava.com");
         
        JSONObject employeeObject = new JSONObject(); 
        employeeObject.put("employee", employeeDetails);
         
        //Second Employee
        JSONObject employeeDetails2 = new JSONObject();
        employeeDetails2.put("firstName", "Brian");
        employeeDetails2.put("lastName", "Schultz");
        employeeDetails2.put("website", "example.com");
         
        JSONObject employeeObject2 = new JSONObject(); 
        employeeObject2.put("employee", employeeDetails2);
         
        //Add employees to list
        JSONArray employeeList = new JSONArray();
        employeeList.add(employeeObject);
        employeeList.add(employeeObject2);
         
        //Write JSON file
        try (FileWriter file = new FileWriter("src/unterordner/books.json")) {
 
            file.write(employeeList.toJSONString());
            file.flush();
 
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
	
	public static void main(String[] args) {
		createBooks();
	}
	
}
