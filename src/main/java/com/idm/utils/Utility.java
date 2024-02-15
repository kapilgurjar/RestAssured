package com.idm.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class Utility {

	public static String getGlobalValue(String key) throws IOException {
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "/src/main/java/com/idm/config/config.properties");
		prop.load(fis);
		return prop.getProperty(key);

	}

	public static String getJsonPath(Response response, String key) {
		String resp = response.asString();
		JsonPath js = new JsonPath(resp);
		return js.get(key).toString();
	}

}
