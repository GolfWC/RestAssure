package TestCase;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Verify_Board_Numbers {
	
	private String key = "f0470a5cae99c0f216bd61d85883b441";
	private String token = "1b64c7918e4d2eb84cf396ad196e9914d06f7fe177e2176e92231b34a8b3d3ab";
	private String idBoard ="";
	private String idList = "";
	int statusCode;
	// Create TestNG method --annotation will control execution flow of method
	@Test(enabled = false)
	public void postNewBoard() {
		int boardCount = 1;
		do {
			// specify base URL in order to creating a request pointing to the service endpoint
			RestAssured.baseURI = "https://api.trello.com/1";
			RequestSpecification request = RestAssured.given();
			// creating the body for the request in JSON format
			JSONObject rp = new JSONObject();
			rp.put("key", key);
			rp.put("token", token);
			rp.put("name", "PongBoard" + boardCount);
			// add the JSON formatted request and send request
			// add header telling the rquest is in JSON format
			request.header("Content-Type", "application/json");
			// add JSON body to the request
			request.body(rp.toJSONString());
			// post the request and check the response
			Response response = request.post("/boards");
			// verify response
			statusCode = response.getStatusCode();
			
			boardCount++;
			System.out.println( boardCount);
			
		} while (statusCode == 200);
		System.out.println("The maximum board is " + boardCount);
	}
	
	@Test(enabled = true)
	public void postNewList() {
		int ListCount = 1;
		do {
			
			RestAssured.baseURI = "https://api.trello.com/1/";
			RequestSpecification request = RestAssured.given();
			JSONObject rp = new JSONObject();
			rp.put("key", key);
			rp.put("token", token);
			rp.put("name", "PongList" + ListCount);
			rp.put("idBoard", idBoard);
			request.header("Content-Type", "application/json");
			request.body(rp.toJSONString());

			Response response = request.post("lists");
			
			System.out.println(response.prettyPrint());
			Assert.assertEquals(response.getStatusCode(), 200);
			statusCode = response.getStatusCode();
			ListCount++;
			System.out.println(ListCount);
		}
		while(statusCode == 200);
		System.out.println("The maximum list is "+ListCount);
		}
	
	@Test(enabled = false)
	public void postNewCard() {
		int cardCount = 0;
		do {

			RestAssured.baseURI = "https://api.trello.com/1/";
			RequestSpecification request = RestAssured.given();

			JSONObject rp = new JSONObject();
			rp.put("key", key);
			rp.put("token",token);
			rp.put("idList", idList);

			request.header("Content-Type", "application/json");
			request.body(rp.toJSONString());
			Response response = request.post("cards");
			System.out.println(response.prettyPrint());
			Assert.assertEquals(response.getStatusCode(), 200);
			statusCode = response.getStatusCode();
			cardCount++;
			System.out.println(cardCount);
		}
		while(statusCode == 200);
		System.out.println("The maximum card is "+cardCount);
		}
}
