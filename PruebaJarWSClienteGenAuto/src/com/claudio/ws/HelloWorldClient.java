package com.claudio.ws;

public class HelloWorldClient {

	public static void main(String[] args) {

//		Generadas con wsimport -keep http://localhost:9999/ws/hello?wsdl
		
		HelloWorldImplService helloService = new HelloWorldImplService();
		HelloWorld hello = helloService.getHelloWorldImplPort();
		
		System.out.println(hello.getHelloWorldAsString("Claudio"));

	}

}
