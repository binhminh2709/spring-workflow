
package org.iocworkflow.test.sequence.ratedrop;

import java.util.HashSet;
import java.util.Set;

import org.iocworkflow.BaseActivity;
import org.iocworkflow.ProcessContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


/**
 * Class:BuildRecipientsActivity
 * Creation Date: Mar 12, 2005
 * CVS ID $Id:$
 * 
 * Should be the first Activity executed during processing of the
 * Airline Rate Drop workflow.  Seed data for the the rate drop should be
 * present.
 * 
 *  @author sdodge
 *  @since $Date:$
 */
public class BuildRecipients extends BaseActivity {
    
   private Log log = LogFactory.getLog(BuildRecipients.class);

    /* (non-Javadoc)
     * @see org.iocworkflow.Activity#execute(org.iocworkflow.ProcessContext)
     */
    public ProcessContext execute(ProcessContext context) throws Exception {
        
        AirlineRouteSeedData seedData = ((RateDropContext)context).getSeedData();
        log.debug("++++ STARTING - Rate Drop Workflow seed data:");
        log.debug("    Airline: "+seedData.getAirlineName()+" AirlineId:"+seedData.getAirlineId());
        log.debug("    Route Origin:  "+seedData.getRouteOrigin());
        log.debug("    Route Destination:   "+seedData.getRouteDestination());
        log.debug("    RouteId: "+seedData.getRouteId());
        log.debug("    Rate Drop: $"+seedData.getRateDrop());
        
        //Query a Databae searching for interested recipients.  To be a recipient, 
        //the user must have subscribed to the route in question and the rate
        //drop must be equal to or greater than that specified by the user.
        
        //pretend to query here, note at the time of this writing airlineconsumer.com was
        //still available.
        Set recipients = new HashSet();
        recipients.add("mary@airlineconsumer.com");
        recipients.add("dingo@airlineconsumer.com");
        recipients.add("blair@airlineconsumer.com");
        
        log.debug("Found "+recipients.size()+" inerested recipients");
        
        //Don't froget to stop the workflow if no recipients are found!
        if(recipients.isEmpty())
            ((RateDropContext)context).setStopEntireProcess(true);
        else
            ((RateDropContext)context).setRecipients(recipients);
        
        return context;
    }

}
