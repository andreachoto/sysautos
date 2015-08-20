/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sysautos.bussines.entities;

import java.util.List;
import sysautos.bussines.drivers.dvrIdentificacion;

/**
 *
 * @author Carolyn
 */
public class Cliente {
    private int id;
    private String nombre;
    private String apellido;
    private String sexo;
    private int edad;
    private String fax;
    private String email;
    private String estadocivil;
    private List<Identificacion> listaidentidad;
    private String identificacion;
    
    public Cliente() {
    }

    public Cliente(int id, String nombre, String apellido, String sexo, int edad, String fax, String email, String estadocivil) throws Exception {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.sexo = sexo;
        this.edad = edad;
        this.fax = fax;
        this.email = email;
        this.estadocivil = estadocivil;
        this.listaidentidad= dvrIdentificacion.getidentificacionByIdCliente(id);
        if(!listaidentidad.isEmpty()){
        this.identificacion=this.listaidentidad.get(0).getNumdescripcion();
        }
            
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }
    
    public List<Identificacion> getListaidentidad() {
        return listaidentidad;
    }

    public void setListaidentidad(List<Identificacion> listaidentidad) {
        this.listaidentidad = listaidentidad;
    }
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEstadocivil() {
        return estadocivil;
    }

    public void setEstadocivil(String estadocivil) {
        this.estadocivil = estadocivil;
    }
    
    
    
}
