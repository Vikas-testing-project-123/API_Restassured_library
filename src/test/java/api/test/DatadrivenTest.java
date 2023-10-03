package api.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import api.endpoints.userEndPoints;
import api.payload.User;
import api.utilities.dataProviders;
import io.restassured.response.Response;

public class DatadrivenTest {
	//here we are getting the data from data provider 1
	@Test(priority=1, dataProvider="Data", dataProviderClass=dataProviders.class)
	public void testPostUser(String userID, String userName, String fname, String lname, String useremail, String password, String phone)
	{
		User userPayload = new User();
		
		userPayload.setId(Integer.parseInt(userID));
		userPayload.setUsername(userName);
		userPayload.setFirstName(fname);
		userPayload.setLastName(lname);
		userPayload.setEmail(useremail);
		userPayload.setPassword(password);
		userPayload.setPhone(phone);
		
		Response response = userEndPoints.createUser(userPayload);
		
		Assert.assertEquals(response.getStatusCode(),200);

	}
	@Test(priority=2, dataProvider="UserNames", dataProviderClass=dataProviders.class)
	public void testDeleteUserByName(String userName)
	{
		Response response=userEndPoints.deleteUser(userName);
		Assert.assertEquals(response.getStatusCode(),200);
	}
}
