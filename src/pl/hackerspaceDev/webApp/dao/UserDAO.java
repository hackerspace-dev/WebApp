package pl.hackerspaceDev.webApp.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.NoResultException;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.jpa.HibernateEntityManagerFactory;
import org.hsqldb.jdbc.JDBCConnection;

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
