package org.acme.rest;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;

import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.flywaydb.core.Flyway;

@Dependent
class GreetingService {

	@Inject
	@ConfigProperty(name = "quarkus.datasource.url")
	String dbURL;
	@Inject
	@ConfigProperty(name = "quarkus.datasource.username")
	String user;
	@Inject
	@ConfigProperty(name = "quarkus.datasource.password")
	String pass;
	// INJECTION (repeated) bug #1650
	@Inject
	@ConfigProperty(name = "custom.config")
	String custom;


	String helloBug1575() {
		var flyway = Flyway.configure()
				.dataSource( dbURL, user, pass )
				.baselineOnMigrate( true )
				.load();
		flyway.baseline();
		flyway.migrate();
		return "Hello ITS OK";
	}

	String helloBug1828() {
		return "IT WORKS";
	}
}