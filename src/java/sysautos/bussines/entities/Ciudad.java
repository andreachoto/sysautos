/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sysautos.bussines.entities;

import sysautos.bussines.drivers.dvrProvincia;



/**
 *
 * @author Carolyn
 */
public class Ciudad {
    private int id;
    private int prvid;
    private String nombre;
    private String nombreprovincia;
    private Provincia nombreprv;

    public Ciudad() {
    }

    public Ciudad(int id, int prvid, String nombre, String nombreprovincia) {
        this.id = id;
        this.prvid = prvid;
        this.nombre = nombre;
        this.nombreprovincia = nombreprovincia;
    }
    
    

    public Ciudad(int id, int prvid, String nombre)throws Exception {
        this.id = id;
        this.prvid = prvid;
        this.nombre = nombre;
            if (prvid != 0) {
            this.nombreprv = dvrProvincia.getProvinciaById(prvid);
        } else {
            this.nombreprv = null;
        }
    }

    public String getNombreprovincia() {
        return nombreprovincia;
    }

    public void setNombreprovincia(String nombreprovincia) {
        this.nombreprovincia = nombreprovincia;
    }

        
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrvid() {
        return prvid;
    }

    public void setPrvid(int prvid) {
        this.prvid = prvid;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Provincia getNombreprv() {
        return nombreprv;
    }

    public void setNombreprv(Provincia nombreprv) {
        this.nombreprv = nombreprv;
    }

    
}
