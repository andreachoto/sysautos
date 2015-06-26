/**
 * @author SOPORTE01
 */

package sysautos.bussines.controllers;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import sysautos.bussines.drivers.dvrPedido;
import sysautos.bussines.entities.Pedido;
import sysautos.bussines.session.MbsMessages;

@ManagedBean(name = "dtPedidosView")
@ViewScoped
public final class vmbPedidos {

    private List<Pedido> pedidos;
    private Pedido pedidoselect;

    public vmbPedidos() {
         this.pedidoselect = new Pedido();
         this.loadPedidos();
    }
    
    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    public Pedido getPedidoselect() {
        return pedidoselect;
    }

    public void setPedidoselect(Pedido pedidoselect) {
        this.pedidoselect = pedidoselect;
    }
    
    //Acciones del bean
    public void loadPedidos() {
        try {
            this.pedidos = dvrPedido.getPedidoList();
        } catch (Exception ex) {
            MbsMessages.fatal(ex.getMessage());
        }
    }
}
