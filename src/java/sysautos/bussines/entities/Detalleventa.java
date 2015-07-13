/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sysautos.bussines.entities;

import java.math.BigDecimal;
import sysautos.bussines.drivers.dvrProducto;

/**
 *
 * @author hp
 */
public class Detalleventa {

    private int id;
    private int vtaid;
    private int pdtid;
    private int cantidad;
    private BigDecimal valoruni;
    private BigDecimal subtotal;
    private BigDecimal descuento;
    private BigDecimal valtotal;
    private Producto producto;

    public Detalleventa() {
    }

    public Detalleventa(int id, int vtaid, int pdtid, int cantidad, BigDecimal valoruni,
            BigDecimal subtotal, BigDecimal descuento, BigDecimal valtotal) throws Exception {
        this.id = id;
        this.vtaid = vtaid;
        this.pdtid = pdtid;
        this.cantidad = cantidad;
        this.valoruni = valoruni;
        this.subtotal = subtotal;
        this.descuento = descuento;
        this.valtotal = valtotal;
        if (pdtid != 0) {
            this.producto = dvrProducto.getProductoById(pdtid);
        } else {
            this.producto = null;
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

    public int getPdtid() {
        return pdtid;
    }

    public void setPdtid(int pdtid) {
        this.pdtid = pdtid;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public BigDecimal getValoruni() {
        return valoruni;
    }

    public void setValoruni(BigDecimal valoruni) {
        this.valoruni = valoruni;
    }

    public BigDecimal getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(BigDecimal subtotal) {
        this.subtotal = subtotal;
    }

    public BigDecimal getDescuento() {
        return descuento;
    }

    public void setDescuento(BigDecimal descuento) {
        this.descuento = descuento;
    }

    public BigDecimal getValtotal() {
        return valtotal;
    }

    public void setValtotal(BigDecimal valtotal) {
        this.valtotal = valtotal;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + this.id;
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
        final Detalleventa other = (Detalleventa) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
}
