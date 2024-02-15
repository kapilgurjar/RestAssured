package com.idm.utils;

import static io.restassured.RestAssured.given;

import java.util.Map;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestUtils {
	public static Response response;

	public static Response getToken(String baseURI, Map<String, Object> formPar, String resorces) {

		response = given().baseUri(baseURI).formParams(formPar).formParams(formPar).formParams(formPar)
				.formParams(formPar).post(resorces);
		return response;
	}

	public static Response performGetRequest(String baseURI, int id, String resorces) {

		response = given().baseUri(baseURI).contentType(ContentType.JSON).pathParam("id", id).get(resorces);
		return response;
	}

	public static Response performGetRequest(String baseURI, String key, Object value, String resorces) {

		response = given().baseUri(baseURI).contentType(ContentType.JSON).queryParam(key, value).get(resorces);
		return response;
	}

	public static Response performPostRequest(String baseURI, String resorces, Object body) {

		response = given().baseUri(baseURI).contentType(ContentType.JSON).body(body).post(resorces);
		return response;
	}

	public static Response performPutRequest(String baseURI, String key, int value, String resorces, Object body) {
		response = given().baseUri(baseURI).contentType(ContentType.JSON).pathParam(key, value).body(body)
				.put(resorces);
		return response;
	}
}
