/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sysautos.bussines.entities;

import java.util.Objects;
import sysautos.bussines.drivers.dvrCliente;
import sysautos.bussines.drivers.dvrTipoIdentidad;

/**
 *
 * @author Carolyn
 */
public class Identificacion {

    private int cltid;
    private int tidid;
    private String numdescripcion;
    private String estado;
    private TipoIdentidad tipoidenti;

    public Identificacion() {
    }

    public Identificacion(int cltid, int tidid, String numdescripcion, String estado) throws Exception {
        this.cltid = cltid;
        this.tidid = tidid;
        this.numdescripcion = numdescripcion;
        this.estado = estado;
        if (tidid != 0) {
            this.tipoidenti = dvrTipoIdentidad.gettipoIdentidadById(tidid);
        } else {
            this.tipoidenti = null;
        }
    }

    public int getCltid() {
        return cltid;
    }

    public void setCltid(int cltid) {
        this.cltid = cltid;
    }

    public int getTidid() {
        return tidid;
    }

    public void setTidid(int tidid) {
        this.tidid = tidid;
    }

    public String getNumdescripcion() {
        return numdescripcion;
    }

    public void setNumdescripcion(String numdescripcion) {
        this.numdescripcion = numdescripcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public TipoIdentidad getTipoidenti() {
        return tipoidenti;
    }

    public void setTipoidenti(TipoIdentidad tipoidenti) {
        this.tipoidenti = tipoidenti;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + this.cltid;
        hash = 79 * hash + this.tidid;
        hash = 79 * hash + Objects.hashCode(this.numdescripcion);
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
        final Identificacion other = (Identificacion) obj;
        if (this.cltid != other.cltid) {
            return false;
        }
        if (this.tidid != other.tidid) {
            return false;
        }
        if (!Objects.equals(this.numdescripcion, other.numdescripcion)) {
            return false;
        }
        return true;
    }

}
