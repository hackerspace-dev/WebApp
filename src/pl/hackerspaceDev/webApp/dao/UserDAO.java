package pl.hackerspaceDev.webApp.dao;

import java.util.List;

import javax.ejb.Stateless;

import pl.hackerspaceDev.webApp.model.User;

@SuppressWarnings("all")
@Stateless
public class UserDAO extends BaseDAO<User> {

	public User get(String id){
		return get(id, User.class);
	}
	
	public List<User> list(){
		return list(User.class);
	}
	
	public User getUserByName(String name){
		return (User) em
				.createQuery("SELECT o FROM User o WHERE o.name=:NAME")
				.setParameter("NAME", name)
				.getSingleResult();
	}
	
	

}
