package api.endpoints;

/*
 Swagget URL: https://petstore.swagger.io/
 
 Post : https://petstore.swagger.io/v2/user
 Get : https://petstore.swagger.io/v2/user/{username}
 Put :https://petstore.swagger.io/v2/user/{username}
delete :https://petstore.swagger.io/v2/user/{username}


 */


public class Routes {
	public static String base_url = "https://petstore.swagger.io/v2";
	
	//User module
	public static String post_url = base_url+"/user/{username}";
	public static String Get_url = base_url+"/user/{username}";
	public static String Put_url = base_url+"/user/{username}";
	public static String Delete_url = base_url+"/user/{username}";
	
	//Pet Module
		//Here you will create the pet module
	//Store module
	//Here you will create the store module
}
