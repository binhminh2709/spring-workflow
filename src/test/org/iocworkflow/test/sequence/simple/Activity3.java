
package org.iocworkflow.test.sequence.simple;

import java.util.Iterator;

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
public class Activity3 extends BaseActivity {

    private Log log = LogFactory.getLog(Activity3.class);

    /*
     * (non-Javadoc)
     * 
     * @see org.iocworkflow.Activity#execute(org.iocworkflow.ProcessContext)
     */
    public ProcessContext execute(ProcessContext context) throws Exception {
        log.info("EXECUTE Activity3");

        SimpleContext simpleContext = (SimpleContext) context;
        int i = 0;
        
        log.info("++++++ ACTIVITY3 Printing cumulative data for the workflow process ++++++++ ");
        for ( Iterator iter = simpleContext.getWorkflowData().iterator(); iter.hasNext(); i++) {
            String data = (String) iter.next();
            log.info(" +data["+i+"]"+data);
        }
        log.info("++++++ ACTIVITY3 Finished ++++++++ ");
        return simpleContext;
    }

}