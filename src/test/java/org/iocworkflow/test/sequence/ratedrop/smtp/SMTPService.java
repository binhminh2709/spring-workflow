package org.iocworkflow.test.sequence.ratedrop.smtp;

import java.util.Set;


/**
 * Class:SMTPService Creation Date: Mar 13, 2005 CVS ID $Id:$
 *
 * Describes the interface for sending mail to an SMTP server
 *
 * @author sdodge
 * @since $Date:$
 */
public interface SMTPService {

  public void sendMessage(String message, String fromAddress, String subject, Set recipients) throws SMTPServerException;
}
