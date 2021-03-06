
package ws.ucm.cliente.descarga;

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
@WebServiceClient(name = "getfilebyid_client_ep", targetNamespace = "http://xmlns.oracle.com/UCMServices/GetFileByID/GetFileByID", wsdlLocation = "http://tineo.bice.local:8005/soa-infra/services/UCM/GetFileByID/getfilebyid_client_ep?WSDL")
public class GetfilebyidClientEp
    extends Service
{

    private final static URL GETFILEBYIDCLIENTEP_WSDL_LOCATION;
    private final static Logger logger = Logger.getLogger(ws.ucm.cliente.descarga.GetfilebyidClientEp.class.getName());

    static {
        URL url = null;  
        String urlWsDescarga = Propiedad.getProp("descarga");
        try {
            URL baseUrl;
            baseUrl = ws.ucm.cliente.descarga.GetfilebyidClientEp.class.getResource(".");
            url = new URL(baseUrl, urlWsDescarga);
        } catch (MalformedURLException e) {
            logger.warning("Failed to create URL for the wsdl Location: '"+ urlWsDescarga +"', retrying as a local file");
            logger.warning(e.getMessage());
        }
        GETFILEBYIDCLIENTEP_WSDL_LOCATION = url;
    }

    public GetfilebyidClientEp(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public GetfilebyidClientEp() {
        super(GETFILEBYIDCLIENTEP_WSDL_LOCATION, new QName("http://xmlns.oracle.com/UCMServices/GetFileByID/GetFileByID", "getfilebyid_client_ep"));
    }

    /**
     * 
     * @return
     *     returns GetFileByID
     */
    @WebEndpoint(name = "GetFileByID_pt")
    public GetFileByID getGetFileByIDPt() {
        return super.getPort(new QName("http://xmlns.oracle.com/UCMServices/GetFileByID/GetFileByID", "GetFileByID_pt"), GetFileByID.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns GetFileByID
     */
    @WebEndpoint(name = "GetFileByID_pt")
    public GetFileByID getGetFileByIDPt(WebServiceFeature... features) {
        return super.getPort(new QName("http://xmlns.oracle.com/UCMServices/GetFileByID/GetFileByID", "GetFileByID_pt"), GetFileByID.class, features);
    }

}
