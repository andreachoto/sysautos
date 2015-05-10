/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sysautos.bussines.drivers;

import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import sysautos.bussines.entities.Profile;
import sysautos.integration.Conexion;
import sysautos.integration.Parameter;


/**
 *
 * @author Carolyn
 */
public class dvrProfile {
     //Insertar un nuevo registro a la tabla
    public static int profileRegister(Profile objeto) throws Exception {
        int codigo = 0;
        List<Parameter> parametros = new ArrayList<>();
        parametros.add(new Parameter(1, objeto.getNombre(), Types.VARCHAR));
        parametros.add(new Parameter(2, objeto.getDescripcion(), Types.VARCHAR));
        parametros.add(new Parameter(3, objeto.isEstado(), Types.BOOLEAN));
         String llamadaPA = "SELECT autos.\"profileRegister_pa\"(?,?,?)";
        Conexion con = new Conexion(llamadaPA, parametros);
        while (con.siguiente()) {
            codigo = con.getInt("profileRegister_pa");
        }
        con.cerrarConexion();
        return codigo;
    }
    //Editar un nuevo registro de la tabla
    public static boolean profileUpdate(Profile objeto) throws Exception {
        boolean respuesta = false;
        List<Parameter> parametros = new ArrayList<>();
        parametros.add(new Parameter(1, objeto.getId(), Types.INTEGER));
        parametros.add(new Parameter(2, objeto.getNombre(), Types.VARCHAR));
        parametros.add(new Parameter(3, objeto.getDescripcion(), Types.VARCHAR));
        parametros.add(new Parameter(4, objeto.isEstado(), Types.BOOLEAN));
        String llamadaPA = "SELECT autos.\"profileUpdate_pa\"(?,?,?,?)";
        Conexion con = new Conexion(llamadaPA, parametros);
        while (con.siguiente()) {
            respuesta = true;
        }
        con.cerrarConexion();
        return respuesta;
    }
    
    //Eliminar un registro de la tabla
    public static boolean profileDelete(Profile objeto) throws Exception {
        boolean respuesta = false;
        List<Parameter> parametros = new ArrayList<>();
        parametros.add(new Parameter(1, objeto.getId(), Types.INTEGER));
        String llamadaPA = "SELECT autos.\"profileDelete_paCascada\"(?)";
        Conexion con = new Conexion(llamadaPA, parametros);
        while (con.siguiente()) {
            respuesta = true;
        }
        con.cerrarConexion();
        return respuesta;
    }
    //Listar todos los registros de la tabla
    public static List<Profile> getProfileList() throws Exception {
        List<Profile> lista = new ArrayList<>();
        String llamadaPA = "SELECT * from autos.\"profileSelectAll_pa\"()";
        Conexion con = new Conexion(llamadaPA);
        while (con.siguiente()) {
            int id = con.getInt("outid");
            String nombre = con.getString("outname");
            String descripcion = con.getString("outdesc");
            boolean estado = con.getBoolean("outisactive");
            lista.add(new Profile(id,nombre,descripcion,estado));
        }
        con.cerrarConexion();
        return lista;
    }
    
    //Listar los registros de la tabla dado el nombre 
    public static List<Profile> getProfileListByName(String text) throws Exception {
        List<Profile> lista = new ArrayList<>();
        List<Parameter> parametros = new ArrayList<>();
        parametros.add(new Parameter(1, text, Types.VARCHAR));
        String llamadaPA = "SELECT * from autos.\"profileByName_pa\"(?)";
        Conexion con = new Conexion(llamadaPA, parametros);
        while (con.siguiente()) {
            int id = con.getInt("outid");
            String nombre = con.getString("outname");
            String descripcion = con.getString("outdesc");
            boolean estado = con.getBoolean("outisactive");
            lista.add(new Profile(id,nombre,descripcion,estado));
        }
        con.cerrarConexion();
        return lista;
    }
    
//     //Listar los registros de la entidad por id foraneo 
//    public static List<Profile> getProfileListByMagnitudeId(int val) throws Exception {
//        List<Profile> lista = new ArrayList<>();
//        List<Parameter> parametros = new ArrayList<>();
//        parametros.add(new Parameter(1, val, Types.INTEGER));
//        String llamadaPA = "SELECT * from autos.\"profileByMagnitudeID_pa\"(?)";
//        Conexion con = new Conexion(llamadaPA, parametros);
//        while (con.siguiente()) {
//            int id = con.getInt("out_Id");
//            String nombre = con.getString("out_nombre");
//            String desc = con.getString("out_desc");
//            boolean active = con.getBoolean("out_active");
//            lista.add(new Profile(id,nombre, desc, active));
//        }
//        con.cerrarConexion();
//        return lista;
//    }
    
    //Listar los registros de la tabla dado el nombre 
    public static Profile getProfileById(int val) throws Exception {
        Profile var = null;
        List<Parameter> parametros = new ArrayList<>();
        parametros.add(new Parameter(1, val, Types.INTEGER));
        String llamadaPA = "SELECT * from autos.\"profileByID_pa\"(?)";
        Conexion con = new Conexion(llamadaPA, parametros);
        if (con.siguiente()) {
            int id = con.getInt("outid");
            String nombre = con.getString("outname");
            String descripcion = con.getString("outdesc");
            boolean estado = con.getBoolean("outisactive");
            var = new Profile(id,nombre,descripcion,estado);
        }
        con.cerrarConexion();
        return var;
    }
    

    
}
