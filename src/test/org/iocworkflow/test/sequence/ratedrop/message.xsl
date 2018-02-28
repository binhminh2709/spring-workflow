<?xml version="1.0" encoding="ISO-8859-1"?>

<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<!-- Looking to process something like this
	<?xml version="1.0" encoding="UTF-8"?>
      <rate-drop dropAmount="30.28">
         <airline airlineId="12" name="X-Jet"/>
         <route destination="LGA" origin="BWI" routeId="117"/>
       </rate-drop>
-->   
<xsl:output method="html"/>

<xsl:template match="/">
  <html>
  
  <body>  	
	<h2>Price Drop Notification</h2>
	<p><b>Great News!</b>This a message to inform you that a price drop of 
		$<xsl:value-of select="/rate-drop/@dropAmount"/> has occured for 
	   the ariline <xsl:value-of select="/rate-drop/airline/@name"/>. This price
	   drop is for all routes from <xsl:value-of select="/rate-drop/route/@origin"/>
	   to <xsl:value-of select="/rate-drop/route/@destination"/>.
       </p>
	   Take advantage of these savings and book your flight now!<br></br>
		<a>
         <xsl:attribute name="href">http://superflightbookingsystem.com/checkflights.go?routeId=<xsl:value-of select="/rate-drop/route/@routeId"/>
        </xsl:attribute>
		Click Here
        </a>
		
	   </body>
	   </html>
 </xsl:template>
</xsl:stylesheet>
