package api.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import api.endPoints.UserEndPoints;
import api.payload.User;
import api.utilities.DataProviders;
import io.restassured.response.Response;

public class DataDriven_UserTest {

	@Test(priority = 1,dataProvider = "Data",dataProviderClass = DataProviders.class)
	public void testPostUser(String userID,String userName,String fname,String lname,String useremail,String pwd,String ph) {
		
        User userPayload=new User();
		
		userPayload.setId(Integer.parseInt(userID));
		userPayload.setUsername(userName);
		userPayload.setFirstName(fname);
		userPayload.setLastName(lname);
		userPayload.setEmail(useremail);
		userPayload.setPassword(pwd);
		userPayload.setPhone(ph);
		
		
		Response response =	UserEndPoints.createUser(userPayload);
	    
	    Assert.assertEquals(response.getStatusCode(),200);

	}
	
	@Test(priority = 2,dataProvider = "UserNames",dataProviderClass = DataProviders.class)
	public void testDeleteByUser(String userName) {
	Response response = UserEndPoints.deleteUser(userName);
	 Assert.assertEquals(response.getStatusCode(),200);
	
	}
}
