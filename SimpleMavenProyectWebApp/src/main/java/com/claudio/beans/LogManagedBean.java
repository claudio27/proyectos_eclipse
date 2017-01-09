package com.claudio.beans;

import javax.faces.bean.ManagedBean;

import org.apache.log4j.Logger;
 
@ManagedBean(name="logManagedBean")
public class LogManagedBean {

	public String mensaje(){

		Logger milogger= Logger.getLogger(this.getClass().getPackage().getName());

		milogger.info("hola desde jsf al log" + new java.util.Date());
		return "log";
	}
}
