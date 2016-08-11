package com.claudio.endpoint;

import javax.xml.ws.Endpoint;

import com.claudio.ws.HelloWorldImpl;

// Endpoint publisher
public class HelloWorldPublisher {

	public static void main(String[] args){
		System.out.println("Iniciando el servicio ... ");
		
		Endpoint.publish("http://localhost:9999/ws/hello",
				new HelloWorldImpl());
	}
}
