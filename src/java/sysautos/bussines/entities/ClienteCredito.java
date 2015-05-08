/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sysautos.bussines.entities;

import java.util.Objects;
import sysautos.bussines.drivers.dvrCliente;
import sysautos.bussines.drivers.dvrTipodeudor;
import sysautos.bussines.drivers.dvrCredit;

/**
 *
 * @author DISMAGIC0985043396
 */
public class ClienteCredito {

    private Cliente cli;
    private Tipodeudor tpd;
    private Credit cred;
    private int idcli, idcred, idtipo;

    public ClienteCredito(int idcli, int idcred, int idtipo) throws Exception {
        this.idcli = idcli;
        this.idcred = idcred;
        this.idtipo = idtipo;
        if (idcli != 0) {
            this.cli = dvrCliente.getClienteById(idcli);
        } else {
            this.cli = null;
        }
         if (idtipo != 0) {
            this.tpd = dvrTipodeudor.getTipodeudorById( idtipo);
        } else {
            this.tpd = null;
        }
          if (idcred != 0) {
            this.cred = dvrCredit.getCreditoById(idcred);
        } else {
            this.cred = null;
        }
         
         
         
    }

    
    public ClienteCredito() {
    }

    public int getIdcli() {
        return idcli;
    }

    public void setIdcli(int idcli) {
        this.idcli = idcli;
    }

    public int getIdcred() {
        return idcred;
    }

    public void setIdcred(int idcred) {
        this.idcred = idcred;
    }

    public int getIdtipo() {
        return idtipo;
    }

    public void setIdtipo(int idtipo) {
        this.idtipo = idtipo;
    }

    

    public Credit getCred() {
        return cred;
    }

    public void setCred(Credit cred) {
        this.cred = cred;
    }

    public Cliente getCli() {
        return cli;
    }

    public void setCli(Cliente cli) {
        this.cli = cli;
    }

    public Tipodeudor getTpd() {
        return tpd;
    }

    public void setTpd(Tipodeudor tpd) {
        this.tpd = tpd;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + Objects.hashCode(this.cli);
        hash = 79 * hash + this.idcli;
        hash = 79 * hash + this.idcred;
        hash = 79 * hash + this.idtipo;
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
        final ClienteCredito other = (ClienteCredito) obj;
        if (!Objects.equals(this.cli, other.cli)) {
            return false;
        }
        if (this.idcli != other.idcli) {
            return false;
        }
        if (this.idcred != other.idcred) {
            return false;
        }
        if (this.idtipo != other.idtipo) {
            return false;
        }
        return true;
    }
    
 

}
