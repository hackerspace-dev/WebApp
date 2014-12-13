package pl.hackerspaceDev.webApp.dao;

import java.util.List;

import javax.ejb.Stateless;

import org.hibernate.Session;
import org.hibernate.jpa.HibernateEntityManagerFactory;

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
		
//		HibernateEntityManagerFactory hemf = (HibernateEntityManagerFactory)em.getEntityManagerFactory();
//		Session s = hemf.getSessionFactory().getCurrentSession();
//		
//		System.out.println(s.createCriteria(User.class).list());
		
		return (User) em
				.createQuery("FROM User WHERE name=:NAME")
				.setParameter("NAME", name)
				.getSingleResult();
	}
	
	

}
