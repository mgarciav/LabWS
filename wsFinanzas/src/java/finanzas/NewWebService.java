package finanzas;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.mongodb.util.JSON;
import com.mongodb.BasicDBObject;
import com.mongodb.BulkWriteOperation;
import com.mongodb.BulkWriteResult;
import com.mongodb.Cursor;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.ParallelScanOptions;

import java.util.List;
import java.util.Set;

import static java.util.concurrent.TimeUnit.SECONDS;
 
import com.mongodb.MongoClient;
import java.net.UnknownHostException;
 


import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Mati
 */
@WebService(serviceName = "NewWebService")
public class NewWebService {

    
    @WebMethod(operationName = "busquedaPagado")
    public String busquedaPagado(@WebParam(name = "sueldo") String sueldo, @WebParam(name = "numerito") final int numero)
    {
        System.out.println("Prueba conexión MongoDB");
        MongoClient mongo = crearConexion();
        if (mongo != null) {
            
            DB db = mongo.getDB("Finanzasdb");
            DBCollection table = db.getCollection("trabajador");
            BasicDBObject query = new BasicDBObject();
            if(numero == 0){
            query.put("rut", sueldo);
            DBCursor cur2 = table.find(query);
            String resultado = new String();
            resultado = "[ ";
                  
            while (cur2.hasNext()) {
                resultado +="{\"rut\" : \"" + cur2.next().get("rut").toString() + "\" , \"sueldo\" : \"" + cur2.curr().get("sueldo").toString() + "\" , \"pagado\" : \"" + cur2.curr().get("pagado").toString() + "\" }";
                if(cur2.hasNext()){
                    resultado+=", ";
                }
               
            }
            resultado += " ]";
            mongo.close();
            return resultado;
            }
            if(numero == 1){
            query.put("sueldo", sueldo);
            DBCursor cur2 = table.find(query);
            String resultado = new String();
            resultado = "[ ";
                  
            while (cur2.hasNext()) {
                resultado +="{\"rut\" : \"" + cur2.next().get("rut").toString() + "\" , \"sueldo\" : \"" + cur2.curr().get("sueldo").toString() + "\" , \"pagado\" : \"" + cur2.curr().get("pagado").toString() + "\" }";
                if(cur2.hasNext()){
                    resultado+=", ";
                }
               
            }
            resultado += " ]";
            mongo.close();
            return resultado;
            }
            if(numero == 2){
            query.put("pagado", sueldo);
            DBCursor cur2 = table.find(query);
            String resultado = new String();
            resultado = "[ ";
                  
            while (cur2.hasNext()) {
                resultado +="{\"rut\" : \"" + cur2.next().get("rut").toString() + "\" , \"sueldo\" : \"" + cur2.curr().get("sueldo").toString() + "\" , \"pagado\" : \"" + cur2.curr().get("pagado").toString() + "\" }";
                if(cur2.hasNext()){
                    resultado+=", ";
                }
                
               
            }
            resultado += " ]";
            mongo.close();
            return resultado;
            }
            
        } else {
            System.out.println("Error: Conexión no establecida");
            return null;
        }
        mongo.close();
        return null;
    }
    
    
    @WebMethod(operationName = "busquedaRut")
    public String busquedaSueldo(@WebParam(name = "rut") String rut) 
    {
        System.out.println("Prueba conexión MongoDB");
        MongoClient mongo = crearConexion();
 
        if (mongo != null) {
            System.out.println("Lista de bases de datos: ");
            printDatabases(mongo);
            System.out.println("Lista de tablas de la base de datos: ");
            DB db = mongo.getDB("Finanzasdb");
            DBCollection table = db.getCollection("trabajador");
            BasicDBObject query = new BasicDBObject();
            query.put("rut", rut);
            DBCursor cur2 = table.find(query);
            String resultado = new String();
            resultado = "[ ";
                  
            while (cur2.hasNext()) {
                resultado +="{\"rut\" : \"" + cur2.next().get("rut").toString() + "\" , \"sueldo\" : \"" + cur2.curr().get("sueldo").toString() + "\" , \"pagado\" : \"" + cur2.curr().get("pagado").toString() + "\" }, ";
                
               
            }
            resultado += "]";
            
            return resultado;
        } else {
            System.out.println("Error: Conexión no establecida");
            return null;
        }
    }
    
    private static MongoClient crearConexion() {
        MongoClient mongo = null;
        try {
            mongo = new MongoClient("localhost", 27017);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return mongo;
    }
    
 
    /**
     * Clase que imprime por pantalla todas las bases de datos MongoDB.
     * @param mongo conexión a MongoDB
     */
    private static void printDatabases(MongoClient mongo) {
        mongo.getDatabaseNames().stream().forEach((s) -> {
            System.out.println(s);
        });
    }

    /**
     * Web service operation
     */
    
}
