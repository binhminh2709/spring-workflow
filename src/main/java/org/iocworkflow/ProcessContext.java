package org.iocworkflow;

import java.io.Serializable;


/**
 * Class:ProcessContext Creation Date: Mar 7, 2005 CVS ID $Id:$
 *
 * Class Descriptoin goes here
 *
 * @author sdodge
 * @since $Date:$
 */
public interface ProcessContext extends Serializable {


  /**
   * Activly informs the workflow process to stop processing no further activities will be exeecuted
   */
  public boolean stopProcess();

  /**
   * Provide seed information to this ProcessContext, usually provided at time of workflow kickoff by the containing workflow processor.
   *
   * @param seedObject - initial seed data for the workflow
   */
  public void setSeedData(Object seedObject);

}
