package org.iocworkflow;

import java.util.List;

/**
 * Class:Processor Creation Date: Mar 11, 2005 CVS ID $Id:$
 *
 * Class Descriptoin goes here
 *
 * @author sdodge
 * @since $Date:$
 */
public interface Processor {

  /**
   * To be implemented by subclasses, ensures each Activity configured in this process is supported.  This method is called by the Processor for each Activity configured.  An implementing subclass
   * should ensure the Activity type passed in is supported.  Implementors could possibly support multiple types of activities.
   *
   * @param Activyt - activity instance of the configured activity
   * @return true if the activity is supported
   */
  public boolean supports(Activity activity);

  /**
   * Abstract method used to kickoff the processing of work flow activities. Each processor implementation should implement doActivities as a means of carrying out the activities wired to the workflow
   * process.
   */
  public void doActivities();

  /**
   * Abstract method used to kickoff the processing of work flow activities. Each processor implementation should implement doActivities as a means of carrying out the activities wired to the workflow
   * process.  This version of doActivities is designed to be called from some external entity, e.g. listening a JMS queue.  That external entitiy would proved the seed data.
   *
   * @param seedData - data necessary for the workflow process to start execution
   */
  public void doActivities(Object seedData);

  /**
   * Sets the collection of Activities to be executed by the Workflow Process
   *
   * @param activities ordered collection (List) of activities to be executed by the processor
   */
  public void setActivities(List activities);

  public void setDefaultErrorHandler(ErrorHandler defaultErrorHandler);
}