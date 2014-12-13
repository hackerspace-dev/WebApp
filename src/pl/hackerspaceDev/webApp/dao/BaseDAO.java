package pl.hackerspaceDev.webApp.dao;

import java.util.List;

import javax.ejb.EJB;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.SessionFactory;

import pl.hackerspaceDev.webApp.model.BaseEntity;

@SuppressWarnings("all")
public class BaseDAO<T extends BaseEntity> {

	@PersistenceContext(unitName="WebAppGit")
	protected EntityManager em;
	
	public T get(Long id, Class<T> clazz){
		return (T) em.find(clazz, id);
	}
	
	public List<T> list(Class<T> clazz){
		return (List<T>) em
				.createQuery("FROM "+clazz.getSimpleName())
				.getResultList();
	}
	
	public void delete(Long id, Class<T> clazz){
		em.createQuery("DELETE o FROM "+clazz.getSimpleName()+" WHERE id=:ID")
			.setParameter("ID", id)
			.executeUpdate();
	}
	
	public void delete(T entity){
		em.remove(entity);
	}
	
	public void insertOrUpdate(T entity){
		if(entity.getId()!=null){
			update(entity);
		} else {
			insert(entity);
		}
	}
	
	public void update(T entity){
		em.merge(entity);
	}
	
	public void insert(T entity){
		em.persist(entity);
	}
	
}
