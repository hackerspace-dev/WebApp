package pl.hackerspaceDev.webApp.util;

import org.apache.log4j.Logger;
import org.apache.openejb.spi.CallerPrincipal;

import pl.hackerspaceDev.webApp.service.HelloBean;

@SuppressWarnings("all")
public class Log {

	
	public static void fatal(Class clazz, String msg, Throwable exception){
		Logger logger = Logger.getLogger(clazz);
		logger.fatal(msg, exception);
	}
	
	public static void error(Class clazz, String msg, Throwable exception){
		Logger logger = Logger.getLogger(clazz);
		logger.error(msg, exception);
	}
	
	public static void warn(Class clazz, String msg, Throwable exception){
		Logger logger = Logger.getLogger(clazz);
		logger.warn(msg, exception);
	}
	
	public static void fatal(Class clazz, String msg){
		Logger logger = Logger.getLogger(clazz);
		logger.fatal(msg);
	}
	
	public static void error(Class clazz, String msg){
		Logger logger = Logger.getLogger(clazz);
		logger.error(msg);
	}
	
	public static void warn(Class clazz, String msg){
		Logger logger = Logger.getLogger(clazz);
		logger.warn(msg);
	}
	
	public static void info(Class clazz, String msg){
		Logger logger = Logger.getLogger(clazz);
		logger.info(msg);
	}
	
	public static void debug(Class clazz, String msg){
		Logger logger = Logger.getLogger(clazz);
		logger.debug(msg);
	}
	
	public static void trace(Class clazz, String msg){
		Logger logger = Logger.getLogger(clazz);
		logger.trace(msg);
	}
	
	public static void fatal(String msg, Throwable exception){
		Class clazz = sun.reflect.Reflection.getCallerClass(2);
		Logger logger = Logger.getLogger(clazz);
		logger.fatal(msg, exception);
	}
	
	public static void error(String msg, Throwable exception){
		Class clazz = sun.reflect.Reflection.getCallerClass(2);
		Logger logger = Logger.getLogger(clazz);
		logger.error(msg, exception);
	}
	
	public static void warn(String msg, Throwable exception){
		Class clazz = sun.reflect.Reflection.getCallerClass(2);
		Logger logger = Logger.getLogger(clazz);
		logger.warn(msg, exception);
	}
	
	public static void fatal(String msg){
		Class clazz = sun.reflect.Reflection.getCallerClass(2);
		Logger logger = Logger.getLogger(clazz);
		logger.fatal(msg);
	}
	
	public static void error(String msg){
		Class clazz = sun.reflect.Reflection.getCallerClass(2);
		Logger logger = Logger.getLogger(clazz);
		logger.error(msg);
	}
	
	public static void warn(String msg){
		Class clazz = sun.reflect.Reflection.getCallerClass(2);
		Logger logger = Logger.getLogger(clazz);
		logger.warn(msg);
	}
	
	public static void info(String msg){
		Class clazz = sun.reflect.Reflection.getCallerClass(2);
		Logger logger = Logger.getLogger(clazz);
		logger.info(msg);
	}
	
	public static void debug(String msg){
		Class clazz = sun.reflect.Reflection.getCallerClass(2);
		Logger logger = Logger.getLogger(clazz);
		logger.debug(msg);
	}
	
	public static void trace(String msg){
		Class clazz = sun.reflect.Reflection.getCallerClass(2);
		Logger logger = Logger.getLogger(clazz);
		logger.trace(msg);
	}
	
	public static boolean isInfoEnabled(Class clazz) {
		Logger logger = Logger.getLogger(clazz);
		return logger.isInfoEnabled();
	}
	
	public static boolean isDebugEnabled(Class clazz) {
		Logger logger = Logger.getLogger(clazz);
		return logger.isDebugEnabled();
	}
	
	public static boolean isTraceEnabled(Class clazz) {
		Logger logger = Logger.getLogger(clazz);
		return logger.isTraceEnabled();
	}
	
	public static boolean isInfoEnabled() {
		Class clazz = sun.reflect.Reflection.getCallerClass(2);
		Logger logger = Logger.getLogger(clazz);
		return logger.isInfoEnabled();
	}
	
	public static boolean isDebugEnabled() {
		Class clazz = sun.reflect.Reflection.getCallerClass(2);
		Logger logger = Logger.getLogger(clazz);
		return logger.isDebugEnabled();
	}
	
	public static boolean isTraceEnabled() {
		Class clazz = sun.reflect.Reflection.getCallerClass(2);
		Logger logger = Logger.getLogger(clazz);
		return logger.isTraceEnabled();
	}
	
	public static Logger getLogger(Class clazz) {
		Logger logger = Logger.getLogger(clazz);
		return logger;
	}
	
	public static Logger getLogger(){
		Class clazz = sun.reflect.Reflection.getCallerClass(2);
		Logger logger = Logger.getLogger(clazz);
		return logger;
	}
	
}
