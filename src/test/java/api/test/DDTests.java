package api.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.UserEndPoints;
import api.payload.User;
import api.utilities.DataProviders;
import io.restassured.response.Response;

public class DDTests {
	

    @Test(priority = 1, dataProvider = "Data", dataProviderClass = DataProviders.class) //if data provider isn't part of same class then we need to provide the class name and also import it.
	public void testPostUser(String userID, String userName, String fname, String lname, String useremail, String pwd,  String ph) {
		
    	User userPayload =  new User();
    	userPayload.setId(Integer.parseInt(userID));
		userPayload.setFirstName(fname);
		userPayload.setLastName(lname);
		userPayload.setEmail(useremail);
		userPayload.setPassword(pwd);
		userPayload.setPhone(ph);
		userPayload.setUsername(userName);	
    	
		Response response = UserEndPoints.createUser(userPayload);
        response.then().log().all();   	
	
	    Assert.assertEquals(response.getStatusCode(), 200);	    
          	
	}
    
    
    @Test(priority = 2, dataProvider = "UserNames",  dataProviderClass =  DataProviders.class)
    public void testDeleteUser(String username) {
		
		Response response = UserEndPoints.deleteUser(username);
		response.then().log().all();
		
		Assert.assertEquals(response.getStatusCode(), 200);	
		
		
	}
	
}
