package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.idm.constants.Constant;
import com.idm.pojo.CreateAuthors;
import com.idm.utils.DataGenerator;
import com.idm.utils.RestUtils;
import com.idm.utils.Utility;
import io.restassured.response.Response;

public class FakeRESTApi {
	Response reponse;
	APIResources resourceAPI;
	String baseURI = "https://fakerestapi.azurewebsites.net";

	@Test
	public void TC01CreateAuthors() {
		resourceAPI = APIResources.valueOf("getAuthors");
		reponse = RestUtils.performPostRequest(baseURI, resourceAPI.getResource(),
				DataGenerator.getAuthorPayload());
		int statusCode = reponse.getStatusCode();
		Assert.assertEquals(statusCode, Constant.statusCode_200);
		CreateAuthors ca=reponse.as(CreateAuthors.class);
		System.out.println("Author first name is " +ca.getFirstName());
		System.out.println("Author Last name is " +ca.getLastName());
		System.out.println("Author id name is " +ca.getId());
		System.out.println("Author bookId name is " +ca.getIdBook());
	}

	@Test
	public void TC02getBooks() {
		resourceAPI = APIResources.valueOf("AddPlaceAPI");
		reponse = RestUtils.performGetRequest(baseURI, 2, resourceAPI.getResource());
		int statusCode = reponse.getStatusCode();
		Assert.assertEquals(statusCode, Constant.statusCode_200);
		String id = Utility.getJsonPath(reponse, "[0].idBook");
		Assert.assertEquals(id, "2");
	}
	@Test
	public void TC03UpdateId() {
	resourceAPI = APIResources.valueOf("updateId");
	reponse=RestUtils.performPutRequest(baseURI, "id", 10, resourceAPI.getResource(), DataGenerator.getAuthorPayload());
	System.out.println(reponse.getStatusCode());
	System.out.println(reponse.getStatusLine());
	System.out.println(reponse.getHeader("Content-Type"));
	System.out.println(reponse.getHeader("Date"));
	System.out.println(reponse.getHeader("Server"));
	System.out.println(reponse.getHeader("api-supported-versions"));
	System.out.println(reponse.getTime());
		
	}
}
