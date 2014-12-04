/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import java.util.List;
import java.lang.reflect.Type;
import java.util.ArrayList;


/**
 *
 * @author Nicolas
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private ComboBox rrhhComboBox;
    @FXML
    private TextField rrhhTextField;
    @FXML
    private Button rrhhButton;
    @FXML
    private TableView<Employed> rrhhTable;
    @FXML
    private TableColumn rrhhTableRut;
    @FXML
    private TableColumn rrhhTableNombre;
    @FXML
    private TableColumn rrhhTableDepto;
    
    @FXML
    private ComboBox fComboBox;
    @FXML
    private TextField fTextField;
    @FXML
    private Button fButton;
    @FXML
    private TableView<Employed1> fTable;
    @FXML
    private TableColumn fTableRut;
    @FXML
    private TableColumn fTableSueldo;
    @FXML
    private TableColumn fTablePagado;
    
    
    @FXML
    private void busquedaDB(ActionEvent event) {
        
        if (rrhhTextField.getText().isEmpty())
            return;
        int switchType = -1;
        
        switch ((String) rrhhComboBox.getValue() )
        {
            case "Nombre":
                switchType = 0;
                break;
            case "Rut":
                switchType = 1;
                break;
            case "Departamento":
                switchType = 2;
                break;
        }
                
        System.out.println(switchType + " " + rrhhTextField.getText());
                
        String resultado = queryTypeDB(rrhhTextField.getText(), switchType);
        List<EmployedJson> empleados = new Gson().fromJson(resultado, new TypeToken<List<EmployedJson>>(){}.getType());
                
        ObservableList<Employed> data = rrhhTable.getItems();
        data.clear();
        empleados.stream().forEach((EmployedJson aux) -> {
        data.add(new Employed(aux.Nombre, aux.Depto, aux.Rut));
        });
    }
        
    
    @FXML
    private void busquedaDB1(ActionEvent event) {
        
        if (fTextField.getText().isEmpty())
            return;
        int switchType1 = -1;
        
        switch ((String) fComboBox.getValue() )
        {
            case "Rut":
                switchType1 = 0;
                break;
            case "Sueldo":
                switchType1 = 1;
                break;
            case "Pagado":
                switchType1 = 2;
                break;
        }
                
        System.out.println(switchType1 + " " + fTextField.getText());
        String resultado = busquedaPagado(fTextField.getText(), switchType1);
        System.out.println(resultado);
        List<Employed1Json> empleados1 = new Gson().fromJson(resultado, new TypeToken<List<Employed1Json>>(){}.getType());
        ObservableList<Employed1> data1;
        data1 = fTable.getItems();
        data1.clear();
        empleados1.stream().forEach((Employed1Json aux) -> {
        data1.add(new Employed1(aux.Rut, aux.Sueldo, aux.Pagado));
        });
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        rrhhComboBox.getItems().setAll("Nombre", "Rut", "Departamento");
        fComboBox.getItems().setAll("Rut", "Sueldo", "Pagado");
    }   
    
    private static String queryDB(java.lang.String search) {
        javafxapplication.Service1 service = new javafxapplication.Service1();
        javafxapplication.IService1 port = service.getBasicHttpBindingIService1();
        return port.queryDB(search);
    }
   
    
    private static String queryTypeDB(java.lang.String search, java.lang.Integer type) {
        javafxapplication.Service1 service = new javafxapplication.Service1();
        javafxapplication.IService1 port = service.getBasicHttpBindingIService1();
        return port.queryTypeDB(search, type);
    }
    
    private static String busquedaPagado(java.lang.String sueldo, int numerito) {
        finanzas.NewWebService_Service service = new finanzas.NewWebService_Service();
        finanzas.NewWebService port = service.getNewWebServicePort();
        return port.busquedaPagado(sueldo, numerito);
    }

    private static String busquedaRut(java.lang.String rut) {
        finanzas.NewWebService_Service service = new finanzas.NewWebService_Service();
        finanzas.NewWebService port = service.getNewWebServicePort();
        return port.busquedaRut(rut);
    }
    
    public class EmployedJson
    {
        public String Nombre;
        public String Rut;
        public String Depto;
    }
    
    public class Employed1Json
    {
        public String Rut;
        public String Sueldo;
        public String Pagado;
    }

      

}
