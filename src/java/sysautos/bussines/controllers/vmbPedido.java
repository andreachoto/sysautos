/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sysautos.bussines.controllers;

import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import sysautos.bussines.common.Genericas;
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
    private Date date;
    private int id;
    private Pedido pedido;

    /**
     * Creates a new instance of NewJSFManagedBean
     *
     * @throws java.lang.Exception
     */
    public vmbPedido() throws Exception {
        this.pedido = new Pedido();
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public String outcome(Pedido pedido) {
        String page = "";
        if (pedido != null) {
            this.id = pedido.getId();
            this.date = Genericas.convertTimeStamptoDate(pedido.getFecha());
            this.pedido = pedido;
            page = "pedidoEdit"; // pagina de edicion de pedido
        } else {
            MbsMessages.error("Seleccione un registro");
            page = "pedido";//pagina de llamada (anterior).
        }
        return page;
    }

}
