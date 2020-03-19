package step_definitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import helper.HelperClass;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.io.IOException;

import org.json.JSONObject;

public class serviceCall extends HelperClass {

	public static String appidvalue = "593a51575493909fb954e5ace4dd79b3";
	public static Response response;
	
	@Given("base URL {string}")
	public void base_URL(String URL) {
	    
		RestAssured.baseURI = URL;
		
		
	}

	@When("service is being called")
	public void service_is_being_called() {
	   
		response = 
		
		given()
		.queryParam("appid", appidvalue)
		.queryParam("q", "Arlington")
		.contentType(ContentType.JSON)
		.log().all()
		.get();
		
	}

	@Then("validate cityName and status code")
	public void validate_cityName_and_status_code() {
	    
		
		
		response.then().statusCode(200);
		response.then().assertThat().statusCode(200);
		response.then().assertThat().body("name",equalTo("Arlington"));
		response.then().assertThat().body("visibility", equalTo(16093));
		
		
		System.out.println(response.asString());
		
		
	}
	
	
	@When("service is being called by get request with query parameters")
	public void service_is_being_called_by_get_request_with_query_parameters() {
	   
		response = 
		
		given()
		.queryParam("appid", appidvalue)
		.queryParam("zip", "22207")
		.log().all()
		.contentType(ContentType.JSON)
		.get();
		
	}

	@Then("validate country and status code")
	public void validate_country_and_status_code() {
	    
		System.out.println(response.asString());
		
		
		response.then().assertThat().body("sys.country",equalTo("US"));
		
		
	}
	@When("I send my custom post method")
	public void i_send_my_custom_post_method() throws IOException {
	    
//		JSONObject jsonobject = new JSONObject();
//		
//		jsonobject.put("login", "kos");
//		jsonobject.put("password", "1234");
//		
		
		
		
		
		response = 
		
		given().auth().basic("kos", "1234")
		.header("ContentType", "application/json")
		.header("Accept", "application/json")
		.log().all()
		.when()
		.body(HelperClass.getJson(".\\src\\test\\resources\\jsonfiles\\post.json"))
		.post("/echo/post/json");
		
		
	}

	@Then("I receive good response and success message")
	public void i_receive_good_response_and_success_message() {
	   
		System.out.println(response.asString());
		
		response.then().assertThat().body("success",equalTo("true"));
		
		
	}
	
}
