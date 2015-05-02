/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sysautos.bussines.entities;

import java.math.BigDecimal;
import java.sql.Timestamp;
import sysautos.bussines.drivers.dvrUser;

/**
 *
 * @author hp
 */
public class Venta {

    private int id;
    private int clitid;
    private int mpgid;
    private int usrid;
    private Timestamp fecha;
    private String numfac;
    private Timestamp fechafac;
    private BigDecimal subtotal;
    private BigDecimal iva;
    private BigDecimal impuestos;
    private BigDecimal descuento;
    private BigDecimal total;
    private String estado;
    private Boolean cancelado;
//    private Cliente cliente;
//    private Modopago modopago;
    private User user;

    public Venta() {
    }

    public Venta(int id, int clitid, int mpgid, int usrid, Timestamp fecha, String numfac, 
            Timestamp fechafac, BigDecimal subtotal, BigDecimal iva, BigDecimal impuestos, 
            BigDecimal descuento, BigDecimal total, String estado, Boolean cancelado) throws Exception {
        this.id = id;
        this.clitid = clitid;
        this.mpgid = mpgid;
        this.usrid = usrid;
        this.fecha = fecha;
        this.numfac = numfac;
        this.fechafac = fechafac;
        this.subtotal = subtotal;
        this.iva = iva;
        this.impuestos = impuestos;
        this.descuento = descuento;
        this.total = total;
        this.estado = estado;
        this.cancelado = cancelado;
//        if (clitid != 0) {
//            this.cliente = dvrCliente.getClienteById(clitid);
//        } else {
//            this.cliente = null;
//        }
//        if (mpgid != 0) {
//            this.modopago = dvrModopago.getModopagoById(mpgid);
//        } else {
//            this.modopago = null;
//        }
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

    public int getClitid() {
        return clitid;
    }

    public void setClitid(int clitid) {
        this.clitid = clitid;
    }

    public int getMpgid() {
        return mpgid;
    }

    public void setMpgid(int mpgid) {
        this.mpgid = mpgid;
    }

    public int getUsrid() {
        return usrid;
    }

    public void setUsrid(int usrid) {
        this.usrid = usrid;
    }

    public Timestamp getFecha() {
        return fecha;
    }

    public void setFecha(Timestamp fecha) {
        this.fecha = fecha;
    }

    public String getNumfac() {
        return numfac;
    }

    public void setNumfac(String numfac) {
        this.numfac = numfac;
    }

    public Timestamp getFechafac() {
        return fechafac;
    }

    public void setFechafac(Timestamp fechafac) {
        this.fechafac = fechafac;
    }

    public BigDecimal getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(BigDecimal subtotal) {
        this.subtotal = subtotal;
    }

    public BigDecimal getIva() {
        return iva;
    }

    public void setIva(BigDecimal iva) {
        this.iva = iva;
    }

    public BigDecimal getImpuestos() {
        return impuestos;
    }

    public void setImpuestos(BigDecimal impuestos) {
        this.impuestos = impuestos;
    }

    public BigDecimal getDescuento() {
        return descuento;
    }

    public void setDescuento(BigDecimal descuento) {
        this.descuento = descuento;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Boolean getCancelado() {
        return cancelado;
    }

    public void setCancelado(Boolean cancelado) {
        this.cancelado = cancelado;
    }

//    public Cliente getCliente() {
//        return cliente;
//    }
//
//    public void setCliente(Cliente cliente) {
//        this.cliente = cliente;
//    }
//
//    public Modopago getModopago() {
//        return modopago;
//    }
//
//    public void setModopago(Modopago modopago) {
//        this.modopago = modopago;
//    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + this.id;
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
        final Venta other = (Venta) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
}
