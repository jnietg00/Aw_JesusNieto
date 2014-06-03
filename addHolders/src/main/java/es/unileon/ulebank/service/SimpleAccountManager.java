package es.unileon.ulebank.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import es.unileon.ulebank.domain.Account;
import es.unileon.ulebank.domain.Person;
import es.unileon.ulebank.repository.AccountDao;
import es.unileon.ulebank.repository.AuthorizedDao;

@Component
public class SimpleAccountManager implements AccountManager{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private AccountDao accountDao;
	
	@Autowired 
	private AuthorizedDao authorizedDao;


	public void addAuthorized (Person person, int idAccount){
		Account account = new Account();
		account.setIdAccount(idAccount);
		
		person.setAccount(account);
		List<Person> authorizeds = new ArrayList<Person>();
		authorizeds.add(person);
		account.setAuthorizeds(authorizeds);
		accountDao.addAccount(account);
		
	}
	
	public void setAuthorizedDao(AuthorizedDao authorizedDao) {
		this.authorizedDao = authorizedDao;
	}
	
	public List<Person> getAuthorizeds() {
        return accountDao.getAuthorizeds();
    }
	
//	public void setAuthorizeds(List<Client> authorized) {
//		this.account.setAuthorizeds(authorized); 
//	}
//
//	public Account getAccount() {
//		return account;
//	}

	public void setAccountDao(AccountDao accountDao) {
		this.accountDao = accountDao;
	}
}
