/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sysautos.bussines.entities;

import sysautos.bussines.drivers.dvrDetallereq;
import sysautos.bussines.drivers.dvrModopago;
import sysautos.bussines.drivers.dvrTipodeudor;



/**
 *
 * @author DISMAGIC0985043396
 */
public class Requisitos {
    private int rqtid;
    private int drqid;
    private int mdpid;
    private int aplid;
    private  Detallereq detallereq;
    private  Modopago modo;
    private  Tipodeudor aplica;

    public Requisitos() {
    }

    public Requisitos(int rqtid) {
        this.rqtid = rqtid;
    }

    public Requisitos(int rqtid, int drqid, int mdpid, int aplid) throws Exception {
        this.rqtid = rqtid;
        this.drqid = drqid;
        this.mdpid = mdpid;
        this.aplid = aplid;
        if ( drqid != 0) {
            detallereq = dvrDetallereq.getDetallereqById(drqid);                            
        } else {
            detallereq = null;
        }
        if ( mdpid != 0) {
            modo = dvrModopago.getModoById(mdpid);                            
        } else {
            modo = null;
        }
        if ( aplid != 0) {
            aplica = dvrTipodeudor.getTipodeudorById(aplid);                            
        } else {
            aplica = null;
        }
    }

    public int getRqtid() {
        return rqtid;
    }

    public void setRqtid(int rqtid) {
        this.rqtid = rqtid;
    }

    public int getDrqid() {
        return drqid;
    }

    public void setDrqid(int drqid) {
        this.drqid = drqid;
    }

    public int getMdpid() {
        return mdpid;
    }

    public void setMdpid(int mdpid) {
        this.mdpid = mdpid;
    }

    public int getAplid() {
        return aplid;
    }

    public void setAplid(int aplid) {
        this.aplid = aplid;
    }

    public Detallereq getDetallereq() {
        return detallereq;
    }

    public void setDetallereq(Detallereq detallereq) {
        this.detallereq = detallereq;
    }

    public Modopago getModo() {
        return modo;
    }

    public void setModo(Modopago modo) {
        this.modo = modo;
    }

    public Tipodeudor getAplica() {
        return aplica;
    }

    public void setAplica(Tipodeudor aplica) {
        this.aplica = aplica;
    }

   

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + this.rqtid;
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
        final Requisitos other = (Requisitos) obj;
        if (this.rqtid != other.rqtid) {
            return false;
        }
        return true;
    }
}
