package TestScripts;

import org.testng.Assert;
import org.testng.annotations.Test;

//import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
public class Test1 {

	@Test
	public void Test_One()
	{
		//RestAssured obj = new RestAssured();
		//Response response =	RestAssured.get("https://reqres.in/api/users?page=2");
		Response response =	get("https://reqres.in/api/users?page=2");
		System.out.println(response.getStatusCode());
		System.out.println(response.getTime());
		
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	
	@Test
	public void Test_Two()
	{
		baseURI="https://reqres.in/api";
		given().get("/users?page=2").then().statusCode(200);
		
	}
}
