/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sysautos.bussines.entities;

import sysautos.bussines.drivers.dvrCliente;
import sysautos.bussines.drivers.dvrProfile;
import sysautos.bussines.drivers.dvrUser;

/**
 *
 * @author Carolyn
 */
public class UserProfile {

    private int usrid;
    private int idprofile;
    private User usuario;
    private Profile profile;

    public UserProfile() {
    }

    public UserProfile(int usrid, int idprofile) throws Exception {
        this.usrid = usrid;
        this.idprofile = idprofile;
        if (usrid != 0) {
            this.usuario = dvrUser.getUserById(usrid);
        } else {
            this.usuario = null;
        }
        if (idprofile != 0) {
            this.profile = dvrProfile.getProfileById(idprofile);
        } else {
            this.profile = null;
        }
    }

    public int getUsrid() {
        return usrid;
    }

    public void setUsrid(int usrid) {
        this.usrid = usrid;
    }

    public int getIdprofile() {
        return idprofile;
    }

    public void setIdprofile(int idprofile) {
        this.idprofile = idprofile;
    }

    public User getUsuario() {
        return usuario;
    }

    public void setUsuario(User usuario) {
        this.usuario = usuario;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 17 * hash + this.usrid;
        hash = 17 * hash + this.idprofile;
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
        final UserProfile other = (UserProfile) obj;
        if (this.usrid != other.usrid) {
            return false;
        }
        if (this.idprofile != other.idprofile) {
            return false;
        }
        return true;
    }
    

}
