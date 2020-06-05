package unterordner;


import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class Books {
	@SuppressWarnings({ "unchecked", "unused" })
	public static void createBooks(String name, int id, String status) {
		int count = 0;
		boolean useCount = false;
		try {
			JSONParser parser = new JSONParser();
			File file = new File("src/unterordner/books.json");
			if(!(file.exists()) || (file.length()<=0)) {
				file.createNewFile();
				JSONArray obj = new JSONArray();
				JSONObject newObj = new JSONObject();
				newObj.put("name", name);
				newObj.put("id", 1);
				newObj.put("status", status);
				obj.add(newObj);
				FileWriter fileW = new FileWriter(file);
				fileW.write(obj.toJSONString());
				fileW.flush();
				fileW.close();
			}else {
				JSONArray obj = getBooks();
				if(id<=0) {
					for(Object line : obj) {
						JSONObject ids = (JSONObject) line;
						count =  Integer.parseInt(ids.get("id").toString());
						useCount = true;
					}
				}
				JSONObject newObj = new JSONObject();
				newObj.put("name", name);
				if(useCount) {
					newObj.put("id", count+1);
				}else {
					newObj.put("id", id);
				}
				newObj.put("status", status);
				obj.add(newObj);
				FileWriter fileW = new FileWriter(file);
				fileW.write(obj.toJSONString());
				fileW.flush();
				fileW.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("unchecked")
	public static void deleteBook(String id) {
		JSONArray obj = getBooks();
		for(Object line : obj) {
			JSONObject lines = (JSONObject) line;
			if(lines.get("id").toString().equals(id)) {
				System.out.println(lines.values().removeAll(lines.values()));
				
				
				JSONArray list = new JSONArray();     
				
				int len = obj.size();

				if (obj != null) { 
				   for (int i=0;i<len;i++)
				   { 
				       Object element = obj.get(i);

				       if (!element.equals("null") && !element.equals("") && !(element.toString().equals("{}"))) {
				          list.add(element);
				          System.out.println(element);
				          System.out.println(element.toString());
				       }
				   } 
				}
				
				
				try {
					File file = new File("src/unterordner/books.json");
					FileWriter fileW = new FileWriter(file);
					fileW.write(list.toJSONString());
					fileW.flush();
					fileW.close();
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
		}
		
	}
	
	public static JSONArray getBooks() {
		try {
			JSONParser parser = new JSONParser();
			File file = new File("src/unterordner/books.json");
			FileReader fileR = new FileReader(file);
			JSONArray obj = (JSONArray) parser.parse(fileR);
			return obj;
		}catch(Exception e) {
			System.out.println(e);
		}
		
		return null;
	}
	
	
}
