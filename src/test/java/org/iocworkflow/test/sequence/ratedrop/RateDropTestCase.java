package org.iocworkflow.test.sequence.ratedrop;

import java.math.BigDecimal;
import junit.framework.Test;
import junit.framework.TestSuite;
import org.iocworkflow.Activity;
import org.iocworkflow.BaseProcessor;
import org.iocworkflow.ProcessContext;
import org.iocworkflow.test.AbstractTestCase;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * Class:SimpleSequenceTest Creation Date: Mar 8, 2005 CVS ID $Id:$
 *
 * Class Descriptoin goes here
 *
 * @author sdodge
 * @since $Date:$
 */
public class RateDropTestCase extends AbstractTestCase {

  private ApplicationContext context;

  public RateDropTestCase(String testName) {
    super(testName);
  }

  /**
   * @return the suite of tests being tested
   */
  public static Test suite() {
    return new TestSuite(RateDropTestCase.class);
  }

  protected void setUp() throws Exception {
    String location = "src/test/resources/reatedrop/rateDrop.xml";
    context = new ClassPathXmlApplicationContext(location);

  }

  public void testDOMBuildActivity() throws Exception {

    Activity domActivity = (Activity) context.getBean("activity2");
    assertNotNull(domActivity);

    AirlineRouteSeedData seed = createSeedData();

    ProcessContext processContext = new RateDropContext();
    processContext.setSeedData(seed);

    RateDropContext ctx = (RateDropContext) domActivity.execute(processContext);

    assertFalse(ctx.stopProcess());

    assertNotNull(ctx.getDomSource());
  }

  public void testWorkflowSequence() throws Exception {
    BaseProcessor processor = (BaseProcessor) context.getBean("rateDropProcessor");
    assertNotNull(processor);

    assertTrue("No activities have been wired up to the processor " + processor.getBeanName(), !processor.getActivities().isEmpty());

    //kick off a single iteration of the processor
    processor.doActivities(createSeedData());
  }

  /**
   * @return
   */
  private AirlineRouteSeedData createSeedData() {
    AirlineRouteSeedData seed = new AirlineRouteSeedData();
    seed.setAirlineId(12);
    seed.setAirlineName("X-Jet");
    seed.setRateDrop(new BigDecimal("30.28"));
    seed.setRouteId(117);
    seed.setRouteOrigin("BWI");
    seed.setRouteDestination("LGA");
    return seed;
  }

  protected void tearDown() throws Exception {
    ((ClassPathXmlApplicationContext) context).close();
  }
}
