package pl.hackerspaceDev.webApp.webServices;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import pl.hackerspaceDev.webApp.util.Log;

@WebService
public class HelloWS {

	@WebMethod
	public String sayHello(@WebParam(name="name")  String name){
		Log.info("wywo³ano serwis z parametrem name="+name);
		
		return "Hello "+name+"!";
	}
	
}


