package es.unileon.ulebank.service;

import java.util.List;
import java.util.ArrayList;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import es.unileon.ulebank.domain.Account;
import es.unileon.ulebank.domain.Client;
import es.unileon.ulebank.domain.Handler;
import es.unileon.ulebank.domain.MalformedHandlerException;
import es.unileon.ulebank.domain.Person;
import es.unileon.ulebank.domain.PersonHandler;

public class SimpleAccountManagerTests {
	
	private Account account;
	
	private SimpleAccountManager accountManager;
	private SimpleAccountManager accountManager2;
	
	private List<Client> authorizeds;
	
	private static int ACCOUNT_COUNT = 2;
	
	private Person person1;
	
	private int dniNumber1 = 71519821;
	private char dniLetter1 = 'x';
	private String name1 = "jesus";
	
	private int dniNumber2 = 71463171;
	private char dniLetter2 = 'd';
	private String name2 = "alicia"; 
	
	PersonHandler id1;
	PersonHandler id2;
	
	@Before
	public void setUp() throws Exception {
		
		
		account = new Account();
		accountManager = new SimpleAccountManager();

		person1 = new Person(dniNumber1, dniLetter1, name1);		
		
		authorizeds = new ArrayList<Client>();
		
		authorizeds.add(person1);
	
		accountManager.setAccount(account);
		account.setAuthorizeds(authorizeds);
	}

	@Test
	public void testGetAuthorizedsWithNoAuthorizeds() {
		accountManager = new SimpleAccountManager();
		authorizeds = new ArrayList<Client>();
		accountManager.setAccount(account);
		account.setAuthorizeds(authorizeds);
		assertEquals(accountManager.getAuthorizeds().size(), 0);
	}
	
	@Test
	public void testGetAuthorizeds() throws MalformedHandlerException {
		Person person2 = new Person(dniNumber2, dniLetter2, name2);	
		authorizeds.add(person2);
		List<Client> authorizeds = accountManager.getAuthorizeds();
		assertNotNull(authorizeds);
		assertEquals(ACCOUNT_COUNT, accountManager.getAuthorizeds().size());
		
		Client client = authorizeds.get(0);
		id1 = new PersonHandler(dniNumber1, dniLetter1);
		assertEquals(id1.compareTo(client.getId()), 0);
		
		client = authorizeds.get(1);
		id2 = new PersonHandler(dniNumber2, dniLetter2);
		assertEquals(id2.compareTo(client.getId()), 0);
	}
	
	@Test
	public void testAddAuthorized () throws MalformedHandlerException {
		Person person2 = new Person(dniNumber2, dniLetter2, name2);	
		assertNotNull(accountManager.getAuthorizeds());
		assertEquals(accountManager.getAuthorizeds().size(), 1);
		accountManager.addAuthorized(person2);
		assertEquals(accountManager.getAuthorizeds().size(), 2);
		Client client = accountManager.getAuthorizeds().get(0);
		id1 = new PersonHandler(dniNumber1, dniLetter1);
		assertEquals(id1.compareTo(client.getId()), 0);
	}
	
	@Test (expected = AssertionError.class) 
	public void testAddAuthorizedWithNullListOfAuthorizeds() {
		try {
			accountManager = new SimpleAccountManager();
			accountManager.addAuthorized(person1);
		} catch (NullPointerException ex) {
			fail("Account list null");
		}
	}
	

}
