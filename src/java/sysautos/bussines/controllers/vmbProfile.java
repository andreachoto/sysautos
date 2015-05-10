/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sysautos.bussines.controllers;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.context.RequestContext;
import sysautos.bussines.drivers.dvrProfile;
import sysautos.bussines.drivers.dvrRole;
import sysautos.bussines.drivers.dvrRoleProfile;
import sysautos.bussines.entities.Profile;
import sysautos.bussines.entities.Role;
import sysautos.bussines.entities.RoleProfile;
import sysautos.bussines.session.MbsMessages;

/**
 *
 * @author Carolyn
 */
@ManagedBean(name = "dtProfileView")
@ViewScoped
public final class vmbProfile implements Serializable {

    private Profile profile;
    private Profile profilesel;
    private List<Profile> profiles;
    private ArrayList<Integer> selecrol;
    private List<Role> lstRol;
    private RoleProfile roleprofile;
    private List<RoleProfile> lstRoleProfile;

    public vmbProfile() throws Exception {
        this.profile = new Profile();
        this.loadprofiles();
         this.selecrol = new ArrayList<>();
        this.lstRol = dvrRole.getRoleList();
        this.roleprofile = new RoleProfile();
        this.lstRoleProfile = new ArrayList<>();
    }

    public List<RoleProfile> getLstRoleProfile() {
        return lstRoleProfile;
    }

    public void setLstRoleProfile(List<RoleProfile> lstRoleProfile) {
        this.lstRoleProfile = lstRoleProfile;
    }
    

    public RoleProfile getRoleprofile() {
        return roleprofile;
    }

    public void setRoleprofile(RoleProfile roleprofile) {
        this.roleprofile = roleprofile;
    }
    
    public ArrayList<Integer> getSelecrol() {
        return selecrol;
    }

    public void setSelecrol(ArrayList<Integer> selecrol) {
        this.selecrol = selecrol;
    }

    public List<Role> getLstRol() {
        return lstRol;
    }

    public void setLstRol(List<Role> lstRol) {
        this.lstRol = lstRol;
    }
    

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public Profile getProfilesel() {
        return profilesel;
    }

    public void setProfilesel(Profile profilesel) {
        this.profilesel = profilesel;
    }

    public List<Profile> getProfiles() {
        return profiles;
    }

    public void setProfiles(List<Profile> profiles) {
        this.profiles = profiles;
    }

    public void loadprofiles() {
        try {
            this.profiles = dvrProfile.getProfileList();
        } catch (Exception ex) {
            MbsMessages.fatal(ex.getMessage());
        }
    }

    public void loadprofile(int tipo) {
        try {
            if (tipo != 0) {
                this.profilesel = dvrProfile.getProfileById(tipo);
                RequestContext.getCurrentInstance().update("frmEditProfile");
                RequestContext.getCurrentInstance().execute("PF('editprofile').show()");
            } else {
                MbsMessages.error("Seleccione un registro");
            }
        } catch (Exception ex) {
            MbsMessages.fatal(ex.getMessage());
        }
    }
        public void cargarverprofile(int tipo) {
        try {
            if (tipo != 0) {
                this.profilesel = dvrProfile.getProfileById(tipo);
                this.lstRoleProfile = dvrRoleProfile.getroleprofileByIdProfile(tipo);
                RequestContext.getCurrentInstance().update("frmVerProfile");
                RequestContext.getCurrentInstance().execute("PF('verprofile').show()");
            } else {
                MbsMessages.error("Seleccione un registro");
            }
        } catch (Exception ex) {
            MbsMessages.fatal(ex.getMessage());
        }
    }

    public void register() {
        try {
            int ban = dvrProfile.profileRegister(this.profile);
            if (ban != 0) {
                for (int x = 0; x < selecrol.size(); x++) {
                    roleprofile.setPflid(ban);
                    roleprofile.setRolid(selecrol.get(x));
                    lstRoleProfile.add(roleprofile);
                    for (RoleProfile rolpro : lstRoleProfile) {
                        dvrRoleProfile.roleprofileRegister(rolpro);
                    }
                }
                this.loadprofiles();
                this.profile = new Profile();
                this.selecrol= new ArrayList<>();
                MbsMessages.info("Profile creado exitosamente!");
            } else {
                MbsMessages.error("No se pudo insertar el registro!");
            }
        } catch (Exception ex) {
            MbsMessages.fatal(ex.getMessage());
        }
    }

    public void update(Profile cli) {
        try {
            if (dvrProfile.profileUpdate(cli)) {
                this.loadprofiles();
                MbsMessages.info("Profile actualizado correctamente!");
            } else {
                MbsMessages.error("No se pudo Actualizar el registro!");
            }
        } catch (Exception ex) {
            MbsMessages.fatal(ex.getMessage());
        }
    }

    public void delete(int tipo) {
        try {
            if (tipo != 0) {
                this.profilesel = dvrProfile.getProfileById(tipo);
                if (dvrProfile.profileDelete(this.profilesel)) {
                    this.loadprofiles();
                    MbsMessages.info("Perfil eliminado exitosamente!");
                } else {
                    MbsMessages.error("No se pudo Eliminar!");
                }
            } else {
                MbsMessages.error("Seleccione un registro");
            }
        } catch (Exception ex) {
            MbsMessages.fatal(ex.getMessage());
        }
    }

}
