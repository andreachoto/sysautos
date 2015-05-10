/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sysautos.bussines.controllers;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.context.RequestContext;
import sysautos.bussines.drivers.dvrCiudad;
import sysautos.bussines.drivers.dvrCliente;
import sysautos.bussines.drivers.dvrDireccion;
import sysautos.bussines.drivers.dvrIdentificacion;
import sysautos.bussines.drivers.dvrPais;
import sysautos.bussines.drivers.dvrProvincia;
import sysautos.bussines.drivers.dvrTelefono;
import sysautos.bussines.drivers.dvrTipoDireccion;
import sysautos.bussines.drivers.dvrTipoIdentidad;
import sysautos.bussines.drivers.dvrTipoTelefono;
import sysautos.bussines.entities.Ciudad;
import sysautos.bussines.entities.Cliente;
import sysautos.bussines.entities.Direccion;
import sysautos.bussines.entities.Identificacion;
import sysautos.bussines.entities.Pais;
import sysautos.bussines.entities.Provincia;
import sysautos.bussines.entities.Telefono;
import sysautos.bussines.entities.TipoDireccion;
import sysautos.bussines.entities.TipoIdentidad;
import sysautos.bussines.entities.TipoTelefono;
import sysautos.bussines.session.MbsMessages;

/**
 *
 * @author Carolyn
 */
@ManagedBean(name = "dtClientView")
@ViewScoped

public class vmbClient implements Serializable {

    /**
     * Creates a new instance of vmbClient
     */
    private Cliente cliente;
    private List<TipoIdentidad> lsttipoidentidad;
    private Identificacion identidad;
    private List<Identificacion> lstIdentificacion;
    private List<TipoDireccion> lsttipodireccion;
    private List<Direccion> lstDireccion;
    private Direccion direccion;
    private List<Pais> lstPais;
    private List<Provincia> lstProvincia;
    private List<Ciudad> lstCiudad;
    private List<Telefono> lstTelefono;
    private Telefono telefono;
    private List<TipoTelefono> lsttipotelefono;
    private List<Cliente> lstCliente;
    private String selectpais;
    private String selectprovincia;
    private String selectciudad;
    private Identificacion identificacionsel;
//    private int cliid;

    public vmbClient() throws Exception {
        this.cliente = new Cliente();
        this.identidad = new Identificacion();
        this.direccion = new Direccion();
        this.telefono = new Telefono();
        this.lstIdentificacion = new ArrayList<>();
        this.lstDireccion = new ArrayList<>();
        this.lstTelefono = new ArrayList<>();
        this.lsttipoidentidad = dvrTipoIdentidad.gettipoIdentidadList();
        this.lsttipodireccion = dvrTipoDireccion.getTipoDireccionList();
        this.lstPais = dvrPais.getPaisList();
        this.lsttipotelefono = dvrTipoTelefono.getTipoTelefonoList();
        limpiar();
    }

    public Identificacion getIdentificacionsel() {
        return identificacionsel;
    }

    public void setIdentificacionsel(Identificacion identificacionsel) {
        this.identificacionsel = identificacionsel;
    }
    
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Identificacion getIdentidad() {
        return identidad;
    }

    public void setIdentidad(Identificacion identidad) {
        this.identidad = identidad;
    }

    public List<Identificacion> getLstIdentificacion() {
        return lstIdentificacion;
    }

    public void setLstIdentificacion(List<Identificacion> lstIdentificacion) {
        this.lstIdentificacion = lstIdentificacion;
    }

    public List<TipoIdentidad> getLsttipoidentidad() {
        return lsttipoidentidad;
    }

    public void setLsttipoidentidad(List<TipoIdentidad> lsttipoidentidad) {
        this.lsttipoidentidad = lsttipoidentidad;
    }

    public List<TipoDireccion> getLsttipodireccion() {
        return lsttipodireccion;
    }

    public void setLsttipodireccion(List<TipoDireccion> lsttipodireccion) {
        this.lsttipodireccion = lsttipodireccion;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    public List<Pais> getLstPais() {
        return lstPais;
    }

    public void setLstPais(List<Pais> lstPais) {
        this.lstPais = lstPais;
    }

    public List<Provincia> getLstProvincia() {
        return lstProvincia;
    }

    public void setLstProvincia(List<Provincia> lstProvincia) {
        this.lstProvincia = lstProvincia;
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

    public List<Ciudad> getLstCiudad() {
        return lstCiudad;
    }

    public void setLstCiudad(List<Ciudad> lstCiudad) {
        this.lstCiudad = lstCiudad;
    }

    public List<Direccion> getLstDireccion() {
        return lstDireccion;
    }

    public void setLstDireccion(List<Direccion> lstDireccion) {
        this.lstDireccion = lstDireccion;
    }

    public List<Telefono> getLstTelefono() {
        return lstTelefono;
    }

    public void setLstTelefono(List<Telefono> lstTelefono) {
        this.lstTelefono = lstTelefono;
    }

    public Telefono getTelefono() {
        return telefono;
    }

    public void setTelefono(Telefono telefono) {
        this.telefono = telefono;
    }

    public List<TipoTelefono> getLsttipotelefono() {
        return lsttipotelefono;
    }

    public void setLsttipotelefono(List<TipoTelefono> lsttipotelefono) {
        this.lsttipotelefono = lsttipotelefono;
    }

    public void loadclientes() {
        try {
            this.lstCliente = dvrCliente.getClienteList();
        } catch (Exception ex) {
            MbsMessages.fatal(ex.getMessage());
        }
    }

    //Metodos complementa la logica del negocio
    public void register() {
        try {
            //if (this.cliente != null) {
            //}
            //llamada a validacion llamada a insertar

            int cliid = dvrCliente.clienteRegister(this.cliente);
            if (cliid != 0) {
                // llamadas a inserta de la tablas hijas
                for (Identificacion identif : lstIdentificacion) {
                    identif.setCltid(cliid);
                    dvrIdentificacion.identificacionRegister(identif);
                }
                for (Direccion direcc : lstDireccion) {
                    direcc.setCltid(cliid);
                    dvrDireccion.direccionRegister(direcc);
                }
                for (Telefono telf : lstTelefono) {
                    telf.setCltid(cliid);
                    dvrTelefono.telefonoRegister(telf);
                }
                MbsMessages.info("Registro existosamente");
            }
        } catch (Exception ex) {
            MbsMessages.error("Error:" + ex.getMessage());
        }
    }

    public void update(Cliente cli) {
        try {
            if (dvrCliente.clienteUpdate(cli)) {
                for (Identificacion identif : lstIdentificacion) {
//                    identif.setCltid(cliid);
//                    identif=dvrIdentificacion.getidentificacionByIdCliente(cliid);
                    lstIdentificacion.add(identif);
                }
                this.loadclientes();
                MbsMessages.info("Cliente actualizado correctamente!");
            } else {
                MbsMessages.error("No se pudo Actualizar el registro!");
            }
        } catch (Exception ex) {
            MbsMessages.fatal(ex.getMessage());
        }
    }

    public void addIdentificacionToList() {
        try {
            Identificacion ident = new Identificacion(this.identidad.getCltid(), this.identidad.getTidid(),
                    this.identidad.getNumdescripcion(), this.identidad.getEstado());
            lstIdentificacion.add(ident);
            limpiar();
            RequestContext.getCurrentInstance().update("frmCliente:tbvcliente");
//                RequestContext.getCurrentInstance().execute("PF('tblidentificacion').show()");
        } catch (Exception e) {
            MbsMessages.error("Error: " + e.getMessage());
        }
    }

    public void addDireccionToList() {
        try {
            //refencia al constructor de la clase
            Direccion direc = new Direccion(this.direccion.getCltid(), this.direccion.getTdrid(), this.direccion.getCidid(),
                    this.direccion.getCalleprincipal(), this.direccion.getCallesecundaria(), this.direccion.getNumcasa(),
                    this.direccion.getParroquia(), this.direccion.getReferencia(), this.direccion.getBarrio(), this.direccion.getSector());
            lstDireccion.add(direc);
            limpiar();
        } catch (Exception e) {
            MbsMessages.error("Error: " + e.getMessage());
        }
    }

    public void addTelefonoToList() {
        try {
            //refencia al constructor de la clase
            Telefono telf = new Telefono(this.telefono.getId(), this.telefono.getCltid(), this.telefono.getTtfid(),
                    this.telefono.getNumero(), this.telefono.getOperadora(), this.telefono.getEstado());
            lstTelefono.add(telf);
            limpiar();
        } catch (Exception e) {
            MbsMessages.error("Error: " + e.getMessage());
        }
    }

    public void cargarprovincias() {

        try {
            lstProvincia = dvrProvincia.getProvinciaListByNamePais(selectpais);
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
            lstCiudad = dvrCiudad.getCiudadListByNameProvincia(selectprovincia);
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

    public void limpiar() {
        cliente = new Cliente();
        direccion = new Direccion();
        identidad = new Identificacion();
        telefono = new Telefono();
        selectpais = "";
        selectprovincia = "";
        selectciudad = "";
//        lstIdentificacion.clear();
//        lstTelefono.clear();
//        lstDireccion.clear();

    }
       public void limpiarlistas() {
        cliente = new Cliente();
        lstIdentificacion.clear();
        lstTelefono.clear();
        lstDireccion.clear();

    }
    
    

    public void delete(int id) {
        try {
            if (id != 0) {
                this.identificacionsel = dvrIdentificacion.getidentificacionByIdTipoIdent(id);
                  for (Identificacion identif : lstIdentificacion) {
                      if(identif.getTidid()== identificacionsel.getTidid() ){
                          lstIdentificacion.remove(id);
                      }
                }
                    MbsMessages.info("Identificación eliminada correctamente!");
                } else {
                    MbsMessages.error("Seleccione un registro");
                }

            }catch (Exception ex) {
            MbsMessages.fatal(ex.getMessage());
        }

        }

    }
