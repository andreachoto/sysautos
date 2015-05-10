/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sysautos.bussines.drivers;

import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import sysautos.bussines.entities.TipoDireccion;
import sysautos.integration.Conexion;
import sysautos.integration.Parameter;


/**
 *
 * @author Carolyn
 */
public class dvrTipoDireccion {
    
           //Insertar un nuevo registro a la tabla
    public static int tipoDireccionRegister(TipoDireccion objeto) throws Exception {
        int codigo = 0;
        List<Parameter> parametros = new ArrayList<>();
        parametros.add(new Parameter(1, objeto.getNombre(), Types.VARCHAR));
        parametros.add(new Parameter(2, objeto.getDescripcion(), Types.VARCHAR));
        String llamadaPA = "SELECT autos.\"tipoDireccionRegister_pa\"(?,?)";
        Conexion con = new Conexion(llamadaPA, parametros);
        while (con.siguiente()) {
            codigo = con.getInt("tipoDireccionRegister_pa");
        }
        con.cerrarConexion();
        return codigo;
    }
    //Editar un nuevo registro de la tabla
    public static boolean tipoDireccionUpdate(TipoDireccion objeto) throws Exception {
        boolean respuesta = false;
        List<Parameter> parametros = new ArrayList<>();
        parametros.add(new Parameter(1, objeto.getId(), Types.INTEGER));
        parametros.add(new Parameter(2, objeto.getNombre(), Types.VARCHAR));
        parametros.add(new Parameter(3, objeto.getDescripcion(), Types.VARCHAR));
        String llamadaPA = "SELECT autos.\"tipoDireccionUpdate_pa\"(?,?,?)";
        Conexion con = new Conexion(llamadaPA, parametros);
        while (con.siguiente()) {
            respuesta = true;
        }
        con.cerrarConexion();
        return respuesta;
    }
    //Eliminar un registro de la tabla
    public static boolean tipoDireccionDelete(TipoDireccion objeto) throws Exception {
        boolean respuesta = false;
        List<Parameter> parametros = new ArrayList<>();
        parametros.add(new Parameter(1, objeto.getId(), Types.INTEGER));
        String llamadaPA = "SELECT autos.\"tipoDireccionDelete_pa\"(?)";
        Conexion con = new Conexion(llamadaPA, parametros);
        while (con.siguiente()) {
            respuesta = true;
        }
        con.cerrarConexion();
        return respuesta;
    }
    //Listar todos los registros de la tabla
    public static List<TipoDireccion> getTipoDireccionList() throws Exception {
        List<TipoDireccion> lista = new ArrayList<>();
        String llamadaPA = "SELECT * from autos.\"tipoDireccionSelectAll_pa\"()";
        Conexion con = new Conexion(llamadaPA);
        while (con.siguiente()) {
            int id = con.getInt("outid");
            String nombre = con.getString("outnombre");
            String descripcion=con.getString("outdescripcion");
            lista.add(new TipoDireccion(id,nombre,descripcion));
        }
        con.cerrarConexion();
        return lista;
    }
    //Listar los registros de la tabla dado el nombre 
    public static List<TipoDireccion> getTipoDireccionListByName(String text) throws Exception {
        List<TipoDireccion> lista = new ArrayList<>();
        List<Parameter> parametros = new ArrayList<>();
        parametros.add(new Parameter(1, text, Types.VARCHAR));
        String llamadaPA = "SELECT * from autos.\"tipoDireccionByName_pa\"(?)";
        Conexion con = new Conexion(llamadaPA, parametros);
        while (con.siguiente()) {
            int id = con.getInt("outid");
            String nombre = con.getString("outnombre");
            String descripcion=con.getString("outdescripcion");
            lista.add(new TipoDireccion(id,nombre,descripcion));
        }
        con.cerrarConexion();
        return lista;
    }
    
//     //Listar los registros de la entidad por id foraneo 
//    public static List<TipoDireccion> getTipoDireccionListByMagnitudeId(int val) throws Exception {
//        List<TipoDireccion> lista = new ArrayList<>();
//        List<Parameter> parametros = new ArrayList<>();
//        parametros.add(new Parameter(1, val, Types.INTEGER));
//        String llamadaPA = "SELECT * from autos.\"tipoDireccionByMagnitudeID_pa\"(?)";
//        Conexion con = new Conexion(llamadaPA, parametros);
//        while (con.siguiente()) {
//            int id = con.getInt("out_Id");
//            String nombre = con.getString("out_nombre");
//            String desc = con.getString("out_desc");
//            boolean active = con.getBoolean("out_active");
//            lista.add(new TipoDireccion(id,nombre, desc, active));
//        }
//        con.cerrarConexion();
//        return lista;
//    }
    
    //Listar los registros de la tabla dado el nombre 
    public static TipoDireccion getTipoDireccionById(int val) throws Exception {
        TipoDireccion var = null;
        List<Parameter> parametros = new ArrayList<>();
        parametros.add(new Parameter(1, val, Types.INTEGER));
        String llamadaPA = "SELECT * from autos.\"tipoDireccionByID_pa\"(?)";
        Conexion con = new Conexion(llamadaPA, parametros);
        if (con.siguiente()) {
            int id = con.getInt("outid");
            String nombre = con.getString("outnombre");
            String descripcion=con.getString("outdescripcion");
            var = new TipoDireccion(id,nombre,descripcion);
        }
        con.cerrarConexion();
        return var;
    }
    
    
}
