package com.idm.utils;

import static io.restassured.RestAssured.given;

import java.util.Map;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestUtils {
	public static RequestSpecification reqSpec;
	public static Response response;

	/**
	 * @author Kapil
	 * @param baseURI
	 */
	public static RequestSpecification getRequestSpecification(String baseURI) {
		return given().baseUri(baseURI).contentType(ContentType.JSON);
	}

	/**
	 * @author Kapil
	 * @param baseURI,formPar,resources
	 */
	public static Response getToken(String baseURI, Map<String, Object> formPar, String resources) {

		return given().baseUri(baseURI).formParams(formPar).formParams(formPar).formParams(formPar).formParams(formPar)
				.post(resources);

	}

	/**
	 * @author Kapil
	 * @param baseURI,id,resources
	 */

	public static Response performGetRequest(String baseURI, int id, String resources) {

		return getRequestSpecification(baseURI).pathParam("id", id).get(resources);

	}

	/**
	 * @author Kapil
	 * @param baseURI,key,value,resources
	 */
	public static Response performGetRequest(String baseURI, String key, Object value, String resources) {

		return getRequestSpecification(baseURI).queryParam(key, value).get(resources);
	}

	/**
	 * @author Kapil
	 * @param baseURI,resources
	 */
	public static Response performPostRequest(String baseURI, String resources, Object body) {

		return getRequestSpecification(baseURI).body(body).post(resources);
	}

	/**
	 * @author Kapil
	 * @param baseURI,key,value,resources,body
	 */
	public static Response performPutRequest(String baseURI, String key, int value, String resources, Object body) {
		return getRequestSpecification(baseURI).pathParam(key, value).body(body).put(resources);

	}

	/**
	 * @author Kapil
	 * @param baseURI,key,value,resources
	 */
	public static Response performDeleteRequest(String baseURI, String key, int value, String resources) {
		return getRequestSpecification(baseURI).pathParam(key, value).delete(resources);
	}
}
