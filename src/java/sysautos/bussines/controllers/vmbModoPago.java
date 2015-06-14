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
import sysautos.bussines.entities.Modopago;
import sysautos.bussines.session.MbsMessages;

/**
 *
 * @author DISMAGIC0985043396
 */
@ManagedBean(name = "dtModoView")
@ViewScoped
public final class vmbModoPago implements Serializable {

    /**
     * Creates a new instance of vmbModoPago
     */
    
      
    private List<Modopago> listaModopago;
    private Modopago mdpNuevo;
    private Modopago mdpSel;
    
    
    
    public vmbModoPago() throws Exception {
        
        
        mdpSel = new Modopago();
        mdpNuevo= new Modopago();
        this.loadmodop();
        
    }

    public List<Modopago> getListaModopago() {
        return listaModopago;
    }

    public void setListaModopago(List<Modopago> listaModopago) {
        this.listaModopago = listaModopago;
    }

    public Modopago getMdpNuevo() {
        return mdpNuevo;
    }

    public void setMdpNuevo(Modopago mdpNuevo) {
        this.mdpNuevo = mdpNuevo;
    }

    public Modopago getMdpSel() {
        return mdpSel;
    }

    public void setMdpSel(Modopago mdpSel) {
        this.mdpSel = mdpSel;
    }



    
    
    public void loadmodop() {
        try {
            this.listaModopago = dvrModopago.getModopagoList();
        } catch (Exception ex) {
            MbsMessages.fatal(ex.getMessage());
        }
    }
    
    
    public void loadmodo(Modopago tipo) {
        try {
            if (tipo != null) {
                this.mdpSel = dvrModopago.getModoById(tipo.getId());
                RequestContext.getCurrentInstance().update("frmEditModo");
                RequestContext.getCurrentInstance().execute("PF('editmodo').show()");
            } else {
                MbsMessages.error("Seleccione un registro");
            }
        } catch (Exception ex) {
            MbsMessages.fatal(ex.getMessage());
        }
    }
    
    
    public void register() {
        try {
            int ban = dvrModopago.userModopRegister(this.mdpNuevo);
            if (ban != 0) {
                this.loadmodop();
                MbsMessages.info("Modo creado exitosamente!");
            } else {
                MbsMessages.error("No se pudo insertar el registro!");
            }
        } catch (Exception ex) {
            MbsMessages.fatal(ex.getMessage());
        }
    }

    public void update(Modopago mp) {
        try {
            if (dvrModopago.ModopUpdate(mp)) {
                this.loadmodop();
                MbsMessages.info("Modo actualizado correctamente!");
            } else {
                MbsMessages.error("No se pudo Actualizar el registro!");
            }
        } catch (Exception ex) {
            MbsMessages.fatal(ex.getMessage());
        }
    }

    public void delete(Modopago tipo) {
        try {
            if (tipo != null) {
                if (dvrModopago.modoDelete(tipo)) {
                    this.loadmodop();
                    MbsMessages.info("Modo eliminado exitosamente!");
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
