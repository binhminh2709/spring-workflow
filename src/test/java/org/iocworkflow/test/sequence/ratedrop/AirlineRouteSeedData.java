package org.iocworkflow.test.sequence.ratedrop;

import java.io.Serializable;
import java.math.BigDecimal;


/**
 * Class:AirlineRouteSeedData Creation Date: Mar 12, 2005 CVS ID $Id:$
 *
 * Class Descriptoin goes here
 *
 * @author sdodge
 * @since $Date:$
 */
public class AirlineRouteSeedData implements Serializable {

  private Integer airlineId;
  private String airlineName;
  private Integer routeId;
  private String routeOrigin;
  private String routeDestination;
  private BigDecimal rateDrop;

  public Integer getAirlineId() {
    return airlineId;
  }

  public void setAirlineId(Integer airlineId) {
    this.airlineId = airlineId;
  }

  public String getAirlineName() {
    return airlineName;
  }

  public void setAirlineName(String airlineName) {
    this.airlineName = airlineName;
  }

  public String getRouteDestination() {
    return routeDestination;
  }

  public void setRouteDestination(String routeDestination) {
    this.routeDestination = routeDestination;
  }

  public Integer getRouteId() {
    return routeId;
  }

  public void setRouteId(Integer routeId) {
    this.routeId = routeId;
  }

  public String getRouteOrigin() {
    return routeOrigin;
  }

  public void setRouteOrigin(String routeOrigin) {
    this.routeOrigin = routeOrigin;
  }

  public BigDecimal getRateDrop() {
    return rateDrop;
  }

  public void setRateDrop(BigDecimal rateDrop) {
    this.rateDrop = rateDrop;
  }
}
