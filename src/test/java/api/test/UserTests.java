package api.test;

import org.testng.Assert;
import org.testng.annotations.*;

import com.github.javafaker.Faker;

import api.endpoints.UserEndPoints;
import api.payload.User;
import io.restassured.response.Response;

public class UserTests {

	Faker faker;
	User userPayload;
	
	@BeforeClass
	public void setupData() {
		
		faker = new Faker();
		userPayload = new User();
		
		userPayload.setId(faker.idNumber().hashCode());
		userPayload.setFirstName(faker.name().firstName());
		userPayload.setLastName(faker.name().lastName());
		userPayload.setEmail(faker.internet().emailAddress());
		userPayload.setPassword(faker.internet().password(5,10));
		userPayload.setPhone(faker.phoneNumber().cellPhone());
		userPayload.setUsername(faker.name().username());	
		
	}
	
	@Test(priority = 1)
	
	public void testPostUser() {
		
		Response response = UserEndPoints.createUser(userPayload);
        response.then().log().all();   	
	
	    Assert.assertEquals(response.getStatusCode(), 200);	    
          	
	}
	
	@Test(priority = 2)
    public void getUserByUserName() {
		
    	Response response = UserEndPoints.readUser(this.userPayload.getUsername());    
    	response.then().log().all();
    	
    	Assert.assertEquals(response.getStatusCode(), 200);	 
          	
	}
	
	@Test(priority = 3)
	public void testUpdatedByUserName() {
		
		//Update Data
		userPayload.setFirstName(faker.name().firstName());
		userPayload.setLastName(faker.name().lastName());
		userPayload.setEmail(faker.internet().emailAddress());
		
		Response response = UserEndPoints.updateUser(this.userPayload.getUsername(), userPayload);
		response.then().log().all();
		
		Assert.assertEquals(response.getStatusCode(), 200);	
	}
	
	@Test(priority = 4)
	public void testDeleteUser() {
		
		Response response = UserEndPoints.deleteUser(this.userPayload.getUsername());
		response.then().log().all();
		
		Assert.assertEquals(response.getStatusCode(), 200);	
		
		
	}
	
	
	
	
}
