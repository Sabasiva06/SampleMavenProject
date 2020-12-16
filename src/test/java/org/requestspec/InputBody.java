package org.requestspec;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Properties;

import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class InputBody {
	static RequestSpecification build;

	public static PreemptiveBasicAuthScheme getValue() throws FileNotFoundException, IOException {

		Properties properties = new Properties();
		properties.load(new FileInputStream(
				"C:\\Users\\WELCOME\\eclipse-workspace\\RestAssured\\src\\test\\resources\\configuration.properties"));

		PreemptiveBasicAuthScheme authScheme = new PreemptiveBasicAuthScheme();

		authScheme.setUserName(new String(Base64.getDecoder()
				.decode(Base64.getEncoder().encodeToString(((String) properties.get("userName")).getBytes()))));
		authScheme.setPassword(new String(Base64.getDecoder()
				.decode(Base64.getEncoder().encodeToString(((String) properties.get("password")).getBytes()))));
		return authScheme;
	}

	public static RequestSpecification requestSpecBuilder() throws FileNotFoundException, IOException {
		if (build == null) {
			RequestSpecBuilder builder = new RequestSpecBuilder();
			build = builder.addHeader("content-type", "application-json").setContentType("application/json")
					.setAuth(getValue()).setBaseUri("https://sabasv.atlassian.net").build();
		}

		return build;
	}

}
