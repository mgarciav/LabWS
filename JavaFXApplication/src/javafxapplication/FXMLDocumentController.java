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
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        rrhhComboBox.getItems().setAll("Nombre", "Rut", "Departamento");
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
    
    public class EmployedJson
    {
        public String Nombre;
        public String Rut;
        public String Depto;
    }
    
}
