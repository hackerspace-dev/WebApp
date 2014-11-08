package pl.hackerspaceDev.webApp.service;

import javax.ejb.Stateless;

@Stateless
public class HelloBean {

	public String getHello(){
		return "Hello from Bean!";
	}
	
}
