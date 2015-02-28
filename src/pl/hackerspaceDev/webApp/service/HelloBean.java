package pl.hackerspaceDev.webApp.service;

import java.security.Principal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.annotation.Resource;
import javax.annotation.security.RolesAllowed;
import javax.ejb.EJB;
import javax.ejb.EJBContext;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;

import pl.hackerspaceDev.webApp.dao.UserDAO;
import pl.hackerspaceDev.webApp.model.User;
import pl.hackerspaceDev.webApp.util.Log;


@Stateless
public class HelloBean {

	private static Logger logger = Logger.getLogger(HelloBean.class);
			
	@EJB
	UserDAO userDAO;
	
	@Resource SessionContext ctx;
	
	//@RolesAllowed({"admin"})
	public String getHello(){
		
		Log.info("Wywo³ano getHello");
		Log.info("ejbContext: "+ctx);
		Principal principal = ctx.getCallerPrincipal();
		Log.info("principal: "+principal);
		Log.info("principal: "+principal.getName());
		Log.info("principal: "+ctx.isCallerInRole("admin"));
		
		User u1 = userDAO.get(1L); 
		
		DateFormat df = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
		String s = "Hello from Bean!\n" + u1.getName();
		s+= "\n"+df.format(u1.getDate());
		s+= "\n";

		return s;
	}
	
}
