package es.unileon.ulebank.domain;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class AccountTests {
	
	private Account account;
	
	@Before
	public void setUp() throws Exception {
		account = new Account();
	}

	@Test
	public void testSetAndGetDescription() throws MalformedHandlerException {
		//int dniNumber = 71519821;
		//char dniLetter = 'x';
		//Person person = new Person(dniNumber, dniLetter);
		//assertNull(account.getAuthorizeds());
		account.setAuthorizeds(new ArrayList<Client>());
		assertEquals(account.getAuthorizeds().size(), 0);		
	}

}
