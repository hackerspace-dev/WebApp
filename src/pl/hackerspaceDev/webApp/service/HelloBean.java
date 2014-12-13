package pl.hackerspaceDev.webApp.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import pl.hackerspaceDev.webApp.model.User;

@Stateless
public class HelloBean {

	@PersistenceContext(unitName="WebAppGit")
	protected EntityManager em;

	public String getHello(){
		User u1 = em.find(User.class, 1);
		
		DateFormat df = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
		String s = "Hello from Bean!\n" + u1.getName();
		s+= "\n"+df.format(u1.getDate());
		s+= "\n";

		return s;
	}
	
}
