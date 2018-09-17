package org.iocworkflow.test.sequence.ratedrop;

import java.util.Set;
import javax.xml.transform.dom.DOMSource;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.iocworkflow.ProcessContext;
import org.iocworkflow.support.XsltAware;

/**
 * Class:RateDropContext Creation Date: Mar 12, 2005 CVS ID $Id:$
 *
 * Process context used for the Airline Rate Drop example, Javaworld Article 2005
 *
 * @author sdodge
 * @since $Date:$
 */
public class RateDropContext implements ProcessContext, XsltAware {

  private boolean stopEntireProcess;
  private AirlineRouteSeedData seedData;
  private Set recipients;
  private DOMSource messageDom;
  private String messageContent;


  private Log log = LogFactory.getLog(RateDropContext.class);

  /* (non-Javadoc)
   * @see org.iocworkflow.ProcessContext#stopProcess()
   */
  public boolean stopProcess() {
    return stopEntireProcess;
  }

  public void setStopEntireProcess(boolean stopEntireProcess) {
    this.stopEntireProcess = stopEntireProcess;
  }

  /* (non-Javadoc)
   * @see org.iocworkflow.support.XsltAware#getDomSource()
   */
  public DOMSource getDomSource() {

    return messageDom;
  }

  /* (non-Javadoc)
   * @see org.iocworkflow.support.XsltAware#getTransformedContent()
   */
  public String getTransformedContent() {

    return messageContent;
  }

  /* (non-Javadoc)
   * @see org.iocworkflow.support.XsltAware#setTransformedContent(java.lang.String)
   */
  public void setTransformedContent(String transformedContent) {
    messageContent = transformedContent;

  }

  public Set getRecipients() {
    return recipients;
  }

  public void setRecipients(Set recipients) {
    this.recipients = recipients;
  }

  public AirlineRouteSeedData getSeedData() {
    return seedData;
  }

  /* (non-Javadoc)
   * @see org.iocworkflow.ProcessContext#setSeedData(java.lang.Object)
   */
  public void setSeedData(Object seedObject) {
    if (!(seedObject instanceof AirlineRouteSeedData)) {
      log.error("STOPPING Workflow Process, seed data instance is incorrect. " +
          "Required class is " + AirlineRouteSeedData.class.getName() + " " +
          "bug found class: " + seedObject.getClass().getName());
      setStopEntireProcess(true);
    }
    seedData = (AirlineRouteSeedData) seedObject;

  }

  public void setMessageDom(DOMSource messageDom) {
    this.messageDom = messageDom;
  }

}
