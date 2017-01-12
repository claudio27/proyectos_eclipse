package com.java.config.importacion;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.java.config.core.CustomerBo;

@Configuration
public class CustomerConfig {
	
	@Bean(name="customer")
	public CustomerBo customerBo() {
		return new CustomerBo();
	}

}
