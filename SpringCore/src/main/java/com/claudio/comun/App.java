package com.claudio.comun;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.claudio.loosely.coupled.IOutputGenerator;
import com.claudio.loosely.coupled.OutputHelper;
import com.claudio.loosely.coupled.impl.CsvOutputGenerator;

public class App {
	public static void main(String[] args) {
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
    	
    	OutputHelper outputHelper = new OutputHelper();
    	outputHelper.generateOutput();
    	
    	//Metodo 3
    	// Spring
    	ApplicationContext context2 =
    	    	   new ClassPathXmlApplicationContext(new String[] {"Spring-Common.xml"});

    	    	OutputHelper outputHelperSpring = (OutputHelper)context2.getBean("OutputHelper");
    	    	outputHelperSpring.generateOutput();
	}
}