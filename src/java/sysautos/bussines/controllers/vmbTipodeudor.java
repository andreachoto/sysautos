/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sysautos.bussines.controllers;

import java.io.Serializable;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.context.RequestContext;
import sysautos.bussines.drivers.dvrTipodeudor;
import sysautos.bussines.entities.Tipodeudor;
import sysautos.bussines.session.MbsMessages;

/**
 *
 * @author DISMAGIC0985043396
 */
@ManagedBean(name = "dtTipodView")
@ViewScoped
public final class vmbTipodeudor  implements Serializable{

    
    private ArrayList<Tipodeudor> listaTipoDeudores;
    private Tipodeudor tipoDueudor, objTipoDeudorSel;
    
    
    public vmbTipodeudor() throws Exception {
        
        this.tipoDueudor= new Tipodeudor();
        this.loadtipos();
        
        
    }

    public ArrayList<Tipodeudor> getListaTipoDeudores() {
        return listaTipoDeudores;
    }

    public void setListaTipoDeudores(ArrayList<Tipodeudor> listaTipoDeudores) {
        this.listaTipoDeudores = listaTipoDeudores;
    }

    public Tipodeudor getTipoDueudor() {
        return tipoDueudor;
    }

    public void setTipoDueudor(Tipodeudor tipoDueudor) {
        this.tipoDueudor = tipoDueudor;
    }

    public Tipodeudor getObjTipoDeudorSel() {
        return objTipoDeudorSel;
    }

    public void setObjTipoDeudorSel(Tipodeudor objTipoDeudorSel) {
        this.objTipoDeudorSel = objTipoDeudorSel;
    }
    
    
    
    
    
    
    
    public void loadtipos() {
        try {
            this.listaTipoDeudores = dvrTipodeudor.getTipodeudorList();
        } catch (Exception ex) {
            MbsMessages.fatal(ex.getMessage());
        }
    }
    
    public void loadtipo(Tipodeudor tipo) {
        try {
            if (tipo != null) {
                this.objTipoDeudorSel = dvrTipodeudor.getTipodeudorById(tipo.getId());
                RequestContext.getCurrentInstance().update("frmEditTipo");
                RequestContext.getCurrentInstance().execute("PF('edittipo').show()");
            } else {
                MbsMessages.error("Seleccione un registro");
            }
        } catch (Exception ex) {
            MbsMessages.fatal(ex.getMessage());
        }
    }
    
    
    
     public void register() {
        try {
            int ban = dvrTipodeudor.tipodeudorRegister(this.tipoDueudor);
            if (ban != 0) {
                this.loadtipos();
                MbsMessages.info("Modo creado exitosamente!");
            } else {
                MbsMessages.error("No se pudo insertar el registro!");
            }
        } catch (Exception ex) {
            MbsMessages.fatal(ex.getMessage());
        }
    }

    public void update(Tipodeudor mp) {
        try {
            if (dvrTipodeudor.tipodeudorUpdate(mp)) {
                this.loadtipos();
                MbsMessages.info("Tipo Deudor actualizado correctamente!");
            } else {
                MbsMessages.error("No se pudo Actualizar el registro!");
            }
        } catch (Exception ex) {
            MbsMessages.fatal(ex.getMessage());
        }
    }

    public void delete(Tipodeudor tipo) {
        try {
            if (tipo != null) {
                if (dvrTipodeudor.tipodeudorDelete(tipo)) {
                    this.loadtipos();
                    MbsMessages.info("Tipo Deudor eliminado exitosamente!");
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
