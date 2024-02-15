package com.idm.utils;

import com.github.javafaker.Faker;
import com.idm.pojo.CreateAuthors;


public class DataGenerator {
	
	public  static CreateAuthors getAuthorPayload() {
		Faker faker = new Faker();
		CreateAuthors createAuthors = new CreateAuthors();
		createAuthors.setId("8");
		createAuthors.setIdBook("10");
		createAuthors.setFirstName(faker.name().firstName());
		createAuthors.setLastName(faker.name().lastName());
		return 	createAuthors;
		
	}

}
