package pl.hackerspaceDev.webApp.webServices;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import pl.hackerspaceDev.webApp.dao.UserDAO;
import pl.hackerspaceDev.webApp.model.User;
import pl.hackerspaceDev.webApp.util.Log;

@Stateless
@WebService(serviceName="userWS")
public class UserWS {

	@EJB
	private UserDAO userDAO; 
	
	@WebMethod
	public User getUser(@WebParam(name="id") long id){
		
		User u = userDAO.get(id);
		
		Log.info("Web service pobiera u¿ytkownika: "+u);
		
		return u;
		/*if(u==null) {
			return null;
		} else {
			UserXDTO userXDTO = new UserXDTO(u);
			return userXDTO;
		}*/
	}
	
}
