/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication;


import javafx.beans.property.SimpleStringProperty;
/**
 *
 * @author Nicolas
 */
public final class Employed {
   private final SimpleStringProperty Nombre = new SimpleStringProperty("");
   private final SimpleStringProperty Rut = new SimpleStringProperty("");
   private final SimpleStringProperty Depto = new SimpleStringProperty("");


    public Employed() {
            this("", "", "");
        }
 
    public Employed(String nombre, String depto, String rut) {
        setNombre(nombre);
        setDepto(depto);
        setRut(rut);
    }

    
    public String getNombre() {
        return Nombre.get();
    }
 
    public void setNombre(String fName) {
        Nombre.set(fName);
    }
        
    public String getDepto() {
        return Depto.get();
    }
    
    public void setDepto(String fName) {
        Depto.set(fName);
    }
    
    public String getRut() {
        return Rut.get();
    }
    
    public void setRut(String fName) {
        Rut.set(fName);
    }
    
}