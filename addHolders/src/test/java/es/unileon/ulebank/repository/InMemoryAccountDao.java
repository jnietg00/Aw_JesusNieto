package es.unileon.ulebank.repository;

import java.util.List;

import es.unileon.ulebank.domain.Account;
import es.unileon.ulebank.domain.Person;

public class InMemoryAccountDao implements AccountDao{
	
	private List<Account> accountList;
	private List<Person> authorizedList;
	
	public InMemoryAccountDao(List<Person> authorizedList, List<Account> accountList) {
		this.accountList = accountList;
		this.authorizedList = authorizedList;
	}

	public List<Account> getAccountList() {
		return accountList;
	}

	public List<Person> getAuthorizeds() {
		return authorizedList;
	}

	public void addAccount(Account account) {
		accountList.add(account);
		authorizedList.addAll(account.getAuthorizeds());
	}

}
