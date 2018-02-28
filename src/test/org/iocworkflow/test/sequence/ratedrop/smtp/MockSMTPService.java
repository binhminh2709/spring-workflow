
package org.iocworkflow.test.sequence.ratedrop.smtp;

import java.util.Iterator;
import java.util.Set;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;



/**
 * Class:MockSMTPService
 * Creation Date: Mar 13, 2005
 * CVS ID $Id:$
 * 
 * Mock implemenation of an SMTP service for testing purposes
 * 
 *  @author sdodge
 *  @since $Date:$
 */
public class MockSMTPService implements SMTPService {

    Log log = LogFactory.getLog(MockSMTPService.class);
    /* (non-Javadoc)
     * @see org.iocworkflow.test.sequence.ratedrop.smtp.SMTPService#sendMessage(java.lang.String, java.lang.String, java.lang.String, java.util.Set)
     */
    public void sendMessage(String message, String fromAddress, String subject, Set recipients)
            throws SMTPServerException {
        log.info("====== Mock SMTP Service, printing message now =====");
        log.info("    TO:");
        for (Iterator iter = recipients.iterator(); iter.hasNext();) {
            String address = (String) iter.next();
            log.info("      "+address);
        }
        log.info("    FROM: "+fromAddress);
        log.info("    SUBJECT: "+subject);
        log.info("    MESSAGE:");
        log.info(message);
        log.info("====== Mock SMTP Service, DONE =====");

    }

}
