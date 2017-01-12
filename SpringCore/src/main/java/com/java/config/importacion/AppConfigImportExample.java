package com.java.config.importacion;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({CustomerConfig.class, SchedulerConfig.class})
public class AppConfigImportExample {
	
	

}
