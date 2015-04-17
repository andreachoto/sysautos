/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sysautos.bussines.classes;

import java.util.Objects;

/**
 *
 * @author hp
 */
public class Role {
    private int rolid;
    private String rolname;
    private String roldesc;
    private boolean rolactive;

    public Role(int rolid, String rolname, String roldesc, boolean rolisactive) {
        this.rolid = rolid;
        this.rolname = rolname;
        this.roldesc = roldesc;
        this.rolactive = rolisactive;
    }

    public Role() {
    }

    public int getRolid() {
        return rolid;
    }

    public void setRolid(int rolid) {
        this.rolid = rolid;
    }

    public String getRolname() {
        return rolname;
    }

    public void setRolname(String rolname) {
        this.rolname = rolname;
    }

    public String getRoldesc() {
        return roldesc;
    }

    public void setRoldesc(String roldesc) {
        this.roldesc = roldesc;
    }

    public boolean isRolactive() {
        return rolactive;
    }

    public void setRolactive(boolean rolisactive) {
        this.rolactive = rolisactive;
    }
    
    @Override
    public String toString() {
        return String.format("%s", this.rolname);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + this.rolid;
        hash = 53 * hash + Objects.hashCode(this.rolname);
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
        if (!Objects.equals(this.rolname, other.rolname)) {
            return false;
        }
        return true;
    }
    
    
    
    
}
