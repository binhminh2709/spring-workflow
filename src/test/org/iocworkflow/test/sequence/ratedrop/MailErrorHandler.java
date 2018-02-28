
package org.iocworkflow.test.sequence.ratedrop;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.iocworkflow.ErrorHandler;
import org.iocworkflow.ProcessContext;
import org.iocworkflow.test.sequence.ratedrop.smtp.SMTPServerException;

/**
 * Class:MailErrorHandler Creation Date: Mar 13, 2005 CVS ID $Id:$
 * 
 * Class Descriptoin goes here
 * 
 * @author sdodge
 * @since $Date:$
 */
public class MailErrorHandler implements ErrorHandler {

    private String beanName;
    private SenderDelegate delegate;

    private Log log = LogFactory.getLog(MailErrorHandler.class);

    /*
     * (non-Javadoc)
     * 
     * @see org.iocworkflow.ErrorHandler#handleError(org.iocworkflow.ProcessContext, java.lang.Throwable)
     */
    public void handleError(ProcessContext context, Throwable th) {

        if (th instanceof SMTPServerException) {
            log.error("Found an error while trying to send for the first time", th);
            try {
                delegate.send((RateDropContext) context);
            } catch (SMTPServerException e) {
                log.error("Failed durinn second try at sending, let's stop now");
                ((RateDropContext) context).setStopEntireProcess(true);
            }
        }
        else{
            log.error("Unknown error occured, forcing a stop", th);
            ((RateDropContext) context).setStopEntireProcess(true);
        }

    }

    /*
     * (non-Javadoc)
     * 
     * @see org.springframework.beans.factory.BeanNameAware#setBeanName(java.lang.String)
     */
    public void setBeanName(String beanName) {
        this.beanName = beanName;

    }

    public void setDelegate(SenderDelegate delegate) {
        this.delegate = delegate;
    }
}