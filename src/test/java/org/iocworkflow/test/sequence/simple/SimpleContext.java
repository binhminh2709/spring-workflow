package org.iocworkflow.test.sequence.simple;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.iocworkflow.ProcessContext;


/**
 * Class:SimpleProcessContext Creation Date: Mar 8, 2005 CVS ID $Id:$
 *
 * Class Descriptoin goes here
 *
 * @author sdodge
 * @since $Date:$
 */
public class SimpleContext implements ProcessContext {

  private boolean stopProcess;
  private Log log = LogFactory.getLog(SimpleContext.class);
  private List workflowData;

  public SimpleContext() {
    log.info("Instantiating SimpleContext");
    workflowData = new ArrayList();
  }


  public void setSeedData(Object seedObject) {
    //no seed data is necessary for this simple case
  }

  public void setStopProcess(boolean stopProcess) {
    this.stopProcess = stopProcess;
  }

  /* (non-Javadoc)
   * @see org.iocworkflow.ProcessContext#stopProcess()
   */
  public boolean stopProcess() {

    return stopProcess;
  }

  public Collection getWorkflowData() {
    return workflowData;
  }
}
