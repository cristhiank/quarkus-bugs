package org.acme.rest

import io.quarkus.test.junit.QuarkusTest
import io.restassured.RestAssured.given
import org.hamcrest.CoreMatchers.`is`
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import javax.inject.Inject

@TestInstance(TestInstance.Lifecycle.PER_CLASS) // Bug #1828
@QuarkusTest
open class GreetingResourceTest {

    @Inject
    lateinit var service: GreetingService

    @Test
    fun testBug1575() {
        given()
                .`when`().get("/bug/1575")
                .then()
                .statusCode(200)
                .body(`is`("Hello ITS OK"))
    }

    @Test
    fun testBug1650() {
        given()
                .`when`().get("/bug/1650")
                .then()
                .statusCode(200)
                .body(`is`("CUSTOMIZED"))
    }

    @Test
    fun testBug1828() {
        val test = service.helloBug1828()
        assertEquals("IT WORKS", test)
    }

}