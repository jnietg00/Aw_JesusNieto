package es.unileon.ulebank.service;

import java.io.Serializable;
import java.util.List;

import es.unileon.ulebank.domain.Person;

public interface AccountManager extends Serializable{

	public void addAuthorized(Person person, int idAccount);
	
	public List<Person> getAuthorizeds();
	

}
