
package org.iocworkflow;

import org.springframework.beans.factory.BeanNameAware;


/**
 * @author sdodge
 * 
 * Class:Activity
 * Creation Date: Feb 28, 2005
 * CVS ID $Id:$
 * 
 * Encapsulates the business logic of a single step in the 
 * workflow process
 * 
 */
public interface Activity extends BeanNameAware {

    /**
     * Called by the encompassing processor to activate
     * the execution of the Activity
     * 
     * @param context - process context for this workflow
     * @return resulting process context
     * @throws Exception
     */
    public ProcessContext execute(ProcessContext context) throws Exception;
    
    
    /**
     * Get the fine-grained error handler wired up for this Activity
     * @return
     */
    public ErrorHandler getErrorHandler();
    
    public String getBeanName();
    
}
