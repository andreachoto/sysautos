/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sysautos.bussines.controllers;

import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.context.RequestContext;
import sysautos.bussines.entities.Role;
import sysautos.bussines.drivers.dvrRole;
import sysautos.bussines.session.MbsMessages;

/**
 *
 * @author hp
 */
@ManagedBean(name = "dtRolesView")
@ViewScoped
public final class vmbRole implements Serializable {

    private Role role;
    private Role rolselection;
    private List<Role> roles;

    /**
     * Creates a new instance of VmbRole
     *
     * @throws java.lang.Exception
     */
    // contructor
    public vmbRole() throws Exception {
        this.role = new Role();
        this.loadroles();
    }

    //getter an setter methods
    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public Role getRolselection() {
        return rolselection;
    }

    public void setRolselection(Role rolselection) {
        this.rolselection = rolselection;
    }

    //businnes logical methods
    public void loadroles() {
        try {
            this.roles = dvrRole.getRoleList();
        } catch (Exception ex) {
            MbsMessages.fatal(ex.getMessage());
        }
    }

    public void loadrol(int id) {
        try {
            if (id != 0) {
                this.rolselection = dvrRole.getRoleById(id);
                RequestContext.getCurrentInstance().update("frmEditRole");
                RequestContext.getCurrentInstance().execute("PF('editrole').show()");
            } else {
                MbsMessages.error("Seleccione un registro");
            }
        } catch (Exception ex) {
             MbsMessages.fatal(ex.getMessage());
        }

    }

    public void register() {
        try {
            int ban = dvrRole.roleRegister(this.role);
            if (ban != 0) {
                this.loadroles();
                MbsMessages.info("Perfil creado correctamente!");
            }
        } catch (Exception ex) {
             MbsMessages.fatal(ex.getMessage());
        }

    }

    public void update(Role role) {
        try {
            if (dvrRole.roleUpdate(role)) {
                this.loadroles();
                MbsMessages.info("Perfil actualizado correctamente!");
            }
        } catch (Exception ex) {
            MbsMessages.fatal(ex.getMessage());
        }

    }
    public void delete(int id) {
        try {
             if (id != 0) {
                this.rolselection = dvrRole.getRoleById(id);
                if (dvrRole.roleDelete(this.rolselection)) {
                this.loadroles();
                MbsMessages.info("Perfil eliminado correctamente!");
            }
            } else {
                MbsMessages.error("Seleccione un registro");
            }
            
        } catch (Exception ex) {
            MbsMessages.fatal(ex.getMessage());
        }

    }
}