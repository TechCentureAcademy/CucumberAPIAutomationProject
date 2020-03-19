package helper;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class updateJson {

	public static String updateJsonFile() throws ParseException {
		
		String jsonMessage = "{\"login\":\"kos\",\"password\":\"1234\"}";
		
		System.out.println("My json Message :" + jsonMessage);
		
		JSONParser parser = new JSONParser();
			
		Object object = parser.parse(jsonMessage);
		
		JSONObject obj = (JSONObject) object;
		
		obj.put("password", "0000");
		
	System.out.println("Updated json : " + obj.toString());
		
		return obj.toString();
	}
	
	public static void main(String[]args) throws ParseException {
		
		updateJson.updateJsonFile();
		
	}
	
	
	
}