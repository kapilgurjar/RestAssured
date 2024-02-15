package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.idm.constants.Constant;
import com.idm.pojo.CreateAuthors;
import com.idm.utils.DataGenerator;
import com.idm.utils.RestUtils;
import com.idm.utils.Utility;
import io.restassured.response.Response;
import testBase.BaseTest;

public class FakeRESTApi extends BaseTest {
	Response response;
	APIResources resourceAPI;
	String baseURI = getBaseURI();

	@Test
	public void TC01CreateAuthors() {
		resourceAPI = APIResources.valueOf("getAuthors");
		response = RestUtils.performPostRequest(baseURI, resourceAPI.getResource(), DataGenerator.getAuthorPayload());
		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, Constant.statusCode_200);
		CreateAuthors ca = response.as(CreateAuthors.class);
		System.out.println("Author first name is " + ca.getFirstName());
		System.out.println("Author Last name is " + ca.getLastName());
		System.out.println("Author id name is " + ca.getId());
		System.out.println("Author bookId name is " + ca.getIdBook());
	}

	@Test
	public void TC02getBooks() {
		resourceAPI = APIResources.valueOf("AddPlaceAPI");
		response = RestUtils.performGetRequest(baseURI, 2, resourceAPI.getResource());
		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, Constant.statusCode_200);
		String id = Utility.getJsonPath(response, "[0].idBook");
		Assert.assertEquals(id, "2");
	}

	@Test
	public void TC03UpdateId() {
		resourceAPI = APIResources.valueOf("updateId");
		response = RestUtils.performPutRequest(baseURI, "id", 10, resourceAPI.getResource(),
				DataGenerator.getAuthorPayload());
		System.out.println(response.getStatusCode());
		System.out.println(response.getStatusLine());
		System.out.println(response.getHeader("Content-Type"));
		System.out.println(response.getHeader("Date"));
		System.out.println(response.getHeader("Server"));
		System.out.println(response.getHeader("api-supported-versions"));
		System.out.println(response.getTime());
	}

	@Test
	public void TC04DeleteBook() {
		resourceAPI = APIResources.valueOf("DeleteBook");
		response = RestUtils.performDeleteRequest(baseURI, "id", 11, resourceAPI.getResource());
		System.out.println(response.getStatusCode());
	}
}
