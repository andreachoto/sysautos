/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sysautos.bussines.drivers;

import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import sun.java2d.cmm.Profile;
import sysautos.bussines.entities.Detallereq;
import sysautos.integration.Conexion;
import sysautos.integration.Parameter;



/**
 *
 * @author hp
 */
public class dvrDetallereq {
    
    public static int detallereqRegister(Detallereq objeto) throws Exception {
        int codigo = 0;
        List<Parameter> parametros = new ArrayList<>();
        parametros.add(new Parameter(1, objeto.getNombre(), Types.VARCHAR));
        parametros.add(new Parameter(2, objeto.getDescrip(), Types.VARCHAR));
        String llamadaPA = "SELECT autos.\"detallereqRegister_pa\"(?,?)";
        Conexion con = new Conexion(llamadaPA, parametros);
        while (con.siguiente()) {
            codigo = con.getInt("detallereqRegister_pa");
        }
        con.cerrarConexion();
        return codigo;
    }

    //Editar un nuevo registro de la tabla
    public static boolean detallereqUpdate(Detallereq objeto) throws Exception {
        boolean respuesta = false;
        List<Parameter> parametros = new ArrayList<>();
        parametros.add(new Parameter(1, objeto.getId(), Types.INTEGER));
        parametros.add(new Parameter(2, objeto.getNombre(), Types.VARCHAR));
        parametros.add(new Parameter(3, objeto.getDescrip(), Types.VARCHAR));

        String llamadaPA = "SELECT autos.\"detallereqUpdate_pa\"(?,?,?)";
        Conexion con = new Conexion(llamadaPA, parametros);
        while (con.siguiente()) {
            respuesta = true;
        }
        con.cerrarConexion();
        return respuesta;
    }

    //Eliminar un registro de la tabla
    public static boolean detallereqDelete(Detallereq objeto) throws Exception {
        boolean respuesta = false;
        List<Parameter> parametros = new ArrayList<>();
        parametros.add(new Parameter(1, objeto.getId(), Types.INTEGER));
        String llamadaPA = "SELECT autos.\"detallereqDelete_pa\"(?)";
        Conexion con = new Conexion(llamadaPA, parametros);
        while (con.siguiente()) {
            respuesta = true;
        }
        con.cerrarConexion();
        return respuesta;
    }
//OUT outid integer, OUT outnombre character varying, OUT outdescrip character varying
    //Listar todos los registros de la tabla
    public static List<Detallereq> getDetallereqList() throws Exception {
        List<Detallereq> lista = new ArrayList<>();
        String llamadaPA = "SELECT * from autos.\"detallereqSelectAll_pa\"()";
        Conexion con = new Conexion(llamadaPA);
        while (con.siguiente()) {
            int id = con.getInt("outid");
            String name = con.getString("outnombre");
            String desc = con.getString("outdescrip");
            lista.add(new Detallereq(id, name, desc));
        }
        con.cerrarConexion();
        return lista;
    }

    //Listar los registros de la tabla dado el nombre 
    public static List<Detallereq> getDetallereqListByName(String text) throws Exception {
        List<Detallereq> lista = new ArrayList<>();
        List<Parameter> parametros = new ArrayList<>();
        parametros.add(new Parameter(1, text, Types.VARCHAR));
        String llamadaPA = "SELECT * from upkeep.\"detallereqByName_pa\"(?)";
        Conexion con = new Conexion(llamadaPA, parametros);
        while (con.siguiente()) {
            int id = con.getInt("outid");
            String name = con.getString("outnombre");
            String desc = con.getString("outdescrip");
            lista.add(new Detallereq(id, name, desc));
        }
        con.cerrarConexion();
        return lista;
    }

    //Listar los registros de la tabla dado el nombre 
    public static Detallereq getDetallereqById(int val) throws Exception {
        Detallereq var = null;
        List<Parameter> parametros = new ArrayList<>();
        parametros.add(new Parameter(1, val, Types.INTEGER));
        String llamadaPA = "SELECT * from autos.\"detallereqByID_pa\"(?)";
        Conexion con = new Conexion(llamadaPA, parametros);
        if (con.siguiente()) {
            int id = con.getInt("outid");
            String name = con.getString("outnombre");
            String desc = con.getString("outdescrip");
            var = new Detallereq(id, name, desc);
        }
        con.cerrarConexion();
        return var;
    }
    
    
    
    
    
    
}
