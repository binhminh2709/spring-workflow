
package org.iocworkflow.test.sequence.simple;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.iocworkflow.BaseActivity;
import org.iocworkflow.ProcessContext;

/**
 * Class:Activity1 Creation Date: Mar 7, 2005 CVS ID $Id:$
 * 
 * Class Descriptoin goes here
 * 
 * @author sdodge
 * @since $Date:$
 */
public class Activity2 extends BaseActivity {

    private Log log = LogFactory.getLog(Activity2.class);

    /*
     * (non-Javadoc)
     * 
     * @see org.iocworkflow.Activity#execute(org.iocworkflow.ProcessContext)
     */
    public ProcessContext execute(ProcessContext context) throws Exception {
        log.info("EXECUTE Activity2");

        SimpleContext simpleContext = (SimpleContext) context;
        simpleContext.getWorkflowData().add("Data from Activity2");
        return simpleContext;
    }

}