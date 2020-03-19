package step_definitions;

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
	public void user_is_verifying_following_data(io.cucumber.datatable.DataTable dataTable) {
	    // Write code here that turns the phrase above into concrete actions
	    // For automatic transformation, change DataTable to one of
	    // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
	    // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
	    // Double, Byte, Short, Long, BigInteger or BigDecimal.
	    //
	    // For other transformations you can register a DataTableType.
	    throw new cucumber.api.PendingException();
	}

}
