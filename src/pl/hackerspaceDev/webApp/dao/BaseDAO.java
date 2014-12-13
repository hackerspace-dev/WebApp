package pl.hackerspaceDev.webApp.dao;

import java.util.List;

import javax.ejb.EJB;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.SessionFactory;

@SuppressWarnings("all")
public class BaseDAO<T> {

	@PersistenceContext(unitName="WebAppGit")
	protected EntityManager em;
	
//	@EJB
//	private SessionFactory factory;
	
	public T get(Long id, Class<T> clazz){
		return (T) em.find(clazz, id);
	}
	
	public List<T> list(Class<T> clazz){
		return (List<T>) em
				.createQuery("SELECT o FROM "+clazz.getSimpleName()+" o")
				.getResultList();
	}
	
	public void delete(T object){
		em.remove(object);
	}
	
}
