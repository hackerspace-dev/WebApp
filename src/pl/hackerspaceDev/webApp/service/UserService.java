package pl.hackerspaceDev.webApp.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Inject;

import pl.hackerspaceDev.webApp.dao.UserDAO;
import pl.hackerspaceDev.webApp.model.User;

@Stateless
public class UserService {

	@EJB
	private UserDAO userDAO;
	
	public User getFirstUser(){
		return userDAO.get(1L);
	}
	
	public List<User> getAllUsers(){
		return userDAO.list();
	}
	
	public User getEla(){
		return userDAO.getUserByName("Ela");
	}
	
	public void removeEvenUsers(){
		List<User> list = new ArrayList<User>(getAllUsers());
		list.removeIf(u->u.getId().longValue()%2==1);
		list.forEach(u->userDAO.delete(u));
	}

	public void createUserWithName(String name) {
		User u = new User();
		u.setName(name);
		u.setDate(new Date());
		userDAO.insertOrUpdate(u);
		
	}
	
}
