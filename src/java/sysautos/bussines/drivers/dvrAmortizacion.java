/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sysautos.bussines.drivers;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import sun.java2d.cmm.Profile;
import sysautos.bussines.entities.Amortizacion;
import sysautos.integration.Conexion;
import sysautos.integration.Parameter;


/**
 *
 * @author hp
 */
public class dvrAmortizacion {

    //Insertar un nuevo registro a la tabla
    public static int userAmtRegister(Amortizacion objeto) throws Exception {
        int codigo = 0;
        List<Parameter> parametros = new ArrayList<>();
        parametros.add(new Parameter(1, objeto.getCreditoid(), Types.INTEGER));
        parametros.add(new Parameter(2, objeto.getAmzcuota(), Types.INTEGER));
        parametros.add(new Parameter(3, objeto.getAmzfecha(), Types.TIMESTAMP));
        parametros.add(new Parameter(4, objeto.getAmzcapital(), Types.DECIMAL));
        parametros.add(new Parameter(5, objeto.getAmzinteres(), Types.DECIMAL));
        parametros.add(new Parameter(6, objeto.getAmzvalorc(), Types.DECIMAL));
        parametros.add(new Parameter(7, objeto.getAmortizacion(), Types.DECIMAL));

        String llamadaPA = "SELECT autos.\"amortizacionRegister_pa\"(?,?,?,?,?,?,?)";
        Conexion con = new Conexion(llamadaPA, parametros);
        while (con.siguiente()) {
            codigo = con.getInt("amortizacionRegister_pa");
        }
        con.cerrarConexion();
        return codigo;
    }

    //Editar un nuevo registro de la tabla

//    public static boolean userProfileUpdate(Profile objeto) throws Exception {
//        boolean respuesta = false;
//        List<Parameter> parametros = new ArrayList<>();
//        parametros.add(new Parameter(1, objeto.getUstid(), Types.INTEGER));
//        parametros.add(new Parameter(2, objeto.getUstname(), Types.VARCHAR));
//        parametros.add(new Parameter(3, objeto.getUstdesc(), Types.VARCHAR));
//        parametros.add(new Parameter(4, objeto.isUstactive(), Types.BOOLEAN));
//
//        String llamadaPA = "SELECT autos.\"profileUpdate_pa\"(?,?,?,?)";
//        Conexion con = new Conexion(llamadaPA, parametros);
//        while (con.siguiente()) {
//            respuesta = true;
//        }
//        con.cerrarConexion();
//        return respuesta;
//    }

    //Eliminar un registro de la tabla

//    public static boolean userProfileDelete(Profile objeto) throws Exception {
//        boolean respuesta = false;
//        List<Parameter> parametros = new ArrayList<>();
//        parametros.add(new Parameter(1, objeto.getUstid(), Types.INTEGER));
//        String llamadaPA = "SELECT autos.\"profileDelete_pa\"(?)";
//        Conexion con = new Conexion(llamadaPA, parametros);
//        while (con.siguiente()) {
//            respuesta = true;
//        }
//        con.cerrarConexion();
//        return respuesta;
//    }

    //Listar todos los registros de la tabla

    public static ArrayList<Amortizacion> getAmortizacionList() throws Exception {
        ArrayList<Amortizacion> lista = new ArrayList<>();
        String llamadaPA = "SELECT * from autos.\"amortizacionSelectAll_pa\"()";
        Conexion con = new Conexion(llamadaPA);
        while (con.siguiente()) {
            int id = con.getInt("outid");
            int credito = con.getInt("outcrt");
            int cuota = con.getInt("outcuota");
            Timestamp  fecha = con.getTimestamp("outfecha");
            BigDecimal capital = con.getBigDecimal("outcapital");
            BigDecimal interes = con.getBigDecimal("outinteres");
            BigDecimal valorc = con.getBigDecimal("outvalorc");
            BigDecimal amort = con.getBigDecimal("outamort");
            lista.add(new Amortizacion(id,credito,cuota,fecha,capital,interes,valorc,amort));
        }
     return lista;
    }
    
    
     public static List<Amortizacion> getAmortizacionListByCred(int cred) throws Exception {
        List<Amortizacion> lista = new ArrayList<>();
        List<Parameter> parametros = new ArrayList<>();
        parametros.add(new Parameter(1, cred, Types.INTEGER));
        String llamadaPA = "SELECT * from autos.\"amortizacionByCred\"(?)";
        Conexion con = new Conexion(llamadaPA, parametros);
        while (con.siguiente()) {
            int id = con.getInt("outid");
            int credito = con.getInt("outcrt");
            int cuota = con.getInt("outcuota");
            Timestamp  fecha = con.getTimestamp("outfecha");
            BigDecimal capital = con.getBigDecimal("outcapital");
            BigDecimal interes = con.getBigDecimal("outinteres");
            BigDecimal valorc = con.getBigDecimal("outvalorc");
            BigDecimal amort = con.getBigDecimal("outamort");
            lista.add(new Amortizacion(id,credito,cuota,fecha,capital,interes,valorc,amort));
        }
        con.cerrarConexion();
        return lista;
    }
    
    
    
    
    
    
    
    
    

    //Listar los registros de la tabla dado el nombre 

//    public static List<Profile> getuserProfileListByName(String text) throws Exception {
//        List<Profile> lista = new ArrayList<>();
//        List<Parameter> parametros = new ArrayList<>();
//        parametros.add(new Parameter(1, text, Types.VARCHAR));
//        String llamadaPA = "SELECT * from upkeep.\"userTypeByName_pa\"(?)";
//        Conexion con = new Conexion(llamadaPA, parametros);
//        while (con.siguiente()) {
//            int id = con.getInt("out_id");
//            String name = con.getString("out_name");
//            String desc = con.getString("out_desc");
//            boolean active = con.getBoolean("out_active");
//            boolean visible = con.getBoolean("out_visible");
//            lista.add(new Profile(id, name, desc, active));
//        }
//        con.cerrarConexion();
//        return lista;
//    }

//    //Listar los registros de la tabla dado el nombre 
//    public static Profile getuserProfileById(int val) throws Exception {
//        Profile var = null;
//        List<Parameter> parametros = new ArrayList<>();
//        parametros.add(new Parameter(1, val, Types.INTEGER));
//        String llamadaPA = "SELECT * from upkeep.\"userTypeByID_pa\"(?)";
//        Conexion con = new Conexion(llamadaPA, parametros);
//        if (con.siguiente()) {
//            int id = con.getInt("out_id");
//            String name = con.getString("out_name");
//            String desc = con.getString("out_desc");
//            boolean active = con.getBoolean("out_active");
//            boolean visible = con.getBoolean("out_visible");
//            var = new Profile(id, name, desc, active);
//        }
//        con.cerrarConexion();
//        return var;
//    }
}
