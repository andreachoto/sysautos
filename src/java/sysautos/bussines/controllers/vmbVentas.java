package sysautos.bussines.controllers;

import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import sysautos.bussines.drivers.dvrVenta;
import sysautos.bussines.entities.Venta;
import sysautos.bussines.session.MbsMessages;

@ManagedBean(name = "dtVentasView")
@ViewScoped
public final class vmbVentas implements Serializable{
    private List<Venta> ventas;
    private Venta ventaselect;


    public vmbVentas() {
         this.ventaselect = new Venta();
         this.loadVentas();
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

    //Acciones del bean
    public void loadVentas() {
        try {
            this.ventas = dvrVenta.getVentaList();
        } catch (Exception ex) {
            MbsMessages.fatal(ex.getMessage());
        }
    }

}
