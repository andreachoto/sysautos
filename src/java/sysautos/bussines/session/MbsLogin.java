/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sysautos.bussines.session;

import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import sysautos.bussines.entities.User;
import sysautos.bussines.drivers.dvrUser;
import sysautos.bussines.drivers.dvrUserProfile;
import sysautos.bussines.entities.UserProfile;

@ManagedBean
@SessionScoped
public class MbsLogin implements Serializable {

    private String login;
    private User user;
    private String pwd;
    private List<UserProfile> lstUserProfile;

    public List<UserProfile> getLstUserProfile() {
        return lstUserProfile;
    }

    public void setLstUserProfile(List<UserProfile> lstUserProfile) {
        this.lstUserProfile = lstUserProfile;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String login() throws Exception {
        try {
            User usuario = dvrUser.getUserByLogin(this.login, this.pwd);
            if (usuario != null) {
                if (usuario.getPwd().equals(this.pwd)) {
                    this.user = usuario;
                    HttpSession httpSession = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
                    httpSession.setAttribute("login", this.login);
                    httpSession.setAttribute("user", usuario);
//                 
                    this.lstUserProfile = dvrUserProfile.getUserprofilesByUserID(this.user.getId());
                    for (UserProfile userprof : lstUserProfile) {
                        if (userprof.getUsrid() == usuario.getId()) {
                            if (userprof.getProfile().getNombre().equals("Admin")) {
                                return "/main";
                            }
                            if (userprof.getProfile().getNombre().equals("Ventas")) {
                                return "/mainVentas";
                            }
                            if (userprof.getProfile().getNombre().equals("Ejecutivo")) {
                                return "/mainEjecutivo";
                            }
                            if (userprof.getProfile().getNombre().equals("Operativos")) {
                                return "/mainOperativos";
                            }
                        }
                    }

                }
            }
            this.login = null;
            this.pwd = null;
            FacesContext.getCurrentInstance().addMessage(login, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error de Acceso", "Usuario o contraseña no validos"));
            return "/login";
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(login, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error Fatal", "Por favor contacte con el Administrador" + ex.getMessage()));
            return null;
        }
    }

    public String closeSession() {
        this.login = null;
        this.pwd = null;
        HttpSession httpSession = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
        httpSession.invalidate();
        return "/login";
    }
}
