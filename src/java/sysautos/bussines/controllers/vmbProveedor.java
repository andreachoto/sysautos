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
import sysautos.bussines.entities.Proveedor;
import sysautos.bussines.drivers.dvrProveedor;
import sysautos.bussines.session.MbsMessages;

/**
 *
 * @author hp
 */
@ManagedBean(name = "dtProveedorView")
@ViewScoped
public final class vmbProveedor implements Serializable {

    private Proveedor proveedor;
    private Proveedor proveedorsel;
    private List<Proveedor> proveedores;

    // contructor
    public vmbProveedor() throws Exception {
        this.proveedor = new Proveedor();
        this.loadproveedores();
    }

    //getter an setter methods
    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public Proveedor getProveedorsel() {
        return proveedorsel;
    }

    public void setProveedorsel(Proveedor proveedorsel) {
        this.proveedorsel = proveedorsel;
    }

    public List<Proveedor> getProveedores() {
        return proveedores;
    }

    public void setProveedores(List<Proveedor> proveedores) {
        this.proveedores = proveedores;
    }
    
    //businnes logical methods
    public void loadproveedores() {
        try {
            this.proveedores = dvrProveedor.getProveedorList();
        } catch (Exception ex) {
            MbsMessages.fatal(ex.getMessage());
        }
    }

    public void loadproveedor(Proveedor tipo) {
        try {
            if (tipo != null) {
                this.proveedorsel = dvrProveedor.getProveedorById(tipo.getId());
                RequestContext.getCurrentInstance().update("frmEditProveedor");
                RequestContext.getCurrentInstance().execute("PF('editproveedor').show()");
            } else {
                MbsMessages.error("Seleccione un registro");
            }
        } catch (Exception ex) {
            MbsMessages.fatal(ex.getMessage());
        }
    }

    public void register() {
        try {
            int ban = dvrProveedor.proveedorRegister(this.proveedor);
            if (ban != 0) {
                this.loadproveedores();
                MbsMessages.info("Proveedor creado exitosamente!");
            } else {
                MbsMessages.error("No se pudo insertar el registro!");
            }
        } catch (Exception ex) {
            MbsMessages.fatal(ex.getMessage());
        }
    }

    public void update(Proveedor proveedor) {
        try {
            if (dvrProveedor.proveedorUpdate(proveedor)) {
                this.loadproveedores();
                MbsMessages.info("Proveedor actualizado correctamente!");
            } else {
                MbsMessages.error("No se pudo Actualizar el registro!");
            }
        } catch (Exception ex) {
            MbsMessages.fatal(ex.getMessage());
        }
    }

    public void delete(Proveedor tipo) {
        try {
            if (tipo != null) {
                if (dvrProveedor.proveedorDelete(tipo)) {
                    this.loadproveedores();
                    MbsMessages.info("Proveedor eliminado exitosamente!");
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
