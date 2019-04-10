package org.acme.rest;

import javax.inject.Inject;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import io.quarkus.test.junit.QuarkusTest;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS) // Bug #1828
@QuarkusTest
public class GreetingResourceTest {

	@Inject
	GreetingService service;

	@Test
	void testBug1575() {
		given()
				.when().get( "/bug/1575" )
				.then()
				.statusCode( 200 )
				.body( is( "Hello ITS OK" ) );
	}

	@Test
	void testBug1650() {
		given()
				.when().get( "/bug/1650" )
				.then()
				.statusCode( 200 )
				.body( is( "CUSTOMIZED" ) );
	}

	@Test
	void testBug1828() {
		var test = service.helloBug1828();
		assertEquals( "IT WORKS", test );
	}

}