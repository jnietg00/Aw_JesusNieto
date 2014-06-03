package es.unileon.ulebank.service;

import java.util.List;
import java.util.ArrayList;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import es.unileon.ulebank.domain.Account;
import es.unileon.ulebank.domain.MalformedHandlerException;
import es.unileon.ulebank.domain.Person;
import es.unileon.ulebank.domain.PersonHandler;
import es.unileon.ulebank.repository.AccountDao;
import es.unileon.ulebank.repository.InMemoryAccountDao;

public class SimpleAccountManagerTests {
	
	
	private SimpleAccountManager accountManager;
	private AccountDao accountDao;	
	private Person person1;
	private Person person2;
	private Account account;
	private List<Person> authorizedList;
	private List<Account> accountList;
		
	PersonHandler id1;
	PersonHandler id2;
	
	@Before
	public void setUp() throws Exception {
		
		accountManager = new SimpleAccountManager();

		account = new Account();
		account.setIdAccount(12345);
		person1 = new Person();	
		person1.setDniLetter('x');
		person1.setDniNumber(71519821);
		person1.setName("jesus");
		person1.setAccount(account);
		
		authorizedList = new ArrayList<Person>() ;
		authorizedList.add(person1);
		
		accountList = new ArrayList<Account>();
		accountList.add(account);
		
		account.setAuthorizeds(authorizedList);
			
		accountDao = new InMemoryAccountDao(null, accountList);
		accountManager.setAccountDao(accountDao);
		
	}

	@Test
	public void testGetAuthorizedsWithNoAuthorizeds() {
		assertNull(accountManager.getAuthorizeds());
	}
	
	@Test
	public void testGetAuthorizeds() throws MalformedHandlerException {
			
		accountDao = new InMemoryAccountDao(authorizedList, accountList);
		accountManager.setAccountDao(accountDao);
		assertEquals(1, accountManager.getAuthorizeds().size());
	}
	
	@Test
	public void testAddAuthorized () throws MalformedHandlerException {
		
		accountDao = new InMemoryAccountDao(authorizedList, accountList);
		accountManager.setAccountDao(accountDao);
		
		person2 = new Person();	
		person2.setDniLetter('d');
		person2.setDniNumber(71463171);
		person2.setName("alicias");
		person2.setAccount(account);
		
		accountManager.addAuthorized(person2, account.getIdAccount());
		assertEquals(2, accountManager.getAuthorizeds().size());		
	}
}
