
package org.iocworkflow.test.sequence.simple;

import org.iocworkflow.ErrorHandler;
import org.iocworkflow.ProcessContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


/**
 * Class:SimpleErrorHandler
 * Creation Date: Mar 8, 2005
 * CVS ID $Id:$
 * 
 * Class Descriptoin goes here
 * 
 *  @author sdodge
 *  @since $Date:$
 */
public class SimpleErrorHandler implements ErrorHandler {

    private Log log = LogFactory.getLog(SimpleErrorHandler.class);
    private String beanName;
    
    /* (non-Javadoc)
     * @see org.iocworkflow.ErrorHandler#handleError(org.iocworkflow.ProcessContext, java.lang.Throwable)
     */
    public void handleError(ProcessContext context, Throwable th) {
        log.error("Handling Error: ", th);

    }

    /* (non-Javadoc)
     * @see org.springframework.beans.factory.BeanNameAware#setBeanName(java.lang.String)
     */
    public void setBeanName(String beanName) {
        this.beanName = beanName;

    }

}
