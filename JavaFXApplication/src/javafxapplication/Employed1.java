/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication;

import javafx.beans.property.SimpleStringProperty;
/**
 *
 * @author Mati
 */
public final class Employed1 {
   private final SimpleStringProperty Rut = new SimpleStringProperty("");
   private final SimpleStringProperty Sueldo = new SimpleStringProperty("");
   private final SimpleStringProperty Pagado = new SimpleStringProperty("");


    public Employed1() {
            this("", "", "");
        }
 
    public Employed1(String rut, String sueldo, String pagado) {
        setRut(rut);
        setSueldo(sueldo);
        setRut(pagado);
    }

    
    public String getRut() {
        return Rut.get();
    }
 
    public void setRut(String fRut) {
        Rut.set(fRut);
    }
        
    public String getSueldo() {
        return Sueldo.get();
    }
    
    public void setSueldo(String fSueldo) {
        Sueldo.set(fSueldo);
    }
    
    public String getPagado() {
        return Pagado.get();
    }
    
    public void setPagado(String fPagado) {
        Pagado.set(fPagado);
    }
}