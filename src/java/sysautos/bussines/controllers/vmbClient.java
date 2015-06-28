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
    private Cliente cliente, clientesel;
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
    private Telefono telefono, telefonosel;
    private List<TipoTelefono> lsttipotelefono;
    private List<Cliente> lstCliente;
    private String selectpais;
    private String selectprovincia;
    private String selectciudad;
    private Identificacion identificacionsel;
    private Direccion direccionsel;
    private ArrayList<Integer> selecidentificacion;
    private ArrayList<Integer> selecdireccion;
    private ArrayList<Integer> selectelefono;


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
        this.direccionsel = new Direccion();
        this.identificacionsel = new Identificacion();
        this.telefonosel = new Telefono();
        this.lstCliente = dvrCliente.getClienteList();
        this.clientesel = new Cliente();
        this.selecidentificacion = new ArrayList<>();
        this.selecdireccion = new ArrayList<>();
        this.selectelefono = new ArrayList<>();
        limpiar();
    }

    public Cliente getClientesel() {
        return clientesel;
    }

    public void setClientesel(Cliente clientesel) {
        this.clientesel = clientesel;
    }

    public Telefono getTelefonosel() {
        return telefonosel;
    }

    public void setTelefonosel(Telefono telefonosel) {
        this.telefonosel = telefonosel;
    }

    public List<Cliente> getLstCliente() {
        return lstCliente;
    }

    public void setLstCliente(List<Cliente> lstCliente) {
        this.lstCliente = lstCliente;
    }

    public Direccion getDireccionsel() {
        return direccionsel;
    }

    public void setDireccionsel(Direccion direccionsel) {
        this.direccionsel = direccionsel;
    }

    public ArrayList<Integer> getSelecidentificacion() {
        return selecidentificacion;
    }

    public void setSelecidentificacion(ArrayList<Integer> selecidentificacion) {
        this.selecidentificacion = selecidentificacion;
    }

    public ArrayList<Integer> getSelecdireccion() {
        return selecdireccion;
    }

    public void setSelecdireccion(ArrayList<Integer> selecdireccion) {
        this.selecdireccion = selecdireccion;
    }

    public ArrayList<Integer> getSelectelefono() {
        return selectelefono;
    }

    public void setSelectelefono(ArrayList<Integer> selectelefono) {
        this.selectelefono = selectelefono;
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
                this.loadclientes();
                this.updateIdentificacion(identificacionsel);
                this.updateDireccion(direccionsel);
                this.updateTelefono(telefonosel);
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

//    public void delete(int id) {
//        try {
//            if (id != 0) {
//                this.identificacionsel = dvrIdentificacion.getidentificacionByIdTipoIdent(id);
//                for (Identificacion identif : lstIdentificacion) {
//                    if (identif.getTidid() == identificacionsel.getTidid()) {
//                        lstIdentificacion.remove(id);
//                    }
//                }
//                MbsMessages.info("Identificación eliminada correctamente!");
//            } else {
//                MbsMessages.error("Seleccione un registro");
//            }
//
//        } catch (Exception ex) {
//            MbsMessages.fatal(ex.getMessage());
//        }
//
//    }
    public void deleteIdentificacion(int id) {
        try {
            if (id != 0) {

                for (int x = 0; x < lstIdentificacion.size(); x++) {
                    identificacionsel.setTidid(id);
                    lstIdentificacion.remove(identificacionsel);
                    limpiar();
                }
                MbsMessages.info("Identificación eliminada Correctamente!");
            } else {
                MbsMessages.error("Seleccione un registro");
            }

        } catch (Exception ex) {
            MbsMessages.fatal(ex.getMessage());
        }

    }

    public void deletedireccion(int id) {
        try {

            if (id != 0) {
                for (int x = 0; x < lstDireccion.size(); x++) {
                    direccionsel.setTdrid(id);
                    lstDireccion.remove(direccionsel);
                    limpiar();
                }
                MbsMessages.info("Dirección eliminada Correctamente!");
            } else {
                MbsMessages.error("Seleccione un registro");
            }

        } catch (Exception ex) {
            MbsMessages.fatal(ex.getMessage());
        }

    }

    public void deletetelefono(int idi) {
        try {
            if (idi != 0) {
                for (int x = 0; x < lstTelefono.size(); x++) {
                    telefonosel.setTtfid(idi);
                    lstTelefono.remove(telefonosel);
                    limpiar();
                }
                MbsMessages.info("Teléfono eliminado Correctamente!");
            } else {
                MbsMessages.error("Seleccione un registro");
            }

        } catch (Exception ex) {
            MbsMessages.fatal(ex.getMessage());
        }

    }

    public void verdireccion(int tipo) {
        try {
            if (tipo != 0) {
                this.direccionsel.setTdrid(tipo);
                RequestContext.getCurrentInstance().update("frmVerDireccion");
                RequestContext.getCurrentInstance().execute("PF('verdireccion').show()");
            } else {
                MbsMessages.error("Seleccione un registro");
            }
        } catch (Exception ex) {
            MbsMessages.fatal(ex.getMessage());
        }
    }

    public void cargaeditdireccion(int tipo) {
        try {
            if (tipo != 0) {
                this.direccionsel.setTdrid(tipo);
                RequestContext.getCurrentInstance().update("frmEditDireccion");
                RequestContext.getCurrentInstance().execute("PF('editdireccion').show()");
            } else {
                MbsMessages.error("Seleccione un registro");
            }
        } catch (Exception ex) {
            MbsMessages.fatal(ex.getMessage());
        }
    }

    public void updateDireccion(Direccion direc) {
        try {
            if (dvrDireccion.direccionUpdate(direc)) {
                this.addDireccionToList();
                MbsMessages.info(" Dirección actualizado correctamente!");
            } else {
                MbsMessages.error("No se pudo Actualizar el registro!");
            }
        } catch (Exception ex) {
            MbsMessages.fatal(ex.getMessage());
        }
    }

    public void cargaedittelefono(int tipotelf) {
        try {
            if (tipotelf != 0) {
                this.telefonosel.setTtfid(tipotelf);
                RequestContext.getCurrentInstance().update("frmEditTelefono");
                RequestContext.getCurrentInstance().execute("PF('edittelefono').show()");
            } else {
                MbsMessages.error("Seleccione un registro");
            }
        } catch (Exception ex) {
            MbsMessages.fatal(ex.getMessage());
        }
    }

    public void updateTelefono(Telefono telf) {
        try {
            if (dvrTelefono.telefonoUpdate(telf)) {
                MbsMessages.info("Teléfono actualizado correctamente!");
            } else {
                MbsMessages.error("No se pudo Actualizar el registro!");
            }
        } catch (Exception ex) {
            MbsMessages.fatal(ex.getMessage());
        }
    }

    public void cargaeditidentificacion(int tipoident) {
        try {
            if (tipoident != 0) {
                this.identificacionsel.setTidid(tipoident);
                RequestContext.getCurrentInstance().update("frmEditIdentificacion");
                RequestContext.getCurrentInstance().execute("PF('editidentificacion').show()");
            } else {
                MbsMessages.error("Seleccione un registro");
            }
        } catch (Exception ex) {
            MbsMessages.fatal(ex.getMessage());
        }
    }

    public void updateIdentificacion(Identificacion ident) {
        try {
            if (dvrIdentificacion.identificacionUpdate(ident)) {
                MbsMessages.info("Identificación actualizado correctamente!");
            } else {
                MbsMessages.error("No se pudo Actualizar el registro!");
            }
        } catch (Exception ex) {
            MbsMessages.fatal(ex.getMessage());
        }
    }

    public void cargarvercliente(int tipo) {
        try {
            if (tipo != 0) {
                this.clientesel = dvrCliente.getClienteById(tipo);
                this.identificacionsel = dvrIdentificacion.getidentByIdCliente(tipo);
                this.direccionsel = dvrDireccion.getDireccionByIdCliente(tipo);
                this.telefonosel = dvrTelefono.getTelefonoByIdCliente(tipo);
                this.lstIdentificacion = dvrIdentificacion.getidentificacionByIdCliente(tipo);
                this.lstDireccion = dvrDireccion.getdireccionListByIdCliente(tipo);
                this.lstTelefono = dvrTelefono.getTelefonoListByIdCliente(tipo);
                RequestContext.getCurrentInstance().update("frmVerCliente");
                RequestContext.getCurrentInstance().execute("PF('vercliente').show()");
            } else {
                MbsMessages.error("Seleccione un registro");
            }
        } catch (Exception ex) {
            MbsMessages.fatal(ex.getMessage());
        }
    }

    public void cargareditcliente(int tipo) {
        try {
            if (tipo != 0) {
                this.clientesel = dvrCliente.getClienteById(tipo);
                this.identificacionsel = dvrIdentificacion.getidentByIdCliente(tipo);
                this.direccionsel = dvrDireccion.getDireccionByIdCliente(tipo);
                this.telefonosel = dvrTelefono.getTelefonoByIdCliente(tipo);
                this.lstIdentificacion = dvrIdentificacion.getidentificacionByIdCliente(tipo);
                this.lstDireccion = dvrDireccion.getdireccionListByIdCliente(tipo);
                this.lstTelefono = dvrTelefono.getTelefonoListByIdCliente(tipo);
               
                RequestContext.getCurrentInstance().update("frmEditarCliente");
                RequestContext.getCurrentInstance().execute("PF('editcliente').show()");
            } else {
                MbsMessages.error("Seleccione un registro");
            }
        } catch (Exception ex) {
            MbsMessages.fatal(ex.getMessage());
        }
    }
    
    
  

}
