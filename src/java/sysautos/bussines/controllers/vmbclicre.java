/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sysautos.bussines.controllers;

import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import sysautos.bussines.drivers.dvrClienteCredito;
import sysautos.bussines.entities.ClienteCredito;
import sysautos.bussines.session.MbsMessages;

/**
 *
 * @author DISMAGIC0985043396
 */
@ManagedBean(name = "dtClicreView")
@ViewScoped
public final class vmbclicre implements Serializable {

    private List<ClienteCredito> listaClienteCredito;
    private ClienteCredito objclientecred;
    private ClienteCredito objsel;
    public vmbclicre() throws Exception {
        
        this.objclientecred= new ClienteCredito();
        this.loadclicreditos();
        
    }
    
    
    public void loadclicreditos() {
        try {
            this.listaClienteCredito = dvrClienteCredito.getAplicarList();
        } catch (Exception ex) {
            MbsMessages.fatal(ex.getMessage());
        }
        
        objclientecred= new ClienteCredito();
        objsel=new ClienteCredito();
    }

    public List<ClienteCredito> getListaClienteCredito() {
        return listaClienteCredito;
    }

    public void setListaClienteCredito(List<ClienteCredito> listaClienteCredito) {
        this.listaClienteCredito = listaClienteCredito;
    }

    public ClienteCredito getObjclientecred() {
        return objclientecred;
    }

    public void setObjclientecred(ClienteCredito objclientecred) {
        this.objclientecred = objclientecred;
    }

    public ClienteCredito getObjsel() {
        return objsel;
    }

    public void setObjsel(ClienteCredito objsel) {
        this.objsel = objsel;
    }
    
    public void insertar() {
        try {
//            if ((dvrClienteCredito.ClienteCreditoRegister(objsel))==true) {
//                FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
//                        "Error", "Error desconocido");
//                FacesContext.getCurrentInstance().addMessage(null, facesMsg);
//               
//            } else {
//                FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_INFO,
//                        "Información", "Ingresado correctamente");
//                FacesContext.getCurrentInstance().addMessage(null, facesMsg);
//                cargar();
//                
//                
//            }
        } catch (Exception ex) {
            Logger.getLogger(ClienteCredito.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
}
