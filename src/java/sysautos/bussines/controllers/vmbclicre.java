/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sysautos.bussines.controllers;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import org.primefaces.context.DefaultRequestContext;
import org.primefaces.context.RequestContext;
import sysautos.bussines.drivers.dvrAmortizacion;
import sysautos.bussines.drivers.dvrClienteCredito;
import sysautos.bussines.drivers.dvrCredit;
import sysautos.bussines.drivers.dvrRequisitosCliente;
import sysautos.bussines.drivers.dvrTipodeudor;
import sysautos.bussines.entities.Amortizacion;
import sysautos.bussines.entities.ClienteCredito;
import sysautos.bussines.entities.Credit;
import sysautos.bussines.entities.RequisitosCliente;
import sysautos.bussines.entities.Tipodeudor;
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
    private Credit credito;
    private List<ClienteCredito> lstCredito;
    private List<RequisitosCliente> lstReqCli;
    private RequisitosCliente objreqcli;

    
    
    public vmbclicre() throws Exception { 

        this.objclientecred = new ClienteCredito();
        this.loadclicreditos();

    }

    public void loadclicreditos() {
        try {
            this.listaClienteCredito = dvrClienteCredito.getAplicarList();
        } catch (Exception ex) {
            MbsMessages.fatal(ex.getMessage());
        }

        objclientecred = new ClienteCredito();
        objsel = new ClienteCredito();
    }

    public RequisitosCliente getObjreqcli() {
        return objreqcli;
    }

    public void setObjreqcli(RequisitosCliente objreqcli) {
        this.objreqcli = objreqcli;
    }

    
   public List<RequisitosCliente> getLstReqCli() {
        return lstReqCli;
    }

    public void setLstReqCli(List<RequisitosCliente> lstReqCli) {
        this.lstReqCli = lstReqCli;
    }
    public Credit getCredito() {
        return credito;
    }

    public void setCredito(Credit credito) {
        this.credito = credito;
    }

    public List<ClienteCredito> getLstCredito() {
        return lstCredito;
    }

    public void setLstCredito(List<ClienteCredito> lstCredito) {
        this.lstCredito = lstCredito;
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

    public void buscar() throws Exception {

        Integer numero = objclientecred.getIdcred();
        lstCredito = dvrRequisitosCliente.getClientesListByCrdito(numero);

    }
     public void buscarreq() throws Exception {

        Integer cliente = objclientecred.getIdcli();
        Integer credito1 = objclientecred.getIdcred();
        lstReqCli = dvrRequisitosCliente.getRequisitosClienteByClCr(cliente, credito1);
                 
    }
    
    
    
    
       public void loadclicreditos(ClienteCredito tipo) {
        try {
            if (tipo != null){
               // this.objsel = dvrClienteCredito.getClientecreditoById(tipo.getIdcli(),tipo.getIdcred());
//                RequestContext.getCurrentInstance().update("frmEditRemopa");
              
                 lstReqCli = dvrRequisitosCliente.getRequisitosClienteByClCr(tipo.getIdcli(), tipo.getIdcred());
                 RequestContext.getCurrentInstance().execute("PF('editremopa').show()");
            } else {
                MbsMessages.error("Seleccione un registro");
            }
        } catch (Exception ex) {
            MbsMessages.fatal(ex.getMessage());
        }
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
