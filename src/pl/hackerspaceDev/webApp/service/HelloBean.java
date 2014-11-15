package pl.hackerspaceDev.webApp.service;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import pl.hackerspaceDev.webApp.model.User;

@Stateless
public class HelloBean {

	@PersistenceContext(unitName="WebAppGit")
	private EntityManager em;
	
	public String getHello(){
		
		User u1 = em.find(User.class, 1);
		
		
		return "Hello from Bean!" + u1.getName();
	}
	
}
