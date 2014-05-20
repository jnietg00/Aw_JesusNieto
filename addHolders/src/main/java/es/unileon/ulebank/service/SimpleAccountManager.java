package es.unileon.ulebank.service;

import java.util.List;

import es.unileon.ulebank.domain.Account;
import es.unileon.ulebank.domain.Client;
import es.unileon.ulebank.domain.MalformedHandlerException;
import es.unileon.ulebank.domain.Person;

public class SimpleAccountManager implements AccountManager{
	
	private Account account;


	public void addAuthorized (Person person){
		account.addAuthorized(person);
	}
	
	public List<Client> getAuthorizeds() {
        return account.getAuthorizeds();  
    }
	
	public void setAuthorizeds(List<Client> authorized) {
		this.account.setAuthorizeds(authorized); 
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}
}
