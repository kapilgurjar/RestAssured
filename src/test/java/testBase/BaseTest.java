package testBase;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.idm.utils.RestUtils;
import com.idm.utils.Utility;

import io.restassured.response.Response;

public class BaseTest {
	
	public String getAccessToken() {
		
		String res="/oauthapi/oauth2/resourceOwner/token";
		String baseURI = "https://rahulshettyacademy.com";
		Map<String, Object> formsData = new HashMap<>();
		formsData.put("client_id", "692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com");
		formsData.put("client_secret", "erZOWM9g3UtwNRj340YYaK_W");
		formsData.put("grant_type", "client_credentials");
		formsData.put("scope", "trust");
		Response response = RestUtils.getToken(baseURI, formsData,res);
		String token = Utility.getJsonPath(response, "access_token");
		return token;
	}
	
	public String getBaseURI() {
		try {
		return 	Utility.getGlobalValue("BaseURI");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
