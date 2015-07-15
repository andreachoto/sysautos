/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sysautos.bussines.controllers;

import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import sysautos.bussines.drivers.dvrRequisitosCliente;
import sysautos.bussines.entities.ClienteCredito;
import sysautos.bussines.entities.RequisitosCliente;
import sysautos.bussines.session.MbsMessages;

/**
 *
 * @author DISMAGIC0985043396
 */
@ManagedBean(name = "dtReqView")
@ViewScoped
public final class vmbRecli implements Serializable {

    private static List<RequisitosCliente> listaReqCliente;
    private RequisitosCliente reqcliNuevo;
    private RequisitosCliente reqcliSel;
    private int codigo;
    private ClienteCredito objclientecred;
    private List<RequisitosCliente> lstReqCli;
    
   
    
    public vmbRecli() {
          this.reqcliNuevo= new RequisitosCliente();
          this.objclientecred= new ClienteCredito();
          
          
          this.loadreqcli();
    }
    
     public void loadreqcli() {
        try {
            this.listaReqCliente = dvrRequisitosCliente.getRequisitosClienteById(codigo);
            
        } catch (Exception ex) {
            MbsMessages.fatal(ex.getMessage());
        }
    }

    public List<RequisitosCliente> getLstReqCli() {
        return lstReqCli;
    }

    public void setLstReqCli(List<RequisitosCliente> lstReqCli) {
        this.lstReqCli = lstReqCli;
    }

    public List<RequisitosCliente> getListaReqCliente() {
        return listaReqCliente;
    }

    public void setListaReqCliente(List<RequisitosCliente> listaReqCliente) {
        this.listaReqCliente = listaReqCliente;
    }

    public RequisitosCliente getReqcliNuevo() {
        return reqcliNuevo;
    }

    public void setReqcliNuevo(RequisitosCliente reqcliNuevo) {
        this.reqcliNuevo = reqcliNuevo;
    }

    public RequisitosCliente getReqcliSel() {
        return reqcliSel;
    }

    public void setReqcliSel(RequisitosCliente reqcliSel) {
        this.reqcliSel = reqcliSel;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public ClienteCredito getObjclientecred() {
        return objclientecred;
    }

    public void setObjclientecred(ClienteCredito objclientecred) {
        this.objclientecred = objclientecred;
    }
     
    public void buscarreq() throws Exception {

        Integer cliente = objclientecred.getIdcli();
        Integer credito = objclientecred.getIdcred();
        lstReqCli = dvrRequisitosCliente.getRequisitosClienteByClCr(cliente, credito);
                 
    }
     
     
     
     
     
     
     
     
     
//      public void loadreclientes(RequisitosCliente tipo) {
//        try {
//            if (tipo != null){
//                this.reqcliSel = dvrRequisitosCliente.getRequisitosClienteById(tipo.getCltid());
//                RequestContext.getCurrentInstance().update("frmEditRemopa");
//                RequestContext.getCurrentInstance().execute("PF('editremopa').show()");
//            } else {
//                MbsMessages.error("Seleccione un registro");
//            }
//        } catch (Exception ex) {
//            MbsMessages.fatal(ex.getMessage());
//        }
//    }
//      
      
    
    
    
    
}

