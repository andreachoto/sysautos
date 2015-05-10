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
import sysautos.bussines.drivers.dvrTipoTelefono;
import sysautos.bussines.entities.TipoTelefono;
import sysautos.bussines.session.MbsMessages;

/**
 *
 * @author Carolyn
 */
@ManagedBean(name = "dtTipoTelefonoView")
@ViewScoped
public final class vmbTipoTelefono implements Serializable {

    private TipoTelefono tipoTelefono;
    private TipoTelefono tipoTelefonosel;
    private List<TipoTelefono> tipoTelefonos;

    public vmbTipoTelefono()throws Exception {
        this.tipoTelefono = new TipoTelefono();
        this.loadtipoTelefonos();
    }

    public TipoTelefono getTipoTelefono() {
        return tipoTelefono;
    }

    public void setTipoTelefono(TipoTelefono tipoTelefono) {
        this.tipoTelefono = tipoTelefono;
    }

    public TipoTelefono getTipoTelefonosel() {
        return tipoTelefonosel;
    }

    public void setTipoTelefonosel(TipoTelefono tipoTelefonosel) {
        this.tipoTelefonosel = tipoTelefonosel;
    }

    public List<TipoTelefono> getTipoTelefonos() {
        return tipoTelefonos;
    }

    public void setTipoTelefonos(List<TipoTelefono> tipoTelefonos) {
        this.tipoTelefonos = tipoTelefonos;
    }

    public void loadtipoTelefonos() {
        try {
            this.tipoTelefonos = dvrTipoTelefono.getTipoTelefonoList();
        } catch (Exception ex) {
            MbsMessages.fatal(ex.getMessage());
        }
    }
    
    public void loadtipoTelefono(TipoTelefono tipo) {
        try {
            if (tipo != null) {
                this.tipoTelefonosel = dvrTipoTelefono.getTipoTelefonoById(tipo.getId());
                RequestContext.getCurrentInstance().update("frmEditTipoTelefono");
                RequestContext.getCurrentInstance().execute("PF('edittipoTelefono').show()");
            } else {
                MbsMessages.error("Seleccione un registro");
            }
        } catch (Exception ex) {
            MbsMessages.fatal(ex.getMessage());
        }
    }

    public void register() {
        try {
            int ban = dvrTipoTelefono.tipoTelefonoRegister(this.tipoTelefono);
            if (ban != 0) {
                this.loadtipoTelefonos();
                MbsMessages.info("TipoTelefono creado exitosamente!");
            } else {
                MbsMessages.error("No se pudo insertar el registro!");
            }
        } catch (Exception ex) {
            MbsMessages.fatal(ex.getMessage());
        }
    }

    public void update(TipoTelefono cli) {
        try {
            if (dvrTipoTelefono.tipoTelefonoUpdate(cli)) {
                this.loadtipoTelefonos();
                MbsMessages.info("TipoTelefono actualizado correctamente!");
            } else {
                MbsMessages.error("No se pudo Actualizar el registro!");
            }
        } catch (Exception ex) {
            MbsMessages.fatal(ex.getMessage());
        }
    }

    public void delete(TipoTelefono tipo) {
        try {
            if (tipo != null) {
                if (dvrTipoTelefono.tipoTelefonoDelete(tipo)) {
                    this.loadtipoTelefonos();
                    MbsMessages.info("TipoTelefono eliminado exitosamente!");
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
