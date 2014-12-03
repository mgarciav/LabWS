
package finanzas;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the finanzas package. 
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

    private final static QName _BusquedaRut_QNAME = new QName("http://finanzas/", "busquedaRut");
    private final static QName _BusquedaPagado_QNAME = new QName("http://finanzas/", "busquedaPagado");
    private final static QName _BusquedaPagadoResponse_QNAME = new QName("http://finanzas/", "busquedaPagadoResponse");
    private final static QName _BusquedaRutResponse_QNAME = new QName("http://finanzas/", "busquedaRutResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: finanzas
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link BusquedaPagadoResponse }
     * 
     */
    public BusquedaPagadoResponse createBusquedaPagadoResponse() {
        return new BusquedaPagadoResponse();
    }

    /**
     * Create an instance of {@link BusquedaPagado }
     * 
     */
    public BusquedaPagado createBusquedaPagado() {
        return new BusquedaPagado();
    }

    /**
     * Create an instance of {@link BusquedaRut }
     * 
     */
    public BusquedaRut createBusquedaRut() {
        return new BusquedaRut();
    }

    /**
     * Create an instance of {@link BusquedaRutResponse }
     * 
     */
    public BusquedaRutResponse createBusquedaRutResponse() {
        return new BusquedaRutResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BusquedaRut }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://finanzas/", name = "busquedaRut")
    public JAXBElement<BusquedaRut> createBusquedaRut(BusquedaRut value) {
        return new JAXBElement<BusquedaRut>(_BusquedaRut_QNAME, BusquedaRut.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BusquedaPagado }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://finanzas/", name = "busquedaPagado")
    public JAXBElement<BusquedaPagado> createBusquedaPagado(BusquedaPagado value) {
        return new JAXBElement<BusquedaPagado>(_BusquedaPagado_QNAME, BusquedaPagado.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BusquedaPagadoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://finanzas/", name = "busquedaPagadoResponse")
    public JAXBElement<BusquedaPagadoResponse> createBusquedaPagadoResponse(BusquedaPagadoResponse value) {
        return new JAXBElement<BusquedaPagadoResponse>(_BusquedaPagadoResponse_QNAME, BusquedaPagadoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BusquedaRutResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://finanzas/", name = "busquedaRutResponse")
    public JAXBElement<BusquedaRutResponse> createBusquedaRutResponse(BusquedaRutResponse value) {
        return new JAXBElement<BusquedaRutResponse>(_BusquedaRutResponse_QNAME, BusquedaRutResponse.class, null, value);
    }

}
