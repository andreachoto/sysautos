/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sysautos.bussines.controllers;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import sysautos.bussines.drivers.dvrAmortizacion;
import sysautos.bussines.entities.Amortizacion;
import sysautos.bussines.entities.Credit;

/**
 *
 * @author DISMAGIC0985043396
 */
@ManagedBean(name = "dtAmortView")
@ViewScoped
public final class vmbAmortizacion  implements Serializable{

    
    private ArrayList<Amortizacion> listaAmt;
    private Amortizacion amtNuevo;
    private Amortizacion amtSel;
    private Amortizacion objAmortizacion;
    private Amortizacion objAmtInsert;
    private Credit credito;
    double saldo = 0;
    
    
    
    
    public vmbAmortizacion() throws Exception {
        
        amtSel = new Amortizacion();
        objAmortizacion = new Amortizacion();
        credito = new Credit();
        
    }

    public ArrayList<Amortizacion> getListaAmt() {
        return listaAmt;
    }

    public void setListaAmt(ArrayList<Amortizacion> listaAmt) {
        this.listaAmt = listaAmt;
    }

    public Amortizacion getAmtNuevo() {
        return amtNuevo;
    }

    public void setAmtNuevo(Amortizacion amtNuevo) {
        this.amtNuevo = amtNuevo;
    }

    public Amortizacion getAmtSel() {
        return amtSel;
    }

    public void setAmtSel(Amortizacion amtSel) {
        this.amtSel = amtSel;
    }

    public Amortizacion getObjAmortizacion() {
        return objAmortizacion;
    }

    public void setObjAmortizacion(Amortizacion objAmortizacion) {
        this.objAmortizacion = objAmortizacion;
    }

    public Amortizacion getObjAmtInsert() {
        return objAmtInsert;
    }

    public void setObjAmtInsert(Amortizacion objAmtInsert) {
        this.objAmtInsert = objAmtInsert;
    }

    public Credit getCredito() {
        return credito;
    }

    public void setCredito(Credit credito) {
        this.credito = credito;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    
    
    public void insertar() {

        try {
            for (Amortizacion amortizacion : listaAmt) {
               dvrAmortizacion.userAmtRegister(amortizacion); 
            }
           //  listaAmt = new ArrayList<Amortizacion>();
        } catch (Exception ex) {
            Logger.getLogger(Amortizacion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

   
    
    
    
    
    
    
}
