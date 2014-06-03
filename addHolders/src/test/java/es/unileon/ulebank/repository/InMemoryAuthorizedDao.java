package es.unileon.ulebank.repository;

import java.util.List;

import es.unileon.ulebank.domain.Person;

public class InMemoryAuthorizedDao implements AuthorizedDao {
	
	private List<Person> authorizedList;
	
	public InMemoryAuthorizedDao(List<Person> authorizedList) {
		this.authorizedList = authorizedList;
	}

	public List<Person> getAuthorizedList() {
		return authorizedList;
	}

	public void addAuthorized(Person authorized) {
	}

}
