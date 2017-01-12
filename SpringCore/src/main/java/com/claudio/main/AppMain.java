package com.claudio.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.claudio.comun.HelloWorld;
import com.claudio.loosely.coupled.IOutputGenerator;
import com.claudio.loosely.coupled.OutputHelper;
import com.claudio.loosely.coupled.impl.CsvOutputGenerator;
import com.java.config.AppConfig;
import com.java.config.HolaMundo;
import com.java.config.core.CustomerBo;
import com.java.config.core.SchedulerBo;
import com.java.config.importacion.AppConfigImportExample;

public class AppMain {
	public static void main(String[] args) {

		llamadaDebilmenteAcoplado();
//		llamadaConfiguracionDesdeJava();
//    	callJavaConfigImportExample();    	
		
    	
	}
	
	public static void llamadaDebilmenteAcoplado() {
		
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"Spring-Module.xml");
		
		HelloWorld obj = (HelloWorld) context.getBean("helloBean");
		obj.printHello();
		
		
//		Loosely coupled
		//Metodo 1 
		IOutputGenerator output = new CsvOutputGenerator();
		output.generateOutput();
		
		//Metodo 2 
		// LLamar por medio de una clase ayundate 
		System.out.println("Creado por constructor");
//		OutputHelper outputHelper = new OutputHelper();
//		outputHelper.generateOutput();
		
		//Metodo 3
		// Spring
		ApplicationContext context2 =
				new ClassPathXmlApplicationContext("Spring-Common.xml");
//		Cannot create inner bean 'com.claudio.loosely.coupled.impl.XmlOutputGenerator#888e6c' 
//		of type [com.claudio.loosely.coupled.impl.XmlOutputGenerator] while setting constructor 
//		argument; nested exception 
//		is org.springframework.beans.factory.CannotLoadBeanClassException: 
//			Error loading class [com.claudio.loosely.coupled.impl.XmlOutputGenerator] for bean 
//			with name 'com.claudio.loosely.coupled.impl.XmlOutputGenerator#888e6c' defined in 
//			class path resource [Spring-Common.xml]: problem with class file or dependent class; 
//			nested exception is java.lang.NoClassDefFoundError: 
//				com/claudio/loosely/coupled/impl/XmlOutputGenerator (wrong name:
//					com/claudio/loosely/coupled/impl/XmlOutPutGenerator)
		
		OutputHelper outputHelperSpring = (OutputHelper)context2.getBean("OutputHelper");
		outputHelperSpring.generateOutput();
	}
	
	
	public static void llamadaConfiguracionDesdeJava() {
		
		ApplicationContext context3 = new AnnotationConfigApplicationContext(AppConfig.class);
		HolaMundo obj3 = (HolaMundo) context3.getBean("beanAnotado");
		obj3.printHolaMundo("Spring3 Java Config");

	}
		
	public static void callJavaConfigImportExample() {
		
		ApplicationContext context = new AnnotationConfigApplicationContext(
				AppConfigImportExample.class);
		
		CustomerBo customer = (CustomerBo) context.getBean("customer");
		customer.printMsg("Hello 1 ");
		
		SchedulerBo scheduler = (SchedulerBo) context.getBean("scheduler");
		scheduler.printMsg("Hello 2 ");
	}
	
}