package na.petapi.stepdef;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpStatus;
import org.json.JSONObject;
import org.junit.Assert;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;
import na.petapi.tierservice.EndpointService;
import na.petapi.utilities.Util;

public class Pets {

	private String requestUrl = "https://petstore.swagger.io/v2/pet";
	private JSONObject body;
	private Response resp;
	private JSONObject responseBody;

	/**
	 * @param status
	 */
	@Given("A valid name, photoUrls and {string} are available for JSON Body")
	public void aValidNamePhotoUrlsAndAreAvailableForJSONBody(String status) {

		body = Util.getBodyForPet(status);

	}

	/**
	 * @param methodType
	 */
	@When("A Request for {string} method is made to the PET API with valid JSON body")
	public void aRequestForMethodIsMadeToThePETAPIWithValidJSONBody(String methodType) {

		resp = (StringUtils.equalsIgnoreCase("POST", methodType)) ? EndpointService.post(body,requestUrl) : EndpointService.get(body, requestUrl);

	}

	/**
	 * @param statusCode
	 */
	@Then("PET API should return status {int}")
	public void petAPIShouldReturnStatus(Integer statusCode) {
		Assert.assertTrue("Invalid Response ", statusCode == resp.getStatusCode());
		if (statusCode == HttpStatus.SC_OK)
			responseBody = new JSONObject(resp.getBody().asString());

	}
	
	/**
	 * 
	 */
	@Then("Response should have same data as Body")
	public void responseShouldHaveSameDataAsBody() {
	  
		JSONAssert.assertEquals(body.toString(), responseBody.toString(), JSONCompareMode.STRICT);		
		
	}


}
