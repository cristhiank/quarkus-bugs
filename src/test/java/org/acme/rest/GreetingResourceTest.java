package org.acme.rest;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;

import static io.restassured.RestAssured.given;

@QuarkusTest
public class GreetingResourceTest {

	@Test
	void testBug() {
		given().when()
				.post( "/bug" )
				.then().statusCode( 200 );
	}

}