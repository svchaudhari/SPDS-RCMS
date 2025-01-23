package com.spds.rcms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
@OpenAPIDefinition(info = @Info(title = "SPDS RCMS", description = "All API definitions for SPDS RCMS", version = "1.0.0"))
public class SpdsRcmsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpdsRcmsApplication.class, args);
	}

}
