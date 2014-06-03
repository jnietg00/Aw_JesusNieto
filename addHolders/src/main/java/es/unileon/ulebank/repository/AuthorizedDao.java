package es.unileon.ulebank.repository;

import java.util.List;

import es.unileon.ulebank.domain.Person;


public interface AuthorizedDao {
	
	public List<Person> getAuthorizedList();
	
	public void addAuthorized(Person authorized);
}
