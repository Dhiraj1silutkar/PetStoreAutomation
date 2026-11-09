package api.endpoints;

/*
 * URI -> https://petstore.swagger.io
 * Create - https://petstore.swagger.io/v2/user
 * Get user - https://petstore.swagger.io/v2/user/{username}
 * Update user - https://petstore.swagger.io/v2/user/{username}
 * Delete user - https://petstore.swagger.io/v2/user/{username}
 * 
 */

//Only URL's will be considered inside this route class

public class Routes {

	public static String base_url = "https://petstore.swagger.io/v2";
	
	//User Module
	
	public static String post_url = base_url+"/user";
	public static String get_url = base_url+"/user/{username}";
	public static String update_url = base_url+"/user/{username}";
	public static String delete_url = base_url+"/user/{username}";
	
	
	
	
	
	
	
	
	
}
