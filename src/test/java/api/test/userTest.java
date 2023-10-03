package api.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.userEndPoints;
import api.payload.User;
import io.restassured.response.Response;
public class userTest {
	//To create the fake data we use the faker library 
	Faker faker;

	//Here we set the payload for the user  
	User userpayload;
	// create a object for logs
	public Logger logger;
	
	@BeforeClass
	public void setup(){
		faker = new Faker();
		//create a object for user 
		userpayload = new User();
		//set the id 
		userpayload.setId(faker.idNumber().hashCode());
		userpayload.setUsername(faker.name().username());
		userpayload.setFirstName(faker.name().firstName());
		userpayload.setLastName(faker.name().lastName());
		userpayload.setEmail(faker.internet().safeEmailAddress());
		userpayload.setPassword(faker.internet().password(5,10));
		userpayload.setPhone(faker.phoneNumber().cellPhone());
		
		
		//logs
		logger = LogManager.getLogger(this.getClass());
	}
	@Test(priority = 1)
	public void testPostUser(){
		logger.info("********Creating user*********");
		Response response = userEndPoints.createUser(userpayload);
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(),200);

	}

	@Test(priority = 2)
	public void testGetUserByName(){
		//get the username for the parameter
		logger.info("********Reading user user*********");
		Response response = userEndPoints.readUser(this.userpayload.getUsername());
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
		logger.info("*******User dat displayed*********");
	}

	@Test(priority = 3)
	public void testUpdateUser(){
		//update user using payload
		logger.info("********Update user *********");
		userpayload.setFirstName(faker.name().firstName());
		userpayload.setLastName(faker.name().lastName());
		userpayload.setEmail(faker.internet().safeEmailAddress());

		Response response = userEndPoints.updateUser(this.userpayload.getUsername(),userpayload);
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(),200);
		
		//check data after update
		Response responseAfterUpdate = userEndPoints.readUser(this.userpayload.getUsername());
		Assert.assertEquals(responseAfterUpdate.getStatusCode(), 200);
	}
	@Test(priority = 4)
	public void testDeleteUserByName(){
		Response response = userEndPoints.deleteUser(this.userpayload.getUsername());
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
	}
}
