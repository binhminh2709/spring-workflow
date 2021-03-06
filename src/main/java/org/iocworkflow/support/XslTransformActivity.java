package org.iocworkflow.support;

import static org.springframework.util.ResourceUtils.CLASSPATH_URL_PREFIX;

import java.io.StringWriter;
import java.net.URL;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.iocworkflow.BaseActivity;
import org.iocworkflow.ProcessContext;
import org.springframework.util.ResourceUtils;
import org.springframework.util.SystemPropertyUtils;

/**
 * Class:XslTransformActivity Creation Date: Mar 12, 2005 CVS ID $Id:$
 *
 * Class Descriptoin goes here
 *
 * @author sdodge
 * @since $Date:$
 */
public class XslTransformActivity extends BaseActivity {

  private String xslLocation;
  private Log log = LogFactory.getLog(XslTransformActivity.class);

  private static String applyTransform(Source xslSource, Source xmlSource) throws Exception {
    StringWriter sWriter = new StringWriter();
    StreamResult sResult = new StreamResult(sWriter);
    getXFormResult(xslSource, xmlSource, sResult);
    return sWriter.toString();
  }

  private static void getXFormResult(Source xslSource, Source xmlSource, Result result) throws Exception {
    TransformerFactory factory = TransformerFactory.newInstance();
    Transformer xformer = factory.newTransformer(xslSource);
    xformer.transform(xmlSource, result);

  }

  /*
   * (non-Javadoc)
   *
   * @see org.iocworkflow.Activity#execute(org.iocworkflow.ProcessContext)
   */
  public ProcessContext execute(ProcessContext context) throws Exception {

    XsltAware xslContext = (XsltAware) context;
    String resolvedLocation = SystemPropertyUtils.resolvePlaceholders(CLASSPATH_URL_PREFIX + xslLocation);
    URL xslUrl = ResourceUtils.getURL(resolvedLocation);

    log.debug("About to apply XSL transform");
    String transData = applyTransform(getXslSource(xslUrl), xslContext.getDomSource());
    xslContext.setTransformedContent(transData);
    log.debug("Transformed content:");
    log.debug(transData);

    return (ProcessContext) xslContext;
  }

  private Source getXslSource(URL url) {
    //use the URL object to get an Extrenal Stirng url e.g. file///usr/local ... etc
    String xslSysId = url.toExternalForm();
    log.debug(" Found xsl file in filesystem " + xslSysId);
    StreamSource xslSource = new StreamSource(xslSysId);

    return xslSource;
  }

  public void setXslLocation(String xslLocation) {
    this.xslLocation = xslLocation;
  }
}