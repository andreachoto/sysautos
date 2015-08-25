/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sysautos.bussines.entities;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;
import sysautos.bussines.drivers.dvrUser;

/**
 *
 * @author DISMAGIC0985043396
 */
public class Credit {

    private int id;
    private Timestamp fecha;
    private Timestamp vencimiento;
    private String formapago;
    private BigDecimal monto;
    private BigDecimal interes;
    private int plazo;
    private int iduser;
    private  User user;
    private String estado;
    private String cliente;

    public Credit() {
    }

    public Credit(int id, Timestamp fecha, Timestamp vencimiento, String formapago, BigDecimal monto, BigDecimal interes, int plazo, int iduser, String estado) throws Exception {
        this.id = id;
        this.fecha = fecha;
        this.vencimiento = vencimiento;
        this.formapago = formapago;
        this.monto = monto;
        this.interes = interes;
        this.plazo = plazo;
        this.iduser = iduser;
        this.estado=estado;
        if (iduser != 0) {
            this.user = dvrUser.getUserById(iduser);
        } else {
            this.user = null;
        }
    }

    public Credit(int id, Timestamp fecha, Timestamp vencimiento, String formapago, BigDecimal monto, BigDecimal interes, int plazo, int iduser, String estado, String cliente) {
        this.id = id;
        this.fecha = fecha;
        this.vencimiento = vencimiento;
        this.formapago = formapago;
        this.monto = monto;
        this.interes = interes;
        this.plazo = plazo;
        this.iduser = iduser;
        this.estado = estado;
        this.cliente = cliente;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }
    
    
    
    
    
    
    

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Timestamp getFecha() {
        return fecha;
    }

    public void setFecha(Timestamp fecha) {
        this.fecha = fecha;
    }

    public Timestamp getVencimiento() {
        return vencimiento;
    }

    public void setVencimiento(Timestamp vencimiento) {
        this.vencimiento = vencimiento;
    }

    public String getFormapago() {
        return formapago;
    }

    public void setFormapago(String formapago) {
        this.formapago = formapago;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    public BigDecimal getInteres() {
        return interes;
    }

    public void setInteres(BigDecimal interes) {
        this.interes = interes;
    }

    public int getPlazo() {
        return plazo;
    }

    public void setPlazo(int plazo) {
        this.plazo = plazo;
    }

    public int getIduser() {
        return iduser;
    }

    public void setIduser(int iduser) {
        this.iduser = iduser;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + this.id;
        hash = 89 * hash + Objects.hashCode(this.monto);
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
        final Credit other = (Credit) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.monto, other.monto)) {
            return false;
        }
        return true;
    }
    
    
    

    
   
   

}
