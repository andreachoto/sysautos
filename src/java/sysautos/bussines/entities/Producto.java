/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sysautos.bussines.entities;

import java.math.BigDecimal;
import java.util.Objects;
import sysautos.bussines.drivers.dvrTipoproducto;

/**
 *
 * @author hp
 */
public class Producto {

    private int pdtid;
    private int tptid; //di tipo producto
    private String nombre;
    private String serial;
    private int pdtstock;
    private BigDecimal valorunit;
    private BigDecimal pvp;
    private String marca;
    private String modelo;
    private BigDecimal cilindraje;
    private Tipoproducto tipoproducto;

    public Producto(int pdtid, int tptid, String nombre, String serial, int pdtstock, 
            BigDecimal valorunit, BigDecimal pvp, String marca, String modelo,
            BigDecimal cilindraje) throws Exception {
        this.pdtid = pdtid;
        this.tptid = tptid;
        this.nombre = nombre;
        this.serial = serial;
        this.pdtstock = pdtstock;
        this.valorunit = valorunit;
        this.pvp = pvp;
        this.marca = marca;
        this.modelo = modelo;
        this.cilindraje = cilindraje;
        if (tptid != 0) {
            this.tipoproducto = dvrTipoproducto.getTipoproductoById(tptid);
        } else {
            this.tipoproducto = null;
        }
        
    }

    public int getPdtid() {
        return pdtid;
    }

    public void setPdtid(int pdtid) {
        this.pdtid = pdtid;
    }

    public int getTptid() {
        return tptid;
    }

    public void setTptid(int tptid) {
        this.tptid = tptid;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public int getPdtstock() {
        return pdtstock;
    }

    public void setPdtstock(int pdtstock) {
        this.pdtstock = pdtstock;
    }

    public BigDecimal getValorunit() {
        return valorunit;
    }

    public void setValorunit(BigDecimal valorunit) {
        this.valorunit = valorunit;
    }

    public BigDecimal getPvp() {
        return pvp;
    }

    public void setPvp(BigDecimal pvp) {
        this.pvp = pvp;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public BigDecimal getCilindraje() {
        return cilindraje;
    }

    public void setCilindraje(BigDecimal cilindraje) {
        this.cilindraje = cilindraje;
    }

    public Tipoproducto getTipoproducto() {
        return tipoproducto;
    }

    public void setTipoproducto(Tipoproducto tipoproducto) {
        this.tipoproducto = tipoproducto;
    }
    
    @Override
    public String toString() {
        return String.format("%s", this.nombre);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + this.pdtid;
        hash = 67 * hash + Objects.hashCode(this.serial);
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
        final Producto other = (Producto) obj;
        return true;
    }
}
