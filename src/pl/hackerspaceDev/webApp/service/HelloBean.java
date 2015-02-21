package pl.hackerspaceDev.webApp.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.annotation.security.RolesAllowed;
import javax.ejb.EJB;
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

	//@RolesAllowed({"admin"})
	public String getHello(){
		
		Log.info("Wywo�ano getHello");
		
		
		//logTest
		if(logger.isTraceEnabled()){
			logger.trace("�lad wywo�a�");
		}
		if(logger.isDebugEnabled()){
			logger.debug("Podgl�d Warto�ci");
		}
		logger.info("Informacje");
		logger.warn("Ostrze�enia");
		logger.error("Wyj�tek");
		logger.fatal("B��d niszcz�cy");
		
		User u1 = userDAO.get(1L); //   em.find(User.class, 1L);
		
		DateFormat df = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
		String s = "Hello from Bean!\n" + u1.getName();
		s+= "\n"+df.format(u1.getDate());
		s+= "\n";

		return s;
	}
	
}
