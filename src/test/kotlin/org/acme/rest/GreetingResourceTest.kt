package org.acme.rest

import io.quarkus.test.junit.QuarkusTest
import io.restassured.RestAssured.given
import org.hamcrest.CoreMatchers.`is`
import org.junit.jupiter.api.Test

@QuarkusTest
open class GreetingResourceTest {

    @Test
    fun testBug1575() {
        given()
                .`when`().get("/bug/1575")
                .then()
                .statusCode(200)
                .body(`is`("Hello ITS OK"))
    }

    @Test
    fun testBugLatest() {
        given()
                .`when`().get("/bug/1650")
                .then()
                .statusCode(200)
                .body(`is`("CUSTOMIZED"))
    }

}