package pl.hackerspaceDev.webApp.util;

import org.apache.log4j.Logger;
import org.apache.openejb.spi.CallerPrincipal;

import pl.hackerspaceDev.webApp.service.HelloBean;

public class Log {

	public static void info(String msg){
		Class clazz = sun.reflect.Reflection.getCallerClass(2);
		Logger logger = Logger.getLogger(clazz);
		logger.info(msg);		
	}
	
}
