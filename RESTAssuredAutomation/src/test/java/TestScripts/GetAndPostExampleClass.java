package TestScripts;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;
public class GetAndPostExampleClass {

	@Test
	public void GetTest()
	{
		baseURI = "https://reqres.in/api";
		given().
			get("/users?page=2").
		then().
			statusCode(200)
			.body("data[4].first_name",equalTo("George"))
			.body("data.first_name",hasItems("George","Rachel"));
	}
	
	
	@Test
	public void PostTest()
	{
		// One way to use map
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("name","Jatin");
		map.put("job","Automation Tester");
		// this is best way
		JSONObject request = new JSONObject();
		
		request.put("name","Jatin");
		request.put("job","Automation Tester");
		
		//System.out.println(request);
		
		baseURI = "https://reqres.in/api";
		given().
		contentType(ContentType.JSON).
		accept(ContentType.JSON).
		body(request.toJSONString())
		.when().post("/users").then().statusCode(201).log().all();
		
	}
	
}
