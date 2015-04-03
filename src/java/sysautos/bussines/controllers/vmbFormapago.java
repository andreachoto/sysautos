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
import sysautos.bussines.entities.Formapago;
import sysautos.bussines.drivers.dvrFormapago;
import sysautos.bussines.session.MbsMessages;

/**
 *
 * @author hp
 */
@ManagedBean(name = "dtFormapagoView")
@ViewScoped
public final class vmbFormapago implements Serializable {

    private Formapago formapago;
    private Formapago formapagosel;
    private List<Formapago> formapagos;

    /**
     * Creates a new instance of VmbFormapago
     *
     * @throws java.lang.Exception
     */
    // contructor
    public vmbFormapago() throws Exception {
        this.formapago = new Formapago();
        this.loadformapagos();
    }

    //getter an setter methods

    public Formapago getFormapago() {
        return formapago;
    }

    public void setFormapago(Formapago formapago) {
        this.formapago = formapago;
    }

    public Formapago getFormapagosel() {
        return formapagosel;
    }

    public void setFormapagosel(Formapago formapagosel) {
        this.formapagosel = formapagosel;
    }

    public List<Formapago> getFormapagos() {
        return formapagos;
    }

    public void setFormapagos(List<Formapago> formapagos) {
        this.formapagos = formapagos;
    }

    //businnes logical methods
    public void loadformapagos() {
        try {
            this.formapagos = dvrFormapago.getFormapagoList();
        } catch (Exception ex) {
            MbsMessages.fatal(ex.getMessage());
        }
    }

    public void loadformapago(Formapago forma) {
        try {
            if (forma != null) {
                this.formapagosel = dvrFormapago.getFormapagoById(forma.getId());
                RequestContext.getCurrentInstance().update("frmEditFormapago");
                RequestContext.getCurrentInstance().execute("PF('editformapago').show()");
            } else {
                MbsMessages.error("Seleccione un registro");
            }
        } catch (Exception ex) {
             MbsMessages.fatal(ex.getMessage());
        }

    }

    public void register() {
        try {
            int ban = dvrFormapago.formapagoRegister(this.formapago);
            if (ban != 0) {
                this.loadformapagos();
                MbsMessages.info("Tipo de Producto creado exitosamente!");
            }
        } catch (Exception ex) {
             MbsMessages.fatal(ex.getMessage());
        }

    }

    public void update(Formapago forma) {
        try {
            if (dvrFormapago.formapagoUpdate(forma)) {
                this.loadformapagos();
                MbsMessages.info("Tipo de Producto actualizado correctamente!");
            }
        } catch (Exception ex) {
            MbsMessages.fatal(ex.getMessage());
        }

    }
    public void delete(Formapago forma) {
        try {
             if (forma != null) {
                if (dvrFormapago.formapagoDelete(forma)) {
                this.loadformapagos();
                MbsMessages.info("Tipo de Producto eliminado correctamente!");
            }
            } else {
                MbsMessages.error("Seleccione un registro");
            }
            
        } catch (Exception ex) {
            MbsMessages.fatal(ex.getMessage());
        }
    }
}