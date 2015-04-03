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
import sysautos.bussines.entities.Tipoproducto;
import sysautos.bussines.drivers.dvrTipoproducto;
import sysautos.bussines.session.MbsMessages;

/**
 *
 * @author hp
 */
@ManagedBean(name = "dtTipoproductoView")
@ViewScoped
public final class vmbTipoproducto implements Serializable {

    private Tipoproducto tipoproducto;
    private Tipoproducto tipoproductosel;
    private List<Tipoproducto> tipoproductos;

    /**
     * Creates a new instance of VmbTipoproducto
     *
     * @throws java.lang.Exception
     */
    // contructor
    public vmbTipoproducto() throws Exception {
        this.tipoproducto = new Tipoproducto();
        this.loadtipoproductos();
    }

    //getter an setter methods
    public Tipoproducto getTipoproducto() {
        return tipoproducto;
    }

    public void setTipoproducto(Tipoproducto tipoproducto) {
        this.tipoproducto = tipoproducto;
    }

    public Tipoproducto getTipoproductosel() {
        return tipoproductosel;
    }

    public void setTipoproductosel(Tipoproducto tipoproductosel) {
        this.tipoproductosel = tipoproductosel;
    }

    public List<Tipoproducto> getTipoproductos() {
        return tipoproductos;
    }

    public void setTipoproductos(List<Tipoproducto> tipoproductos) {
        this.tipoproductos = tipoproductos;
    }
    

    //businnes logical methods
    public void loadtipoproductos() {
        try {
            this.tipoproductos = dvrTipoproducto.getTipoproductoList();
        } catch (Exception ex) {
            MbsMessages.fatal(ex.getMessage());
        }
    }

    public void loadtipoproducto(Tipoproducto tipo) {
        try {
            if (tipo != null) {
                this.tipoproductosel = dvrTipoproducto.getTipoproductoById(tipo.getId());
                RequestContext.getCurrentInstance().update("frmEditTipoproducto");
                RequestContext.getCurrentInstance().execute("PF('edittipoproducto').show()");
            } else {
                MbsMessages.error("Seleccione un registro");
            }
        } catch (Exception ex) {
             MbsMessages.fatal(ex.getMessage());
        }

    }

    public void register() {
        try {
            int ban = dvrTipoproducto.tipoproductoRegister(this.tipoproducto);
            if (ban != 0) {
                this.loadtipoproductos();
                MbsMessages.info("Tipo de Producto creado exitosamente!");
            }
        } catch (Exception ex) {
             MbsMessages.fatal(ex.getMessage());
        }

    }

    public void update(Tipoproducto tipoproducto) {
        try {
            if (dvrTipoproducto.tipoproductoUpdate(tipoproducto)) {
                this.loadtipoproductos();
                MbsMessages.info("Tipo de Producto actualizado correctamente!");
            }
        } catch (Exception ex) {
            MbsMessages.fatal(ex.getMessage());
        }

    }
    public void delete(Tipoproducto tipo) {
        try {
             if (tipo != null) {
                if (dvrTipoproducto.tipoproductoDelete(tipo)) {
                this.loadtipoproductos();
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