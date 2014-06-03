package es.unileon.ulebank.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import es.unileon.ulebank.domain.Account;
import es.unileon.ulebank.domain.Person;


@Repository(value = "accountDao")
public class JPAAccountDao implements AccountDao{
	
	private EntityManager em = null;
	
	@PersistenceContext
	public void setEntityManager(EntityManager em) {
		this.em = em;
	}
	
	@Transactional(readOnly = true)
	@SuppressWarnings("unchecked")
	public List<Account> getAccountList() {
		return em.createQuery("select a from Account a order by a.id").getResultList();
	}
	
	@Transactional(readOnly = false)
	public void addAccount(Account account) {
		em.merge(account);
	}
	
	@Transactional(readOnly = true)
	@SuppressWarnings("unchecked")
	public List<Person> getAuthorizeds() {
		return em.createQuery("select p from Person p order by p.dniNumber").getResultList();
	}
}
