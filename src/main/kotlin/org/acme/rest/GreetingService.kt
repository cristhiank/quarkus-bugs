package org.acme.rest;

import org.eclipse.microprofile.config.inject.ConfigProperty
import org.flywaydb.core.Flyway
import javax.enterprise.context.Dependent
import javax.inject.Inject

@Dependent
open class GreetingService {

    @Inject
    @ConfigProperty(name = "quarkus.datasource.url")
    lateinit var dbURL: String
    @Inject
    @ConfigProperty(name = "quarkus.datasource.username")
    lateinit var user: String
    @Inject
    @ConfigProperty(name = "quarkus.datasource.password")
    lateinit var pass: String


    fun helloBug(): String {
        val flyway = Flyway.configure()
                .dataSource(dbURL, user, pass)
                .load()
        flyway.migrate()
        return "Hello ITS OK"
    }
}