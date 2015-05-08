/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sysautos.bussines.entities;
/**
 *
 * @author DISMAGIC0985043396
 */
public class AmortizacionPagos {
    
    private Integer amrid;
    private Integer pagosid;
    
    private Integer factura;
    private Integer credito;

    public AmortizacionPagos(Integer amrid, Integer pagosid, Integer factura, Integer credito) {
        this.amrid = amrid;
        this.pagosid = pagosid;
        this.factura = factura;
        this.credito = credito;
    }

    public Integer getFactura() {
        return factura;
    }

    public void setFactura(Integer factura) {
        this.factura = factura;
    }

    public Integer getCredito() {
        return credito;
    }

    public void setCredito(Integer credito) {
        this.credito = credito;
    }
    

    public AmortizacionPagos(Integer amrid, Integer pagosid) {
        this.amrid = amrid;
        this.pagosid = pagosid;
    }

    public Integer getAmrid() {
        return amrid;
    }

    public void setAmrid(Integer amrid) {
        this.amrid = amrid;
    }

    public Integer getPagosid() {
        return pagosid;
    }

    public void setPagosid(Integer pagosid) {
        this.pagosid = pagosid;
    }

    public AmortizacionPagos() {
    }
    
}
