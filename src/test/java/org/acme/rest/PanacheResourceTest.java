package org.acme.rest;

import java.util.UUID;
import javax.inject.Inject;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;
import org.acme.rest.panache.TestEntity;
import org.acme.rest.panache.TestEntityRepository;

import static io.restassured.RestAssured.given;
import static org.wildfly.common.Assert.assertNotNull;

@QuarkusTest
class PanacheResourceTest {
	@Inject
	TestEntityRepository repository;

	@Test
	void testBug1969() {
		var entity = new TestEntity();
		entity.name = "TEST";
		repository.persist( entity );
		Assertions.assertNotNull( entity.id );
		System.out.println( "Entity id is: " + entity.id );
		var found = repository.findById( entity.id );
		Assertions.assertNotNull( found );
	}

	@Test
	void testBug1969Rest() {
		var entity = new TestEntity();
		entity.id = UUID.randomUUID();
		entity.name = "TEST";
		//repository.persist(entity)
		assertNotNull( entity.id );
		System.out.println( "Entity id is: ${entity.id}" );
		given().when()
				.get( "/test-entity/{0}", entity.id )
				.then()
				.assertThat()
				.statusCode( 204 ); // 204 is ok.. doesn't exist
	}

}