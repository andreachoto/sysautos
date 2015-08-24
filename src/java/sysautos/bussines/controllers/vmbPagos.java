/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sysautos.bussines.controllers;

import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import sysautos.bussines.drivers.dvrModopago;
import sysautos.bussines.drivers.dvrVenta;
import sysautos.bussines.entities.Modopago;
import sysautos.bussines.entities.Venta;
import sysautos.bussines.session.MbsMessages;

/**
 *
 * @author hp
 */
@ManagedBean(name = "dtPagosView")
@ViewScoped
public final class vmbPagos implements Serializable {

    /**
     * Creates a new instance of vmbPagos
     */
    
    private List<Venta> ventas;
    private Venta ventaselect;
    private List<Modopago> modopago;
    private Modopago modoselect;
    
    public vmbPagos() {
         this.ventaselect = new Venta();
         this.modoselect = new Modopago();
         this.loadVentas();
         this.loadModopago();
    }

    public List<Venta> getVentas() {
        return ventas;
    }

    public void setVentas(List<Venta> ventas) {
        this.ventas = ventas;
    }

    public Venta getVentaselect() {
        return ventaselect;
    }

    public void setVentaselect(Venta ventaselect) {
        this.ventaselect = ventaselect;
    }

    public List<Modopago> getModopago() {
        return modopago;
    }

    public void setModopago(List<Modopago> modopago) {
        this.modopago = modopago;
    }

    public Modopago getModoselect() {
        return modoselect;
    }

    public void setModoselect(Modopago modoselect) {
        this.modoselect = modoselect;
    }
    
    //********** Logica ************
    public void loadModopago() {
        try {
            this.modopago = dvrModopago.getModopagoList();
        } catch (Exception ex) {
            MbsMessages.fatal(ex.getMessage());
        }
    }
    
    public void loadVentas() {
        try {
            if (this.modoselect.getId()!=0){
                this.ventas = dvrVenta.getVentaListByModo(0,this.modoselect.getId());
            } else {
                this.ventas = dvrVenta.getVentaList();
            }
        } catch (Exception ex) {
            MbsMessages.fatal(ex.getMessage());
        }
    }
    
}
