package org.iocworkflow;


/**
 * Abstract implemention of activity designed for re-use by business purpose specific Activities
 *
 * Class:BaseActivity Creation Date: Mar 4, 2005 CVS ID $Id:$
 *
 * @author sdodge
 * @since $Date:$
 */
public abstract class BaseActivity implements Activity {

  private ErrorHandler errorHandler;
  private String beanName;


  public ErrorHandler getErrorHandler() {

    return errorHandler;
  }

  /**
   * Set the fine grained error handler
   */
  public void setErrorHandler(ErrorHandler errorHandler) {
    this.errorHandler = errorHandler;
  }

  public String getBeanName() {
    return beanName;
  }

  public void setBeanName(String beanName) {
    this.beanName = beanName;

  }
}
