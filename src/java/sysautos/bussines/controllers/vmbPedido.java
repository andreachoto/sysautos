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
import sysautos.bussines.drivers.dvrPedido;
import sysautos.bussines.entities.Pedido;
import sysautos.bussines.session.MbsMessages;

/**
 *
 * @author SOPORTE01
 */
@ManagedBean(name = "dtPedidoView")
@ViewScoped
public final class vmbPedido {

    //atributos del bean
    private Pedido pedido;
    private Pedido pedidoselect;
    private List<Pedido> pedidos;

    /**
     * Creates a new instance of NewJSFManagedBean
     *
     * @throws java.lang.Exception
     */
    public vmbPedido() throws Exception {
        this.pedido = new Pedido();
        this.pedidoselect = new Pedido();
        this.loadPedidos();
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

    //Metodos para el negocio
    public void loadPedidos() {
        try {
            this.pedidos = dvrPedido.getPedidoList();
        } catch (Exception ex) {
            MbsMessages.fatal(ex.getMessage());
        }
    }

    public void loadpedido(Pedido prod) {
        try {
            if (prod != null) {
                this.pedidoselect = dvrPedido.getPedidoById(prod.getId());
                RequestContext.getCurrentInstance().update("frmEditPedido");
                RequestContext.getCurrentInstance().execute("PF('editpedido').show()");
            } else {
                MbsMessages.error("Seleccione un registro");
            }
        } catch (Exception ex) {
            MbsMessages.fatal(ex.getMessage());
        }
    }

    public void register() {
        try {
            int ban = dvrPedido.pedidoRegister(this.pedido);
            if (ban != 0) {
                this.loadPedidos();
                MbsMessages.info("Pedido creado exitosamente!");
            } else {
                MbsMessages.error("No se pudo insertar el registro!");
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
}
