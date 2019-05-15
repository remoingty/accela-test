package na.petapi.tierservice;

import static io.restassured.RestAssured.given;

import org.json.JSONObject;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class EndpointService {

	/**
	 * @param body
	 * @param requestUrl
	 * @return
	 */ 
	public static Response get(JSONObject body, String requestUrl) {

		return given().urlEncodingEnabled(true).body(body.toString()).header("Accept", ContentType.JSON.getAcceptHeader())
				.get(requestUrl);

	}

	/**
	 * @param body
	 * @param requestUrl
	 * @return
	 */ 
	public static Response post(JSONObject body, String requestUrl) {

		return given().body(body.toString()).contentType(ContentType.JSON)
				.post(requestUrl);

	}
	
}
