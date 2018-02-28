
package org.iocworkflow.test.sequence.ratedrop;

import junit.framework.Test;
import junit.framework.TestSuite;

import org.iocworkflow.test.AbstractTestCase;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * Class:SimpleSequenceTest
 * Creation Date: Mar 8, 2005
 * CVS ID $Id:$
 * 
 * Class Descriptoin goes here
 * 
 *  @author sdodge
 *  @since $Date:$
 */
public class PollingTestCase extends AbstractTestCase {

    private ApplicationContext context;
    
    public PollingTestCase(String testName)
    {
        super(testName);
    }
    
    protected void setUp() throws Exception {
        String[] locations = {"org/iocworkflow/test/sequence/ratedrop/rateDrop.xml",
                "org/iocworkflow/test/sequence/ratedrop/pollingRateDrop.xml"};
        context = new ClassPathXmlApplicationContext(locations);
        
    }
    
  
    
    public void testWorkflowSequence() throws Exception
    {

        //basically we wait and watch the logs while the poller does it stuff
        Thread.sleep(10000);

    }
    


    protected void tearDown() throws Exception {
        ((ClassPathXmlApplicationContext)context).close();
    }
    
    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( PollingTestCase.class );
    }
}
