
package ws.ucm.cliente.subida;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ws.ucm.cliente.subida package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ws.ucm.cliente.subida
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link StatusInfo }
     * 
     */
    public StatusInfo createStatusInfo() {
        return new StatusInfo();
    }

    /**
     * Create an instance of {@link IdcProperty }
     * 
     */
    public IdcProperty createIdcProperty() {
        return new IdcProperty();
    }

    /**
     * Create an instance of {@link Process }
     * 
     */
    public Process createProcess() {
        return new Process();
    }

    /**
     * Create an instance of {@link ProcessResponse }
     * 
     */
    public ProcessResponse createProcessResponse() {
        return new ProcessResponse();
    }

    /**
     * Create an instance of {@link IdcFile }
     * 
     */
    public IdcFile createIdcFile() {
        return new IdcFile();
    }

    /**
     * Create an instance of {@link CheckInUniversalResult }
     * 
     */
    public CheckInUniversalResult createCheckInUniversalResult() {
        return new CheckInUniversalResult();
    }

    /**
     * Create an instance of {@link IdcPropertyList }
     * 
     */
    public IdcPropertyList createIdcPropertyList() {
        return new IdcPropertyList();
    }

}
