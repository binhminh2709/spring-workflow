package org.iocworkflow.test.sequence.ratedrop;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.iocworkflow.test.sequence.ratedrop.smtp.SMTPServerException;
import org.iocworkflow.test.sequence.ratedrop.smtp.SMTPService;


/**
 * Class:SenderDelegateImpl Creation Date: Mar 13, 2005 CVS ID $Id:$
 *
 * Class Descriptoin goes here
 *
 * @author sdodge
 * @since $Date:$
 */
public class SenderDelegateImpl implements SenderDelegate {

  private SMTPService smtpService;
  private String fromAddress;
  private String subject;
  private Log log = LogFactory.getLog(SenderDelegateImpl.class);

  public void setFromAddress(String fromAddress) {
    this.fromAddress = fromAddress;
  }

  public void setSubject(String subject) {
    this.subject = subject;
  }

  /* (non-Javadoc)
   * @see org.iocworkflow.test.sequence.ratedrop.SenderDelegate#send(org.iocworkflow.test.sequence.ratedrop.RateDropContext)
   */
  public void send(RateDropContext context) throws SMTPServerException {
    log.debug("About to send message to recipients");
    smtpService.sendMessage(context.getTransformedContent(), fromAddress, subject, context.getRecipients());

  }

  public void setSmtpService(SMTPService smtpService) {
    this.smtpService = smtpService;
  }
}
