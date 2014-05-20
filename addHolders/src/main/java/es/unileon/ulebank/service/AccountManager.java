package es.unileon.ulebank.service;

import java.io.Serializable;
import java.util.List;

import es.unileon.ulebank.domain.Client;
import es.unileon.ulebank.domain.Person;

public interface AccountManager extends Serializable{

	public void addAuthorized(Person person);
	
	public List<Client> getAuthorizeds();
	

}
