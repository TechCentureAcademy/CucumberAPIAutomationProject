package helper;

import java.util.Map;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;

import static com.jayway.restassured.RestAssured.given;
import static org.junit.Assert.assertTrue;

public class apiHelper {
	
	public Response getFromURI(String url) {
		System.out.println("Before sending Get request to end point " + url);
		Response response = given().when().get(url);
		//verifyForStatusCode(response, expectedCode);
		System.out.println("Sending Get request to end point " + url);
		return response;
	}
	public Response getFromURIwithToken(String url, String Token) {
		Response response = given().header("Authorization", "Bearer " + Token).relaxedHTTPSValidation().when().get(url);
		// verifyForStatusCode(response, expectedCode);
		System.out.println("Sending Get request to end point " + url);
		return response;
	}
	
	public Response PostToURI(Map body, String url) {
		// Sending post request
		Response response = // postToURI(content, url);
				given().accept(ContentType.JSON).and().contentType(ContentType.JSON).and().body(body).when()
						.post(url);
		return response;
	}
	
	public void verifyForStatusCode(Response response, int statusCode) {
		System.out.println("Getting status code: " + response.getStatusCode());
		assertTrue(response.getStatusCode() == statusCode);
	}

}
