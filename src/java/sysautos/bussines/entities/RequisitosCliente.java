/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sysautos.bussines.entities;

import sysautos.bussines.drivers.dvrRequisitos;



/**
 *
 * @author DISMAGIC0985043396
 */
public class RequisitosCliente {

    private int rqtid;
    private int cltid;
    private int crtid;
    private Cliente cli;
    private boolean verificacion;
    private Requisitos requisitos;
    private Detallereq detareq;
    
    

 

    public RequisitosCliente() { 
    }

    public RequisitosCliente(int rqtid, int cltid, int crtid, boolean verificacion) throws Exception {
        this.rqtid = rqtid;
        this.cltid = cltid;
        this.crtid = crtid;
        this.verificacion = verificacion;
        if (rqtid != 0) {
            this.requisitos = sysautos.bussines.drivers.dvrRequisitos.getRequisitosById(rqtid);
        } else {
            this.requisitos = null;
        }
         if (cltid != 0) {
            this.cli = sysautos.bussines.drivers.dvrCliente.getClienteById(cltid);
        } else {
            this.cli = null;
        }
        
        
        
    }

    public Detallereq getDetareq() {
        return detareq;
    }

    public void setDetareq(Detallereq detareq) {
        this.detareq = detareq;
    }
    
    
    
    
    public Cliente getCli() {
        return cli;
    }

    public void setCli(Cliente cli) {
        this.cli = cli;
    }
    
    
    

    public int getRqtid() {
        return rqtid;
    }

    public void setRqtid(int rqtid) {
        this.rqtid = rqtid;
    }

    public int getCltid() {
        return cltid;
    }

    public void setCltid(int cltid) {
        this.cltid = cltid;
    }

    public int getCrtid() {
        return crtid;
    }

    public void setCrtid(int crtid) {
        this.crtid = crtid;
    }

    public boolean isVerificacion() {
        return verificacion;
    }

    public void setVerificacion(boolean verificacion) {
        this.verificacion = verificacion;
    }

    public Requisitos getRequisitos() {
        return requisitos;
    }

    public void setRequisitos(Requisitos requisitos) {
        this.requisitos = requisitos;
    }

    
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + this.rqtid;
        hash = 67 * hash + this.cltid;
        hash = 67 * hash + this.crtid;
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
        final RequisitosCliente other = (RequisitosCliente) obj;
        if (this.rqtid != other.rqtid) {
            return false;
        }
        if (this.cltid != other.cltid) {
            return false;
        }
        if (this.crtid != other.crtid) {
            return false;
        }
        return true;
    }
}