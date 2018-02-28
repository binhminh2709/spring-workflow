
package org.iocworkflow.test.sequence.ratedrop;

import java.math.BigDecimal;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.iocworkflow.BaseActivity;
import org.iocworkflow.ProcessContext;

/**
 * Class:PollRates Creation Date: Mar 12, 2005 CVS ID $Id:$
 * 
 * Simulate the polling to activley check for stimuli to the workflow process
 * 
 * @author sdodge
 * @since $Date:$
 */
public class PollRates extends BaseActivity {

    private Log log = LogFactory.getLog(PollRates.class);

    //Not thread safe, but for this example, it won't hurt.
    private Long startTime;

    private static final long maxTime = 5000;

    /*
     * (non-Javadoc)
     * 
     * @see org.iocworkflow.Activity#execute(org.iocworkflow.ProcessContext)
     */
    public ProcessContext execute(ProcessContext context) throws Exception {

        log.debug("--- Polling for changes in rates ---");
        if (startTime == null)
            startTime = new Long(System.currentTimeMillis());
        long now = System.currentTimeMillis();
        if ((now - startTime.longValue()) > maxTime) {
            log.debug("  !! Rate increase Found, kick off workflow processor !!");
            startTime = null;
            ((RateDropContext) context).setSeedData(createSeedData());

        } else {
            log.debug("   no rate drop found :( ");
            ((RateDropContext) context).setStopEntireProcess(true);
        }

        return context;
    }
    
    private AirlineRouteSeedData createSeedData() {
        AirlineRouteSeedData seed = new AirlineRouteSeedData();
        seed.setAirlineId(new Integer(14));
        seed.setAirlineName("Poll-Jet");
        seed.setRateDrop(new BigDecimal("93.65"));
        seed.setRouteId(new Integer(147));
        seed.setRouteOrigin("DFW");
        seed.setRouteDestination("LAX");
        return seed;
    }    

}