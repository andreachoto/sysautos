/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sysautos.bussines.session;

import java.sql.Timestamp;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import sysautos.bussines.common.Genericas;


/**
 *
 * @author hp
 */
@ManagedBean (name = "Common")
@ApplicationScoped
public class MbaCommon {

    /**
     * Creates a new instance of MbaCommon
     */
    public MbaCommon() {
    }
    
    public String TimestampFormat(Timestamp ts){
       return Genericas.convertTimeStamptoStrFormat(ts, "dd/MM/yyyy");
    }
    
}
