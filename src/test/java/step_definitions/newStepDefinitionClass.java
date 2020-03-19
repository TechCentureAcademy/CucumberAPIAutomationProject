package step_definitions;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;
import io.restassured.RestAssured;
import io.restassured.RestAssured.*;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.*;

public class newStepDefinitionClass {

	public static RequestSpecification reqspeq;
	public static Response response;
	public static String pathparam;
	public static List<Header> listOfheaders;
	public static Headers head;
	
	
	@Before
	public void LoadClasses() {
		listOfheaders = new ArrayList<Header>();
		head = new Headers();
	}
	
	@Given("new Base URL")
	public void new_Base_URL() {
	    
		RestAssured.basePath = "http://api.football-data.org";
		
		
		
	}

	@When("the resource path {string}")
	public void the_resource_path(String resource) {
	   
		
		
	}

	@When("add headers")
	public void add_headers(DataTable dataTable) {
	   
		List<Map<String, String>> map = dataTable.asMaps(String.class,String.class);
		
		Iterator<Map<String,String>> iterator = map.iterator();
		
		while(iterator.hasNext()) {
			Map<String,String> keyValue = iterator.next();
			Set<Entry<String,String>> entrySet = keyValue.entrySet();
	
			for(Entry<String,String> pair :entrySet) {
				
				System.out.println("Header : " + pair.getKey()
				
					+ " Value of header :" + pair.getValue()	
						);
				Header h1 = new Header(pair.getKey(), pair.getValue());
				System.out.println("HEADER PARAMETHER" + h1.toString());
				listOfheaders.add(h1);
				
			}
			
			Headers head = new Headers(listOfheaders);
			
			reqspeq = RestAssured.given().headers(head);
			
		}
		
	}

	@Given("method name is {string} and {string}")
	public void method_name_is_and(String callname, String resource) {
		switch(callname) {
		case "get":
			response = RestAssured.given().headers(head).log().all().when().get(RestAssured.basePath = resource);
			break;
		case "post":
			response = reqspeq.log().all().when().post(RestAssured.basePath = resource);
			break;
		case "put":
			response = reqspeq.log().all().when().put(RestAssured.basePath = resource);
			break;
		case "delete":
			response = reqspeq.log().all().when().delete(RestAssured.basePath = resource);
			break;
		
			
		
		
		
		
		
	}
	}
	   
		

	@Then("I see {int} ok response")
	public void i_see_ok_response(Integer int1) {
	    
		System.out.println(response.asString());
		response.then().assertThat().statusCode(int1);
		
		
		
		
	}
	
	
}