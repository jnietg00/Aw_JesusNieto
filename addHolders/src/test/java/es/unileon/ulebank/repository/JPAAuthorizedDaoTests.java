package es.unileon.ulebank.repository;

import static org.junit.Assert.*;


import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import es.unileon.ulebank.domain.Account;
import es.unileon.ulebank.domain.Person;

public class JPAAuthorizedDaoTests {
	
	private ApplicationContext context;
	private AuthorizedDao authorizedDao;

	@Before
	public void setUp() throws Exception {
		context = new ClassPathXmlApplicationContext("classpath:test-context.xml");
		authorizedDao = (AuthorizedDao) context.getBean("authorizedDao");
	}
	
	@Test
	public void testGetAuthorizedList() {
		List<Person> list = authorizedDao.getAuthorizedList();
		assertEquals(list.size(), 1, 0);
	}
	
	
	public void testAddAuthorized() {
		
		Person person1 = new Person();
		Account account = new Account();
		account.setIdAccount(67890);
		person1.setAccount(account);
		person1.setDniNumber(71463171);
		person1.setDniLetter('d');
		person1.setName("ali");
		person1.setAccount(account);
		
		authorizedDao.addAuthorized(person1);
		List<Person> list = authorizedDao.getAuthorizedList();
		assertEquals(list.size(), 2);	
	}
	
	
}
