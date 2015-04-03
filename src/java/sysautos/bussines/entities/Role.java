/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sysautos.bussines.entities;

import java.util.Objects;

/**
 *
 * @author hp
 */
public class Role {
    private int rolid;
    private String name;
    private String desc;
    private boolean active;

    public Role(int rolid, String name, String desc, boolean active) {
        this.rolid = rolid;
        this.name = name;
        this.desc = desc;
        this.active = active;
    }

    public Role() {
    }

    public int getRolid() {
        return rolid;
    }

    public void setRolid(int rolid) {
        this.rolid = rolid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
    
    @Override
    public String toString() {
        return String.format("%s", this.name);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + this.rolid;
        hash = 53 * hash + Objects.hashCode(this.name);
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
        final Role other = (Role) obj;
        if (this.rolid != other.rolid) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return true;
    }
}