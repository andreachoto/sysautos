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
import sysautos.bussines.drivers.dvrCiudad;
import sysautos.bussines.drivers.dvrCliente;
import sysautos.bussines.drivers.dvrDireccion;
import sysautos.bussines.drivers.dvrPais;
import sysautos.bussines.drivers.dvrProvincia;
import sysautos.bussines.drivers.dvrTipoDireccion;
import sysautos.bussines.entities.Cliente;
import sysautos.bussines.entities.Ciudad;
import sysautos.bussines.entities.Direccion;
import sysautos.bussines.entities.Pais;
import sysautos.bussines.entities.Provincia;
import sysautos.bussines.entities.TipoDireccion;
import sysautos.bussines.session.MbsMessages;

/**
 *
 * @author Carolyn
 */
@ManagedBean(name = "dtDireccionView")
@ViewScoped
public final class vmbDireccion implements Serializable {

    private Direccion direccion;
    private Direccion direccionsel;
    private List<Direccion> direccions;
    private List<Pais> listaPais;
    private List<Provincia> listaProvincia;
    private List<Ciudad> listaCiudad;
    private List<TipoDireccion> listaTipoDireccion;
    private String selectpais;
    private String selectprovincia;
    private String selectciudad;
    private List<Cliente> listaCliente;

    public vmbDireccion() throws Exception {
        this.direccion = new Direccion();
        this.loaddireccions();
    }

    public String getSelectpais() {
        return selectpais;
    }

    public void setSelectpais(String selectpais) {
        this.selectpais = selectpais;
    }
    
    
    public String getSelectprovincia() {
        return selectprovincia;
    }

    public void setSelectprovincia(String selectprovincia) {
        this.selectprovincia = selectprovincia;
    }

    public String getSelectciudad() {
        return selectciudad;
    }

    public void setSelectciudad(String selectciudad) {
        this.selectciudad = selectciudad;
    }

    public List<Pais> getListaPais() {
        return listaPais;
    }

    public void setListaPais(List<Pais> listaPais) {
        this.listaPais = listaPais;
    }

    public List<Provincia> getListaProvincia() {
        return listaProvincia;
    }

    public void setListaProvincia(List<Provincia> listaProvincia) {
        this.listaProvincia = listaProvincia;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    public Direccion getDireccionsel() {
        return direccionsel;
    }

    public void setDireccionsel(Direccion direccionsel) {
        this.direccionsel = direccionsel;
    }

    public List<Direccion> getDireccions() {
        return direccions;
    }

    public void setDireccions(List<Direccion> direccions) {
        this.direccions = direccions;
    }

    public List<Ciudad> getListaCiudad() {
        return listaCiudad;
    }

    public void setListaCiudad(List<Ciudad> listaCiudad) {
        this.listaCiudad = listaCiudad;
    }

    public List<Cliente> getListaCliente() {
        return listaCliente;
    }

    public void setListaCliente(List<Cliente> listaCliente) {
        this.listaCliente = listaCliente;
    }

    public List<TipoDireccion> getListaTipoDireccion() {
        return listaTipoDireccion;
    }

    public void setListaTipoDireccion(List<TipoDireccion> listaTipoDireccion) {
        this.listaTipoDireccion = listaTipoDireccion;
    }

    public void loaddireccions() {
        try {
            this.direccions = dvrDireccion.getDireccionList();
            this.listaCliente = dvrCliente.getClienteList();
            this.listaTipoDireccion = dvrTipoDireccion.getTipoDireccionList();
            this.listaPais = dvrPais.getPaisList();
//            this.listaCiudad = dvrCiudad.getCiudadList();
           
        } catch (Exception ex) {
            MbsMessages.fatal(ex.getMessage());
        }
    }

    public void loaddireccion(Direccion tipo) {
        try {
            if (tipo != null) {
                this.direccionsel = dvrDireccion.getDireccionById(tipo.getCltid(), tipo.getTdrid());
                RequestContext.getCurrentInstance().update("frmDireccion");
                RequestContext.getCurrentInstance().execute("PF('editdireccion').show()");
            } else {
                MbsMessages.error("Seleccione un registro");
            }
        } catch (Exception ex) {
            MbsMessages.fatal(ex.getMessage());
        }
    }

    public void register() {
        try {
            boolean b = (dvrDireccion.direccionRegister(this.direccion));
            int ban = b ? 1 : 0;
            if (ban != 0) {
                this.loaddireccions();
                MbsMessages.info("Cliente creado exitosamente!");
            } else {
                MbsMessages.error("No se pudo insertar el registro!");
            }
        } catch (Exception ex) {
            MbsMessages.fatal(ex.getMessage());
        }
    }

    public void update(Direccion cli) {
        try {
            if (dvrDireccion.direccionUpdate(cli)) {
                this.loaddireccions();
                MbsMessages.info("Direccion actualizado correctamente!");
            } else {
                MbsMessages.error("No se pudo Actualizar el registro!");
            }
        } catch (Exception ex) {
            MbsMessages.fatal(ex.getMessage());
        }
    }

    public void delete(Direccion tipo) {
        try {
            if (tipo != null) {
                if (dvrDireccion.direccionDelete(tipo)) {
                    this.loaddireccions();
                    MbsMessages.info("Direccion eliminado exitosamente!");
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

    public void cargarprovincias() {

        try {
            listaProvincia = dvrProvincia.getProvinciaListByNamePais(selectpais);
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

    public void cargarcuidades() {

        try {
            listaCiudad = dvrCiudad.getCiudadListByNameProvincia(selectprovincia);
//                 System.out.println(selectprovincia);
//          for( Ciudad valor:listaCiudad){
//              System.out.println(valor.getId());
//              System.out.println(valor.getNombre());
//              System.out.println(valor.getPrvid());
//              System.out.println(valor.getNombreprovincia());
//          }
            

        } catch (Exception ex) {
            Logger.getLogger(vmbProvincia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
