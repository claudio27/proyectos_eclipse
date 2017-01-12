package com.java.config.importacion;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.java.config.core.SchedulerBo;

@Configuration
public class SchedulerConfig {
	
	@Bean(name="scheduler")
	public SchedulerBo schedulerBo() {
		return new SchedulerBo();
	}

}
