/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sysautos.bussines.entities;

import java.math.BigDecimal;
import java.sql.Timestamp;
import sysautos.bussines.drivers.dvrFormapago;
import sysautos.bussines.drivers.dvrUser;
import sysautos.bussines.drivers.dvrVenta;

/**
 *
 * @author hp
 */
public class Pagos {
    private int id;
    private int vtaid;
    private int fpgid;
    private BigDecimal valor;
    private Timestamp fecha;
    private int numdocumento;
    private String concepto;
    private BigDecimal mora;
    private int usrid;
    private Venta venta;
    private Formapago formapago;
    private User user;

    public Pagos() {
    }

    public Pagos(int id, int vtaid, int fpgid, BigDecimal valor, Timestamp fecha, 
            int numdocumento, String concepto, BigDecimal mora, int usrid) throws Exception {
        this.id = id;
        this.vtaid = vtaid;
        this.fpgid = fpgid;
        this.valor = valor;
        this.fecha = fecha;
        this.numdocumento = numdocumento;
        this.concepto = concepto;
        this.mora = mora;
        this.usrid = usrid;
        if (vtaid != 0) {
            this.venta = dvrVenta.getVentaById(vtaid);
        } else {
            this.venta = null;
        }
        if (fpgid != 0) {
            this.formapago = dvrFormapago.getFormapagoById(fpgid);
        } else {
            this.formapago = null;
        }
        if (usrid != 0) {
            this.user = dvrUser.getUserById(usrid);
        } else {
            this.user = null;
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getVtaid() {
        return vtaid;
    }

    public void setVtaid(int vtaid) {
        this.vtaid = vtaid;
    }

    public int getFpgid() {
        return fpgid;
    }

    public void setFpgid(int fpgid) {
        this.fpgid = fpgid;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public Timestamp getFecha() {
        return fecha;
    }

    public void setFecha(Timestamp fecha) {
        this.fecha = fecha;
    }

    public int getNumdocumento() {
        return numdocumento;
    }

    public void setNumdocumento(int numdocumento) {
        this.numdocumento = numdocumento;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }
    
    public BigDecimal getMora() {
        return mora;
    }

    public void setMora(BigDecimal mora) {
        this.mora = mora;
    }

    public int getUsrid() {
        return usrid;
    }

    public void setUsrid(int usrid) {
        this.usrid = usrid;
    }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    public Formapago getFormapago() {
        return formapago;
    }

    public void setFormapago(Formapago formapago) {
        this.formapago = formapago;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 83 * hash + this.id;
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
        final Pagos other = (Pagos) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
}
