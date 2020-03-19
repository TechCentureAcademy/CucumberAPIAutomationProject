package step_definitions;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.Map;

import com.jayway.restassured.response.Response;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import helper.ConfigurationReader;
import helper.apiHelper;

public class CurrentWeather_stepDefinition {
	
	final String url = ConfigurationReader.getProperty("url");
	final private String privateKey = ConfigurationReader.getProperty("private_key");
	
	apiHelper helper = new apiHelper();
	
	private Response response;
	
	@When("User is sending {string} request to the {string} end-point")
	public void user_is_sending_request_to_the_end_point(String requestType, String endPoint, Map<String, String> city) {
		response = helper.getFromURI(url + endPoint + "?q=" + city.get("city") + "&appid=" + privateKey);
	}

	@Then("User is verifying that status code is {int}")
	public void user_is_verifying_that_status_code_is(Integer statusCode) {
	    helper.verifyForStatusCode(response, statusCode);
	}

	@Then("User is verifying following data")
	public void user_is_verifying_following_data(Map<String, String> expectedMap) {
	    Map<Object, Object> responseMap = response.jsonPath().getMap("");
	    Map<String, Double> coordMap = (Map<String, Double>) responseMap.get("coord");
	    List<Map<String, Object>> weatherList = (List<Map<String, Object>>) responseMap.get("weather");
	    String name = (String) responseMap.get("name");
	    
	    // asserting name
	    System.out.println(expectedMap.get("name") + "---" + name);
	    assertEquals(expectedMap.get("name"), name);
	    
	    // asserting description
	    System.out.println(expectedMap.get("description") + "---" + weatherList.get(0).get("description"));
	    assertEquals(expectedMap.get("description"), weatherList.get(0).get("description"));
	    
	    // asserting latitude
	    System.out.println(expectedMap.get("latitude") + "---" + coordMap.get("lat"));
	    assertEquals(Float.valueOf(expectedMap.get("latitude")), coordMap.get("lat"));
	    
	    // asserting longtitude
	    System.out.println(expectedMap.get("longtitude") + "---" + coordMap.get("lon"));
	    assertEquals(Float.valueOf(expectedMap.get("longtitude")), coordMap.get("lon"));
	    
	    
	    
	}

}
