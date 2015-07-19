/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sysautos.bussines.entities;

import sysautos.bussines.drivers.dvrRole;

/**
 *
 * @author Carolyn
 */
public class RoleProfile {

    private int pflid;
    private int rolid;
    //private Profile profile;
    private Role rol;

    public RoleProfile() {
    }

    public RoleProfile(int pflid, int rolid) throws Exception {
        this.pflid = pflid;
        this.rolid = rolid;
//        if (pflid != 0) {
//            this.profile = dvrProfile.getProfileById(pflid);
//        } else {
//            this.profile = null;
//        }
        if (rolid != 0) {
            this.rol = dvrRole.getRoleById(rolid);
        } else {
            this.rol = null;
        }
    }

    public int getPflid() {
        return pflid;
    }

    public void setPflid(int pflid) {
        this.pflid = pflid;
    }

    public int getRolid() {
        return rolid;
    }

    public void setRolid(int rolid) {
        this.rolid = rolid;
    }

//    public Profile getProfile() {
//        return profile;
//    }
//
//    public void setProfile(Profile profile) {
//        this.profile = profile;
//    }

    public Role getRol() {
        return rol;
    }

    public void setRol(Role rol) {
        this.rol = rol;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 43 * hash + this.pflid;
        hash = 43 * hash + this.rolid;
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
        final RoleProfile other = (RoleProfile) obj;
        if (this.pflid != other.pflid) {
            return false;
        }
        if (this.rolid != other.rolid) {
            return false;
        }
        return true;
    }
    

}
