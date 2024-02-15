package testCases;

import org.testng.annotations.Test;

import com.idm.pojo.Api;
import com.idm.pojo.Courses;
import com.idm.pojo.GetAllCourses;
import com.idm.pojo.WebAutomation;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.List;

public class DummyApi {

	@Test
	public void PostApi() {

		RestAssured.baseURI = "https://rahulshettyacademy.com";

		String response = given().queryParam("key", "qaclick123").header("Content-Type", "application/json").body("")
				.when().post("maps/api/place/add/json").then().assertThat().statusCode(200)
				.body("scope", equalTo("APP")).header("server", "Apache/2.4.18 (Ubuntu)").extract().response()
				.asString();
	}

	@Test
	public void OathTest() {
		String response = given()
				.formParams("client_id", "692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")

				.formParams("client_secret", "erZOWM9g3UtwNRj340YYaK_W")

				.formParams("grant_type", "client_credentials")

				.formParams("scope", "trust")

				.when().log().all()

				.post("https://rahulshettyacademy.com/oauthapi/oauth2/resourceOwner/token").asString();

		// System.out.println(response);

		JsonPath jsonPath = new JsonPath(response);

		String accessToken = jsonPath.getString("access_token");

		System.out.println(accessToken);

		GetAllCourses allCourses = given()

				.queryParams("access_token", accessToken)

				.when()

				.get("https://rahulshettyacademy.com/oauthapi/getCourseDetails")

				.as(GetAllCourses.class);
		List<WebAutomation> name = allCourses.getCourses().getWebAutomation();
		for (int i = 0; i < name.size(); i++) {

			String title =name.get(i).getCourseTitle();
			System.out.println(title);
		}

	}

}
