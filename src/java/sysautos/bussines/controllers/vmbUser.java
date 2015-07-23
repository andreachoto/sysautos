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
import sysautos.bussines.drivers.dvrUser;
import sysautos.bussines.drivers.dvrUserProfile;
import sysautos.bussines.entities.Profile;
import sysautos.bussines.entities.User;
import sysautos.bussines.entities.UserProfile;
import sysautos.bussines.session.MbsMessages;

/**
 *
 * @author Carolyn
 */
@ManagedBean(name = "dtUserView")
@ViewScoped
public final class vmbUser implements Serializable {

    private User user;
    private User usersel;
    private List<User> users;
    private List<UserProfile> lstUserProfile;
    private List<Profile> lstProfile;
    private Profile profile;
    private ArrayList<Integer> selecprofile;
    private UserProfile userprofile;
    private UserProfile userprofilesel;

    public vmbUser() throws Exception {
        this.user = new User();
        this.loadusers();
        this.profile = new Profile();
        this.userprofile = new UserProfile();
        this.lstUserProfile = new ArrayList<>();
        this.selecprofile = new ArrayList<>();
        this.lstProfile = dvrProfile.getProfileList();

    }

    public UserProfile getUserprofilesel() {
        return userprofilesel;
    }

    public void setUserprofilesel(UserProfile userprofilesel) {
        this.userprofilesel = userprofilesel;
    }

    public UserProfile getUserprofile() {
        return userprofile;
    }

    public void setUserprofile(UserProfile userprofile) {
        this.userprofile = userprofile;
    }

    public ArrayList<Integer> getSelecprofile() {
        return selecprofile;
    }

    public void setSelecprofile(ArrayList<Integer> selecprofile) {
        this.selecprofile = selecprofile;
    }

    public List<UserProfile> getLstUserProfile() {
        return lstUserProfile;
    }

    public void setLstUserProfile(List<UserProfile> lstUserProfile) {
        this.lstUserProfile = lstUserProfile;
    }

    public List<Profile> getLstProfile() {
        return lstProfile;
    }

    public void setLstProfile(List<Profile> lstProfile) {
        this.lstProfile = lstProfile;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getUsersel() {
        return usersel;
    }

    public void setUsersel(User usersel) {
        this.usersel = usersel;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public void loadusers() {
        try {
            this.users = dvrUser.getUserList();
        } catch (Exception ex) {
            MbsMessages.fatal(ex.getMessage());
        }
    }

    public void loaduser(int tipo) {
        try {
            if (tipo != 0) {
                this.usersel = dvrUser.getUserById(tipo);
                this.lstUserProfile = dvrUserProfile.getuserprofileByIdCliente(tipo);

                RequestContext.getCurrentInstance().update("frmEditUser");
                RequestContext.getCurrentInstance().execute("PF('edituser').show()");
            } else {
                MbsMessages.error("Seleccione un registro");
            }
        } catch (Exception ex) {
            MbsMessages.fatal(ex.getMessage());
        }
    }

    public void cargaruser(int tipo) {
        try {
            if (tipo != 0) {
                this.usersel = dvrUser.getUserById(tipo);
                this.lstUserProfile = dvrUserProfile.getuserprofileByIdCliente(tipo);
                for (UserProfile valor : lstUserProfile) {

                    System.out.println("dato ingresado:" + valor.getProfile().getNombre());

                }

                RequestContext.getCurrentInstance().update("frmVerUser");
                RequestContext.getCurrentInstance().execute("PF('veruser').show()");
            } else {
                MbsMessages.error("Seleccione un registro");
            }
        } catch (Exception ex) {
            MbsMessages.fatal(ex.getMessage());
        }
    }

    public void register() {
        try {
            int ban = dvrUser.usersRegister(this.user);
            int pro = profile.getId();
            if (ban != 0) {
                //ingreso de las tablas usuario y userprofile (el usuario tiene un solo perfil)
                UserProfile usp = new UserProfile();
                usp.setUsrid(ban);
                usp.setIdprofile(pro);
                dvrUserProfile.userprofileRegister(usp);
           
//                for (int x = 0; x < selecprofile.size(); x++) {
//                    userprofile.setUsrid(ban);
//                    userprofile.setIdprofile(selecprofile.get(x));
//                    lstUserProfile.add(userprofile);
//                    for (UserProfile usp : lstUserProfile) {
//                        dvrUserProfile.userprofileRegister(usp);
//                    }
//                }
                this.loadusers();
                this.user = new User();
                this.profile = new Profile();
                MbsMessages.info("User creado exitosamente!");
            } else {
                MbsMessages.error("No se pudo insertar el registro!");
            }
        } catch (Exception ex) {
            MbsMessages.fatal(ex.getMessage());
        }
    }

    public void update(User cli) {
        try {
            if (dvrUser.usersUpdate(cli)) {
                this.loadusers();
                MbsMessages.info("User actualizado correctamente!");
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
                this.usersel = dvrUser.getUserById(tipo);
                if (dvrUser.usersDelete(this.usersel)) {
                    this.loadusers();
                    MbsMessages.info("Usuario eliminado exitosamente!");
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

    public void actualizar(int tipo) {
        try {
            if (tipo != 0) {
                this.lstUserProfile = dvrUserProfile.getuserprofileByIdCliente(tipo);

                MbsMessages.info("Usuario eliminado exitosamente!");

            } else {
                MbsMessages.error("Seleccione un registro");
            }
        } catch (Exception ex) {
            MbsMessages.fatal(ex.getMessage());
        }
    }
    

}
