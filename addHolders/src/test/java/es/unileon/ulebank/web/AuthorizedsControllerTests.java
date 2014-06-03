package es.unileon.ulebank.web;

import java.util.ArrayList;
import java.util.Map;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import es.unileon.ulebank.domain.Account;
import es.unileon.ulebank.repository.InMemoryAccountDao;
import es.unileon.ulebank.service.SimpleAccountManager;


public class AuthorizedsControllerTests {

    @Test
    public void testHandleRequestView() throws Exception{		
        AccountController controller = new AccountController();
        SimpleAccountManager sam = new SimpleAccountManager();
        sam.setAccountDao(new InMemoryAccountDao(null, new ArrayList<Account>()));
        controller.setAccountManager(sam);
        //controller.setProductManager(new SimpleProductManager());
        ModelAndView modelAndView = controller.handleRequest(null, null);		
        assertEquals("hello", modelAndView.getViewName());
        assertNotNull(modelAndView.getModel());
        @SuppressWarnings("unchecked")
        Map<String, Object> modelMap = (Map<String, Object>) modelAndView.getModel().get("model");
        String nowValue = (String) modelMap.get("now");
        assertNotNull(nowValue);
    }
}