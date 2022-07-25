package com.tkluza.spring.efficientunittests

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.runApplication

@SpringBootApplication
@ConfigurationPropertiesScan
class EfficientUnitTestingApplication

fun main(args: Array<String>) {
	runApplication<EfficientUnitTestingApplication>(*args)
}
