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
import sysautos.bussines.drivers.dvrModopago;

import sysautos.bussines.drivers.dvrDetallereq;
import sysautos.bussines.drivers.dvrRequisitos;
import sysautos.bussines.drivers.dvrTipodeudor;
import sysautos.bussines.entities.Modopago;
import sysautos.bussines.entities.Detallereq;
import sysautos.bussines.entities.Requisitos;

import sysautos.bussines.entities.Tipodeudor;
import sysautos.bussines.session.MbsMessages;


/**
 *
 * @author DISMAGIC0985043396
 */
@ManagedBean(name = "dtRemopaView")
@ViewScoped
public final class vmbRequisitos implements Serializable{

    /**
     * Creates a new instance of vmbRemopa
     */
    
    private List<Requisitos> listaReModoPago;
    private Requisitos rmpNuevo;
    private Requisitos rmpSel;
    private List<Tipodeudor> listaplicar;
    private List<Modopago> listmodo;
    private List<Detallereq> listreq;
    
    
    
    public vmbRequisitos() throws Exception{
        
        this.rmpNuevo= new Requisitos();
        this.loadremopas();
        
    }

    public List<Requisitos> getListaReModoPago() {
        return listaReModoPago;
    }

    public void setListaReModoPago(List<Requisitos> listaReModoPago) {
        this.listaReModoPago = listaReModoPago;
    }

    public Requisitos getRmpNuevo() {
        return rmpNuevo;
    }

    public void setRmpNuevo(Requisitos rmpNuevo) {
        this.rmpNuevo = rmpNuevo;
    }

    public Requisitos getRmpSel() {
        return rmpSel;
    }

    public void setRmpSel(Requisitos rmpSel) {
        this.rmpSel = rmpSel;
    }

    public List<Tipodeudor> getListaplicar() {
        return listaplicar;
    }

    public void setListaplicar(List<Tipodeudor> listaplicar) {
        this.listaplicar = listaplicar;
    }

    public List<Modopago> getListmodo() {
        return listmodo;
    }

    public void setListmodo(List<Modopago> listmodo) {
        this.listmodo = listmodo;
    }

    public List<Detallereq> getListreq() {
        return listreq;
    }

    public void setListreq(List<Detallereq> listreq) {
        this.listreq = listreq;
    }
    
    
    public void loadremopas() {
        try {
            this.listaReModoPago = dvrRequisitos.getRequisitosList();
            listaplicar = dvrTipodeudor.getTipodeudorList();
            listmodo = dvrModopago.getModopagoList();
            listreq = dvrDetallereq.getDetallereqList();
        } catch (Exception ex) {
            MbsMessages.fatal(ex.getMessage());
        }
    }
    
    public void loadremopa(Requisitos tipo) {
        try {
            if (tipo != null) {
                this.rmpSel = dvrRequisitos.getRequisitosById(tipo.getRqtid());
                RequestContext.getCurrentInstance().update("frmEditRemopa");
                RequestContext.getCurrentInstance().execute("PF('editremopa').show()");
            } else {
                MbsMessages.error("Seleccione un registro");
            }
        } catch (Exception ex) {
            MbsMessages.fatal(ex.getMessage());
        }
    }
    
    
    
    public void register() {
        try {
            int ban = dvrRequisitos.requisitosRegister(this.rmpNuevo);
            if (ban != 0) {
                this.loadremopas();
                MbsMessages.info("Requisitos creado exitosamente!");
            } else {
                MbsMessages.error("No se pudo insertar el registro!");
            }
        } catch (Exception ex) {
            MbsMessages.fatal(ex.getMessage());
        }
    }
    
    
     public void update(Requisitos mp) {
        try {
            if (dvrRequisitos.requisitosUpdate(mp)) {
                this.loadremopas();
                MbsMessages.info("Modo Pago actualizado correctamente!");
            } else {
                MbsMessages.error("No se pudo Actualizar el registro!");
            }
        } catch (Exception ex) {
            MbsMessages.fatal(ex.getMessage());
        }
    }
     
     
     
     

    public void delete(Requisitos tipo) {
        try {
            if (tipo != null) {
                if (dvrRequisitos.requisitosDelete(tipo)) {
                    this.loadremopas();
                    MbsMessages.info("Requisitos eliminado exitosamente!");
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
