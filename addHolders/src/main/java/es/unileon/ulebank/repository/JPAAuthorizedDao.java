package es.unileon.ulebank.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import es.unileon.ulebank.domain.Person;

@Repository(value = "authorizedDao")
public class JPAAuthorizedDao implements AuthorizedDao{
	
	private EntityManager em = null;
	
	@PersistenceContext
	public void setEntityManager(EntityManager em) {
		this.em = em;
	}
	
	@Transactional(readOnly = true)
	@SuppressWarnings("unchecked")
	public List<Person> getAuthorizedList() {
		return em.createQuery("select a from Person a order by a.dniNumber").getResultList();
	}
	
	@Transactional(readOnly = false)
	public void addAuthorized(Person authorized) {
		em.merge(authorized);
	}
	

}
