
package ws.ucm.cliente.subida;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CheckInUniversalResult" type="{http://xmlns.oracle.com/UCMServices/CheckInUniversal/CheckInUniversal}CheckInUniversalResult" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "checkInUniversalResult"
})
@XmlRootElement(name = "processResponse")
public class ProcessResponse {

    @XmlElement(name = "CheckInUniversalResult")
    protected CheckInUniversalResult checkInUniversalResult;

    /**
     * Gets the value of the checkInUniversalResult property.
     * 
     * @return
     *     possible object is
     *     {@link CheckInUniversalResult }
     *     
     */
    public CheckInUniversalResult getCheckInUniversalResult() {
        return checkInUniversalResult;
    }

    /**
     * Sets the value of the checkInUniversalResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link CheckInUniversalResult }
     *     
     */
    public void setCheckInUniversalResult(CheckInUniversalResult value) {
        this.checkInUniversalResult = value;
    }

}
