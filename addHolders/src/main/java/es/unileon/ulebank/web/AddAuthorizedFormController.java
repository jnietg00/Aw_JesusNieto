package es.unileon.ulebank.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import es.unileon.ulebank.domain.MalformedHandlerException;
import es.unileon.ulebank.domain.Person;
import es.unileon.ulebank.service.AddAuthorized;
import es.unileon.ulebank.service.AccountManager;

@Controller
@RequestMapping(value = " /addAuthorized.htm")

public class AddAuthorizedFormController {
	
    /** Logger for this class and subclasses */
    protected final Log logger = LogFactory.getLog(getClass());
    
    @Autowired
    private AccountManager accountManager;
    
    @RequestMapping(method = RequestMethod.POST)
    public String onSubmit(@Valid AddAuthorized addAuthorized, BindingResult result) throws MalformedHandlerException {
    	if (result.hasErrors()) {
    		return "addauthorized";
    	}
    	
    	int dniNumber = addAuthorized.getDniNumber();
    	logger.info("dniNumber by" + dniNumber);
    	
    	char dniLetter = addAuthorized.getDniLetter();
    	logger.info("dniLetter by" + dniLetter);
    	
    	String name = addAuthorized.getName();
    	logger.info("name by" + name);
    	
    	Person person = new Person(dniNumber, dniLetter, name);
    	
    	accountManager.addAuthorized(person);


    	return "redirect:/hello.htm";
    }
    
    @RequestMapping (method = RequestMethod.GET) 
    protected AddAuthorized formBackingObject (HttpServletRequest request) throws ServletException {
    	AddAuthorized addAuthorized = new AddAuthorized();
    	addAuthorized.setDniNumber(71463171);
    	char d = 'd';
    	addAuthorized.setDniLetter(d);
    	addAuthorized.setName("alicia");
    	return addAuthorized;   	
    }

    public void setAccountManager(AccountManager accountManager) {
    	this.accountManager = accountManager;
    }
    
    public AccountManager getAccountManager() {
    	return accountManager;
    }

}
