/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sysautos.bussines.entities;

import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 *
 * @author DISMAGIC0985043396
 */
public class Amortizacion {
    
    
    private Integer amztid;
    private Integer creditoid;
    private Integer amzcuota;
    private  Timestamp amzfecha;
    private BigDecimal  amzcapital;
    private BigDecimal  amzinteres;
    private BigDecimal  amzvalorc;
    private BigDecimal  amortizacion;

    public Amortizacion(Integer amztid, Integer creditoid, Integer amzcuota, Timestamp amzfecha, BigDecimal amzcapital, BigDecimal amzinteres, BigDecimal amzvalorc,BigDecimal amort) {
        this.amztid = amztid;
        this.creditoid = creditoid;
        this.amzcuota = amzcuota;
        this.amzfecha = amzfecha;
        this.amzcapital = amzcapital;
        this.amzinteres = amzinteres;
        this.amzvalorc = amzvalorc;
        this.amortizacion=amort;
    }

     public Amortizacion() {
        
        
    }

    public BigDecimal getAmortizacion() {
        return amortizacion;
    }

    public void setAmortizacion(BigDecimal amortizacion) {
        this.amortizacion = amortizacion;
    }

     
    public Integer getAmztid() {
        return amztid;
    }

    public void setAmztid(Integer amztid) {
        this.amztid = amztid;
    }

    public Integer getCreditoid() {
        return creditoid;
    }

    public void setCreditoid(Integer creditoid) {
        this.creditoid = creditoid;
    }

    public Integer getAmzcuota() {
        return amzcuota;
    }

    public void setAmzcuota(Integer amzcuota) {
        this.amzcuota = amzcuota;
    }

    public Timestamp getAmzfecha() {
        return amzfecha;
    }

    public void setAmzfecha(Timestamp amzfecha) {
        this.amzfecha = amzfecha;
    }

    public BigDecimal getAmzcapital() {
        return amzcapital;
    }

    public void setAmzcapital(BigDecimal amzcapital) {
        this.amzcapital = amzcapital;
    }

    public BigDecimal getAmzinteres() {
        return amzinteres;
    }

    public void setAmzinteres(BigDecimal amzinteres) {
        this.amzinteres = amzinteres;
    }

    public BigDecimal getAmzvalorc() {
        return amzvalorc;
    }

    public void setAmzvalorc(BigDecimal amzvalorc) {
        this.amzvalorc = amzvalorc;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
}
