/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sysautos.bussines.session;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author hp
 */
@ManagedBean
@SessionScoped
public class MbsMessages {

    /**
     * Creates a new instance of mgbMessages
     *
     * @param msg
     */
    public static void info(String msg) {
        if (msg != null) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Informacion!", msg);
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }

    public static void warn(String msg) {
        if (msg != null) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Advertencia!", msg);
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }

    public static void error(String msg) {
         if (msg != null) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", msg);
            FacesContext.getCurrentInstance().addMessage(null, message);
         }
    }

    public static void fatal(String msg) {
        if (msg != null) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_FATAL, "Fatal!", msg);
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }

}
