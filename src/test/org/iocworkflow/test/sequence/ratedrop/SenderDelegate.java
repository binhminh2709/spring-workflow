
package org.iocworkflow.test.sequence.ratedrop;

import org.iocworkflow.test.sequence.ratedrop.smtp.SMTPServerException;


/**
 * Class:SenderDelegate
 * Creation Date: Mar 13, 2005
 * CVS ID $Id:$
 * 
 * Delegate the sending here for easy re-use.
 * 
 *  @author sdodge
 *  @since $Date:$
 */
public interface SenderDelegate {
    
    public void send(RateDropContext context)throws SMTPServerException;

}
