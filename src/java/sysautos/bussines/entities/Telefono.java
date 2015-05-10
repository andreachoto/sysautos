/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sysautos.bussines.entities;


import java.util.Objects;
import sysautos.bussines.drivers.dvrCliente;
import sysautos.bussines.drivers.dvrTipoTelefono;


/**
 *
 * @author Carolyn
 */
public class Telefono {

    private int id;
    private int cltid;
    private int ttfid;
    private String numero;
    private String operadora;
    private String estado;
    private Cliente nombreclt;
    private TipoTelefono nombrettf;

    public Telefono() {
    }

    public Telefono(int id, int cltid, int ttfid, String numero, String operadora, String estado) throws Exception {
        this.id = id;
        this.cltid = cltid;
        this.ttfid = ttfid;
        this.numero = numero;
        this.operadora = operadora;
        this.estado = estado;
        if (cltid != 0) {
            this.nombreclt = dvrCliente.getClienteById(cltid);
        } else {
            this.nombreclt = null;
        }
          if (ttfid != 0) {
            this.nombrettf = dvrTipoTelefono.getTipoTelefonoById(ttfid);
        } else {
            this.nombrettf = null;
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCltid() {
        return cltid;
    }

    public void setCltid(int cltid) {
        this.cltid = cltid;
    }

    public int getTtfid() {
        return ttfid;
    }

    public void setTtfid(int ttfid) {
        this.ttfid = ttfid;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getOperadora() {
        return operadora;
    }

    public void setOperadora(String operadora) {
        this.operadora = operadora;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Cliente getNombreclt() {
        return nombreclt;
    }

    public void setNombreclt(Cliente nombreclt) {
        this.nombreclt = nombreclt;
    }

    public TipoTelefono getNombrettf() {
        return nombrettf;
    }

    public void setNombrettf(TipoTelefono nombrettf) {
        this.nombrettf = nombrettf;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + this.id;
        hash = 59 * hash + this.cltid;
        hash = 59 * hash + this.ttfid;
        hash = 59 * hash + Objects.hashCode(this.numero);
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
        final Telefono other = (Telefono) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.cltid != other.cltid) {
            return false;
        }
        if (this.ttfid != other.ttfid) {
            return false;
        }
        if (!Objects.equals(this.numero, other.numero)) {
            return false;
        }
        return true;
    }
        
}
