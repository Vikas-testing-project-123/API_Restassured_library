package api.endpoints;
import static io.restassured.RestAssured.given;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

//UserEndPoints.java file
// It is create for crud(Create retrive update) requests for user API
public class userEndPoints {
	public static Response createUser(User payload){
		Response response = given()
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(payload)
		.when()
		.post(Routes.post_url);
		
		return response;
	}
	
	public static Response readUser(String userName){
		Response response = given()
				.pathParam("username", userName)
		.when()
		.get(Routes.Get_url);
		
		return response;
	}
	
	public static Response updateUser(String userName, User payload){
		Response response = given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.pathParam("username", userName)
				.body(payload)
				.when()
				.put(Routes.Put_url);
				
				return response;
	}
	
	public static Response deleteUser(String userName){
		Response response = given()
				.pathParam("username", userName)
		.when()
		.delete(Routes.Delete_url);
		
		return response;
	}
	
	
}
