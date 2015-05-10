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
import sysautos.bussines.drivers.dvrIdentificacion;
import sysautos.bussines.drivers.dvrTipoIdentidad;
import sysautos.bussines.entities.Cliente;
import sysautos.bussines.entities.Identificacion;
import sysautos.bussines.entities.TipoIdentidad;
import sysautos.bussines.session.MbsMessages;

/**
 *
 * @author Carolyn
 */
@ManagedBean(name = "dtIdentificacionView")
@ViewScoped
public final class vmbIdentificacion implements Serializable {

    private Identificacion identificacion;
    private Identificacion identificacionsel;
    private List<Identificacion> identificacions;
    private List<TipoIdentidad> listaTipoIdentidad;
    private List<Cliente> listaCliente;

    public vmbIdentificacion()throws Exception {
        this.identificacion = new Identificacion();
        this.loadidentificacions();
    }

    public List<Cliente> getListaCliente() {
        return listaCliente;
    }

    public void setListaCliente(List<Cliente> listaCliente) {
        this.listaCliente = listaCliente;
    }

    public List<TipoIdentidad> getListaTipoIdentidad() {
        return listaTipoIdentidad;
    }

    public void setListaTipoIdentidad(List<TipoIdentidad> listaTipoIdentidad) {
        this.listaTipoIdentidad = listaTipoIdentidad;
    }
    
    
    public Identificacion getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(Identificacion identificacion) {
        this.identificacion = identificacion;
    }

    public Identificacion getIdentificacionsel() {
        return identificacionsel;
    }

    public void setIdentificacionsel(Identificacion identificacionsel) {
        this.identificacionsel = identificacionsel;
    }

    public List<Identificacion> getIdentificacions() {
        return identificacions;
    }

    public void setIdentificacions(List<Identificacion> identificacions) {
        this.identificacions = identificacions;
    }

    public void loadidentificacions() {
        try {
            this.identificacions = dvrIdentificacion.getidentificacionList();
            this.listaCliente = dvrCliente.getClienteList();
            this.listaTipoIdentidad = dvrTipoIdentidad.gettipoIdentidadList();
        } catch (Exception ex) {
            MbsMessages.fatal(ex.getMessage());
        }
    }
    
      public void loadidentificacion(Identificacion tipo) {
        try {
            if (tipo != null) {
                this.identificacionsel = dvrIdentificacion.getidentificacionById(tipo.getCltid(),tipo.getTidid());
                RequestContext.getCurrentInstance().update("frmEditCliente");
                RequestContext.getCurrentInstance().execute("PF('editcliente').show()");
            } else {
                MbsMessages.error("Seleccione un registro");
            }
        } catch (Exception ex) {
            MbsMessages.fatal(ex.getMessage());
        }
    }

       public void register() {
        try {
            boolean b=(dvrIdentificacion.identificacionRegister(this.identificacion));
            int ban =  b ? 1 : 0;
            if (ban != 0) {
                this.loadidentificacions();
                MbsMessages.info("Cliente creado exitosamente!");
            } else {
                MbsMessages.error("No se pudo insertar el registro!");
            }
        } catch (Exception ex) {
            MbsMessages.fatal(ex.getMessage());
        }
    }

    public void update(Identificacion cli) {
        try {
            if (dvrIdentificacion.identificacionUpdate(cli)) {
                this.loadidentificacions();
                MbsMessages.info("Identificacion actualizado correctamente!");
            } else {
                MbsMessages.error("No se pudo Actualizar el registro!");
            }
        } catch (Exception ex) {
            MbsMessages.fatal(ex.getMessage());
        }
    }

   public void delete(int id) {
        try {
             if (id != 0) {
                this.identificacionsel = dvrIdentificacion.getidentificacionByIdTipoIdent(id);
                if (dvrIdentificacion.identificacionDelete(this.identificacionsel)) {
                this.loadidentificacions();
                MbsMessages.info("Rol eliminado correctamente!");
            }
            } else {
                MbsMessages.error("Seleccione un registro");
            }
            
        } catch (Exception ex) {
            MbsMessages.fatal(ex.getMessage());
        }

    }

}
