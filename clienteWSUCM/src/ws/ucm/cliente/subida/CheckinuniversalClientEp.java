
package ws.ucm.cliente.subida;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Logger;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;

import ws.ucm.utiles.Propiedad;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.1.6 in JDK 6
 * Generated source version: 2.1
 * 
 */
@WebServiceClient(name = "checkinuniversal_client_ep", targetNamespace = "http://xmlns.oracle.com/UCMServices/CheckInUniversal/CheckInUniversal", wsdlLocation = "http://tineo.bice.local:8005/soa-infra/services/UCM/CheckInUniversal/checkinuniversal_client_ep?WSDL")
public class CheckinuniversalClientEp
    extends Service
{

    private final static URL CHECKINUNIVERSALCLIENTEP_WSDL_LOCATION;
    private final static Logger logger = Logger.getLogger(ws.ucm.cliente.subida.CheckinuniversalClientEp.class.getName());

    static {
        URL url = null; 
        String urlWebServiceSubida = Propiedad.getProp("subida");
        try {
            URL baseUrl;
            baseUrl = ws.ucm.cliente.subida.CheckinuniversalClientEp.class.getResource(".");
            url = new URL(baseUrl, urlWebServiceSubida);
        } catch (MalformedURLException e) {
            logger.warning("Failed to create URL for the wsdl Location: '" + urlWebServiceSubida + "', retrying as a local file");
            logger.warning(e.getMessage());
        }
        CHECKINUNIVERSALCLIENTEP_WSDL_LOCATION = url;
    }

    public CheckinuniversalClientEp(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public CheckinuniversalClientEp() {
        super(CHECKINUNIVERSALCLIENTEP_WSDL_LOCATION, new QName("http://xmlns.oracle.com/UCMServices/CheckInUniversal/CheckInUniversal", "checkinuniversal_client_ep"));
    }

    /**
     * 
     * @return
     *     returns CheckInUniversal
     */
    @WebEndpoint(name = "CheckInUniversal_pt")
    public CheckInUniversal getCheckInUniversalPt() {
        return super.getPort(new QName("http://xmlns.oracle.com/UCMServices/CheckInUniversal/CheckInUniversal", "CheckInUniversal_pt"), CheckInUniversal.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns CheckInUniversal
     */
    @WebEndpoint(name = "CheckInUniversal_pt")
    public CheckInUniversal getCheckInUniversalPt(WebServiceFeature... features) {
        return super.getPort(new QName("http://xmlns.oracle.com/UCMServices/CheckInUniversal/CheckInUniversal", "CheckInUniversal_pt"), CheckInUniversal.class, features);
    }

}
