package TestCase;

import static org.testng.Assert.assertEquals;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Create_Board {
	// Create TestNG method --annotation will control execution flow of method
	@Test(priority = 1)
	public void postNewBoard() {
		
		
			// creating a request pointing to the service endpoint
			RestAssured.baseURI = "https://api.trello.com/1";
			RequestSpecification request = RestAssured.given();
			// creating the body for the request in JSON format
			JSONObject rp = new JSONObject();
			rp.put("key", "f0470a5cae99c0f216bd61d85883b441");
			rp.put("token", "1b64c7918e4d2eb84cf396ad196e9914d06f7fe177e2176e92231b34a8b3d3ab");
			rp.put("name", "PongTodo");
			// add the JSON formatted request and send request
			// add header telling the rquest is in JSON format
			request.header("Content-Type", "application/json");
			// add JSON body to the request
			request.body(rp.toJSONString());
			// post the request and check the response
			Response response = request.post("/boards");
			// verify response
			Assert.assertEquals(response.getStatusCode(), 200);
	}
	
	@Test(priority= 2)
	public void postNewList() {
		

			// creating a request pointing to the service endpoint
			RestAssured.baseURI = "https://api.trello.com/1/";
			RequestSpecification request = RestAssured.given();
			// creating the body for the request in JSON format
			JSONObject rp = new JSONObject();
			rp.put("key", "f0470a5cae99c0f216bd61d85883b441");
			rp.put("token", "1b64c7918e4d2eb84cf396ad196e9914d06f7fe177e2176e92231b34a8b3d3ab");
			rp.put("name", "Dunken");
			rp.put("idBoard", "60d7865b10771c046bef3782");
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
	}
	
	@Test(priority = 3)
	public void postNewCard() {
		
		
			// creating a request pointing to the service endpoint
			RestAssured.baseURI = "https://api.trello.com/1";
			RequestSpecification request = RestAssured.given();
			// creating the body for the request in JSON format
			JSONObject rp = new JSONObject();
			rp.put("key", "f0470a5cae99c0f216bd61d85883b441");
			rp.put("token", "1b64c7918e4d2eb84cf396ad196e9914d06f7fe177e2176e92231b34a8b3d3ab");
			rp.put("idList", "60d75e5a5e7e5672de478e4d");
			rp.put("name", "PongCard");
			// add the JSON formatted request and send request
			// add header telling the rquest is in JSON format
			request.header("Content-Type", "application/json");
			// add JSON body to the request
			request.body(rp.toJSONString());
			// post the request and check the response
			Response response = request.post("/boards");
			// verify response
			Assert.assertEquals(response.getStatusCode(), 200);
	}

}
