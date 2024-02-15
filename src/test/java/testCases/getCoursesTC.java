package testCases;
import java.util.List;
import org.testng.annotations.Test;
import com.idm.pojo.GetAllCourses;
import com.idm.pojo.WebAutomation;
import com.idm.utils.RestUtils;
import io.restassured.response.Response;
import testBase.BaseTest;

public class getCoursesTC extends BaseTest{

	
	
	/*
	 * This test case will get access token and fetch number of course in api 
	 @Author Kapil
	 */
	@Test
	public void getAllCourses() {
		String res="/oauthapi/oauth2/resourceOwner/token";
		String baseURI = "https://rahulshettyacademy.com";
		String token =getAccessToken();
		System.out.println("Authorization access token is " + token);
		Response response2=RestUtils.performGetRequest(baseURI, "access_token",token,"/oauthapi/getCourseDetails");
		GetAllCourses allCourses=response2.as(GetAllCourses.class);
		List<WebAutomation> name = allCourses.getCourses().getWebAutomation();
		for (int i = 0; i < name.size(); i++) {
			String title = name.get(i).getCourseTitle();
			System.out.println(title);
		}
	}

}
