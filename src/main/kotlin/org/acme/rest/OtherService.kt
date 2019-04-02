package org.acme.rest

import org.eclipse.microprofile.config.inject.ConfigProperty
import javax.enterprise.context.Dependent
import javax.inject.Inject

/**
 *
 * @author cristhiank on 2019-03-22
 *
 **/
@Dependent
class OtherService {
    // INJECTION (repeated) bug #1650
    @Inject
    @ConfigProperty(name = "custom.config")
    lateinit var customConfig: String

    fun helloBug1650(): String {
        println("Config=$customConfig")
        return customConfig
    }
}