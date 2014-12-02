
package javafxapplication;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.6-1b01 
 * Generated source version: 2.2
 * 
 */
@WebService(name = "IService1", targetNamespace = "http://tempuri.org/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface IService1 {


    /**
     * 
     * @return
     *     returns java.lang.Boolean
     */
    @WebMethod(action = "http://tempuri.org/IService1/dropDB")
    @WebResult(name = "dropDBResult", targetNamespace = "http://tempuri.org/")
    @RequestWrapper(localName = "dropDB", targetNamespace = "http://tempuri.org/", className = "javafxapplication.DropDB")
    @ResponseWrapper(localName = "dropDBResponse", targetNamespace = "http://tempuri.org/", className = "javafxapplication.DropDBResponse")
    public Boolean dropDB();

    /**
     * 
     * @param rut
     * @param name
     * @param depto
     * @return
     *     returns java.lang.Boolean
     */
    @WebMethod(action = "http://tempuri.org/IService1/addDB")
    @WebResult(name = "addDBResult", targetNamespace = "http://tempuri.org/")
    @RequestWrapper(localName = "addDB", targetNamespace = "http://tempuri.org/", className = "javafxapplication.AddDB")
    @ResponseWrapper(localName = "addDBResponse", targetNamespace = "http://tempuri.org/", className = "javafxapplication.AddDBResponse")
    public Boolean addDB(
        @WebParam(name = "name", targetNamespace = "http://tempuri.org/")
        String name,
        @WebParam(name = "depto", targetNamespace = "http://tempuri.org/")
        String depto,
        @WebParam(name = "rut", targetNamespace = "http://tempuri.org/")
        String rut);

    /**
     * 
     * @param search
     * @return
     *     returns java.lang.String
     */
    @WebMethod(action = "http://tempuri.org/IService1/queryDB")
    @WebResult(name = "queryDBResult", targetNamespace = "http://tempuri.org/")
    @RequestWrapper(localName = "queryDB", targetNamespace = "http://tempuri.org/", className = "javafxapplication.QueryDB")
    @ResponseWrapper(localName = "queryDBResponse", targetNamespace = "http://tempuri.org/", className = "javafxapplication.QueryDBResponse")
    public String queryDB(
        @WebParam(name = "search", targetNamespace = "http://tempuri.org/")
        String search);

    /**
     * 
     * @param search
     * @param type
     * @return
     *     returns java.lang.String
     */
    @WebMethod(action = "http://tempuri.org/IService1/queryTypeDB")
    @WebResult(name = "queryTypeDBResult", targetNamespace = "http://tempuri.org/")
    @RequestWrapper(localName = "queryTypeDB", targetNamespace = "http://tempuri.org/", className = "javafxapplication.QueryTypeDB")
    @ResponseWrapper(localName = "queryTypeDBResponse", targetNamespace = "http://tempuri.org/", className = "javafxapplication.QueryTypeDBResponse")
    public String queryTypeDB(
        @WebParam(name = "search", targetNamespace = "http://tempuri.org/")
        String search,
        @WebParam(name = "type", targetNamespace = "http://tempuri.org/")
        Integer type);

}
