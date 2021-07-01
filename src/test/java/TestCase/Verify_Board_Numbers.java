package TestCase;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Verify_Board_Numbers {
	
	@Test(enabled = false)
	public void postNewBoard() {
		int statusCode;
		int boardCount = 0;
		do {
			// creating a request pointing to the service endpoint
			RestAssured.baseURI = "https://api.trello.com/1";
			RequestSpecification request = RestAssured.given();
			// creating the body for the request in JSON format
			JSONObject rp = new JSONObject();
			rp.put("key", "f0470a5cae99c0f216bd61d85883b441");
			rp.put("token", "1b64c7918e4d2eb84cf396ad196e9914d06f7fe177e2176e92231b34a8b3d3ab");
			rp.put("name", "PongInterview1");
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
		
		int statusCode;
		int ListCount = 0;
		do {
			// creating a request pointing to the service endpoint
			RestAssured.baseURI = "https://api.trello.com/1/";
			RequestSpecification request = RestAssured.given();
			// creating the body for the request in JSON format
			JSONObject rp = new JSONObject();
			rp.put("key", "f0470a5cae99c0f216bd61d85883b441");
			rp.put("token", "1b64c7918e4d2eb84cf396ad196e9914d06f7fe177e2176e92231b34a8b3d3ab");
			rp.put("name", "PongList");
			rp.put("idBoard", "60dd1e58e4fb3a602336ded9");
			// add the JSON formatted request and send request
			// add header telling the rquest is in JSON format
			request.header("Content-Type", "application/json");
//			request.header("key", "f0470a5cae99c0f216bd61d85883b441");
//			request.header("token", "1b64c7918e4d2eb84cf396ad196e9914d06f7fe177e2176e92231b34a8b3d3ab");
//			request.header("name", "Testing-1");
			
			// add JSON body to the request
			request.body(rp.toJSONString());
			// post the request and check the response
			Response response = request.post("lists");
			
			System.out.println(response.prettyPrint());
			// verify response
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
		
		int statusCode;
		int cardCount = 0;
		do {
			// creating a request pointing to the service endpoint
			RestAssured.baseURI = "https://api.trello.com/1/";
			RequestSpecification request = RestAssured.given();
			// creating the body for the request in JSON format
			JSONObject rp = new JSONObject();
			rp.put("key", "f0470a5cae99c0f216bd61d85883b441");
			rp.put("token", "1b64c7918e4d2eb84cf396ad196e9914d06f7fe177e2176e92231b34a8b3d3ab");
			rp.put("idList", "60dd179a08637b83b3a6746a");
			// add the JSON formatted request and send request
			// add header telling the rquest is in JSON format
			request.header("Content-Type", "application/json");
//			request.header("key", "f0470a5cae99c0f216bd61d85883b441");
//			request.header("token", "1b64c7918e4d2eb84cf396ad196e9914d06f7fe177e2176e92231b34a8b3d3ab");
//			request.header("name", "Testing-1");
			
			// add JSON body to the request
			request.body(rp.toJSONString());
			// post the request and check the response
			Response response = request.post("cards");
			
			System.out.println(response.prettyPrint());
			// verify response
			Assert.assertEquals(response.getStatusCode(), 200);
			statusCode = response.getStatusCode();
			cardCount++;
			System.out.println(cardCount);
		}
		while(statusCode == 200);
		System.out.println("The maximum card is "+cardCount);
		}
}
