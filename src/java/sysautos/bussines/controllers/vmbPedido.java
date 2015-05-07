/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sysautos.bussines.controllers;

import static com.sun.corba.se.spi.presentation.rmi.StubAdapter.request;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import org.primefaces.context.RequestContext;
import sysautos.bussines.common.Genericas;
import sysautos.bussines.drivers.dvrDetallepedido;
import sysautos.bussines.drivers.dvrPedido;
import sysautos.bussines.drivers.dvrProducto;
import sysautos.bussines.drivers.dvrProveedor;
import sysautos.bussines.entities.Detallepedido;
import sysautos.bussines.entities.Pedido;
import sysautos.bussines.entities.Producto;
import sysautos.bussines.entities.Proveedor;
import sysautos.bussines.entities.User;
import sysautos.bussines.session.MbsLogin;
import sysautos.bussines.session.MbsMessages;

/**
 *
 * @author SOPORTE01
 */
@ManagedBean(name = "dtPedidoView")
@ViewScoped
public final class vmbPedido {

    @ManagedProperty("#{MbsLogin}")
    private MbsLogin login;

    //atributos del bean
    private Date date;
    private Pedido pedido, pedidoselect;
    private Producto producto;
    private List<Pedido> pedidos;
    private List<Proveedor> proveedores;
    private List<Producto> productos;
    private List<Detallepedido> pedidoitems;
    private Detallepedido itempedido, itemselect;

    /**
     * Creates a new instance of NewJSFManagedBean
     *
     * @throws java.lang.Exception
     */
    public vmbPedido() throws Exception {
        this.date = new Date();
        this.pedido = new Pedido();
        this.pedidoselect = new Pedido();
        this.producto = new Producto();
        this.itempedido = new Detallepedido();
        this.itemselect = new Detallepedido();
        this.loadPedidos();
        this.loadProveedores();
        this.loadProductos();
        this.pedidoitems = new ArrayList<>();
    }

    public MbsLogin getLogin() {
        return login;
    }

    public void setLogin(MbsLogin login) {
        this.login = login;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Pedido getPedidoselect() {
        return pedidoselect;
    }

    public void setPedidoselect(Pedido pedidoselect) {
        this.pedidoselect = pedidoselect;
    }

    public List<Proveedor> getProveedores() {
        return proveedores;
    }

    public void setProveedores(List<Proveedor> proveedores) {
        this.proveedores = proveedores;
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

    public List<Detallepedido> getPedidoitems() {
        return pedidoitems;
    }

    public void setPedidoitems(List<Detallepedido> pedidoitems) {
        this.pedidoitems = pedidoitems;
    }

    public Detallepedido getItempedido() {
        return itempedido;
    }

    public void setItempedido(Detallepedido itempedido) {
        this.itempedido = itempedido;
    }

    public Detallepedido getItemselect() {
        return itemselect;
    }

    public void setItemselect(Detallepedido itemselect) {
        this.itemselect = itemselect;
    }

    //Metodos para el negocio
    public void loadItemspedido() {
        try {
            this.pedidoitems = dvrDetallepedido.getDetallepedidoList();
        } catch (Exception ex) {
            MbsMessages.fatal(ex.getMessage());
        }
    }

    public void loadProductos() {
        try {
            this.productos = dvrProducto.getProductoList();
        } catch (Exception ex) {
            MbsMessages.fatal(ex.getMessage());
        }
    }

    public void loadProveedores() {
        try {
            this.proveedores = dvrProveedor.getProveedorList();
        } catch (Exception ex) {
            MbsMessages.fatal(ex.getMessage());
        }
    }

    public void loadPedidos() {
        try {
            this.pedidos = dvrPedido.getPedidoList();
        } catch (Exception ex) {
            MbsMessages.fatal(ex.getMessage());
        }
    }

    public void loadpedido(Pedido pedido) {
        try {
            if (pedido != null) {
                this.pedidoselect = dvrPedido.getPedidoById(pedido.getId());
                this.pedidoitems = dvrDetallepedido.getDetallepedidoByForeingID(pedido.getId(), 0);
                FacesContext.getCurrentInstance().getExternalContext().redirect("pedidoEdit.xhtml");
            } else {
                MbsMessages.error("Seleccione un registro");
            }
        } catch (Exception ex) {
            MbsMessages.fatal(ex.getMessage());
        }
    }

    public void register() {
        try {
            Date dat = this.date;
            if (this.pedido.getPvdid() != -1) {
                Pedido ped = this.pedido;
                ped.setFecha(Genericas.parsDatetoTimestamp(dat));
                ped.setEstado("Solicitado");
                HttpSession httpSession = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
                User user = (User) httpSession.getAttribute("user");
                ped.setUsrid(user.getId());
                int ban = dvrPedido.pedidoRegister(ped);
                if (ban != 0) {
                    //Guardar items del pedido
                    for (Detallepedido item : this.pedidoitems) {
                        item.setPedid(ban);
                        dvrDetallepedido.detallepedidoRegister(item);
                    }
                    //refescamos la lista de pedidos
                    this.loadPedidos();
                    MbsMessages.info("Pedido creado exitosamente!");
                } else {
                    MbsMessages.error("No se pudo insertar el registro!");
                }
            } else {
                MbsMessages.error("Seleccione un proveedor!");
            }
        } catch (Exception ex) {
            MbsMessages.fatal(ex.getMessage());
        }
    }

    public void update(Pedido pedido) {
        try {
            if (dvrPedido.pedidoUpdate(pedido)) {
                this.loadPedidos();
                MbsMessages.info("Pedido actualizado correctamente!");
            } else {
                MbsMessages.error("No se pudo Actualizar el registro!");
            }
        } catch (Exception ex) {
            MbsMessages.fatal(ex.getMessage());
        }
    }

    public void delete(Pedido tipo) {
        try {
            if (tipo != null) {
                if (dvrPedido.pedidoDelete(tipo)) {
                    this.loadPedidos();
                    MbsMessages.info("Pedido eliminado exitosamente!");
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

    public void addItemDetalle() {
        try {
            if (this.itempedido.getPdtid() != -1) {
                if (this.itempedido.getCantidad() > 0) {
                    Detallepedido item = new Detallepedido(0, 0, this.itempedido.getPdtid(), this.itempedido.getCantidad(), "En pedido", this.itempedido.getObser());
                    this.pedidoitems.add(item);
                } else {
                    MbsMessages.error("Ingrese la cantidad de productos al Item de Pedido");
                }
            } else {
                MbsMessages.error("Seleccione un producto para agregar Items al pedido");
            }
        } catch (Exception ex) {
            MbsMessages.fatal(ex.getMessage());
        }
    }

    public void delItemDetalle() {
        try {
            Detallepedido item = this.itemselect;
            this.pedidoitems.remove(item);
        } catch (Exception ex) {
            MbsMessages.fatal(ex.getMessage());
        }
    }

}
