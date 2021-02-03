package TestScripts;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.*;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class PutAndDeleteExampleClass {

	@Test
	public void PutTest()
	{
		JSONObject request = new JSONObject();
		
		request.put("name","Jatin");
		request.put("job","Automation Tester");
		
		//System.out.println(request);
		
		baseURI = "https://reqres.in/api";
		given().
		contentType(ContentType.JSON).
		accept(ContentType.JSON).
		body(request.toJSONString())
		.when().put("/users/2").then().statusCode(200).log().all();
		
	}
	@Test
	public void PatchTest()
	{
		JSONObject request = new JSONObject();
		
		request.put("name","Jatin1");
		request.put("job","Automation Tester1");
		
		//System.out.println(request);
		
		baseURI = "https://reqres.in";
		given().
		contentType(ContentType.JSON).
		accept(ContentType.JSON).
		body(request.toJSONString())
		.when().patch("/api/users/2").then().statusCode(200).log().all();
		
	}
	
	@Test
	public void DeleteTest()
	{
		
		baseURI = "https://reqres.in";
		when().delete("/api/users/2").then().statusCode(204).log().all();
		
	}
}
