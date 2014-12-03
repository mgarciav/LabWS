
package finanzas;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para busquedaPagado complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="busquedaPagado">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="sueldo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="numerito" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "busquedaPagado", propOrder = {
    "sueldo",
    "numerito"
})
public class BusquedaPagado {

    protected String sueldo;
    protected int numerito;

    /**
     * Obtiene el valor de la propiedad sueldo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSueldo() {
        return sueldo;
    }

    /**
     * Define el valor de la propiedad sueldo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSueldo(String value) {
        this.sueldo = value;
    }

    /**
     * Obtiene el valor de la propiedad numerito.
     * 
     */
    public int getNumerito() {
        return numerito;
    }

    /**
     * Define el valor de la propiedad numerito.
     * 
     */
    public void setNumerito(int value) {
        this.numerito = value;
    }

}
