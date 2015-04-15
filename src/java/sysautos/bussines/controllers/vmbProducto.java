/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sysautos.bussines.controllers;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.context.RequestContext;
import sysautos.bussines.drivers.dvrProducto;
import sysautos.bussines.drivers.dvrTipoproducto;
import sysautos.bussines.entities.Producto;
import sysautos.bussines.entities.Tipoproducto;
import sysautos.bussines.session.MbsMessages;

/**
 *
 * @author SOPORTE01
 */
@ManagedBean (name = "dtProductoView")
@ViewScoped
public final class vmbProducto {
    
    //atributos del bean
    private List<Producto> productos;
    private Producto producto;
    private Producto productoselect;
    private List<Tipoproducto> tipoproductos;
    private Tipoproducto tipoproductosel;
    
    /**
     * Creates a new instance of NewJSFManagedBean
     * @throws java.lang.Exception
     */
    public vmbProducto() throws Exception {
        this.producto = new Producto();
        this.loadProductos();
        this.tipoproductos = dvrTipoproducto.getTipoproductoList();
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Producto getProductoselect() {
        return productoselect;
    }

    public void setProductoselect(Producto productoselect) {
        this.productoselect = productoselect;
    }

    public List<Tipoproducto> getTipoproductos() {
        return tipoproductos;
    }

    public void setTipoproductos(List<Tipoproducto> tipoproductos) {
        this.tipoproductos = tipoproductos;
    }

    public Tipoproducto getTipoproductosel() {
        return tipoproductosel;
    }

    public void setTipoproductosel(Tipoproducto tipoproductosel) {
        this.tipoproductosel = tipoproductosel;
    }
    
    //Metodos para el negocio
    public void loadProductos() {
        try {
            this.productos = dvrProducto.getProductoList();
        } catch (Exception ex) {
            MbsMessages.fatal(ex.getMessage());
        }
    }
    
    public void loadproducto(Producto prod) {
        try {
            if (prod != null) {
                this.productoselect = dvrProducto.getProductoById(prod.getId());
                RequestContext.getCurrentInstance().update("frmEditProducto");
                RequestContext.getCurrentInstance().execute("PF('editproducto').show()");
            } else {
                MbsMessages.error("Seleccione un registro");
            }
        } catch (Exception ex) {
            MbsMessages.fatal(ex.getMessage());
        }
    }

    public void register() {
        try {
            Producto pro = this.producto;
            int ban = dvrProducto.productoRegister(pro);
            if (ban != 0) {
                this.loadProductos();
                MbsMessages.info("Producto creado exitosamente!");
            } else {
                MbsMessages.error("No se pudo insertar el registro!");
            }
        } catch (Exception ex) {
            MbsMessages.fatal(ex.getMessage());
        }
    }

    public void update(Producto producto) {
        try {
            if (dvrProducto.productoUpdate(producto)) {
                this.loadProductos();
                MbsMessages.info("Producto actualizado correctamente!");
            } else {
                MbsMessages.error("No se pudo Actualizar el registro!");
            }
        } catch (Exception ex) {
            MbsMessages.fatal(ex.getMessage());
        }
    }

    public void delete(Producto tipo) {
        try {
            if (tipo != null) {
                if (dvrProducto.productoDelete(tipo)) {
                    this.loadProductos();
                    MbsMessages.info("Producto eliminado exitosamente!");
                } else {
                    MbsMessages.error("No se pudo Eliminar!");
                }
            } else {
                MbsMessages.error("Seleccione un registro");
            }
        } catch (Exception ex) {
            MbsMessages.fatal(ex.getMessage());
        }
    }
    
}
