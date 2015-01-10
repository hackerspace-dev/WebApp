package pl.hackerspaceDev.webApp.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.NoResultException;

import pl.hackerspaceDev.webApp.model.User;

@SuppressWarnings("all")
@Stateless
public class UserDAO extends BaseDAO<User> {

	public User get(Long id){
		return get(id, User.class);
	}
	
	public List<User> list(){
		return list(User.class);
	}
	
	public User getUserByName(String name){
		
//		Session session = em.unwrap(Session.class);
//		Criteria cUser = session.createCriteria(User.class);
//		cUser.add(Restrictions.eq("id", 1L))
//			.addOrder(Order.asc("name")).list();

		try {
			return (User) em
					.createQuery("FROM User WHERE name=:NAME")
					.setParameter("NAME", name)
					.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}
	
	

}
