package com.claudio.ws;

import javax.jws.WebService;

// Service Implementation

@WebService(endpointInterface = "com.claudio.ws.HelloWorld")
public class HelloWorldImpl implements HelloWorld{
	
	@Override
	public String getHelloWorldAsString(String name) {
		
		return "Hola mundo JAX-WS " + name ;
	}
}
