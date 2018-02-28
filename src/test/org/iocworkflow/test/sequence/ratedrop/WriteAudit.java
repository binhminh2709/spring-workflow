
package org.iocworkflow.test.sequence.ratedrop;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.iocworkflow.BaseActivity;
import org.iocworkflow.ProcessContext;


/**
 * Class:WriteAudit
 * Creation Date: Mar 12, 2005
 * CVS ID $Id:$
 * 
 * Write some audit data to ensure we log all the intended recipients and
 * the corresponding message
 * 
 *  @author sdodge
 *  @since $Date:$
 */
public class WriteAudit extends BaseActivity {
    
   private Log log = LogFactory.getLog(WriteAudit.class);

    /* (non-Javadoc)
     * @see org.iocworkflow.Activity#execute(org.iocworkflow.ProcessContext)
     */
    public ProcessContext execute(ProcessContext context) throws Exception {
        


        log.debug("Writing Audit infomation to DB");
        
        return context;
    }

}
