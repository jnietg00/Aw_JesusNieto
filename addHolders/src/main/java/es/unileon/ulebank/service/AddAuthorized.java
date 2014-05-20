package es.unileon.ulebank.service;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class AddAuthorized {
	
    /** Logger for this class and subclasses */
    protected final Log logger = LogFactory.getLog(getClass());
    
    private int dniNumber;
    private char dniLetter;
    private String name;
    
    public void setDniNumber (int i) {
    	dniNumber = i;
    	logger.info("dniNumber set to " + i);
    }
    
    public int getDniNumber () {
    	return dniNumber;
    }
    
    public void setDniLetter (char i) {
    	dniLetter = i;
    	logger.info("dniLetter set to" + i);
    }
    
    public char getDniLetter () {
    	return dniLetter;
    }
    
    public void setName (String nam) {
    	name = nam;
    	logger.info("name set to" + nam);
    }
    
    public String getName() {
    	return name;
    }

}
