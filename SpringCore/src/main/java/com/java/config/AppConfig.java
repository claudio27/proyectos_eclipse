package com.java.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
	
	@Bean(name="beanAnotado")
	public HolaMundo holaMundo() {
		return new HolaMundoImpl();
	}

}
