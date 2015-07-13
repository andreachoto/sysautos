package sysautos.bussines.entities;

import sysautos.bussines.drivers.dvrProducto;

public class Detallepedido {

    private int id;
    private int pedid;
    private int pdtid;
    private int cantidad;
    private String estado;
    private String obser;
    private Producto producto;

    public Detallepedido() {
    }

    public Detallepedido(int id, int pedid, int pdtid, int cantidad, String estado, String obser) throws Exception {
        this.id = id;
        this.pedid = pedid;
        this.pdtid = pdtid;
        this.cantidad = cantidad;
        this.estado = estado;
        this.obser = obser;
        if (pdtid != 0) {
            this.producto = dvrProducto.getProductoById(pdtid);
        } else {
            this.producto = null;
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPedid() {
        return pedid;
    }

    public void setPedid(int pedid) {
        this.pedid = pedid;
    }

    public int getPdtid() {
        return pdtid;
    }

    public void setPdtid(int pdtid) {
        this.pdtid = pdtid;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getObser() {
        return obser;
    }

    public void setObser(String obser) {
        this.obser = obser;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 31 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Detallepedido other = (Detallepedido) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
}
