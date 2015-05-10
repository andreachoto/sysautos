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
import sysautos.bussines.drivers.dvrCiudad;
import sysautos.bussines.drivers.dvrProvincia;
import sysautos.bussines.entities.Ciudad;
import sysautos.bussines.entities.Provincia;
import sysautos.bussines.session.MbsMessages;

/**
 *
 * @author Carolyn
 */
@ManagedBean(name = "dtCiudadView")
@ViewScoped
public final class vmbCuidad implements Serializable {

    private Ciudad ciudad;
    private Ciudad ciudadsel;
    private List<Ciudad> ciudades;
    private List<Provincia> listaProvincia;

    public vmbCuidad()throws Exception {
        this.ciudad = new Ciudad();
        this.loadciudades();
    }

    public Ciudad getCiudad() {
        return ciudad;
    }

    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
    }

    public Ciudad getCiudadsel() {
        return ciudadsel;
    }

    public void setCiudadsel(Ciudad ciudadsel) {
        this.ciudadsel = ciudadsel;
    }

    public List<Ciudad> getCiudades() {
        return ciudades;
    }

    public void setCiudades(List<Ciudad> ciudades) {
        this.ciudades = ciudades;
    }

    public List<Provincia> getListaProvincia() {
        return listaProvincia;
    }

    public void setListaProvincia(List<Provincia> listaProvincia) {
        this.listaProvincia = listaProvincia;
    }

    
    public void loadciudades() {
        try {
            this.ciudades = dvrCiudad.getCiudadList();
            this.listaProvincia = dvrProvincia.getProvinciaList();
        } catch (Exception ex) {
            MbsMessages.fatal(ex.getMessage());
        }
    }
    
    public void loadciudad(Ciudad tipo) {
        try {
            if (tipo != null) {
                this.ciudadsel = dvrCiudad.getCiudadById(tipo.getId());
                RequestContext.getCurrentInstance().update("frmEditCiudad");
                RequestContext.getCurrentInstance().execute("PF('editciudad').show()");
            } else {
                MbsMessages.error("Seleccione un registro");
            }
        } catch (Exception ex) {
            MbsMessages.fatal(ex.getMessage());
        }
    }

    public void register() {
        try {
            int ban = dvrCiudad.ciudadRegister(this.ciudad);
            if (ban != 0) {
                this.loadciudades();
                MbsMessages.info("Ciudad creado exitosamente!");
            } else {
                MbsMessages.error("No se pudo insertar el registro!");
            }
        } catch (Exception ex) {
            MbsMessages.fatal(ex.getMessage());
        }
    }

    public void update(Ciudad cli) {
        try {
            if (dvrCiudad.ciudadUpdate(cli)) {
                this.loadciudades();
                MbsMessages.info("Ciudad actualizado correctamente!");
            } else {
                MbsMessages.error("No se pudo Actualizar el registro!");
            }
        } catch (Exception ex) {
            MbsMessages.fatal(ex.getMessage());
        }
    }

    public void delete(Ciudad tipo) {
        try {
            if (tipo != null) {
                if (dvrCiudad.ciudadDelete(tipo)) {
                    this.loadciudades();
                    MbsMessages.info("Ciudad eliminado exitosamente!");
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
