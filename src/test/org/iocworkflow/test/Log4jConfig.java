
package org.iocworkflow.test;

import org.springframework.beans.factory.BeanInitializationException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.util.Log4jConfigurer;


/**
 * Class:Log4jConfig
 * Creation Date: Mar 12, 2005
 * CVS ID $Id:$
 * 
 * Class Descriptoin goes here
 * 
 *  @author sdodge
 *  @since $Date:$
 */
public class Log4jConfig extends Log4jConfigurer implements InitializingBean {
    
    private String configXml;

    /* (non-Javadoc)
     * @see org.springframework.beans.factory.InitializingBean#afterPropertiesSet()
     */
    public void afterPropertiesSet() throws Exception {

        if(configXml == null || !configXml.endsWith(XML_FILE_EXTENSION))
            throw new BeanInitializationException("Cannont configure log4j, the configXml file: "+configXml+" " +
            		"is not a valid location, example: org/iocworkflow/test/log4j.xml");
        
        initLogging(CLASSPATH_URL_PREFIX+configXml);

        
    }

    public void setConfigXml(String configXml) {
        this.configXml = configXml;
    }
}
