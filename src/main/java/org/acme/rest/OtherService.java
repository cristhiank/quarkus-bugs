package org.acme.rest;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;

import org.eclipse.microprofile.config.inject.ConfigProperty;

/**
 * @author cristhiank on 2019-03-22
 **/
@Dependent
class OtherService {
	// INJECTION (repeated) bug #1650
	@Inject
	@ConfigProperty(name = "custom.config")
	String customConfig;

	String helloBug1650() {
		System.out.println( "Config=" + customConfig );
		return customConfig;
	}
}