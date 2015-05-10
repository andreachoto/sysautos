/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sysautos.bussines.entities;

import sysautos.bussines.drivers.dvrPais;




/**
 *
 * @author Carolyn
 */
public class Provincia {
    private int id;
    private int pisid;
    private String nombre;
    private String nombrepais;
    private Pais nombrepis;

    public Provincia() {
    }

    public Provincia(int id, int pisid, String nombre, String nombrepais) {
        this.id = id;
        this.pisid = pisid;
        this.nombre = nombre;
        this.nombrepais = nombrepais;
    }



    public Provincia(int id, int pisid, String nombre)throws Exception {
        this.id = id;
        this.pisid = pisid;
        this.nombre = nombre;
        
         if (pisid != 0) {
            this.nombrepis = dvrPais.getPaisById(pisid);
        } else {
            this.nombrepis = null;
        }
    }

    public String getNombrepais() {
        return nombrepais;
    }

    public void setNombrepais(String nombrepais) {
        this.nombrepais = nombrepais;
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPisid() {
        return pisid;
    }

    public void setPisid(int pisid) {
        this.pisid = pisid;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Pais getNombrepis() {
        return nombrepis;
    }

    public void setNombrepis(Pais nombrepis) {
        this.nombrepis = nombrepis;
    }


  
  
    
}
