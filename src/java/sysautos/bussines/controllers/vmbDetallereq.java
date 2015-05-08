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
import org.primefaces.context.RequestContext;
import sysautos.bussines.drivers.dvrDetallereq;
import sysautos.bussines.entities.Detallereq;
import sysautos.bussines.session.MbsMessages;

/**
 *
 * @author DISMAGIC0985043396
 */
@ManagedBean (name = "dtRequisitosView")
@ViewScoped
public final class vmbDetallereq implements Serializable{

    
    private List<Detallereq> listaReqyre;

    private Detallereq objsel;
    private Detallereq objReq;
    
    public vmbDetallereq() throws Exception {
        
        this.objReq= new Detallereq();
        this.loadrequisitos();
        
    }

    public List<Detallereq> getListaReqyre() {
        return listaReqyre;
    }

    public void setListaReqyre(List<Detallereq> listaReqyre) {
        this.listaReqyre = listaReqyre;
    }

    public Detallereq getObjsel() {
        return objsel;
    }

    public void setObjsel(Detallereq objsel) {
        this.objsel = objsel;
    }

    public Detallereq getObjReq() {
        return objReq;
    }

    public void setObjReq(Detallereq objReq) {
        this.objReq = objReq;
    }
    
    
    
    
    public void loadrequisitos() {
        try {
            this.listaReqyre = dvrDetallereq.getDetallereqList();
        } catch (Exception ex) {
            MbsMessages.fatal(ex.getMessage());
        }
    }
    
    public void loadrequisito(Detallereq tipo) {
        try {
            if (tipo != null) {
                this.objsel = dvrDetallereq.getDetallereqById(tipo.getId());
                RequestContext.getCurrentInstance().update("frmEditRequisitos");
                RequestContext.getCurrentInstance().execute("PF('editrequisitos').show()");
            } else {
                MbsMessages.error("Seleccione un registro");
            }
        } catch (Exception ex) {
            MbsMessages.fatal(ex.getMessage());
        }
    }
    
    
    
     public void register() {
        try {
            int ban = dvrDetallereq.detallereqRegister(this.objReq);
            if (ban != 0) {
                this.loadrequisitos();
                MbsMessages.info("Requisito creado exitosamente!");
            } else {
                MbsMessages.error("No se pudo insertar el registro!");
            }
        } catch (Exception ex) {
            MbsMessages.fatal(ex.getMessage());
        }
    }

    public void update(Detallereq mp) {
        try {
            if (dvrDetallereq.detallereqUpdate(mp)) {
                this.loadrequisitos();
                MbsMessages.info("Requisitos Deudor actualizado correctamente!");
            } else {
                MbsMessages.error("No se pudo Actualizar el registro!");
            }
        } catch (Exception ex) {
            MbsMessages.fatal(ex.getMessage());
        }
    }

    public void delete(Detallereq tipo) {
        try {
            if (tipo != null) {
                if (dvrDetallereq.detallereqDelete(tipo)) {
                    this.loadrequisitos();
                    MbsMessages.info("Requisito Deudor eliminado exitosamente!");
                } else {
                    MbsMessages.error("No se pudo Eliminar!");
                }
            } else {
                MbsMessages.error("Seleccione un registro");
            }
        } catch (Exception ex) {
            MbsMessages.fatal(ex.getMessage());
        }
    }
    
    
    
    
    
    
    
}
