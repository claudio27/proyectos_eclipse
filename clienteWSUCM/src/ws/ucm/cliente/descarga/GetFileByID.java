
package ws.ucm.cliente.descarga;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.1.6 in JDK 6
 * Generated source version: 2.1
 * 
 */
@WebService(name = "GetFileByID", targetNamespace = "http://xmlns.oracle.com/UCMServices/GetFileByID/GetFileByID")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface GetFileByID {


    /**
     * 
     * @param dID
     * @param extraProps
     * @param rendition
     * @return
     *     returns ws.ucm.cliente.descarga.GetFileByIDResult
     */
    @WebMethod(action = "process")
    @WebResult(name = "GetFileByIDResult", targetNamespace = "http://xmlns.oracle.com/UCMServices/GetFileByID/GetFileByID")
    @RequestWrapper(localName = "process", targetNamespace = "http://xmlns.oracle.com/UCMServices/GetFileByID/GetFileByID", className = "ws.ucm.cliente.descarga.Process")
    @ResponseWrapper(localName = "processResponse", targetNamespace = "http://xmlns.oracle.com/UCMServices/GetFileByID/GetFileByID", className = "ws.ucm.cliente.descarga.ProcessResponse")
    public GetFileByIDResult process(
        @WebParam(name = "dID", targetNamespace = "http://xmlns.oracle.com/UCMServices/GetFileByID/GetFileByID")
        Integer dID,
        @WebParam(name = "rendition", targetNamespace = "http://xmlns.oracle.com/UCMServices/GetFileByID/GetFileByID")
        String rendition,
        @WebParam(name = "extraProps", targetNamespace = "http://xmlns.oracle.com/UCMServices/GetFileByID/GetFileByID")
        IdcPropertyList extraProps);

}
