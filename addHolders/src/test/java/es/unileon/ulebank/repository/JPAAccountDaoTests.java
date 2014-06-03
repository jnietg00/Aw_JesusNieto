package es.unileon.ulebank.repository;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import es.unileon.ulebank.domain.Account;
import es.unileon.ulebank.domain.Person;

public class JPAAccountDaoTests {
	
	private ApplicationContext context;
	private AccountDao accountDao;
	private AuthorizedDao authorizedDao;
	
	@Before
	public void setUp() throws Exception {
		context = new ClassPathXmlApplicationContext("classpath:test-context.xml");
		accountDao = (AccountDao) context.getBean("accountDao");
		authorizedDao = (AuthorizedDao) context.getBean("authorizedDao");

	}

	@Test
	public void testGetAccountList() {
		List<Account> accounts = accountDao.getAccountList();
		assertEquals(accounts.size(), 1, 0);
		System.out.println(accounts.get(0).getIdAccount());
		assertEquals(accounts.get(0).getIdAccount(), 12345);
	}
	
	@Test
	public void testAddAccount() {
		//List<Account> accountList;
	}
	
	@Test
	public void testAddAuthorized() {
		
		Person person1 = new Person();
		Account account = new Account();
		account.setIdAccount(12345);
		person1.setAccount(account);
		person1.setDniNumber(71463171);
		person1.setDniLetter('d');
		person1.setName("ali");
		List<Person> authorizedlist = new ArrayList<Person>() ;
		authorizedlist.add(person1);
		account.setAuthorizeds(authorizedlist);
		
		accountDao.addAccount(account);
		
		List<Person> persons=authorizedDao.getAuthorizedList();
		assertEquals(persons.size(), 2);
		
		
	}
}
