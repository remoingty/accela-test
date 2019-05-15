package na.petapi.utilities;

import java.util.Random;

import org.json.JSONArray;
import org.json.JSONObject;

public class Util {

	/**
	 * @param status
	 * @return
	 */
	public static JSONObject getBodyForPet(String status) {

		Random rand = new Random();
		int id = 10000 + rand.nextInt(100000);

		JSONObject category = new JSONObject().put("id", id).put("name", "Lab123456789");

		JSONArray tags = new JSONArray().put(new JSONObject().put("id", id).put("name", "RandomNames"));

		JSONArray photoUrls = new JSONArray().put("");

		return new JSONObject().put("id", id).put("category", category).put("name", "doggie")
				.put("photoUrls", photoUrls).put("tags", tags).put("status", status);

	}
	
}
