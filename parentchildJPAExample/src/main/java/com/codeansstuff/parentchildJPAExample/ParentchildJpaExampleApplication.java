package com.codeansstuff.parentchildJPAExample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

@SpringBootApplication
public class ParentchildJpaExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(ParentchildJpaExampleApplication.class, args);
	}


	@Bean
	public Jackson2ObjectMapperBuilder jacksonBuilder() {
		Jackson2ObjectMapperBuilder b = new Jackson2ObjectMapperBuilder();
		b.failOnEmptyBeans(false);
		b.failOnUnknownProperties(false);
		return b;
	}

}
