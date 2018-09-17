package org.iocworkflow.support;

import javax.xml.transform.dom.DOMSource;


/**
 * Class:XsltAwareProcessContext Creation Date: Mar 12, 2005 CVS ID $Id:$
 *
 * Makes any object XSLT aware used as input to the {@link XslTransformActivity}
 *
 * @author sdodge
 * @since $Date:$
 */
public interface XsltAware {


  /**
   * Returns the DOM source object created by a previous activity.
   *
   * @return the DOM source object
   */
  public DOMSource getDomSource();

  /**
   * After applying an XSL transform to a DOM tree, set the resulting content in a String field
   */
  public void setTransformedContent(String transformedContent);

}
