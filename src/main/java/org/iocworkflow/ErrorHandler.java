
package org.iocworkflow;

import org.springframework.beans.factory.BeanNameAware;


/**
 * @author sdodge
 * 
 * Class:ErrorHandler
 * Creation Date: Feb 28, 2005
 * CVS ID $Id:$
 * 
 * Class Descriptoin goes here
 * 
 */
public interface ErrorHandler extends BeanNameAware {
    
    public void handleError(ProcessContext context, Throwable th);

}
