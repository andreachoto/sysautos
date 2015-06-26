/**
 * @author SOPORTE01
 *
 */
package sysautos.bussines.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
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
import sysautos.bussines.session.MbsMessages;

@ManagedBean(name = "dtPedidoView")
@ViewScoped
public final class vmbPedido {

    //atributos del bean
    private Date date;
    private Pedido pedido;
    private String action;
    private List<Proveedor> proveedores;
    private List<Detallepedido> pedidoitems;
    private Detallepedido itempedido, itemselect;
    private List<Producto> productos;

    public vmbPedido() throws Exception {
        this.pedido = new Pedido();
        this.pedidoitems = new ArrayList<>();
        this.loadProveedores();
        this.loadProductos();
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public List<Proveedor> getProveedores() {
        return proveedores;
    }

    public void setProveedores(List<Proveedor> proveedores) {
        this.proveedores = proveedores;
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

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    //Metodos de logica
    public void loadProveedores() {
        try {
            this.proveedores = dvrProveedor.getProveedorList();
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

}
