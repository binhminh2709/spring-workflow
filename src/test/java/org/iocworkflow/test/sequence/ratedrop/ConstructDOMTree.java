package org.iocworkflow.test.sequence.ratedrop;


import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.dom.DOMSource;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.xml.serialize.OutputFormat;
import org.apache.xml.serialize.XMLSerializer;
import org.iocworkflow.BaseActivity;
import org.iocworkflow.ProcessContext;
import org.w3c.dom.Document;
import org.w3c.dom.Element;


/**
 * Class:ConstructDOMTreeActivity Creation Date: Mar 12, 2005 CVS ID $Id:$
 *
 * Build a DOM tree based on Airline Route and Price Drop data
 *
 * @author sdodge
 * @since $Date:$
 */
public class ConstructDOMTree extends BaseActivity {

  private Log log = LogFactory.getLog(ConstructDOMTree.class);

  /* (non-Javadoc)
   * @see org.iocworkflow.Activity#execute(org.iocworkflow.ProcessContext)
   */
  public ProcessContext execute(ProcessContext context) throws Exception {

    RateDropContext rateDropCtx = (RateDropContext) context;
    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    factory.setNamespaceAware(false);
    factory.setValidating(false);

    DocumentBuilder builder = null;
    try {
      builder = factory.newDocumentBuilder();
    } catch (ParserConfigurationException pe) {
      log.fatal("Error Building DOM tree Parser configurtion error, Factory could not retrieve new builder instance!", pe);
      rateDropCtx.setStopEntireProcess(true);
      return context;
    }
    Document xmlDoc = builder.newDocument();
    Element rate_drop = xmlDoc.createElement("rate-drop");
    rate_drop.setAttribute("dropAmount", rateDropCtx.getSeedData().getRateDrop().toString());
    xmlDoc.appendChild(rate_drop);

    Element airline = xmlDoc.createElement("airline");
    airline.setAttribute("airlineId", rateDropCtx.getSeedData().getAirlineId().toString());
    airline.setAttribute("name", rateDropCtx.getSeedData().getAirlineName());
    rate_drop.appendChild(airline);

    Element route = xmlDoc.createElement("route");
    route.setAttribute("routeId", rateDropCtx.getSeedData().getRouteId().toString());
    route.setAttribute("origin", rateDropCtx.getSeedData().getRouteOrigin());
    route.setAttribute("destination", rateDropCtx.getSeedData().getRouteDestination());
    rate_drop.appendChild(route);

    log.debug("++++++++Resulting DOM tree+++++++:" + getPrettyXml(xmlDoc));

    rateDropCtx.setMessageDom(new DOMSource(xmlDoc));

    return context;
  }

  /**
   * @param rate_drop
   * @return
   */
  private String getPrettyXml(Document rateDOM) {
    String result = rateDOM.toString();
    Writer writer = new StringWriter();

    OutputFormat fmt = new OutputFormat(rateDOM, "UTF-8", true);
    XMLSerializer serializer = new XMLSerializer(writer, fmt);
    try {
      writer.write("\n");
      serializer.serialize(rateDOM);
      result = ((StringWriter) writer).getBuffer().toString();
    } catch (IOException e) {
      log.error("IOException", e);
    }
    return result;
  }

}
