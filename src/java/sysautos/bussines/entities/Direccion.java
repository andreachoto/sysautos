/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sysautos.bussines.entities;

import java.util.Objects;
import sysautos.bussines.drivers.dvrCliente;
import sysautos.bussines.drivers.dvrCiudad;
import sysautos.bussines.drivers.dvrTipoDireccion;

/**
 *
 * @author Carolyn
 */
public class Direccion {

    private int cltid;
    private int tdrid;
    private int cidid;
    private String calleprincipal;
    private String callesecundaria;
    private String numcasa;
    private String parroquia;
    private String referencia;
    private String barrio;
    private String sector;
    private Cliente cliente;
    private TipoDireccion nomdireccion;
    private Ciudad nomcuidad;

    public Direccion() {
    }

    public Direccion(int cltid, int tdrid, int cidid, String calleprincipal, String callesecundaria, String numcasa, String parroquia, String referencia, String barrio, String sector) throws Exception {
        this.cltid = cltid;
        this.tdrid = tdrid;
        this.cidid = cidid;
        this.calleprincipal = calleprincipal;
        this.callesecundaria = callesecundaria;
        this.numcasa = numcasa;
        this.parroquia = parroquia;
        this.referencia = referencia;
        this.barrio = barrio;
        this.sector = sector;
        if (cltid != 0) {
            this.cliente = dvrCliente.getClienteById(cltid);
        } else {
            this.cliente = null;
        }

        if (tdrid != 0) {
            this.nomdireccion = dvrTipoDireccion.getTipoDireccionById(tdrid);
        } else {
            this.nomdireccion = null;
        }
        if (cidid != 0) {
            this.nomcuidad = dvrCiudad.getCiudadById(cidid);
        } else {
            this.nomcuidad = null;
        }

    }

    public int getCltid() {
        return cltid;
    }

    public void setCltid(int cltid) {
        this.cltid = cltid;
    }

    public int getTdrid() {
        return tdrid;
    }

    public void setTdrid(int tdrid) {
        this.tdrid = tdrid;
    }

    public int getCidid() {
        return cidid;
    }

    public void setCidid(int cidid) {
        this.cidid = cidid;
    }

    public String getCalleprincipal() {
        return calleprincipal;
    }

    public void setCalleprincipal(String calleprincipal) {
        this.calleprincipal = calleprincipal;
    }

    public String getCallesecundaria() {
        return callesecundaria;
    }

    public void setCallesecundaria(String callesecundaria) {
        this.callesecundaria = callesecundaria;
    }

    public String getNumcasa() {
        return numcasa;
    }

    public void setNumcasa(String numcasa) {
        this.numcasa = numcasa;
    }

    public String getParroquia() {
        return parroquia;
    }

    public void setParroquia(String parroquia) {
        this.parroquia = parroquia;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public String getBarrio() {
        return barrio;
    }

    public void setBarrio(String barrio) {
        this.barrio = barrio;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public TipoDireccion getNomdireccion() {
        return nomdireccion;
    }

    public void setNomdireccion(TipoDireccion nomdireccion) {
        this.nomdireccion = nomdireccion;
    }

    public Ciudad getNomcuidad() {
        return nomcuidad;
    }

    public void setNomcuidad(Ciudad nomcuidad) {
        this.nomcuidad = nomcuidad;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 31 * hash + this.cltid;
        hash = 31 * hash + this.tdrid;
        hash = 31 * hash + this.cidid;
        hash = 31 * hash + Objects.hashCode(this.calleprincipal);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Direccion other = (Direccion) obj;
        if (this.cltid != other.cltid) {
            return false;
        }
        if (this.tdrid != other.tdrid) {
            return false;
        }
        if (this.cidid != other.cidid) {
            return false;
        }
        if (!Objects.equals(this.calleprincipal, other.calleprincipal)) {
            return false;
        }
        return true;
    }
    

   
}
