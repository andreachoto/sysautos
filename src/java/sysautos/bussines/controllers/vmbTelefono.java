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
import sysautos.bussines.drivers.dvrCliente;
import sysautos.bussines.drivers.dvrTelefono;
import sysautos.bussines.drivers.dvrTipoTelefono;
import sysautos.bussines.entities.Cliente;
import sysautos.bussines.entities.Telefono;
import sysautos.bussines.entities.TipoTelefono;
import sysautos.bussines.session.MbsMessages;

/**
 *
 * @author Carolyn
 */
@ManagedBean(name = "dtTelefonoView")
@ViewScoped
public final class vmbTelefono implements Serializable {

    private Telefono telefono;
    private Telefono telefonosel;
    private List<Telefono> telefonos;
    private List<Cliente> listaCliente;
    private List<TipoTelefono> listaTipoTelefono;

    public vmbTelefono()throws Exception {
        this.telefono = new Telefono();
        this.telefonosel= new Telefono();
        this.loadtelefonos();
        this.listaCliente = dvrCliente.getClienteList();
        this.listaTipoTelefono = dvrTipoTelefono.getTipoTelefonoList();
    }

    public Telefono getTelefono() {
        return telefono;
    }

    public void setTelefono(Telefono telefono) {
        this.telefono = telefono;
    }

    public Telefono getTelefonosel() {
        return telefonosel;
    }

    public void setTelefonosel(Telefono telefonosel) {
        this.telefonosel = telefonosel;
    }

    public List<Telefono> getTelefonos() {
        return telefonos;
    }

    public void setTelefonos(List<Telefono> telefonos) {
        this.telefonos = telefonos;
    }

    public List<Cliente> getListaCliente() {
        return listaCliente;
    }

    public void setListaCliente(List<Cliente> listaCliente) {
        this.listaCliente = listaCliente;
    }

    public List<TipoTelefono> getListaTipoTelefono() {
        return listaTipoTelefono;
    }

    public void setListaTipoTelefono(List<TipoTelefono> listaTipoTelefono) {
        this.listaTipoTelefono = listaTipoTelefono;
    }
    
        public void loadtelefonos() {
        try {
            this.telefonos = dvrTelefono.getTelefonoList();
            
        } catch (Exception ex) {
            MbsMessages.fatal(ex.getMessage());
        }
    }
       
    
    public void loadtelefono(Telefono tipo) {
        try {
            if (tipo != null) {
                this.telefonosel = dvrTelefono.getTelefonoById(tipo.getId());
                RequestContext.getCurrentInstance().update("frmEditTelefono");
                RequestContext.getCurrentInstance().execute("PF('edittelefono').show()");
            } else {
                MbsMessages.error("Seleccione un registro");
            }
        } catch (Exception ex) {
            MbsMessages.fatal(ex.getMessage());
        }
    }

    public void register() {
        try {
            int ban = dvrTelefono.telefonoRegister(this.telefono);
            if (ban != 0) {
                this.loadtelefonos();
                MbsMessages.info("Telefono creado exitosamente!");
            } else {
                MbsMessages.error("No se pudo insertar el registro!");
            }
        } catch (Exception ex) {
            MbsMessages.fatal(ex.getMessage());
        }
    }

    public void update(Telefono cli) {
        try {
            if (dvrTelefono.telefonoUpdate(cli)) {
                this.loadtelefonos();
                MbsMessages.info("Telefono actualizado correctamente!");
            } else {
                MbsMessages.error("No se pudo Actualizar el registro!");
            }
        } catch (Exception ex) {
            MbsMessages.fatal(ex.getMessage());
        }
    }

    public void delete(Telefono tipo) {
        try {
            if (tipo != null) {
                if (dvrTelefono.telefonoDelete(tipo)) {
                    this.loadtelefonos();
                    MbsMessages.info("Telefono eliminado exitosamente!");
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
