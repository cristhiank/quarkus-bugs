package org.acme.rest

import io.quarkus.test.junit.QuarkusTest
import org.acme.rest.panache.TestEntity
import org.acme.rest.panache.TestEntityRepository
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import javax.inject.Inject

@QuarkusTest
class PanacheResourceKotlinTest {
    @Inject
    lateinit var repository: TestEntityRepository

    @Test
    fun testBug1969() {
        val entity = TestEntity()
        entity.name = "TEST"
        repository.persist(entity)
        Assertions.assertNotNull(entity.id)
        println("Entity id is: ${entity.id}")
        val found = repository.findById(entity.id)
        Assertions.assertNotNull(found)
    }
}