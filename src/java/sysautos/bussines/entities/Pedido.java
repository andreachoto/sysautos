/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sysautos.bussines.entities;

import java.sql.Timestamp;
import sysautos.bussines.drivers.dvrProveedor;
import sysautos.bussines.drivers.dvrUser;

/**
 *
 * @author hp
 */
public class Pedido {
    private int id;
    private int pvdid;
    private int usrid;
    private Timestamp fecha;
    private String estado;
    private Proveedor proveedor;
    private User user;

    public Pedido() {
    }

    public Pedido(int id, int pvdid, int usrid, Timestamp fecha, String estado) throws Exception {
        this.id = id;
        this.pvdid = pvdid;
        this.usrid = usrid;
        this.fecha = fecha;
        this.estado = estado;
         if (pvdid != 0) {
            this.proveedor = dvrProveedor.getProveedorById(pvdid);
        } else {
            this.proveedor = null;
        }
          if (usrid != 0) {
            this.user = dvrUser.getUserById(usrid);
        } else {
            this.user = null;
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPvdid() {
        return pvdid;
    }

    public void setPvdid(int pvdid) {
        this.pvdid = pvdid;
    }

    public int getUsrid() {
        return usrid;
    }

    public void setUsrid(int usrid) {
        this.usrid = usrid;
    }

    public Timestamp getFecha() {
        return fecha;
    }

    public void setFecha(Timestamp fecha) {
        this.fecha = fecha;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + this.id;
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
        final Pedido other = (Pedido) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
}
