package com.claudio.contexto;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Contexto {
	
	protected static ApplicationContext contexto;
	
	static {
		
		contexto = new ClassPathXmlApplicationContext(
				"Spring-Module.xml");
	}
	
	public static Object getBean(String beanName) {
		
		return contexto.getBean(beanName);
	} 

}
