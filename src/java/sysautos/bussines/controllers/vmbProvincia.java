/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sysautos.bussines.controllers;

import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.context.RequestContext;
import sysautos.bussines.drivers.dvrProvincia;
import sysautos.bussines.drivers.dvrPais;
import sysautos.bussines.entities.Provincia;
import sysautos.bussines.entities.Pais;
import sysautos.bussines.session.MbsMessages;

/**
 *
 * @author Carolyn
 */
@ManagedBean(name = "dtProvinciaView")
@ViewScoped
public final class vmbProvincia implements Serializable {

    private Provincia provincia;
    private Provincia provinciasel;
    private List<Provincia> provincias;
    private List<Pais> listaPais;
    private String selectprovincia;

    public vmbProvincia()throws Exception {
        this.provincia = new Provincia();
        this.loadprovincias();
    }

    public List<Provincia> getProvincias() {
        return provincias;
    }

    public void setProvincias(List<Provincia> provincias) {
        this.provincias = provincias;
    }

    public String getSelectprovincia() {
        return selectprovincia;
    }

    public void setSelectprovincia(String selectprovincia) {
        this.selectprovincia = selectprovincia;
    }

   
  
    public Provincia getProvincia() {
        return provincia;
    }

    public void setProvincia(Provincia provincia) {
        this.provincia = provincia;
    }

    public Provincia getProvinciasel() {
        return provinciasel;
    }

    public void setProvinciasel(Provincia provinciasel) {
        this.provinciasel = provinciasel;
    }

    public List<Provincia> getProvinciaes() {
        return provincias;
    }

    public void setProvinciaes(List<Provincia> provincias) {
        this.provincias = provincias;
    }

    public List<Pais> getListaPais() {
        return listaPais;
    }

    public void setListaPais(List<Pais> listaPais) {
        this.listaPais = listaPais;
    }

    
    public void loadprovincias() {
        try {
            this.provincias = dvrProvincia.getProvinciaList();
            this.listaPais = dvrPais.getPaisList();
        } catch (Exception ex) {
            MbsMessages.fatal(ex.getMessage());
        }
    }
    
    public void loadprovincia(Provincia tipo) {
        try {
            if (tipo != null) {
                this.provinciasel = dvrProvincia.getProvinciaById(tipo.getId());
                RequestContext.getCurrentInstance().update("frmEditProvincia");
                RequestContext.getCurrentInstance().execute("PF('editprovincia').show()");
            } else {
                MbsMessages.error("Seleccione un registro");
            }
        } catch (Exception ex) {
            MbsMessages.fatal(ex.getMessage());
        }
    }

    public void register() {
        try {
            int ban = dvrProvincia.provinciaRegister(this.provincia);
            if (ban != 0) {
                this.loadprovincias();
                MbsMessages.info("Provincia creado exitosamente!");
            } else {
                MbsMessages.error("No se pudo insertar el registro!");
            }
        } catch (Exception ex) {
            MbsMessages.fatal(ex.getMessage());
        }
    }

    public void update(Provincia cli) {
        try {
            if (dvrProvincia.provinciaUpdate(cli)) {
                this.loadprovincias();
                MbsMessages.info("Provincia actualizado correctamente!");
            } else {
                MbsMessages.error("No se pudo Actualizar el registro!");
            }
        } catch (Exception ex) {
            MbsMessages.fatal(ex.getMessage());
        }
    }

    public void delete(Provincia tipo) {
        try {
            if (tipo != null) {
                if (dvrProvincia.provinciaDelete(tipo)) {
                    this.loadprovincias();
                    MbsMessages.info("Provincia eliminado exitosamente!");
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
    
    public void cargarprovincias(){
        
        try {
           provincias = dvrProvincia.getProvinciaListByNamePais(selectprovincia);
//           System.out.println(selectprovincia);
//          for( Provincia valor:provincias){
//              System.out.println(valor.getId());
//              System.out.println(valor.getNombre());
//              System.out.println(valor.getPisid());
//              System.out.println(valor.getNombrepais());
//          }
        } catch (Exception ex) {
            Logger.getLogger(vmbProvincia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
  

}
