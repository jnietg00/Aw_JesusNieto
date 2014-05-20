package es.unileon.ulebank.web;

import java.util.Map;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import es.unileon.ulebank.web.AuthorizedsController;
import es.unileon.ulebank.domain.Account;
import es.unileon.ulebank.service.SimpleAccountManager;


public class AuthorizedsControllerTests {

    @Test
    public void testHandleRequestView() throws Exception{		
    	
        AuthorizedsController controller = new AuthorizedsController();
        
        Account account = new Account();
        
        SimpleAccountManager accountManager = new SimpleAccountManager();
        
        //List<Client> clients = new ArrayList<Client>();
        //account.setAuthorizeds(authorizeds);
        controller.setAccountManager(accountManager);
        //ModelAndView modelAndView = controller.handleRequest(null, null);		
        //assertEquals("hello", modelAndView.getViewName());
        //assertNotNull(modelAndView.getModel());
       // Map<String, Object> modelMap = (Map<String, Object>) modelAndView.getModel().get("model");
        //String nowValue = (String) modelMap.get("now");
        //assertNotNull(nowValue);

    }

}