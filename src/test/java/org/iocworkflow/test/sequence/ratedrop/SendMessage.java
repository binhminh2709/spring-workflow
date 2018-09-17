package org.iocworkflow.test.sequence.ratedrop;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.iocworkflow.BaseActivity;
import org.iocworkflow.ProcessContext;

/**
 * Class:SendMessage Creation Date: Mar 12, 2005 CVS ID $Id:$
 *
 * Using the SMTP Service, send the message
 *
 * @author sdodge
 * @since $Date:$
 */
public class SendMessage extends BaseActivity {

  private Log log = LogFactory.getLog(SendMessage.class);
  private SenderDelegate delegate;


  /*
   * (non-Javadoc)
   *
   * @see org.iocworkflow.Activity#execute(org.iocworkflow.ProcessContext)
   */
  public ProcessContext execute(ProcessContext context) throws Exception {

    RateDropContext ctx = (RateDropContext) context;

    delegate.send(ctx);

    //Message must have sent properly if we get here
    log.debug("Message sent successfully, writing success to audit data");

    return context;
  }


  public void setDelegate(SenderDelegate delegate) {
    this.delegate = delegate;
  }
}