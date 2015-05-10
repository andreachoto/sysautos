/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sysautos.bussines.drivers;

import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import sysautos.bussines.entities.Provincia;
import sysautos.integration.Conexion;
import sysautos.integration.Parameter;


/**
 *
 * @author Carolyn
 */
public class dvrProvincia {
       //Insertar un nuevo registro a la tabla
    public static int provinciaRegister(Provincia objeto) throws Exception {
        int codigo = 0;
        List<Parameter> parametros = new ArrayList<>();
        parametros.add(new Parameter(1, objeto.getPisid(), Types.INTEGER));
        parametros.add(new Parameter(2, objeto.getNombre(), Types.VARCHAR));
        String llamadaPA = "SELECT autos.\"provinciaRegister_pa\"(?,?)";
        Conexion con = new Conexion(llamadaPA, parametros);
        while (con.siguiente()) {
            codigo = con.getInt("provinciaRegister_pa");
        }
        con.cerrarConexion();
        return codigo;
    }
    //Editar un nuevo registro de la tabla
    public static boolean provinciaUpdate(Provincia objeto) throws Exception {
        boolean respuesta = false;
        List<Parameter> parametros = new ArrayList<>();
        parametros.add(new Parameter(1, objeto.getId(), Types.INTEGER));
        parametros.add(new Parameter(2, objeto.getPisid(), Types.INTEGER));
        parametros.add(new Parameter(3, objeto.getNombre(), Types.VARCHAR));
        String llamadaPA = "SELECT autos.\"provinciaUpdate_pa\"(?,?,?)";
        Conexion con = new Conexion(llamadaPA, parametros);
        while (con.siguiente()) {
            respuesta = true;
        }
        con.cerrarConexion();
        return respuesta;
    }
    //Eliminar un registro de la tabla
    public static boolean provinciaDelete(Provincia objeto) throws Exception {
        boolean respuesta = false;
        List<Parameter> parametros = new ArrayList<>();
        parametros.add(new Parameter(1, objeto.getId(), Types.INTEGER));
        String llamadaPA = "SELECT autos.\"provinciaDelete_pa\"(?)";
        Conexion con = new Conexion(llamadaPA, parametros);
        while (con.siguiente()) {
            respuesta = true;
        }
        con.cerrarConexion();
        return respuesta;
    }
    //Listar todos los registros de la tabla
    public static List<Provincia> getProvinciaList() throws Exception {
        List<Provincia> lista = new ArrayList<>();
        String llamadaPA = "SELECT * from autos.\"provinciaSelectAll_pa\"()";
        Conexion con = new Conexion(llamadaPA);
        while (con.siguiente()) {
            int id = con.getInt("outid");
            int pisid=con.getInt("outpisid");
            String nombre = con.getString("outnombre");
            lista.add(new Provincia(id,pisid,nombre));
        }
        con.cerrarConexion();
        return lista;
    }
    //Listar los registros de la tabla dado el nombre 
    public static List<Provincia> getProvinciaListByName(String text) throws Exception {
        List<Provincia> lista = new ArrayList<>();
        List<Parameter> parametros = new ArrayList<>();
        parametros.add(new Parameter(1, text, Types.VARCHAR));
        String llamadaPA = "SELECT * from autos.\"provinciaByName_pa\"(?)";
        Conexion con = new Conexion(llamadaPA, parametros);
        while (con.siguiente()) {
            int id = con.getInt("out_Id");
            int provincia=con.getInt("out_provincia");
            String nombre = con.getString("out_nombre");
            lista.add(new Provincia(id,provincia,nombre));
        }
        con.cerrarConexion();
        return lista;
    }
    
//     //Listar los registros de la entidad por id foraneo 
//    public static List<Provincia> getProvinciaListByMagnitudeId(int val) throws Exception {
//        List<Provincia> lista = new ArrayList<>();
//        List<Parameter> parametros = new ArrayList<>();
//        parametros.add(new Parameter(1, val, Types.INTEGER));
//        String llamadaPA = "SELECT * from autos.\"provinciaByMagnitudeID_pa\"(?)";
//        Conexion con = new Conexion(llamadaPA, parametros);
//        while (con.siguiente()) {
//            int id = con.getInt("out_Id");
//            String nombre = con.getString("out_nombre");
//            String desc = con.getString("out_desc");
//            boolean active = con.getBoolean("out_active");
//            lista.add(new Provincia(id,nombre, desc, active));
//        }
//        con.cerrarConexion();
//        return lista;
//    }
    
    //Listar los registros de la tabla dado el nombre 
    public static Provincia getProvinciaById(int val) throws Exception {
        Provincia var = null;
        List<Parameter> parametros = new ArrayList<>();
        parametros.add(new Parameter(1, val, Types.INTEGER));
        String llamadaPA = "SELECT * from autos.\"provinciaByID_pa\"(?)";
        Conexion con = new Conexion(llamadaPA, parametros);
        if (con.siguiente()) {
            int id = con.getInt("outid");
            int provincia=con.getInt("outpisid");
            String nombre = con.getString("outnombre");
            var = new Provincia(id,provincia,nombre);
        }
        con.cerrarConexion();
        return var;
    }
    
            //Listar los registros de la tabla dado el nombre 
    public static List<Provincia> getProvinciaListByPais(int fkpais) throws Exception {
        List<Provincia> lista = new ArrayList<>();
        List<Parameter> parametros = new ArrayList<>();
        parametros.add(new Parameter(1, fkpais, Types.INTEGER));
        String llamadaPA = "SELECT * from autos.\"paisSelectProv_id_Pais\"(?)";
        Conexion con = new Conexion(llamadaPA, parametros);
        while (con.siguiente()) {
           int id = con.getInt("outid");
            int pisid=con.getInt("outidpais");
            String nombre = con.getString("outnombre");
            lista.add(new Provincia(id,pisid,nombre));
        }
        con.cerrarConexion();
        return lista;
    }
    
             //Listar los registros de la tabla dado el nombre 
    public static List<Provincia> getProvinciaListByNamePais(String nompais) throws Exception {
        List<Provincia> lista = new ArrayList<>();
        List<Parameter> parametros = new ArrayList<>();
        parametros.add(new Parameter(1, nompais, Types.VARCHAR));
        String llamadaPA = "SELECT * from autos.\"paisSelectProv_nom_Pais\"(?)";
        Conexion con = new Conexion(llamadaPA, parametros);
        while (con.siguiente()) {
           int id = con.getInt("outid");
            int pisid=con.getInt("outidpais");
            String nombre = con.getString("outnombre");
            String nombrepais = con.getString("outnompais");
            lista.add(new Provincia(id,pisid,nombre,nombrepais));
        }
        con.cerrarConexion();
        return lista;
    }
    
}
