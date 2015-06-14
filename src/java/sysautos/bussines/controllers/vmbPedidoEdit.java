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
@ManagedBean(name = "dtPedidoEditView")
@ViewScoped
public final class vmbPedidoEdit {

    //atributos del bean
    private Date date;
    private int id;
    private Pedido pedidosel;

    /**
     * Creates a new instance of NewJSFManagedBean
     *
     * @throws java.lang.Exception
     */
    public vmbPedidoEdit() throws Exception {
        this.pedidosel = new Pedido();
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

    public Pedido getPedidosel() {
        return pedidosel;
    }

    public void setPedidosel(Pedido pedidosel) {
        this.pedidosel = pedidosel;
    }
    
    public String outcome(Pedido pedido) {
        String page = "";
        if (pedido != null) {
            this.id = pedido.getId();
            this.date = Genericas.convertTimeStamptoDate(pedido.getFecha());
            this.pedidosel = pedido;
            page = "pedidoEdit"; // pagina de edicion de pedido
        } else {
            MbsMessages.error("Seleccione un registro");
            page = "pedido";//pagina de llamada (anterior).
        }
        return page;
    }

}
