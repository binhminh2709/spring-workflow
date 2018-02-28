
package org.iocworkflow.test.sequence.simple;

import junit.framework.Test;
import junit.framework.TestSuite;

import org.iocworkflow.BaseProcessor;
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
public class SimpleSequenceTestCase extends AbstractTestCase {

    private ApplicationContext context;
    
    public SimpleSequenceTestCase(String testName)
    {
        super(testName);
    }
    
    protected void setUp() throws Exception {
        String location = "org/iocworkflow/test/sequence/simple/sequenceSimple.xml";
        context = new ClassPathXmlApplicationContext(location);
        
    }
    
    public void testSimpleSequence() throws Exception
    {
        BaseProcessor processor = (BaseProcessor)context.getBean("simpleProcessor");
        assertNotNull(processor);
        
        assertTrue("No activities have been wired up to the processor "+processor.getBeanName(), !processor.getActivities().isEmpty());
        
        //kick off a single iteration of the processor
        processor.doActivities();
    }
    
    protected void tearDown() throws Exception {
       ((ClassPathXmlApplicationContext)context).close();
    }
    
    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( SimpleSequenceTestCase.class );
    }
}
