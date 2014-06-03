package es.unileon.ulebank.repository;

import java.util.List;

import es.unileon.ulebank.domain.Account;
import es.unileon.ulebank.domain.Person;

public interface AccountDao {
	
	public List<Account> getAccountList();
	
	public List<Person> getAuthorizeds();
	
	public void addAccount(Account account);

}
