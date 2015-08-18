package sysautos.bussines.controllers;

import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.context.RequestContext;
import sysautos.bussines.drivers.dvrDetallepedido;
import sysautos.bussines.drivers.dvrPedido;
import sysautos.bussines.entities.Detallepedido;
import sysautos.bussines.entities.Pedido;
import sysautos.bussines.session.MbsMessages;

@ManagedBean(name = "dtPedidosView")
@ViewScoped
public final class vmbPedidos implements Serializable{
    private List<Pedido> pedidos;
    private Pedido pedidoselect;
    private Detallepedido detallepedidosel;

    public vmbPedidos() {
         this.pedidoselect = new Pedido();
         this.detallepedidosel = new Detallepedido();
         this.loadPedidos();
    }

    public Detallepedido getDetallepedidosel() {
        return detallepedidosel;
    }

    public void setDetallepedidosel(Detallepedido detallepedidosel) {
        this.detallepedidosel = detallepedidosel;
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
       public void cargarverpedido(int tipo) {
        try {
            if (tipo != 0) {
                this.pedidoselect = dvrPedido.getPedidoById(tipo);
                this.detallepedidosel = dvrDetallepedido.getDetallepedidoById(tipo);
                RequestContext.getCurrentInstance().update("frmVerPedido");
                RequestContext.getCurrentInstance().execute("PF('verpedido').show()");
            } else {
                MbsMessages.error("Seleccione un registro");
            }
        } catch (Exception ex) {
            MbsMessages.fatal(ex.getMessage());
        }
    }
}
